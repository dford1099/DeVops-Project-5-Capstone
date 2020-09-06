pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Testing') {
            steps {
                echo 'Running Testing'
                sh 'mvn test'
            }
        }
        stage('Linting') {
            steps {
                echo 'Running Linting'
                'hadolint Dockerfile'
            }
        }
        stage('Packing') {
            steps {
                echo 'Packing'
                sh 'mvn clean package'
            }
        }
    }
}