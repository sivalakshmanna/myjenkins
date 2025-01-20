pipeline{
    agent any
    stages{
        stage('any agent'){
            steps{
                sh "hostname -i"
            }
        }
    }
}

#### specifying agent for total job

pipeline{
    agent {
        label "maven"
    }
    stages {
        stage ('specifying label'){
            steps{
                sh "hostname -i"
            }
        }
    }
}


#### specifing label at the stage level

pipeline {
     // the below agent is at the pipeline level,and applies for all stages
    agent none
    stages {
        stage("agent secifying at stage level"){
            // the below agent is for specific stage, 
            agent {
                node {
                    label 'maven'
                    customWorkspace '/home/siva/jenkins'
                }
            }
            steps{
                echo "Hello !, executing node in agent"
                sh "hostname -i"
                sh "cat imp.txt"
            }
        }
    }
}