---
geometry: margin=1in
fontsize: 12pt
urlcolor: blue
header-includes: |
    \usepackage[scaled]{beramono}
    \usepackage{setspace}\doublespacing
    \usepackage{float}
    \usepackage{fancyhdr}
    \usepackage{graphicx}
    \pagestyle{fancy}
    \floatplacement{figure}{H}
    \lhead{Jaan Jaerving}
    \chead{}
    \rhead{Distributed Systems, Assignment 15}
...

## 1. An NTP peer node B receives a message from an NTP peer node A at 16:34:23.480 according to B's local clock. This message contains a sending timestamp 16:34:13.430 that has been set by A according to A's local clock. As a reply, B creates a message with timestamp 16:34.25.7 (according to B's clock) that is received by A at 16:34:15.725 (according to A's clock). What is the clock offset between A and B?

* T1: 16:34:13.430
* T2: 16:34:23.480
* T3: 16:34:25.700
* T4: 16:34:15.725
* $Tm = (23.48 - 13.43 + 25.7 - 15.725) / 2 = 10.0125$

\pagebreak

## 2. Consider the scenario of processes (or users) X, Y, Z, and A shown in chapter 2 on slide 2-30:

### a. Attach Lamport timestamps to all events of that scenario!

\begin{figure}
\centering
\includegraphics[width=150mm]{lamport.png}
\end{figure}

\pagebreak

### b. Now, consider Vector clocks:

* i. Attach Vector clock timestamps to all events of that scenario! 
* ii. From this scenario, consider all possible pairs of the three events Y.receive(m1), Y.send(m2), and Z.receive(m1): use the vector clock timestamps to decide which of the pairs of events are concurrent to each other, which happened before each other!   

\begin{figure}
\centering
\includegraphics[width=150mm]{vector.png}
\end{figure}

Here it is only possible to discern that Y.send(m2) happened after Y.receive(m1) since the vector clock at Y.send(m2) > the vector clock at Y.receive(m1). Vector clocks between different processes are not comparable however, we can assume Y.receive(m1) and Z.receive(m1) happened concurrently.

