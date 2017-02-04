node('bagel') {
    echo "let's get it started"
    stage('code') {
        dir('nodeLoc') {
            //credentials are configured in Jenkins
            //git credentialsId: 'kwhetstone_github', url: 'http://github.com/kwhetstone/ath_demo/'
            scm checkout
        }
    }
 
    def ato_app
    stage('build') {
        dir('nodeLoc') {            
            sh 'npm install'
        }
        ato_app = docker.build("kwhetstone/ato_demo:${env.BUILD_TAG}", 'nodeLoc')
    }

    
    stage('test') {
        echo 'Launch the docker container for testing'
        def toTest = ato_app.run()
        
        dir('nodeLoc') {
            sh 'npm test'
            junit '*.xml'
        }
        toTest.stop()
    }
    
    milestone label: 'prod'
    echo "Only the most recent build  will be deployed"
    stage('deploy') {
        echo 'This will be the external deploy'
        //push to dockerhub; credentials definied in Jenkins
        docker.withRegistry("https://registry.hub.docker.com", 'kwhetstone_dockerhub') { 
             ato_app.push 'latest'
        }
    }

    stage('cleanup') {
        dir('nodeLoc') {
            deleteDir() //cleanup!
        }
    }
}