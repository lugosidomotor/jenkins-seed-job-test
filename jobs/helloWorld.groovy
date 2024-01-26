// Example of a DSL script (e.g., example.groovy)

def jobPrefix = FOLDER ? "${FOLDER}/" : ""

job("${jobPrefix}helloWorld-${BRANCH_NAME}") {
    steps {
        shell("echo Building from branch: ${BRANCH_NAME}")
        shell("echo Hello World!")
    }
}
