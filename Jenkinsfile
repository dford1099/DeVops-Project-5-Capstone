pipeline {
    agent none
    environment {
      registry = '156790592858.dkr.ecr.us-west-2.amazonaws.com/spring-tdd'
      registryCredential = '13f73a3f-aa94-4ebf-b2c3-02a62c6ca3d3'
      dockerImage = ''
    } 


    stages {

        stage('Testing and Building and deploy') {
            agent { docker 'maven:3-alpine' }
            steps {
                sh './scripts/testing.sh'
                sh 'ls -l'
              //  sh "cp ./target/customer-0.0.1-SNAPSHOT.jar ${WORKSPACE}"
               //    archiveArtifacts 'customer-0.0.1-SNAPSHOT.jar'
                sh "pwd"
                echo "${WORKSPACE}"
            }
        } 
        
        stage('Checking without docker pipeline') {
            agent any
            steps {
                sh './scripts/testing.sh'
                sh 'ls -l'
                sh "cp ./target/customer-0.0.1-SNAPSHOT.jar ${WORKSPACE}"
                   archiveArtifacts 'customer-0.0.1-SNAPSHOT.jar'
                sh "pwd"
                echo "${WORKSPACE}"
                //sh './scripts/deploy.sh'
                script {
                  dockerImage = docker.build registry + ":$BUILD_NUMBER"
               
                  docker.withRegistry("https://" + registry, "ecr:us-west-2:" + registryCredential) {
                    dockerImage.push()
                  }
                }
            }
        }
        
  /*      

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
