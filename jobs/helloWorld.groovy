def jobPrefix = FOLDER ? "${FOLDER}/" : ""

// Ha van megadva mappa, akkor hozzuk létre
if (FOLDER) {
    folder(FOLDER) {
        displayName("${FOLDER} Mappa")
    }
}
def jobPrefix = FOLDER ? "${FOLDER}/" : ""

job("${jobPrefix}helloWorld-${BRANCH_NAME}") {
    steps {
        shell("echo Building from branch: ${BRANCH_NAME}")
        shell("echo Hello World!")
    }
}
