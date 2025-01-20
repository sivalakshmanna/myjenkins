// This environment block can be used at pipeline level and stage level
pipeline {
    agent any 
    // this env variables can be used across all the stages
    environment {
        name = "siva"
        course = "k8s"
        cloud = "gcp"
    }
    stages {
        stage ('environment variables') {
            // these environment varibles are specific to this stage only
            environment {
                cloud = "aws"
            }
            steps {
                echo "my name is ${name}"
                echo "enrolled course is ${course}"
                echo "your are learning ${cloud}" // it will show the out put is you are learning aws
            }
        }
        stage ('build') {
            environment {
                name = "bhavika"
            }
            steps {
                echo "my name is ${name}"  //  it will show the output is my name is bhavika
                echo "enrolled course is ${course}"
                echo "your are learning ${cloud}"  
            }
        }
    }
}