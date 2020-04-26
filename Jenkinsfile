// pipeline {
//     agent any
    
//     stages {
//         stage('Build Backend') {
//             steps {
//                 echo 'building...'
//                 sh 'mvn clean package -DskipTests=true'
//             }
//         }
//         stage('Unit Tests') {
//             steps {
//                 sh 'mvn test'
//             }
//         }
//     }
// }

node('java') {
    stage('Build Backend') {
        sh 'mvn clean package -DskipTests=true'
    }
    stage('Unit Tests') {
        sh 'mvn test'
    }
}