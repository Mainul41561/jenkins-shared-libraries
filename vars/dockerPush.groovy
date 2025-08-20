def call(String project, String imageTag = "latest", String dockerHubUser){
    // replace credentialsId with your Jenkins credentialsId
    withCredentials([usernamePassword(credentialsId: 'urcredentialsId', 
                                      usernameVariable: 'DOCKER_USER', 
                                      passwordVariable: 'DOCKER_PASS')]) {
        sh """
            echo "${DOCKER_PASS}" | docker login -u "${DOCKER_USER}" --password-stdin
            docker push ${dockerHubUser}/${project}:${imageTag}
        """
    }
}
