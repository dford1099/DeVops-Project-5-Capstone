pipeline {
    agent none
   /* environment {
      registry = '1111111111111.dkr.ecr.eu-central-1.amazonaws.com/myRepo'
      registryCredential = 'ID_OF_MY_AWS_JENKINS_CREDENTIAL'
      dockerImage = ''
    } */


    stages {

        stage('Testing and Building') {
            agent { docker 'maven:3-alpine' }
            steps {
                sh './scripts/testing.sh'
            }
        }

        stage('Linting Dockerfile') {
            agent { docker 'hadolint/hadolint' }
            steps {
                sh 'hadolint Dockerfile'
            }
        }
         stage('Build') {
         agent any
            steps {
                sh 'mvn clean install'
            }
         }
        stage('Deploy') {
        //    agent { docker 'docker:latest' }
            agent any
            steps {
                sh './scripts/deploy.sh'
            }
        }

    }
}
