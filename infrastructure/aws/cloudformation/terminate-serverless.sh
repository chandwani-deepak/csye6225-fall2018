#!/bin/bash -e

if [ -z "$1" ]
then
	echo "No command line argument provided for stack STACK_NAME"
	exit 1
else
	echo "Starting with deletion of stack..."
fi

RC=$(aws cloudformation describe-stacks --stack-name $1-serverless --query Stacks[0].StackId --output text)

if [ $? -eq 0 ]
then
	continue
else
	echo "Stack $1 doesn't exist.Enter correct value"
	exit 0
fi

terminateOutput=$(aws cloudformation delete-stack --stack-name $1-serverless)

echo "Serverless stack deletion in progress. Please wait..."
RC=$(aws cloudformation wait stack-delete-complete --stack-name $1-serverless)

if [ $? -eq 0 ]
then
  echo "Serverless stack deletion is completed successfully..."
else
 	echo "Failed Stack deletion!! Try Again"
 	exit 1
fi
