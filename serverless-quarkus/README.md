1) Install GRAALVM
2) Install AWS CLI
3) Install AWS SAM
4) Export GRAAL_VM_HOME -> JAVA_HOME
5) Start docker
6) Build
normal: mvn clean install
native: mvn clean install -Pnative -Dnative-image.docker-build=true
7) Run Local
normal: sam.cmd local invoke --template template.normal.yaml
native: sam.cmd local invoke --template template.native.yaml
8) Deploy: buckets
normal create buckets: aws s3 mb s3://bucket-normal-quarkus
normal create buckets: aws s3 mb s3://bucket-native-quarkus
9) Deploy: lambda
normal: sam.cmd deploy --template template.normal.yaml --stack-name normal-quarkus --s3-bucket bucket-normal-quarkus --capabilities CAPABILITY_AUTO_EXPAND CAPABILITY_IAM
native: sam.cmd deploy --template template.native.yaml --stack-name native-quarkus --s3-bucket bucket-native-quarkus --capabilities CAPABILITY_AUTO_EXPAND CAPABILITY_IAM
10) Run remote
normal: aws lambda invoke --function-name "normal-quarkus-QuarkuslambdaFunction-XYZ" response.json
native: aws lambda invoke --function-name "native-quarkus-QuarkuslambdaNativeFunction-XYZ" response.json
