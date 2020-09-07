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

        stage('Test') {
            steps {
                sh 'export MAVEN=/var/lib/jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven_3.6.0/bin'
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
                echo 'docker --version'
            }
        }

    }
}