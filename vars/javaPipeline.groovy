def call(Map pipelineParams) {
personName1 = pipelineParams.getOrDefault('personName',null)
pipeline {
    agent any
    tools {
        maven "M3"
    }
    stages {
        stage('Cloning Github') {
            steps {
                git 'https://github.com/awsdevopsaravind/ci.git'
                echo 'github repo cloned'
            }
        }
        stage('Build') {
            steps {
                sh "mvn clean test"
		echo 'build completed'
            }
        }
    }
}
