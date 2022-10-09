# Assignment 8

Package source code can be viewed in `/main/java/hi/distributed_systems`

Packages are split into:

* client
* server
* shared


This assignment was packaged with maven and uses maven commands to compile and run.

To compile the project (in project root) run:
```
mvn compile
```

To start the server run: 
```
mvn exec:java@server-cli
```

To start the client run: 
```
mvn exec:java@client-cli
```

The server is currently coded to be localhost and the ports are 3002 for the server and 3003 for the client.