folder('seed') {
  description('Folder for development branch jobs')
}

job('seed/seed_job_from_dev') {
  }
  
  steps {
    scm {
      git {
        remote {
          url 'https://github.com/lugosidomotor/jenkins-seed-job-test'
        }
        // Use the variable
        branches("dev")
      }
    }

    jobDsl {
      additionalParameters([branchName: "dev"])
      targets '*jobs/*.groovy'
    }
  }
}
