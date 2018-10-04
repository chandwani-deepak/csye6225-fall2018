echo "Creating application stack"
aws cloudformation create-stack --stack-name $1 --template-body file://csye6225-cf-application.yml  --parameters file://startmyinstance.json
echo "Task completed successfully"
