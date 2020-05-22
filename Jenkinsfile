pipeline {
    agent any
    environment{
        DOCKER_TAG = getDockerTag()              
    }
    stages{
	
	
	    stage('Mvn Package){
            steps{
			 echo "this is a DOCKER_TAG:: ${DOCKER_TAG}";
			 def mvnHome = tool name: 'maven-3', type: 'maven'
			 def mvnCMD = "${mvnHome}/bin/mvn"
			 sh "${mvnCMD} clean package"
                
            }
        }
	
        stage('Build Docker Image'){
            steps{
                sh "docker build . -t ${DOCKER_TAG}"
            }
        }
  
 
    }
}

def getDockerTag(){
    def tag  = sh script: 'git rev-parse HEAD', returnStdout: true
    return tag
}
