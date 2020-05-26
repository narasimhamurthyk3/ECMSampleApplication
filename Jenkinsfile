pipeline {
    agent any
    environment{
        DOCKER_TAG = getDockerTag()   		
        IMAGE_URL_WITH_TAG = "narasimhamurthyk/ecm-sample-application:${DOCKER_TAG}"
		VERSION_NUMBER="3.0"

    }
    stages{
	
	    stage('MVN PACKAGE'){
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
               
            }         
        }
    }

stage('sonar-scanner') {

steps{

  script {
  def sonarqubeScannerHome = tool name: 'sonar', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
	  withSonarQubeEnv(credentialsId: 'sonar') {
    // some block
		  echo "inside sonarqube******"
}
      withCredentials([string(credentialsId: 'sonar', variable: 'sonarLogin')]) {
	       echo "inside sonarqube#######"
        //sh "${sonarqubeScannerHome}/bin/sonar-scanner -e -Dsonar.host.url=http://ecmserver:9000 -Dsonar.login=${sonarLogin} -Dsonar.projectName=gs-gradle -Dsonar.projectVersion=${env.BUILD_NUMBER} -Dsonar.projectKey=GS -Dsonar.sources=complete/src/main/ -Dsonar.tests=complete/src/test/ -Dsonar.language=java -Dsonar.java.binaries=."
	      sh "${sonarqubeScannerHome}/bin/sonar-scanner -e -Dsonar.host.url=http://ecmserver:9000 -Dsonar.login=${sonarLogin} -Dsonar.sourceEncoding=UTF-8 -Dsonar.tests=src/test -Dsonar.projectKey=ECMSampleApplication -Dsonar.java.binaries=target/classes -Dsonar.sources=src/main -Dsonar.projectVersion=${env.BUILD_NUMBER}  -Dsonar.language=java -Dsonar.projectBaseDir=/var/lib/jenkins/workspace/ECM-SAMPLE-APPLICATION-JOB"
  
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
