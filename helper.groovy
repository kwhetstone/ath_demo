def test(dockerImg) {
    def testImg = docker.build('kwhetstone/ato_demo_test:snapshot', 'test')
    dockerImg.withRun { img ->
        testImg.inside("--link=${img.id}:testing") {
            wrap([$class: 'Xvnc', takeScreenshot: true, useXauthority: true]) {
                sh "npm test"
                junit '*.xml'
            }
        }
    }
}

return this