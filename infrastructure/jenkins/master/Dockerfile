# Starting off with the Jenkins base Image
FROM jenkins/jenkins:latest
# Installing the plugins we need using the in-built install-plugins.sh script

# Skip the initial setup wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
ENV BUILD_URL = localhost:8080
ENV JENKINS_URL = localhost:8080

#Configure jenkins working directory 
VOLUME /var/jenkins_home

#Install Docker
USER root
RUN apt-get update -qq \
    && apt-get install -qqy apt-transport-https ca-certificates curl gnupg2 software-properties-common 
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
RUN add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/debian \
   $(lsb_release -cs) \
   stable"
RUN apt-get update  -qq \
    && apt-get install docker-ce=17.12.1~ce-0~debian -y
RUN usermod -aG docker jenkins

#Install required plugins
RUN /usr/local/bin/install-plugins.sh git matrix-auth amazon-ecs amazon-ecr build-pipeline-plugin workflow-aggregator github-oauth configuration-as-code authorize-project configuration-as-code-support job-dsl

#Configure Jenkins as a code plugin
COPY Jenkins.yaml ${JENKINS_HOME}/casc_configs
ENV CASC_JENKINS_CONFIG=${JENKINS_HOME}/casc_configs
