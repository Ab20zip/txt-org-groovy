package scripts

import utils.FileUtils

import java.nio.file.Files
import java.nio.file.attribute.BasicFileAttributes

static def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() }
    files.each { file ->
        def attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class)
        def accessTime = attributes.lastAccessTime().toMillis()
        def currentTime = System.currentTimeMillis()
        def daysSinceAccessed = (currentTime - accessTime) / (1000 * 60 * 60 * 24)
        def destDir = "${dir}/OrganizedByAccessFrequency/"

        if (daysSinceAccessed < 30) {
            destDir += "FrequentlyAccessed"
        } else if (daysSinceAccessed < 180) {
            destDir += "ModeratelyAccessed"
        } else {
            destDir += "RarelyAccessed"
        }

        FileUtils.moveFile(file as File, destDir)
    }
}
