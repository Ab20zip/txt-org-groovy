package utils

class FileUtils {
    static void createDirectory(String path) {
        File dir = new File(path)
        if (!dir.exists()) {
            dir.mkdirs()
        }
    }

    static void moveFile(File file, String destDir) {
        createDirectory(destDir)
        File dest = new File(destDir, file.name)
        file.renameTo(dest)
    }

    static List<File> listFiles(String dir) {
        return new File(dir).listFiles().findAll { it.isFile() }
    }
}
