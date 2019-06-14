# Starting off with the Jenkins base Image
FROM jenkins/jenkins:alpine

# Installing the plugins we need using the in-built install-plugins.sh script
RUN /usr/local/bin/install-plugins.sh git matrix-auth amazon-ecs amazon-ecr build-pipeline-plugin workflow-aggregator github-oauth configuration-as-code authorize-project configuration-as-code-support job-dsl

# Skip the initial setup wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
ENV BUILD_URL = https://jenka.azurewebsites.net
ENV JENKINS_URL = https://jenka.azurewebsites.net

#Configure jenkins working directory 
VOLUME /var/jenkins_home

COPY Jenkins.yaml ${JENKINS_HOME}/casc_configs
ENV CASC_JENKINS_CONFIG=${JENKINS_HOME}/casc_configs
