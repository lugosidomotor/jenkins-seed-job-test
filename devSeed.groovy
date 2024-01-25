job('SeedJob') {
  parameters {
      stringParam('BRANCH_NAME', 'main', 'Branch to use for seeding jobs')
  }

  scm {
      git {
          remote {
              url 'https://github.com/lugosidomotor/jenkins-seed-job-test'
          }
          branch('$BRANCH_NAME')
      }
  }
  steps {
      dsl {
          external('jobs/*.groovy', [BRANCH_NAME: '$BRANCH_NAME'])
      }
  }
}
