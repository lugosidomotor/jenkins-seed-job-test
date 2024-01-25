// Example of a DSL script (e.g., example.groovy)

job("helloWorld-${BRANCH_NAME}") {
    steps {
        shell("echo Building from branch: ${BRANCH_NAME}")
        shell("echo Hello World!")
    }
}
