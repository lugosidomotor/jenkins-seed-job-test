job('seed-from-dev') {
    parameters {
        stringParam('BRANCH_NAME', 'default-branch', 'The name of the branch to seed from')
        stringParam('FOLDER', 'TEST', 'The name of the seed job')
    }

    scm {
        git {
            remote {
                url 'https://github.com/lugosidomotor/jenkins-seed-job-test'
                credentials('your-credentials-id')
            }
            branch '${BRANCH_NAME}'
        }
    }

    steps {
        dsl {
            external('jobs/*.groovy')
        }
    }
}

