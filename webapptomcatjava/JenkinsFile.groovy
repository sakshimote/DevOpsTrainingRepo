pipeline {
    agent any
    stages {
        stage('Build Application') {
            steps {
                sh 'mvn -f webapptomcatjava/pom.xml test'
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
                    echo "deploy application in staging"
                }
            }

            stage('Deploy in prod environment'){
                steps{
                    echo "deploy application in production"
                }
            }


        }

    }

        