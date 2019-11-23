pipeline {
    stages {
        stage('Run test') {
            steps {
                sh 'clojure -A:test'
            }
        }

        stage('Generate Uberjar') {
            steps {
               sh 'clojure -A:uberjar --app-version `mvn help:evaluate -Dexpression=project.version -q -DforceStdout`'
            }
        }

        stage('Deploy clojar') {
            steps {
                sh 'mvn deploy'
            }
        }

    }
}