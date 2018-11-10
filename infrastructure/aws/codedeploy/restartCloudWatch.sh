
#!/bin/bash

sudo cp /opt/cloudwatch-config.json /opt/tomcat/logs/
sudo service awslogs start
sudo service awslogs stop
sudo service awslogs restart
