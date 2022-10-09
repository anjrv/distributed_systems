# Assignment 9

This assignment MUST be compiled and run with Java version <= 17 to work. Security policy warnings were replaced by critical errors for version 18

To compile the project (in project root) run:
```
javac *.java
```

To enable rmiregistry
```
rmiregistry
```

To start the server run: 
```
java -Djava.security.policy=./allpermission.policy Server
```

To start the client run: 
```
java -Djava.security.policy=./allpermission.policy Client
```
