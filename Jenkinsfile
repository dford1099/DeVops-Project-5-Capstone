pipeline {
    agent { docker 'hadolint/hadolint' }
    stages {
        stage('Example Build') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                echo 'Hello, Maven'
                sh 'mvn --version'
            }
        }
        stage('Linting Test') {

            steps {
                echo 'Hello, Linting'
                sh 'ls'
                sh 'hadolint Dockerfile'
            }
        }
    }
}