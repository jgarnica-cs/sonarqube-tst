node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'Maven 3.6.3';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn sonar:sonar -X"
    }
  }
}