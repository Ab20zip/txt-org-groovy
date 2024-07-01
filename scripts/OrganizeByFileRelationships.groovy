package scripts

import utils.FileCategorizerUtils

static def determineRelationships(File file) {
    return file.name.contains("project") ? ["Relationships/ProjectFiles"] : ["Relationships/Uncategorized"]
}

def organizeFiles(String dir) {
    FileCategorizerUtils.organizeFiles(dir, this.&determineRelationships)
}
