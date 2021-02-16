node('Master') {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
        def mvn = tool 'Maven 3.6.3';
        withSonarQubeEnv() {
            sh "${mvn}/bin/mvn clean install -Dmaven.test.failure.ignore=true"
            sh "${mvn}/bin/mvn verify sonar:sonar -X"
        }
    }
  }
}