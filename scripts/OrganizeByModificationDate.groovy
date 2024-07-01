package scripts

import utils.FileUtils

static def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() }
    files.each { file ->
        def lastModified = new Date(file.lastModified())
        def year = lastModified.format('yyyy')
        def month = lastModified.format('MM')
        def day = lastModified.format('dd')
        def destDir = "${dir}/OrganizedByDate/${year}/${month}/${day}"
        FileUtils.moveFile(file as File, destDir)
    }
}
