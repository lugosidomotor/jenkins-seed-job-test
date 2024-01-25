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
      def branchName = BRANCH_NAME
      targets '*jobs/*.groovy'
      additionalParameters [branchName: branchName]
    }
  }
}
