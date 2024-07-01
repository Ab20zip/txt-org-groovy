package scripts

import utils.FileUtils

static def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() }
    files.each { file ->
        def size = file.length()
        def destDir = "${dir}/OrganizedBySize/"
        if (size < 1024 * 1024) {
            destDir += "Small"
        } else if (size < 1024 * 1024 * 10) {
            destDir += "Medium"
        } else {
            destDir += "Large"
        }
        FileUtils.moveFile(file as File, destDir)
    }
}
