pipeline {
    agent none
    stages {
        stage('Testing') {
            agent { docker 'maven:3-alpine' }
            steps {
                sh 'mvn test'
            }
        }
        stage('Building') {
            agent { docker 'maven:3-alpine' }
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Example Test') {
            agent { docker 'openjdk:8-jre' }
            steps {
                echo 'Hello, JDK'
                sh 'java -version'
            }
        }
    }
}