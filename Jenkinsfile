node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {

        def mvn = tool 'Maven 3.6.3';
        echo "Showing event ID"
        if (env.CHANGE_ID) {
            echo env.CHANGE_ID
            sh 'mvn clean install'
            // echo sh(script: 'env|sort', returnStdout: true)
            pullRequest.review('REQUEST_CHANGES', 'Change is the essential process of all existence.')
        }
    }
  }
}