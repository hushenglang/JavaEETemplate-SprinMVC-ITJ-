#readme.txt#

This file will tell you how to deploy ecargo on your web server, please follow the steps:

1.create folder on your window computer with path "c:\\ecargo";
2.change init.properties database config info to match your local DB server.
3.put modified init.properties into folder "c:\\ecargo";(application would scan folder "c:\\ecargo" to find the 
  init.properties file, if found use it as db config info, if not found use the one in the war);
4.depoly the ecargo.war to the web server;
5.start the web server, open browser to input "http://localhost:[port]/ecargo/";

 
ps:assume that you are using Windows system do deploy this project. If you need deploy on centOS(Linux like system),
   please change ConfigLoader.properties configPath to Linux system file path.
