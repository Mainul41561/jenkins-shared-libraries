def call(String projectName, String imageTag = "latest", String dockerHubUser) {
    try {
        echo "🐳 Building Docker image: ${dockerHubUser}/${projectName}:${imageTag}"

        sh """
            docker build \
              --pull \
              --no-cache \
              -t ${dockerHubUser}/${projectName}:${imageTag} .
        """
        return "${dockerHubUser}/${projectName}:${imageTag}"
    } catch (err) {
        error "Docker build failed for ${dockerHubUser}/${projectName}:${imageTag}: ${err}"
    }
}

