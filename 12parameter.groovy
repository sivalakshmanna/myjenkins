pipeline {
    agent any
    parameters {
        string (name: 'PERSON', defaultValue: 'siva', description: 'Who should I say hello to?')
        string (name: 'BRANCH_NAME', defaultValue: "main", description: 'Whats the branch i should build??')
        booleanParam( // true, false
            name: 'TOOGLE',
            defaultValue: true,
            description: 'toogle this value'
        )
        choice(
            name: 'ENV',
            choices: ['dev', 'tst', 'stg', 'prd'],
            description: 'Select the env u want to deploy'
        )
    }
     stages {
        stage ('Example') {
            steps {
                echo "Hello ${params.PERSON}"
                echo "Boolean parameter is: ${params.TOOGLE}"
                echo "Deploying to ${params.ENV} environment"
            }
        }
    }
}