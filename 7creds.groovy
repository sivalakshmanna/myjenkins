// when condition, should have atleast one condition
// https://www.jenkins.io/doc/book/pipeline/syntax/#when
pipeline {
    agent any 
    environment {
        // credentials('id') , this id should be the same from jenkins credeentials 
        GITHUB_CREDS = credentials('devops_github_creds')  // this must be specified in the jenkins "devops_github_creds"
        name = "siva"
    }
    stages {
        stage (build) {
            steps {
                echo "Github Credentials are ${GITHUB_CREDS}"
                echo "User id is : ${GITHUB_CREDS_USR}"
                echo "Password is: ${GITHUB_CREDS_PSW}"
            }
        }
    }
}