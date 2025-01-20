pipeline {
    agent any
    tools {
        maven 'maveen3.8.8'
    }
    stages {
        stage ("exicute maven by defalt") {
            steps {
                echo "exicuting default tool "
                sh "maven --version"
            }
        }
        stage ("override to the default tool") {
            tools {
                jdk 'jdk-18'
            }
            steps {
                echo "java building"
                sh "java --version"
            }
        }
    }
}