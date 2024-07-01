package scripts

import utils.ArchiveUtils

static def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() && it.lastModified() < (new Date() - 365 as Character) }
    ArchiveUtils.zipFiles(files, "${dir}/Archives/archived_${new Date().format('yyyyMMdd')}.zip")
    files.each { it.delete() }
}
