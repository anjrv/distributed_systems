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
    \rhead{Distributed Systems, Assignment 14}
...

## 1. The Sun NFS version 3 file update semantics differs from the one-copy file update semantics of local Unix file systems: Describe a scenario of file operations by two processes sharing a file that reveals the different semantics when running in a distributed NFSv3 file system and when running in a local Unix file system.

A difference can be seen in how write caching is done for the two systems. Local Unix file systems access a single cache which is flushed to disk periodically. If the machine hosting the file system were to crash then any applications using the files on it would also crash and file consistency is maintained.

For NFSv3 the default way to handle data write operations is to only write cache to disk when a commit is requested for any relevant file. This indicates that clients may continue to operate with the assumption that the results of previous writes are committed, as they would be on a traditional local Unix file system, but this is not necessarily the case and a server may fail without actually committing the requested writes.

\pagebreak

## 2. Why is it a problem to have the NFS server state-full, but why is it no problem to have the NFS client module state-full? (Take care to consider not only channel omission, but also process omission failures.)

A state-full server would have to supervise all file accesses done by clients. It would also have to successfully notify all clients of changes to the files. Local Unix systems move the read/write head for consecutive requests, doing so is not idempotent. For distributed file systems RPC calls to the server might be lost, if clients issue their operation repeatedly they might produce a discrepancy in how the server and the clients perceive the data to be.

In NFSv3 the client maintains its own read/write head position which is sent along with requests to the server. Because requests are made for specific sections read/write actions are idempotent and therefore repeat requests due to lost RPC calls is not an issue as they would be working with the same sections.
