job('seed/seed_job_from_main') {
  parameters {
    stringParam('BRANCH_NAME', 'dev', 'A branch neve, amiből építeni fogunk.')
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
    // Ellenőrizd az aktuális munkakönyvtárat és a workspace-t
    shell('pwd')
    shell('echo Workspace directory: ${WORKSPACE}')

    // A 'jobs' mappa ellenőrzése
    shell('if [ -d "${WORKSPACE}/jobs" ]; then echo "jobs directory found"; else echo "jobs directory NOT found"; fi')

    // Job DSL script
    jobDsl {
      scriptText '''
        def branchName = "${BRANCH_NAME}"

        def workspace = new File("${WORKSPACE}")
        def scriptDirectory = new File(workspace, 'jobs')
        println("Script directory: " + scriptDirectory.getAbsolutePath())

        if (scriptDirectory.exists()) {
            scriptDirectory.eachFile { file ->
                if (file.name.endsWith('.groovy')) {
                    evaluate(file)
                }
            }
        } else {
            println("The 'jobs' directory was not found in the workspace.")
        }
      '''
    }
  }
}
