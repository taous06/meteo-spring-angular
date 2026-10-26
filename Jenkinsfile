pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {
        stage('Compilation') {
            steps {
                dir('meteo') {
                    sh 'mvn -B clean compile'
                }
            }
        }

        stage('Tests') {
            steps {
                dir('meteo') {
                    sh 'mvn -B test'
                }
            }
        }
    }
}