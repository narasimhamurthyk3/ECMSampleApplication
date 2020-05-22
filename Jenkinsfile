pipeline {
    agent any
    environment{
        DOCKER_TAG = getDockerTag()              
    }
    stages{
        stage('Build Docker Image'){
            steps{
                echo "this is a DOCKER_TAG:: ${DOCKER_TAG}";
                sh "docker build . -t ${DOCKER_TAG}"
            }
        }
  
 
    }
}

def getDockerTag(){
    def tag  = sh script: 'git rev-parse HEAD', returnStdout: true
    return tag
}
