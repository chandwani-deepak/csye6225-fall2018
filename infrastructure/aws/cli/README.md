# AWS CLI scripts

**Note: Before running any file in linux, it should be checked whether the file has read, write and exceute permissions**

* [csye6225-aws-networking-setup.sh](https://github.com/nitin-prince/csye6225-fall2018/blob/master/infrastructure/aws/cli/csye6225-aws-networking-setup.sh) this shell script when run in linux, creates 'Virtual Private Cloud (VPC)', creates 3 'subnet' and asks details about the same, creates 'Internet Gateway' and attachs it with VPC, creates a public 'Route table' and attachs all subnet to this route table and creates a public route of CIDR block '0.0.0.0/0'.

