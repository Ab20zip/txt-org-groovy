package scripts

import utils.FileUtils

static def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() }
    files.each { file ->
        def destDir = "${dir}/OrganizedByImportance/"

        // Placeholder logic to determine file importance
        if (file.name.contains("important")) {
            destDir += "HighImportance"
        } else {
            destDir += "LowImportance"
        }

        FileUtils.moveFile(file as File, destDir)
    }
}
