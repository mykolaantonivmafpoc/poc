pipeline
{
    options
    {
        buildDiscarder(logRotator(numToKeepStr: '3'))
    }
    agent any
    environment 
    {
        VERSION = 'latest'
        PROJECT = 'tap_sample'
        APIIMAGE = 'apiapp:1.0.0-stable'
        STATICIMAGE = 'staticeapp:1.0.0-stable'
        DBIMAGE = 'db:1.0.0-stable'
        ECRURL = 'http://999999999999.dkr.ecr.eu-central-1.amazonaws.com'
        ECRCRED = 'ecr:eu-central-1:tap_ecr'
    }
    stages
    {
        stage('Build preparations')
        {
            steps
            {
                script 
                {
                    // calculate GIT lastest commit short-hash
                    gitCommitHash = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
                    shortCommitHash = gitCommitHash.take(7)
                    // calculate a sample version tag
                    VERSION = shortCommitHash
                    // set the build display name
                    currentBuild.displayName = "#${BUILD_ID}-${VERSION}"
                    IMAGE = "$PROJECT:$VERSION"
                }
            }
        }
        stage('Docker build API')
        {
            steps
            {
                script
                {
                    // Build the docker image using a Dockerfile
                    sh 'docker build -t "$APIIMAGE" -f docker/Dockerfile.api .'
                }
            }
            
        }

        stage('Docker build STATIC')
        {
            steps
            {
                script
                {
                    // Build the docker image using a Dockerfile
                    sh 'docker build -t "$STATICIMAGE" -f docker/Dockerfile.static .'
                }
            }
            
        }
        stage('Docker build DB')
        {
            steps
            {
                script
                {
                    // Build the docker image using a Dockerfile
                    sh 'docker build -t "$DBIMAGE" -f docker/Dockerfile.db .'
                }
            }
            
        }
        
    }
    
    post
    {
        always
        {
            // make sure that the Docker image is removed
            sh 'docker rm "$(docker ps -a -q)"'
        }
    }
} 