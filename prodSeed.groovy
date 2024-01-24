folder('seed') {
  description('Folder for development branch jobs')
}

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
    jobDsl {
      scriptText '''
        def branchName = "${BRANCH_NAME}"
        def workspaceRoot = new File('.')
        println "A munkaterület gyökérkönyvtára: ${workspaceRoot.absolutePath}"
        
        def jobsDir = new File(workspaceRoot, 'jobs')
        if (jobsDir.exists()) {
            println "A 'jobs' mappa megtalálható: ${jobsDir.absolutePath}"
        } else {
            println "A 'jobs' mappa nem található."
        }

        def scriptDirectory = new File('jobs')
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
