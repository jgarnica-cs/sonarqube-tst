node('Master') {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
        def mvn = tool 'Maven 3.6.3';
        echo env.CHANGE_ID;
    }
  }
}