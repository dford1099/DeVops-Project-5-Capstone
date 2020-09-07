pipeline {
    agent { docker 'hadolint/hadolint' }
    tools {
        maven 'Maven 3.6.0'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage('Build') {
            steps {
                echo 'Hello, Maven'
            }
        }

        stage('Testing') {
            steps {
                sh 'mvn clean test'
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