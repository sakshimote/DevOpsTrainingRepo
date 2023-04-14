job('First_Maven_Project_via_DSL'){
    description("first maven project generated on ${new Date()}, for testing dsl")
    scm{
        git("https://github.com/sakshimote/DevOpsTrainingRepo.git",main)
    }
    triggers{
        scm('* * * * *')
    }
    steps{
        maven('clean package','mavendemo/pom.xml')
    }
    publishers{
        archiveArtifacts '**/*.jar'
    }
}