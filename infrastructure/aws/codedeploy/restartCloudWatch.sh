
#!/bin/bash

sudo cp /home/centos/awslogs.conf /opt/tomcat/logs/
sudo service awslogs start
sudo service awslogs stop
sudo service awslogs restart
