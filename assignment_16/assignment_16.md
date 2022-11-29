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
    \rhead{Distributed Systems, Assignment 16}
...

## 1. Consider the Bully election algorithm: Assume that a server process that has the highest identifier has crashed, thus re-election is triggered. Because this server process crashed, it will obviously not participate in the election, hence a process with a lower identity gets elected. Now, assume that the crashed former server processes has recovered after the election has finished (and another server has obviously been elected).

\

### a. Is it reasonable that this recovered server process calls an election (where that server processes will likely win - at least it won the previous election)?

Assuming the newly elected process is functioning normally the recovered process should not call an election. Ideally an election should be started when it is detected, through timeouts, that the coordinator has failed.

\

### b. If (whether it is reasonable or not) the recovered server process decided to call an election, is it really necessary that it sends an “election” message as it is intended by the algorithm? 

Since this process knows it has the highest identifier it can elect itself as the coordinator by sending only the coordinator message to all processes with lower identifiers. Election messages are only required by processes that know that they do not have the highest identifiers.

\pagebreak

## 2. Consider the Ring-based election algorithm: describe a sample scenario of two processes beginning separate elections at more or less the same time and demonstrate that double elections are “extinguished” before election results are propagated.

During elections any identifiers that are lower than those that have been seen previously are discarded. Thus anywhere in the ring where a process has seen an identifier *N+1* a new election message with identifier *N* would be discarded.
