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
        new File('jobs').eachFile { file ->
          if (file.name.endsWith('.groovy')) {
            evaluate(file)
          }
        }
      '''
    }
  }
}
