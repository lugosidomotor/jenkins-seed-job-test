// Assuming BRANCH_NAME is passed as an additional parameter
def branch = BRANCH_NAME ?: 'main'  // Default to 'main' if BRANCH_NAME is not provided

job("example-${branch}") {
  steps {
    shell('echo Hello World!')
  }
}
