package scripts

import utils.FileUtils

import java.nio.file.Files
import java.nio.file.attribute.PosixFilePermissions

static def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() }
    files.each { file ->
        def permissions = PosixFilePermissions.toString(Files.getPosixFilePermissions(file.toPath()))
        def destDir = "${dir}/OrganizedByPermissions/${permissions}"
        FileUtils.moveFile(file as File, destDir)
    }
}
