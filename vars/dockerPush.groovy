def call(String Project, String imageTag = "latest", String dockerHubUser){
  // replace credentialsId with ur own credentialsId
  withCredentials([usernamePassword(credentialsId: 'urcredentialsId', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
  sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
