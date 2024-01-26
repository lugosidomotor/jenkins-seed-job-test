def jobPrefix = FOLDER ? "${FOLDER}/" : ""

if (FOLDER) {
    folder(FOLDER) {
        displayName("${FOLDER}")
    }
}

job("${jobPrefix}helloWorld-${BRANCH_NAME}") {
    steps {
        shell("echo Building from branch: ${BRANCH_NAME}")
        shell("echo Hello World!")
    }
}
