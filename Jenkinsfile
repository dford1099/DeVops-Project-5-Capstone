pipeline {
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
                sh 'hadolint Dockerfile'
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