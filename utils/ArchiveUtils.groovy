package utils

import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

class ArchiveUtils {
    static void zipFiles(List<File> files, String outputZip) {
        FileOutputStream fos = new FileOutputStream(outputZip)
        ZipOutputStream zos = new ZipOutputStream(fos)

        files.each { file ->
            ZipEntry zipEntry = new ZipEntry(file.name)
            zos.putNextEntry(zipEntry)

            FileInputStream fis = new FileInputStream(file)
            byte[] buffer = new byte[1024]
            int length
            while ((length = fis.read(buffer)) >= 0) {
                zos.write(buffer, 0, length)
            }
            zos.closeEntry()
            fis.close()
        }

        zos.close()
        fos.close()
    }
}
