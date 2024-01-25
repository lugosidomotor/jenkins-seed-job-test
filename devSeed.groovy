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
      // Use double quotes for string interpolation
      branches("${params.BRANCH_NAME}")
    }
  }
  
  steps {
    jobDsl {
      // Directly use params.BRANCH_NAME
      def branchName = params.BRANCH_NAME
      targets '*jobs/*.groovy'
      additionalParameters [branchName: branchName]
    }
  }
}
