aws cloudformation create-stack --stack-name $1-serverless --capabilities "CAPABILITY_NAMED_IAM" --template-body file://./csye6225-cf-serverless.json
aws cloudformation wait stack-create-complete --stack-name $1-serverless
AccountId=$(aws iam get-user|python -c "import json as j,sys;o=j.load(sys.stdin);print o['User']['Arn'].split(':')[4]")
echo "AccountId: $AccountId"
STACKDETAILS=$(aws cloudformation describe-stacks --stack-name $1-serverless --query Stacks[0].StackId --output text)

