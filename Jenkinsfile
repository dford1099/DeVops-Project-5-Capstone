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
                echo 'mvn clean test'
            }
        }

        stage('Test') {
            steps {
                sh './test.sh'
            }
        }

        stage('Linting') {
            steps {
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