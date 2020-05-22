node{
   stage('SCM Checkout'){
       git credentialsId: 'GITCredentials', url: 'https://github.com/narasimhamurthyk3/ECMSampleApplication.git'
   }
   stage('Mvn Package'){
     def mvnHome = tool name: 'maven-3', type: 'maven'
     def mvnCMD = "${mvnHome}/bin/mvn"
     sh "${mvnCMD} clean package"
   }
   stage('Build Docker Image'){
     sh 'docker build -t narasimhamurthyk/ecm-sample-application:1.0 .'
   }
   
   stage('Push Docker Image'){
     withCredentials([string(credentialsId: 'docker-hub-password', variable: 'dockerHubPwd')]) {
        sh "docker login -u narasimhamurthyk -p ${dockerHubPwd}"
     }
     sh 'docker push narasimhamurthyk/ecm-sample-application:1.0'
   }

   stage('Run Container on Dev Server'){
     def dockerRun = 'docker run -p 8084:8084 -d --name narasimhamurthyk/ecm-sample-application:1.0'
     sh 'docker run -p 8084:8084 -d --name ecm-sample-application narasimhamurthyk/ecm-sample-application:1.0'
	
    
   }
}
