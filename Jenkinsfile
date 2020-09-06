pipeline {
    agent { docker 'maven:3-alpine' }
    stages {
        stage('Example Build') {
            steps {
                echo 'Hello, Maven'
                sh 'mvn --version'
            }
        }
        stage('Example Test') {
            agent { docker 'openjdk:8-jre' }
            steps {
                echo 'Hello, JDK'
                sh 'mvn test'
            }
        }
        stage('Linting Test') {
            agent { docker 'hadolint/hadolint' }
            steps {
                echo 'Hello, Linting'
                sh 'handolint --version'
            }
        }

    }
}