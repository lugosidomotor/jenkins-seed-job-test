folder('seed') {
  description('Folder for development branch jobs')
}

job('seed/seed_job_from_dev') {
  parameters {
    stringParam('BRANCH_NAME', 'dev', 'The name of the branch to build from.')
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
      targets '**/jobs/*.groovy'
      // Use scriptText to pass the BRANCH_NAME to the DSL script
      scriptText '''
        def branchName = params.BRANCH_NAME
        evaluate(new File('path/to/jobs/folder/example.groovy'))
      '''
    }
  }
}