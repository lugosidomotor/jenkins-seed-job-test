// Example of a DSL script (e.g., example.groovy)

job("helloWorld-${BRANCH_NAME}") {
    steps {
        shell('echo Building from branch: ${branchName}')
        shell('echo Hello World!')
    }
}
