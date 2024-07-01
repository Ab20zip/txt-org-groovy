package scripts

import utils.FileUtils

static def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() }
    files.each { file ->
        def firstLetter = file.name[0].toUpperCase()
        def destDir = "${dir}/OrganizedByFirstLetter/${firstLetter}"
        FileUtils.moveFile(file as File, destDir)
    }
}
