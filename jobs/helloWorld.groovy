// Példa egy DSL scriptre (pl. example.groovy)
def branchName = binding.variables.get('branchName') ?: 'main'

job("example-${branchName}") {
  steps {
    shell('echo Hello World!')
  }
}
