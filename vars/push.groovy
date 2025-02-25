def call(string credId, string imageName) {
    withCredentials([usernamePassword(
        credentialsId: "${credId}",
        usernameVariable: "dockerHubUsername",
        passwordVariable: "dockerHubPassword"
    )]) {
        sh "docker login -u ${env.dockerHubUsername} -p ${env.dockerHubPassword}"
        sh "docker tag react-single-tier-app ${env.dockerHubUsername}/${imageName}"
        sh "docker push ${env.dockerHubUsername}/${imageName}"
    }
}