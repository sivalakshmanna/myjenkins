pipeline {
    agent any
    stages {
        stage ('build') {
            steps {
                echo "building"
            }
        }
        stage ('Stages Running in Parallel') {
            Parallel {
                stage ('sonar check'){
                    steps {
                        echo  "Executing Sonar Scan"
                        sleep 60
                    }
                }
                stage ('FortifyScan') {
                    steps {
                        echo "Executing FortifyScan"
                        sleep 60
                    }
                }
                stage ('Checkmarx Scan') {
                    steps {
                        echo  "Executing Checkmarx Scan"
                        sleep 60
                    }
                }
            }
            stage ('deploy') {
                steps {
                    echo "Executing Deploy"
                }
            }
        }
    }
}