pipeline {
    agent { docker 'hadolint/hadolint' }
    tools {
        maven 'Maven 3.6.0'
    }
    stages {

        stage('Build') {
            steps {
                echo 'Hello, Maven'
            }
        }

        stage('Testing') {
            steps {
                echo 'mvn clean test'
            }
        }

        stage('Linting') {
            steps {
                sh 'hadolint Dockerfile'
            }
        }

        stage('Deployment') {
            steps {
                sh 'mvn --version'
            }
        }

    }
}