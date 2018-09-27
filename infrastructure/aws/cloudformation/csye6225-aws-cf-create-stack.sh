cho "Creating CloudFormation Stack"
aws cloudformation create-stack --stack-name $1 --template-body file://csye-cf-networking.yaml --parameters file://startmyinstance-parameters.json

aws cloudformation validate-template --template-body file://csye-cf-networking.yaml
