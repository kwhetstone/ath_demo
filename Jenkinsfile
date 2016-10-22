node('bagel') {
    dir('nodeLoc') {
    // some block
    }
 
    def ato_app
    stage('build') {
        dir('nodeLoc') {
            checkout scm
            //git credentialsId: 'a62b642d-fdda-44b9-88bc-1318a2d9e332', url: 'http://github.com/kwhetstone/ath_demo/'
            
            //bat 'npm install'
            sh 'npm install'
        }
        ato_app = docker.build("kwhetstone/ato_app:${env.BUILD_TAG}", 'nodeLoc')
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
        //push to dockerhub
        docker.withRegistry('https://hub.docker.com/, 'kwhetstone_dockerhub']) { //defined in credentials
             ato_app.push('latest')
        }
    }

    stage('cleanup') {
        dir('nodeLoc') {
            deleteDir() //cleanup!
        }
    }
}