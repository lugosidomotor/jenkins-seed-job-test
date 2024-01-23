job('YourJobName') {
    description 'Job description here'

    // Adding parameters
    parameters {
        booleanParam('runDefault', true, 'If this checked: Hello World!')
        stringParam('userNameToPrint', '', 'If this specified and runDefault is false: Hello <NAME>!')
        choiceParam('clusterToDeploy', ['docker-desktop'], 'Kubernetes cluster\'s name to deploy')
        stringParam('helmReleaseName', 'hello', 'Helm release name')
        stringParam('dockerImageVersion', 'latest', 'Docker image\'s version to deploy')
        stringParam('branchToBuild', 'main', 'Branch to build')
    }

    scm {
        github('lugosidomotor/devops-assessment', '*/main')
    }
    triggers {
        // Define triggers if needed
    }
    steps {
        shell("""
            echo 'hello'
        """)
    }
    wrappers {
        credentialsBinding {
            usernamePassword('DOCKER_HUB_CREDENTIALS', 'dockerHubUser', 'dockerHubPassword')
            file('KUBECONFIG_FILE', 'kubeconfig')
        }
    }
    publishers {
        // Define publishers for post-build actions
    }
}
