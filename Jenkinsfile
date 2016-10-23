node('bagel') { 
    def ato_app
    stage('build') {
        dir('nodeLoc') {
            checkout scm
            //git credentialsId: 'a62b642d-fdda-44b9-88bc-1318a2d9e332', url: 'http://github.com/kwhetstone/ath_demo/'
            
            //bat 'npm install'
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
    
    echo "Only the most recent build  will be deployed"
    stage('feature check') {
        echo 'Let us not actually deploy on my feature branch...'
        
    }

    stage('cleanup') {
        dir('nodeLoc') {
            deleteDir() //cleanup!
        }
    }
}