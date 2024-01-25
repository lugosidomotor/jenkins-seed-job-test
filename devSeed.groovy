folder('seed') {
  description('Folder for development branch jobs')
}

job('seed/seed_job_from_dev') {
  parameters {
    stringParam('BRANCH_NAME', 'dev', 'The name of the branch to build from.')
  }
  
  steps {
    script {
      // Assign the parameter value to a variable within a script block
      def branchName = BRANCH_NAME
    }

    scm {
      git {
        remote {
          url 'https://github.com/lugosidomotor/jenkins-seed-job-test'
        }
        // Use the variable
        branches("*/${branchName}")
      }
    }

    jobDsl {
      additionalParameters([branchName: branchName])
      targets '*jobs/*.groovy'
    }
  }
}
