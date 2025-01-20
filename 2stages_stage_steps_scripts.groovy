pipeline {
    agent any
    stages {
        stage ('stages stage steps script') {
            steps{
                echo "hello world"
            }
        }
        stage ('script in steps') {
            steps {
               script {
                    def course = "k8s" // static definition
                    if (course == "k8s") { // $(params.name)
                        println ("Thanks for enrolling to ${course}")
                    }
                    else
                        println("Do enroll")
                    // just sleep for 5 seconds
                    // https://www.jenkins.io/doc/pipeline/steps/workflow-basic-steps/#sleep-sleep
                    // This will pause the pipelines , till the time mentioned
                    sleep 5 // sh "sleep 5"
                    echo "********************** Script block ended **********************"
                }

            }
        }
    }
}