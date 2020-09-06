pipeline {
    agent { docker 'hadolint/hadolint' }
    stages {
        stage('Example Build') {
            steps {
                echo 'Hello, Maven'
//                 sh 'mvn --version'
            }
        }
        stage('Linting Test') {

            steps {
                echo 'Hello, Linting'
                sh 'ls'
                sh 'hadolint Dockerfile'
            }
        }
    }
}