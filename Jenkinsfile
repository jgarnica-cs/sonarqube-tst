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
                       minimumInstructionCoverage: '50'
                 )
                 echo "Holiiiiiii"
                 pullRequest.removeLabel('Jenkins review failed')
                 pullRequest.addLabel('Jenkins review passed')
                 pullRequest.review('APPROVE', 'The execution, coverage and unit test failure verification passed successfully. This can be merged without issues.')


            } catch (all) {
                echo "${all}"
                pullRequest.addLabel('Jenkins review failed')
                pullRequest.removeLabel('Jenkins review passed')
                pullRequest.review('REQUEST_CHANGES', 'A failure was detected.')
            }
        }
    }
  }
}