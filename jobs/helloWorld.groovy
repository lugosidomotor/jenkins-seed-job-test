// Example of a DSL script (e.g., example.groovy)
def branchName = BRANCH_NAME

job("example-${branchName}") {
    steps {
        shell('echo Building from branch: ${branchName}')
        shell('echo Hello World!')
    }
}
