#!/bin/bash
echo "TOMCAT_HOME=/opt/tomcat"
echo "Stoping tomcat..."
systemctl stop tomcat
echo git pull
git pull
echo "mvn clean & tomcat clean"
mvn clean
rm -rf /opt/tomcat/webapps/academic
rm /opt/tomcat/webapps/academic.war
echo mvn package
mvn package -DskipTests=true
mv target/academic.war target/academic.war
echo copying academic.war
cp target/academic.war /opt/tomcat/webapps
echo Starting tomcat
echo TOMCAT_HOME=/opt/tomcat
systemctl start tomcat
echo Script Completed!
