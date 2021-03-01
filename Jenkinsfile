node('Master') {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
        def mvn = tool 'Maven 3.6.3';
        echo "Showing event ID"
        echo env.CHANGE_ID
        pullRequest.title = 'Updated title'
        pullRequest.body = pullRequest.body + '\nEdited by Pipeline'
    }
  }
}