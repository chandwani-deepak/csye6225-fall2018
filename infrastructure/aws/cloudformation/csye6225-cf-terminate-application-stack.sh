echo "Starting teardown of application stack"
aws cloudformation delete-stack --stack-name $1
echo "Task completed successfully"
