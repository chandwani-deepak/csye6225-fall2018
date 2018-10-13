aws cloudformation create-stack --stack-name $1 --template-body file://csye6225-cf-create-application-S3.yml --parameter file://parameter-s3-instance.json
echo "Creation of stack is successfully completed"
