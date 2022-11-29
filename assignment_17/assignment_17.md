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
    \rhead{Distributed Systems, Assignment 17}
...

*According to the requirements on algorithms for distributed mutual exclusion, it is desirable to respect Lamport's happened-before ordering of requests, i.e. if a request happened-before an other request, access should be granted in the same happened-before order. Most of the time, requests from different processes are concurrent (i.e. neither a→b nor a→b is valid), hence any ordering of the access is allowed. Nevertheless, scenarios can be constructed in which happened-before ordering can be determined for two requests. (Hint: think about messages being exchanged between processes thus imposing a happened-before ordering.)*

## 1. For the Central server algorithm, describe a sample scenario in which two processes  are not granted access to the critical section in happened-before order of their requests.

Due to no shared clock it is actually impossible to guarantee that requests are served in the order they send their requests. The order in which requests are granted is determined by when they arrive at the server, as such a request that is sent first but takes longer to arrive will be served after a request that was sent after it but arrived quicker to the server.

\pagebreak

## 2. For the Ring-based algorithm, describe a sample scenario in which two processes are not granted access to the critical section in happened-before order of their requests. (Note: while the token message is always sent along the logical ring structure, all other messages may be sent over the network completely independent from this ring structure.)

A similar issue exists for the basic Ring-based algorithm. For a system with *N* peer processes it can take $1...N$ messages to get access to the critical section. As such a process that sends its request first may have that request travel *N* messages while a process that requests access after that may have its request travel *1* message. As such the process requesting later will get access first. The Ring-based algorithm is also susceptible to process failure where message tokens are lost along the way due to process failure, as such a request may never arrive.

## 3. May it also occur with the algorithm from Ricart and Agrawala that processes are not granted access to the critical section in happened-before order of their requests? Justify your answer!

No, this implementation of the algorithm requires agreement from all peer processes. As such the $1...N$ issue can no longer happen because all requests take *N* messages.
