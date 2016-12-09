# Distributed Systems - Asynchronous RMI String Comparison Service

This application uses the Java RMI framework to develop a remote, asynchronous string comparison service. A client can remotely connect and pass two strings to the service for comparison. The service uses one of a number of optional string comparison algorithms to compute the edit distance or optimal alignment between the two strings.

The application is multi-threaded on both the client and remote service sides.  The client side ServiceHandler class uses Naming.lookup which is a request to a remote registry for an object with a human-readable name.  The Servant Class creates and instance of a remote object StringServiceImpl and binds it to the RMI registry.  Port 1099 is the port number that the registry is listening on for incoming client requests.

Client requests are added to a LinkedList which is polled by an ExecutorService Thread Pool and executes remote calls to the services remote comparison methods.  The RMI immediately returns an empty instance of a Resultator object which is stored in a Hashmap with a designated taskNumber.  The client side polls the Hashmap every ten seconds to check if the string comparison has been processed.  When it is processed, the Resultator is removed from the map and the string comparison result is outputted to the client.   

To execute project please follow the following steps:

1. Extract the comparator.war and string-service.jar files.
2. Add the comparator.war file to the Apache Tomcat Webapps folder
3. Move the string-service.jar to the Desktop
4. The jar file can be fun from the cmd by using cd to the Desktop and using command

            java -cp ./string-service.jar ie.gmit.sw.Servant

   A message should appear on the cmd saying "server ready".

5. Add the comparator.war file to the Apache Tomcat Webapps folder
6. Using cmd, cd to the bin directory of Apache Tomcats bin folder and use command 

            startup.bat

   This will start Tomcat and run any war files contained in the Webapps folder.

7. Open an internet browser of choice and go to http://localhost:8080/comparator/ and follow the instructions on screen.


