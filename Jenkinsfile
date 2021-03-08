node {
  stage('SCM') {
    checkout scm
  }
  stage('Analyzing UTs') {
    withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {

        def mvn = tool 'Maven 3.6.3';
        def coverage = '100'// replace with a Jenkins parameter or create a job to read from env
        if (env.CHANGE_ID) {

            try {
                // Checkout to develop and run mvn test
                 sh "${mvn}/bin/mvn test"
                 jacoco(
                       execPattern: 'target/*.exec',
                       classPattern: 'target/classes',
                       sourcePattern: 'src/main/java',
                       exclusionPattern: 'src/test*',
                       minimumLineCoverage: coverage
                 )

                 def jacocoReport = sh(
                    script: "cat target/site/jacoco/index.html",
                    returnStdout: true
                 ).trim()

                // Find a better way to do so, try to check XmlSlurper
                echo jacocoReport
                def index = jacocoReport.indexOf('<td class="ctr2">')
                echo index.toString()
                def lineCoverage = jacocoReport.substring(index + 17, index + 20)

                 // Getting information from html
                 /*def ulDom = new XmlSlurper().parseText(jacocoReport)
                 def elements = ulDom.table.findAll {
                    echo it.localText()
                 }*/

                 try {
                    pullRequest.removeLabel('JenkinsReviewFailed')
                    pullRequest.addLabel('JenkinsReviewPassed')
                    pullRequest.review('APPROVE', 'The execution, coverage and unit test failure verification passed successfully. \n Line coverage: ${lineCoverage}')
                 } catch(ex) {
                    echo "Published"
                 }
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