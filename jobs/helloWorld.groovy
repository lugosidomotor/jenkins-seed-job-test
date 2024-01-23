// Assuming branchName is passed from the seed job
job("example-${branchName}") {
  steps {
    shell('echo Hello World!')
  }
}
