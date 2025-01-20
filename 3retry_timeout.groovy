pipeline {
    agent any
    stages {
        stage ("build the retry block") {
           steps {
            retry (3) {
                echo "Attempting Build Stage"
             
              // if any error accors during build it will retrys up to 3 times if onece exicute ontime  there is no error it will exicute  the next steps
            // The message "Attempting Build Stage" will be printed once, because there is no error in the block.
            // The pipeline will not retry, even though retry(3) is set, because no error occurs in the steps block.
            }
               echo "Printing after 3 retrys"
           }
        }
    }
}

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                retry(3) { // Retry up to 3 times if there is an error
                    echo "Attempting Build Stage"
                    error "Simulated error in Build" // This causes an error, triggering a retry
                    // Jenkins will retry up to 3 times (because of retry(3)) if the error occurs inside the retry block.
                    // If all retries fail, the pipeline will fail after the last retry attempt.
                }
                echo "Printing after 3 retrys"  // this step is no exicute
            }
        }
    }
}


//    Timeout 

pipeline {
    agent any
    stages {
        stage ('timeout') {
            steps{
                timeout(time: 30, unit: SECONDS ) { //Values: NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS
                     echo "Sleeping for 20 seconds"
                     sleep 20   //this steps will exicute becuse time out seconds is 30 our sleep time is 20 so it will exicute 
                }
                
            }
        }
        stage ('timeout error') {
            steps{
                timeout(time: 30, unit: SECONDS ) { //Values: NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS
                   echo "Sleeping for 60 seconds"
                   sleep 60   //this steps will not exicute becuse time out seconds is 30 our sleep time is 60 so it will not  exicute 
                }
                
            }
        }
    }
}
