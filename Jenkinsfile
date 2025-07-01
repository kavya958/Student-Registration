pipeline {
    agent any

    tools {
        maven 'Maven_3.9.1'  // Must match name in Jenkins Maven config
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/kavya958/Student-Registration.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        success {
            echo '✅ Build and Tests Passed!'
        }
        failure {
            echo '❌ Build Failed!'
        }
    }
}
