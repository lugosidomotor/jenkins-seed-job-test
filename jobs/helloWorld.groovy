// example.groovy
def branchName = BRANCH_NAME ?: 'main' // Default to 'main' if BRANCH_NAME is not provided

job("example-${branchName}") {
  steps {
    shell('echo Hello World!')
  }
}
