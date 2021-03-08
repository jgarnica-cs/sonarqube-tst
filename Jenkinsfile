node {
  stage('SCM') {
    checkout scm
  }
  stage('Analyzing UTs') {
    withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {

        def mvn = tool 'Maven 3.6.3';
        echo "Showing event ID"
        def coverage = '0'// replace with a Jenkins parameter or create a job to read from env
        if (env.CHANGE_ID) {
            echo env.CHANGE_ID
            try {
                // Checkout to develop and run mvn test
                 sh "${mvn}/bin/mvn test"
                 jacoco(
                       execPattern: 'target/*.exec',
                       classPattern: 'target/classes',
                       sourcePattern: 'src/main/java',
                       exclusionPattern: 'src/test*',
                       minimumInstructionCoverage: coverage
                 )
                 pullRequest.removeLabel('JenkinsReviewFailed')
                 pullRequest.addLabel('JenkinsReviewPassed')
                 pullRequest.review('APPROVE', 'The execution, coverage and unit test failure verification passed successfully. This can be merged without issues.')

                sh 'ls'

            } catch (all) {
                def error = "${all}"
                echo error
                if(error.contains("hudson.AbortException: script returned exit code 1")) {
                    echo "Exception detected: test errors"
                    pullRequest.review('REQUEST_CHANGES', 'The build had failed. Maybe some of your unit tests are failing up')
                } else {
                    echo "Exception detected: error on the build"
                    pullRequest.review('REQUEST_CHANGES', 'Error on the build')
                }

                try {
                    pullRequest.removeLabel('JenkinsReviewPassed')
                    pullRequest.addLabel('JenkinsReviewFailed')
                } catch(ex) {
                    echo 'Finished'
                }

            }
        }
    }
  }
}