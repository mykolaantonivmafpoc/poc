pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  triggers {
    cron('@daily')
  }
  stages {
    stage('Build') {
      steps {
        sh 'docker build -t apiapp:1.0.0-stable -f docker/Dockerfile.api .'
        sh 'docker build -t stableapp:1.0.0-stable -f docker/Dockerfile.stable .'
        sh 'docker build -t dbapp:1.0.0-stable -f docker/Dockerfile.db .'
      }
    }
    stage('Publish') {
      when {
        branch 'master'
      }
      steps {
	withDockerRegistry([ credentialsId: "6533de7e-17a4-4376-969b-e86bc1e4f903", url: "" ]) {
          sh 'docker push apiapp:latest'
	  sh 'docker push apiapp:latest'
	}
      }
    }
  }
}
