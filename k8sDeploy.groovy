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
            // Checkout Source Stage
            gitCommit=\$(git rev-parse HEAD)
            shortCommit=\${gitCommit:0:6}

            // Docker Build Stage
            dockerTag=\${BUILD_NUMBER}-\${shortCommit}
            if [ \${runDefault} = true ]; then
              docker build -t ${dockerRepository}/${dockerImage}:\${dockerTag} -t ${dockerRepository}/${dockerImage}:latest .
            else
              docker build --build-arg username='\${userNameToPrint}' -t ${dockerRepository}/${dockerImage}:\${dockerTag} -t ${dockerRepository}/${dockerImage}:latest .
            fi

            // Docker Login Stage
            docker login -u \${dockerHubUser} -p \${dockerHubPassword}

            // Docker Push Stage
            docker image push --all-tags ${dockerRepository}/${dockerImage}

            // Helm Deploy Stage
            // Include your helm deploy commands here

            // Collect Container Logs Stage
            // Include your log collection commands here
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
