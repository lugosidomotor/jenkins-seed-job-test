folder('seed') {
  description('Folder for development branch jobs')
}

job('seed/seed_job_from_dev') {  
  scm {
    git {
      remote {
        url 'https://github.com/lugosidomotor/jenkins-seed-job-test'
      }
      branches('dev')
    }
  }
  
  steps {
    jobDsl {
      targets '*jobs/*.groovy'
      additionalParameters {
        branchName dev
      }
    }
  }
}
