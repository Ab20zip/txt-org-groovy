package scripts

import org.apache.tika.Tika
import org.apache.tika.metadata.Metadata
import org.apache.tika.metadata.Property
import org.apache.tika.parser.AutoDetectParser
import org.apache.tika.sax.BodyContentHandler
import org.xml.sax.ContentHandler
import utils.FileUtils

def tika = new Tika()
def parser = new AutoDetectParser()

def organizeFiles(String dir) {
    def files = new File(dir).listFiles().findAll { it.isFile() }
    files.each { file ->
        def metadata = new Metadata()
        ContentHandler handler = new BodyContentHandler()
        file.withInputStream { stream ->
            parser.parse(stream, handler, metadata)
        }
        def tags = metadata.names()
        tags.each { tag ->
            def destDir = "${dir}/OrganizedByMetadataTags/${tag}/${metadata.get(tag as Property)}"
            FileUtils.moveFile(file as File, destDir)
        }
    }
}
