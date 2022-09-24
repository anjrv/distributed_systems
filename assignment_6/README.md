**Question 2 answer:**

The client does not react at all. The MultiClient process will happily keep sending with no server listening. This is pretty much what you would expect from UDP with no message acknowledgements.

**Java Classes are split into to categories:**

* SingleClient.java
* SingleServer.java

This is the simple single thread server and a client that will send a single message and terminate.

* MultiClient.java
* MultiServer.java

This is a server that will fork off threads to handle packets and a client that will loop infinitely sending different messages.

* PoolServer.java

This is a server that uses Executors to run a constant number of worker threads

There are also helper classes.

* Person.java
  - This contains the object being serialized and sent
* DatagramReader.java
  - This is the runnable used by the MultiServer program
* PoolWorker.java
  - This is a runnable used by the PoolServer program

**Usage**

In the root of the project to compile all Java files:

`javac *.java`

To run a single thread server:

`java SingleServer <port>`

To send a single message:

`java SingleClient <ip/name> <port>`

Optionally choose the name and city for the Person object:

`java SingleClient <ip/name> <port> <name> <city>`

To run a multithread server:

`java MultiServer <port>`

To run a pooled server:

`java PoolServer <port> <threads>`

To run a message sending loop:

`java MultiClient <ip/name> <port> <max ms delay> <loop id>`


**Usage examples:**

`java SingleServer 3002`

`java SingleClient localhost 3002`

`java SingleClient localhost 3002 John London`

`java MultiServer 3002`

`java PoolServer 3002 2`

`java MultiClient localhost 3002 1000 1` (This will have up to a second of delay)

`java MultiClient localhost 3002 0 1` (This will send without additional delay)

