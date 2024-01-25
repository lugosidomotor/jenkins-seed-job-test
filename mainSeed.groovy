job('seed-from-main') {
    parameters {
        stringParam('BRANCH_NAME', 'main', 'The name of the branch to seed from')
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

