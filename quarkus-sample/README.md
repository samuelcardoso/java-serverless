# Instructions

0. Install Java

   - export JAVA_HOME=/home/samuel/devel/tools/jvm/jdk-17.0.10/
   - export PATH=$JAVA_HOME/bin:$PATH

1. Install Maven

   - <https://maven.apache.org/download.cgi>
   - export MAVEN_HOME=/home/samuel/devel/tools/maven/apache-maven-3.9.6/
   - export PATH=$MAVEN_HOME/bin:$PATH

2. Install AWS CLI

   - <https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html>

3. Install AWS SAM

   - <https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html>

4. Install Quarkus Cli

   - <https://pt.quarkus.io/guides/cli-tooling>

5. Start docker (if Windows)

6. Build
   normal: quarkus build
   native: quarkus build --native -Dquarkus.native.container-build=true

7. Run Local SAM (if Windows: sam.cmd)
   normal: (change runtime to java17) sam local start-api --template target/sam.jvm.yaml
   native: sam local start-api --template target/sam.native.yaml

8. Deploy: buckets
   normal create buckets: aws s3 mb s3://bucket-java-normal-quarkus
   normal create buckets: aws s3 mb s3://bucket-java-native-quarkus

9. Deploy: lambda
   normal: (change runtime to java17) sam deploy --template target/sam.jvm.yaml --stack-name normal-quarkus --s3-bucket bucket-java-normal-quarkus --capabilities CAPABILITY_AUTO_EXPAND CAPABILITY_IAM
   native: (change runtime to provided.al2023) sam deploy --template target/sam.native.yaml --stack-name native-quarkus --s3-bucket bucket-java-native-quarkus --capabilities CAPABILITY_AUTO_EXPAND CAPABILITY_IAM

GraalVM

- <https://www.graalvm.org/downloads/>
- export JAVA_HOME=/home/samuel/devel/tools/jvm/graalvm-jdk-17.0.10+11.1/

Build (ignore)

- normal: mvn clean package
- native: mvn clean package -Pnative -Dnative-image.docker-build=true

Run remote

- normal: curl --location 'https://ktu3yv63hd.execute-api.us-east-1.amazonaws.com/Prod/movies'
- native: curl --location 'https://tbhldodcyl.execute-api.us-east-1.amazonaws.com/Prod/movies'
