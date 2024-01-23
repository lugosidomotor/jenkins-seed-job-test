folder('dev') {
  description('Folder for development branch jobs')
}

job('dev/Job_DSL_Seed_Dev') {
  scm {
    git {
      remote {
        url 'https://github.com/lugosidomotor/jenkins-seed-job-test'
      }
      branches('dev')  // Specify the dev branch here
    }
  }
  steps {
    jobDsl {
      targets '*.groovy'
    }
  }
}
