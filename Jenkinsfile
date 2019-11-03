pipeline {
         agent { label 'clj' }
         stages {
                stage('test') {
                              steps {
                                    sh 'clj -Atest'
                              }
                }
         }
}
