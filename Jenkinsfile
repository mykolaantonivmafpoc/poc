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
                    docker.build("$APIIMAGE","docker/Dockerfile.api .")
                    //sh 'docker build -t apiapp:1.0.0-stable -f docker/Dockerfile.api .'
                    //sh 'docker build -t staticeapp:1.0.0-stable -f docker/Dockerfile.static.'
                    //sh 'docker build -t db:1.0.0-stable -f docker/Dockerfile.db .'
                }
            }
        }
        stage('Docker push')
        {
            steps
            {
                script
                {
                    sh("eval \$(aws ecr get-login --no-include-email | sed 's|https://||')")
                    // Push the Docker image to ECR
                    docker.withRegistry(ECRURL, ECRCRED)
                    {
                        docker.image(IMAGE).push()
                    }
                }
            }
        }
    }
    
    post
    {
        always
        {
            // make sure that the Docker image is removed
            sh "docker rmi $IMAGE | true"
        }
    }
} 