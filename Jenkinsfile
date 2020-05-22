pipeline {
    agent any
    environment{
        DOCKER_TAG = getDockerTag()
    }
    stages{
	
	   stage('Mvn Package'){
	   steps{
			 def mvnHome = tool name: 'maven-3', type: 'maven'
			 def mvnCMD = "${mvnHome}/bin/mvn"
			 sh "${mvnCMD} clean package"
			 }
			        } 
	
        stage('Build Docker Image'){
            steps{
                sh "docker build . -t narasimhamurthyk/ecm-sample-application:${DOCKER_TAG} "
            }
        }
        stage('DockerHub Push'){
            steps{
                withCredentials([string(credentialsId: 'docker-hub-password', variable: 'dockerHubPwd')]) {
                    sh "docker login -u narasimhamurthyk -p ${dockerHubPwd}"
                    sh "docker push narasimhamurthyk/ecm-sample-application:${DOCKER_TAG}"
                }
            }
        }
  
    }
}

def getDockerTag(){
    def tag  = sh script: 'git rev-parse HEAD', returnStdout: true
    return tag
}
