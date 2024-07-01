package scripts

import org.apache.commons.text.similarity.JaccardSimilarity
import utils.FileUtils

static def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() }
    def similarity = new JaccardSimilarity()
    def clusters = [:]

    files.each { file ->
        def content = file.text
        def clusterKey = clusters.find { key, clusterContent ->
            similarity.apply(content, clusterContent as CharSequence) > 0.8
        }?.key ?: file.name

        clusters[clusterKey] = content
        def destDir = "${dir}/OrganizedByContentSimilarity/${clusterKey}"
        FileUtils.moveFile(file as File, destDir)
    }
}
