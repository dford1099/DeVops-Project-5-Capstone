pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m2'
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Linting 2') {
             steps {
                ls
             }
        }
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }
  }
}