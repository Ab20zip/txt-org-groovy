package scripts

import utils.FileUtils

import java.nio.file.Files

static def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() }
    files.each { file ->
        def owner = Files.getOwner(file.toPath()).getName()
        def destDir = "${dir}/OrganizedByOwner/${owner}"
        FileUtils.moveFile(file as File, destDir)
    }
}
