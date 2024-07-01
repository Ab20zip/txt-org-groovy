package scripts

import org.apache.tika.language.detect.LanguageDetector
import org.apache.tika.language.detect.LanguageResult
import utils.FileUtils

static def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() }
    LanguageDetector detector

    files.each { file ->
        def text = file.text
        LanguageResult result = detector.detect(text as CharSequence)

        def language = result.language
        def destDir = "${dir}/OrganizedByLanguage/${language}"
        FileUtils.moveFile(file as File, destDir)
    }
}
