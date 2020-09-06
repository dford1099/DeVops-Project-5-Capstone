pipeline {
    agent none
    stages {
        stage('Testing') {
            steps {
                echo 'Running Testing'
                'mvn test'
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
                'mvn clean package'
            }
        }
    }
}