pipeline {
    agent any
    
    stages {
        stage('Build Backend') {
            steps {
                echo 'building...'
                sh 'mvn clean package -DskipTests=true'
            }
        }
    }
}