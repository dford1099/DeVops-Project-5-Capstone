pipeline {
   agent {
       docker {
          image 'maven:3-alpine'
          args '-v $HOME/.m2:/root/.m2'
       }
    }
    stages {

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