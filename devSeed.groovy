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
      // Directly use the parameter name
      branches("${BRANCH_NAME}")
    }
  }
  
  steps {
    jobDsl {
      // Use the parameter directly
      def branchName = BRANCH_NAME
      targets '*jobs/*.groovy'
      // Correct syntax for map assignment in Groovy
      additionalParameters([branchName: branchName])
    }
  }
}
