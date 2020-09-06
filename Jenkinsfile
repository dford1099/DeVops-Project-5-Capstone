pipeline {
    agent { docker 'hadolint/hadolint' }
    stages {
        stage('Build') {
            steps {
                echo 'Hello, Maven'
            }
        }
        stage('Linting') {
            steps {
                echo 'Hello, Linting'
                sh 'ls'
                sh 'hadolint Dockerfile'
            }
        }
        stage('Deployment') {
            steps {
                echo 'Hello, Deployment'
            }
        }
    }
}