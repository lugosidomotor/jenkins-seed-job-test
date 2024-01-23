pipelineJob('pipeline-job') {
    description 'Job description here'

    parameters {
        booleanParam('runDefault', true, 'If this checked: Hello World!')
        stringParam('userNameToPrint', '', 'If this specified and runDefault is false: Hello <NAME>!')
        choiceParam('clusterToDeploy', ['docker-desktop'], 'Kubernetes cluster\'s name to deploy')
        stringParam('helmReleaseName', 'hello', 'Helm release name')
        stringParam('dockerImageVersion', 'latest', 'Docker image\'s version to deploy')
        stringParam('branchToBuild', 'main', 'Branch to build')
    }

    definition {
        cps {
            script("""
                pipeline {
                    agent any

                    stages {
                        stage('Checkout Source') {
                            steps {
                                script {
                                    // Your checkout source script here
                                }
                            }
                        }

                        stage('Docker Build') {
                            steps {
                                script {
                                    // Your docker build script here
                                }
                            }
                        }

                        // Define other stages similarly

                    }

                    post {
                        always {
                            script {
                                // Your post build script here
                            }
                        }
                    }
                }
            """)
            sandbox()
        }
    }
}
