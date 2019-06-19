# Starting off with the Jenkins base Image
FROM jenkins/jenkins:latest

# Skip the initial setup wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
ENV BUILD_URL = localhost:8080
ENV JENKINS_URL = localhost:8080

#Configure jenkins working directory 
VOLUME /var/jenkins_home

#Install required plugins
RUN /usr/local/bin/install-plugins.sh git matrix-auth amazon-ecs amazon-ecr build-pipeline-plugin workflow-aggregator github-oauth configuration-as-code authorize-project configuration-as-code-support job-dsl blueocean

#Configure Jenkins as a code plugin
COPY executors.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY default-user.groovy /usr/share/jenkins/ref/init.groovy.d/