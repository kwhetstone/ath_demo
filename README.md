# ath_demo
A nodejs app completely managed by Jenkins.

The content of the app is unimportant; what's important is the Pipeline script.
The `feature1` branch contains a different `Jenkinsfile` along with loading a separate Groovy utility script.
Keep your Pipeline Scripts [DRY](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself)

While the ATO talk focused on the highlights of Pipeline, there are several places where you can find some additional information.
Most of the pipeline documentation can be found on the Jenkins.io website.

## Some Example Resources
* [Jenkins Documentation](https://jenkins.io/doc/)  There are specific links to the Pipeline handbook
* [Jenkins Project Example Scripts](https://github.com/jenkinsci/pipeline-examples)
* [Docker Pipeline Example](https://github.com/jenkinsci/docker-workflow-plugin/tree/master/demo) which this demo heavily references

## Specific Help Mentioned in the Talk 
* [Pipeline Exmaples](https://jenkins.io/doc/pipeline/examples/)  The 2nd type of Snippet Generator
* [Jenkins Pipeline Plugin Step Documention](https://jenkins.io/doc/pipeline/steps/)
* [Pipeline Shared Libraries](https://github.com/jenkinsci/workflow-cps-global-lib-plugin)  The end all, be all
* [Grape Documentation](http://docs.groovy-lang.org/latest/html/documentation/grape.html#_quick_start) This is extremely useful in loading external libraries 
* [Pipeline Multibranch Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Pipeline+Multibranch+Plugin)
* [GitHub Organization Folder](https://github.com/jenkinsci/github-organization-folder-plugin)
* [Bitbucket Branch Source Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Bitbucket+Branch+Source+Plugin)