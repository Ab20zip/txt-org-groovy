package scripts

import utils.FileUtils

static def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() }
    files.each { file ->
        def ageInDays = (System.currentTimeMillis() - file.lastModified()) / (1000 * 60 * 60 * 24)
        def destDir = "${dir}/OrganizedByAge/"

        if (ageInDays < 30) {
            destDir += "Recent"
        } else if (ageInDays < 365) {
            destDir += "LastYear"
        } else {
            destDir += "Older"
        }

        FileUtils.moveFile(file as File, destDir)
    }
}
