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
        dir('nodeLoc') {
            def helper = load 'nodeLoc/helper.groovy'
            echo 'Launch the docker container for testing'

            helper.test(ato_app);
        }
    }
    
    echo "Only the most recent build  will be deployed"
    stage('feature check') {
        echo 'Do not actually deploy on my feature branch...'
        
    }

    stage('cleanup') {
        dir('nodeLoc') {
            deleteDir() //cleanup!
        }
    }
}