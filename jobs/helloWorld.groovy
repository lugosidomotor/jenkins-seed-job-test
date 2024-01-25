// Example of a DSL script (e.g., example.groovy)
def branchName = binding.variables.get('branchName') ?: 'main'

job("example-${branchName}") {
    steps {
        shell('echo Building from branch: ${branchName}')
        shell('echo Hello World!')
    }
}
