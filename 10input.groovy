pipeline {
    agent any 
    stages {
        stage ('stage') {
            steps {
                timeout (time: 300, unit: SECONDS){
                    input message: 'Are you Building the applicaiton', ok: 'yes', submitter: 'siva, bhavika'
                }
                echo "Builing the applicaiton"
            }
        }
    }
}


