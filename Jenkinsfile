pipeline {
    agent any

    tools {
        maven 'Maven_3.9.1'
    }

    environment {
        IMAGE_NAME = "student-registration"
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
                    dockerImage = docker.build("${IMAGE_NAME}:latest")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    script {
                        sh """
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker tag ${IMAGE_NAME}:latest $DOCKER_USER/${IMAGE_NAME}:latest
                        docker push $DOCKER_USER/${IMAGE_NAME}:latest
                        """
                    }
                }
            }
        }
    }

    post {
        success {
            echo '✅ Build, Test, Docker Build, and Docker Push completed!'
        }
        failure {
            echo '❌ One or more stages failed.'
        }
    }
}

