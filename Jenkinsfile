node {
  stage('SCM') {
    checkout scm
  }
  stage('Analyzing UTs') {
    withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {

        def mvn = tool 'Maven 3.6.3';
        echo "Showing event ID"
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
                       minimumInstructionCoverage: '100'
                 )
                 echo "Holiiiiiii"
                 pullRequest.removeLabel('JenkinsReviewFailed')
                 pullRequest.addLabel('JenkinsReviewPassed')
                 pullRequest.review('APPROVE', 'The execution, coverage and unit test failure verification passed successfully. This can be merged without issues.')

                sh 'ls'

            } catch (all) {
                echo "${all}"
                echo 'on the exception! '
                if(all == "hudson.AbortException: script returned exit code 1") {
                    pullRequest.review('REQUEST_CHANGES', 'The build had failed. Maybe some of your unit tests are failing up')
                } else {
                    pullRequest.review('REQUEST_CHANGES', 'Error on the build')
                }
                pullRequest.removeLabel('JenkinsReviewPassed')
                pullRequest.addLabel('JenkinsReviewFailed')
            }
        }
    }
  }
}