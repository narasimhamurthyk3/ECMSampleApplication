pipeline {
    agent any
    environment{
        DOCKER_TAG = getDockerTag()   
		NEXUS_URL  = "172.31.34.232:8080"
        IMAGE_URL_WITH_TAG = "narasimhamurthyk/ecm-sample-application:${DOCKER_TAG}"


    }
    stages{
	
	
	    stage('Mvn Package'){
        steps {        
            script {
                Boolean bool = true
                if(bool) {
                    println "The File exists :)"
					echo "this is a IMAGE_URL_WITH_TAG:: ${IMAGE_URL_WITH_TAG}";
					def mvnHome = tool name: 'maven-3', type: 'maven'
					def mvnCMD = "${mvnHome}/bin/mvn"
					sh "${mvnCMD} clean package"
					
                }
                else {
                    println "The File does not exist :("
                }   
            }         
        }
    }
	

	
        stage('Build Docker Image'){
            steps{
                sh "docker build . -t ${IMAGE_URL_WITH_TAG}"
            }
        }
		
		
			    stage('Run Container on Dev Server'){
					steps {        
						script {
						Boolean bool = true
					if(bool) {
                    println "The File exists :)"
					echo "this is a IMAGE_URL_WITH_TAG:: ${IMAGE_URL_WITH_TAG}";
					
					sh 'docker images'
					sh 'kubectl get pods --all-namespaces'
					sh 'docker stop ecm-sample-application'
					sh 'docker rm ecm-sample-application'					
					def dockerRun = 'docker run -p 8084:8084 -d --name ecm-sample-application ${IMAGE_URL_WITH_TAG}'
					sh 'docker run -p 8084:8084 -d --name ecm-sample-application ${IMAGE_URL_WITH_TAG}'
					
						}
                else {
                    println "The File does not exist :("
                }   
            }         
        }
    }
  
 
    }
}

def getDockerTag(){
    def tag  = sh script: 'git rev-parse HEAD', returnStdout: true
    return tag
}
