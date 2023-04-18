pipeline {
    agent any
    stages {
        stage('Build Application') {
            steps {
                sh 'mvn -f webapptomcatjava/pom.xml clean package'
            }
            post {
                success {
                    echo "Now Archiving the Artifacts...."
                    archiveArtifacts artifacts: '**/*.war'
                }
            }
        }
            stage('Deploy in Staging Environment'){
                steps{
                    build job:'deploy_application_staging_environment'
                }
            }


        }

    }

        