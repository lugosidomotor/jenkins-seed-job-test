def folderPath = build.workspace.child(FOLDER)

if (!folderPath.exists()) {
    folderPath.mkdirs()
}

def jobPrefix = FOLDER ? "${FOLDER}/" : ""

job("${jobPrefix}helloWorld-${BRANCH_NAME}") {
    steps {
        shell("echo Building from branch: ${BRANCH_NAME}")
        shell("echo Hello World!")
    }
}
