pipeline {
    agent any

    tools {
        maven 'Maven_3.9.1'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    dockerImage = docker.build("student-registration:latest")
                }
            }
        }
    }

    post {
        success {
            echo '✅ Build, Test, and Docker Build Successful!'
        }
        failure {
            echo '❌ One or more stages failed.'
        }
    }
}
