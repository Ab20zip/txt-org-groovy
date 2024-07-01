#!/usr/bin/env groovy

static def runScript(scriptName, String dir) {
    def script = new GroovyShell().parse(new File("scripts/${scriptName}.groovy"))
    script.organizeFiles(dir)
}

static def main(String[] args) {
    def criteriaScripts = [
            "OrganizeByModificationDate",
            "OrganizeByFileType",
            "ArchiveFiles",
            "OrganizeByFileSize",
            "OrganizeByFirstLetter",
            "OrganizeByOwner",
            "OrganizeByAccessFrequency",
            "OrganizeByMetadataTags",
            "OrganizeByFileImportance",
            "OrganizeByFileAge",
            "OrganizeByFilePermissions",
            "OrganizeByFileHashes",
            "OrganizeByFileContentSimilarity",
            "OrganizeByFileRelationships",
            "OrganizeByFileLanguage",
            "OrganizeByFileCollaborators"
    ]

    if (args.length < 2) {
        println "Usage: groovy main.groovy <directory> <criteria>"
        return
    }

    String dir = args[0]
    String criteria = args[1]

    if (criteriaScripts.contains(criteria)) {
        runScript(criteria, dir)
    } else {
        println "Invalid criteria. Available criteria are: ${criteriaScripts.join(', ')}"
    }
}
