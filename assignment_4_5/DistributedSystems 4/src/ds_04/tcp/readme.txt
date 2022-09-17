1. Compile the server (e.g. in first command prompt/cmd shell); javac TCPServer.java
(adjust classpath parameter -cp to let it point to your directory that contains the ds_04 subdirectory that contain the *.class files)
Start server; java TCPServer

2. Complie the client; jvac TCPClient.java. Start on same machine client (e.g. in second command prompt/cmd shell) using (adjust classpath) 
java TCPClient "Hello world" localhost