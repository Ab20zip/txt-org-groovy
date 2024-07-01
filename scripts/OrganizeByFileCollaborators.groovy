package scripts

import utils.FileCategorizerUtils

static def determineCollaborators(File file) {
    return file.name.contains("team") ? ["Collaborators/TeamA"] : ["Collaborators/Individual"]
}

def organizeFiles(String dir) {
    FileCategorizerUtils.organizeFiles(dir, this.&determineCollaborators)
}
