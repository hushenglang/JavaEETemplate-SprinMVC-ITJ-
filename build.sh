echo -------------------------------------- 
echo updating the svn workspace of ecargo
svn up

echo --------------------------------------
echo shutdown the tomcat server
/opt/apache-tomcat-7.0.64/bin/./shutdown.sh
 
echo --------------------------------------
echo build and publish the project
rm -rf /opt/apache-tomcat-7.0.64/webapps/ecargo
mvn clean package
 
echo --------------------------------------
echo startup the tomcat server
/opt/apache-tomcat-7.0.64/bin/./startup.sh




