package scripts

import utils.FileUtils

static def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() }
    files.each { file ->
        def ext = file.name.tokenize('.').last()
        def destDir = "${dir}/OrganizedByType/${ext}"
        FileUtils.moveFile(file as File, destDir)
    }
}
