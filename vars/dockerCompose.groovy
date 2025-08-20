def call(String action, String composeFile = "docker-compose.yml", String projectName) {
    try {
        echo "🐳 Running docker-compose '${action}' with file: ${composeFile}, project: ${projectName}"

        sh """
            docker-compose -f ${composeFile} -p ${projectName} ${action}
        """
    } catch (err) {
        error "Docker-compose '${action}' failed for project '${projectName}': ${err}"
    }
}
