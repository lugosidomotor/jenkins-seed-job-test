job('seed/seed_job_from_main') {
    parameters {
        stringParam('BRANCH_NAME', 'dev', 'A branch neve, amiből építeni fogunk.')
        // Additional parameters can be added here if needed
    }

    scm {
        git {
            remote {
                url 'https://github.com/lugosidomotor/jenkins-seed-job-test'
            }
            branches('${BRANCH_NAME}')
        }
    }

    steps {
        // Checking the current working directory and workspace
        shell('pwd')
        shell('echo Workspace directory: ${WORKSPACE}')

        // Checking for the 'jobs' directory
        shell('if [ -d "${WORKSPACE}/jobs" ]; then echo "jobs directory found"; else echo "jobs directory NOT found"; fi')

        // Job DSL script
        jobDsl {
            scriptText '''
                def branchName = BRANCH_NAME // This variable comes from the job parameters

                // Setting up the workspace and script directory
                def workspace = new File("${WORKSPACE}")
                def scriptDirectory = new File(workspace, 'jobs')
                println("Script directory: " + scriptDirectory.getAbsolutePath())

                // Checking and evaluating groovy scripts in the 'jobs' directory
                if (scriptDirectory.exists()) {
                    scriptDirectory.eachFile { file ->
                        if (file.name.endsWith('.groovy')) {
                            // Passing the 'branchName' variable to the evaluated script
                            def script = file.text
                            def additionalParameters = [branchName: branchName]
                            evaluate(script, new Binding(additionalParameters))
                        }
                    }
                } else {
                    println("The 'jobs' directory was not found in the workspace.")
                }
            '''
        }
    }
}
