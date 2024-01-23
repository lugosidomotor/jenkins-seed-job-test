job('seed_job_from_main') {
  scm {
    git {
      remote {
        url 'https://github.com/lugosidomotor/jenkins-seed-job-test'
      }
    }
  }
  steps {
    jobDsl {
      targets '**/jobs/*.groovy'
    }
  }
}