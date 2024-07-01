package scripts

import utils.FileUtils

import java.security.MessageDigest

static def computeHash(File file) {
    def digest = MessageDigest.getInstance("MD5")
    file.withInputStream { fis ->
        def buffer = new byte[1024]
        int read
        while ((read = fis.read(buffer)) != -1) {
            digest.update(buffer, 0, read)
        }
    }
    return digest.digest().collect { String.format("%02x", it) }.join()
}

static def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() }
    files.each { file ->
        def hash = computeHash(file as File)
        def destDir = "${dir}/OrganizedByHash/${hash}"
        FileUtils.moveFile(file as File, destDir)
    }
}
