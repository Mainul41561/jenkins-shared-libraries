def call(String gitUrl, String gitBranch = "main") {
    try {
        checkout([
            $class: 'GitSCM',
            branches: [[name: "*/${gitBranch}"]],
            userRemoteConfigs: [[url: gitUrl]]
        ])
        
        return sh(script: "git rev-parse HEAD", returnStdout: true).trim()
    } catch (err) {
        error "Git checkout failed for ${gitUrl} on branch ${gitBranch}: ${err}"
    }
}

