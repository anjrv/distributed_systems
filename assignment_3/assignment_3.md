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

*NOTE: See p. 68*

## Consider two communication services for use in asynchronous distributed systems: 
 
* **In communication service A, messages may be lost, duplicated or delayed and checksums apply only to headers (e.g. target address) but not the payload of a message.**
* **In communication service B, messages may be lost, delayed or delivered very slow, but those that are delivered arrive with the correct contents.**
 
## Describe for each service A and B: 
 
1. **the classes (or types respectively) of failure exhibited,**
2. **the effect of the failures on the properties validity and integrity,**
3. **whether the service is reliable or not.**


 
## Next, consider a server process Y that operates in an asynchronous distributed system and is contacted by a client process X via the above communication service B: 
 
4. **Which additional classes (or types respectively) of failure may now occur as part of a service invocation?**
