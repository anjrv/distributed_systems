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
    \rhead{Distributed Systems, Assignment 3}
...

## Consider two communication services for use in asynchronous distributed systems: 
 
* **In communication service A, messages may be lost, duplicated or delayed and checksums apply only to headers (e.g. target address) but not the payload of a message.**
* **In communication service B, messages may be lost, delayed or delivered very slow, but those that are delivered arrive with the correct contents.**
 
## Describe for each service A and B: 
 
1. **the classes (or types respectively) of failure exhibited,**
2. **the effect of the failures on the properties validity and integrity,**
3. **whether the service is reliable or not.**

*NOTE:* Neither of these services suffer from timing failures due to being asynchronous.

**Service A:**

Here we primarily have omission failures due to lost messages and arbitrary failures due to duplicated messages and incorrect payloads. Additionally delayed messages would be a type of performance failure. This service does not have validity due to lost messages and it also does not have integrity due to incorrect payloads. Due to lack of validity and integrity this cannot be considered a reliable service.

**Service B:**

Here we also have omission failures due to lost messages. We also have performance failures in the form of delayed or very slow messages. This service also does not have validity due to lost messages but it could be considered to have integrity since in this case the payloads are correct. It can still not be considered reliable due to lack of validity.

\pagebreak
 
## Next, consider a server process Y that operates in an asynchronous distributed system and is contacted by a client process X via the above communication service B: 
 
4. **Which additional classes (or types respectively) of failure may now occur as part of a service invocation?**

* Due to the reliability issues exhibited by service B both send and receive omissions are possible due to lost messages.
* Depending on error handling we may also introduce crash failures where X or Y may crash and the other process is not able to detect it.

All the initial failures exhibited by service B, such as performance failures, would still exist here.
