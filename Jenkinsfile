pipeline {
    agent none
    environment {
      registry = '156790592858.dkr.ecr.us-west-2.amazonaws.com/spring-tdd'
      registryCredential = '13f73a3f-aa94-4ebf-b2c3-02a62c6ca3d3'
      dockerImage = ''
    } 


    stages {
 
        stage('Build and deploy') {
            agent any
            steps {
                sh './scripts/testing.sh'
                sh 'ls -l'
                sh "cp ./target/customer-0.0.1-SNAPSHOT.jar ${WORKSPACE}"
                   archiveArtifacts 'customer-0.0.1-SNAPSHOT.jar'
               
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                    docker.withRegistry("https://" + registry, "ecr:us-west-2:" + registryCredential) {
                        dockerImage.push()
                     }
                }
            }
        }

        stage('Deploy Image to K8s') {
            agent any
            steps {
                sh './scripts/deploy.sh'
            }
        }
    }
}
