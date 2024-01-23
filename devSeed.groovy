folder('dev') {
  description('Folder for development branch jobs')
}

job('dev/Job_DSL_Seed_Dev') {
  parameters {
    stringParam('BRANCH_NAME', 'dev', 'The name of the branch to build from.')
  }
  
  scm {
    git {
      remote {
        url 'https://github.com/lugosidomotor/jenkins-seed-job-test'
      }
      branches('${BRANCH_NAME}')  // Use the parameter to specify the branch
    }
  }
  
  steps {
    jobDsl {
      targets '*.groovy'
    }
  }
}
