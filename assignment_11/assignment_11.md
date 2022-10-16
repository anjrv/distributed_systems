---
geometry: margin=1in
fontsize: 12pt
urlcolor: blue
header-includes: |
    \usepackage[scaled]{beramono}
    \usepackage{setspace}\doublespacing
    \usepackage{float}
    \usepackage{fancyhdr}
    \pagestyle{fancy}
    \floatplacement{figure}{H}
    \lhead{Jaan Jaerving}
    \chead{}
    \rhead{Distributed Systems, Assignment 11}
...

## 1. Consider the Amazon EC2 REST Web service API to re-start a stopped instance on slide 8-61: is this a good or a bad RESTful API design? If you think, it is bad: can you think of an alternative way of representing a cloud instance resource via an URL? How would you delete an instance? How create an instance? How change the state to “stopped”? How to start an instance? (Both starting and stopping shall be idempotent, e.g. if a stopped instance is to be started, it shall be started, but if it was anyway already running, it should keep on running.) Answer these questions by providing an example URL and the HTTP request (HTTP method and –if necessary- request body) to be used!

\
The service shown in the slides is not ideal. It is posed as a `GET` request with query parameters but also mutates state. This request should be a `PUT` request with the `InstanceId` variable defined in the body and the credentials attached as a bearer token. 

Method proposals can be seen on the next page.

\pagebreak

*Note: For all these methods you would send an Authorization header with the credentials that was previously in the parameters.*

Delete:
```json
DELETE https://ec2.amazonaws.com/instances/{id}
```

Create:
```json
POST https://ec2.amazonaws.com/instances
body: {
  AnyAdditionalVariablesThatAwsUses: 1
}
```

Start:
```json
PUT https://ec2.amazonaws.com/instances/{id}
body: {
  "state": "started"
  AnyAdditionalVariablesThatAwsUses: 1
}
```

Stop:
```json
PUT https://ec2.amazonaws.com/instances/{id}
body: {
  "state": "stopped"
  AnyAdditionalVariablesThatAwsUses: 1
}
```

\pagebreak

## 2. Play around with a sample RESTful Web service that uses JSON format for input/output. To this aim, use a generic REST client, for example plug-ins for your web browser (Firefox: RESTClient1, Chrome: Advanced REST client2) or simply via the web page http://resttesttest.com/. Use the base URL http://jsonplaceholder.typicode.com 3 to perform some actions and answer questions:

### a) GET list of all users via resource users. How many users are printed out? 

`GET http://jsonplaceholder.typicode.com/users` returns a total of **10** users of the format:

\singlespacing
```json
[
    {
        "id": 1,
        "name": "Leanne Graham",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "address": {
          ...
        },
        "phone": "1-770-736-8031 x56442",
        "website": "hildegard.org",
        "company": {
          ...
        }
    },
    ...
]
```

\pagebreak

### b) GET just user 2 via via resource users/2, what is the name of user 2? 

`GET http://jsonplaceholder.typicode.com/users/2` returns the user **Erwin Howell**

\singlespacing
```json
{
    "id": 2,
    "name": "Ervin Howell",
    "username": "Antonette",
    "email": "Shanna@melissa.tv",
    "address": {
      ...
    },
    "phone": "010-692-6593 x09125",
    "website": "anastasia.net",
    "company": {
      ...
    }
}
```
\doublespacing

### c) Change the name of user 2 to Peter Pan while keeping all other values as they are. In principle, PUT is supposed to overwrite the whole resource with just the provided values (=deleting all other existing values of that resource), while PATCH will keep all existing values and change only the provided value: how does PUT behave in that particular REST service?

`PUT http://jsonplaceholder.typicode.com/users/2` with request body
\singlespacing
```json
{
  "name": "Peter Pan"
}
```
\doublespacing
Response:
\singlespacing
```json
{
  "name": "Peter Pan",
  "id": 2
}
```
\doublespacing

`PUT` for this REST service is not idempotent, really you only get the response variable but the name is not overwritten.

### d) Create new user Peter Pan via resource users/ using HTTP method POST with payload from response body of (c), however having removed the Id. Which Id is assigned to the new resource?

`POST http://jsonplaceholder.typicode.com/users` with request body
\singlespacing
```json
{
  "name": "Peter Pan"
}
```
\doublespacing
Response:
\singlespacing
```json
{
  "name": "Peter Pan",
  "id": 11
}
```
\doublespacing

Id for new user Peter Pan is incremented to 11.

### e) DELETE user 2 via resource users/2. What is the content of the response body? 

`DELETE http://jsonplaceholder.typicode.com/users/2`

Response:
\singlespacing
```json
{}
```
\doublespacing

Response body is empty.

\pagebreak

## 3. The lecture slides do not provide an example of the JAX-RS Java API for RESTful Web services. Find out on your own (e.g. using some tutorial) how to annotate the following class that implements on the server side a resource with the URL /users where GET /users and GET /users/some Name should be supported (write down the correct annotation to use instead of each placeholder @Annotation): 

```java
@Path("/users")
public class Users { 
  @GET
  public String getAllUser() { 
    return "List of all users"; 
  } 
   
  @GET
  @Path("/{param}")
  public String getUserByName(@PathParam("param") String name) { 
    return "User with name: " + name; 
  } 
} 
```


