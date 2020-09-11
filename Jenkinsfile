pipeline {
    agent none
   /* environment {
      registry = '1111111111111.dkr.ecr.eu-central-1.amazonaws.com/myRepo'
      registryCredential = 'ID_OF_MY_AWS_JENKINS_CREDENTIAL'
      dockerImage = ''
    } */


    stages {

     /*   stage('Testing and Building and deploy') {
            agent { docker 'maven:3-alpine' }
            steps {
               // sh './scripts/testing.sh'
                sh 'ls -l'
              //  sh "cp ./target/customer-0.0.1-SNAPSHOT.jar ${WORKSPACE}"
               //    archiveArtifacts 'customer-0.0.1-SNAPSHOT.jar'
                sh "pwd"
                echo "${WORKSPACE}"
            }
        } */
        
        stage('Checking without docker pipeline') {
            agent any
            steps {
                sh './scripts/testing.sh'
                sh 'ls -l'
                sh "cp ./target/customer-0.0.1-SNAPSHOT.jar ${WORKSPACE}"
                   archiveArtifacts 'customer-0.0.1-SNAPSHOT.jar'
                sh "pwd"
                echo "${WORKSPACE}"
                sh './scripts/deploy.sh'
            }
        }
        
  /*      stage('Copy file outside') {
            agent any
            steps {
                  def image = docker.image("maven:3-alpine")
                 image.inside { 
                   sh 'ls -l'
                   sh "cp ./target/customer-0.0.1-SNAPSHOT.jar ${WORKSPACE}"
                   archiveArtifacts 'customer-0.0.1-SNAPSHOT.jar'
                 }
                }
        } 

        stage('Linting Dockerfile') {
            agent { docker 'hadolint/hadolint' }
            steps {
               // sh 'hadolint Dockerfile'
            }
        }*/
      
        stage('Deploy') {
          // agent { docker 'docker:latest' }
            agent any
            steps {
                sh "pwd"
                sh "docker image ls"
                echo "${WORKSPACE}"
                sh 'ls -l'
              //  sh './scripts/deploy.sh'
            }
        }

    }
}
