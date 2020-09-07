pipeline {
    agent none
    environment {
      registry = '1111111111111.dkr.ecr.eu-central-1.amazonaws.com/myRepo'
      registryCredential = 'ID_OF_MY_AWS_JENKINS_CREDENTIAL'
      dockerImage = ''
    }
    stages {

        stage('Testing') {
            agent { docker 'maven:3-alpine' }
            steps {
                sh 'mvn test'
            }
        }

        stage('Building') {
            agent { docker 'maven:3-alpine' }
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Executing Java') {
            steps {
                echo 'Hello, JDK'
                sh 'docker --version'
            }
        }

        stage('Linting Dockerfile') {
            agent { docker 'hadolint/hadolint' }
            steps {
                sh 'hadolint Dockerfile'
            }
        }

    }
}