package utils

class FileCategorizerUtils {
    static void organizeFiles(String dir, Closure determineCategories) {
        def files = new File(dir).listFiles().findAll { it.isFile() }
        files.each { file ->
            def categories = determineCategories(file)
            categories.each { category ->
                def destDir = "${dir}/OrganizedBy${category}"
                FileUtils.moveFile(file as File, destDir)
            }
        }
    }
}
