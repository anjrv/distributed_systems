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
    \rhead{Distributed Systems, Assignment 1}
...

## 1. Apply Coulouris' et al. definition of a distributed system to answer the following questions (justify your answers)

*A distributed system is one in which components located at networked computers communicate and coordinate their actions only by passing messages. This definition leads to the following especially significant characteristics of distributed systems: concurrency of components, lack of a global clock and independent failures of components*

### a) Is a multi-processor or multi-core computer a distributed system?

No. These kinds of multi-processor or multi-core systems use shared memory instead of message passing which is described as a requirement for a distributed system. The components are also much more closely tied together through hardware interfaces instead of networked ones which means that any kind of scalability is drastically reduced and individual component failures are problematic for the entire system.

### b) Is a computing cluster (many similar machines connected via a local area network (LAN) appearing as a single computer) a distributed system?

Yes. An example of this could be something like a Raspberry Pi cluster, these individual computers work with their own internal clocks which does not necessarily match between devices, they also have individual memory but communicate by using message passing. Theoretically such a system would also be easily scalable by adding more Pi nodes into the cluster and the failure of a single Pi could be mitigated by load balancing onto other devices in the cluster.

### c) Is a computer with a co-processor having its own non-shared physical memory (e.g. a video card with graphics processing unit (GPU) and video memory) distributed system? 

\pagebreak

## 2. Why does the definition of a distributed system from Lamport refer to „transparency“ and to which transparency/transparencies does it refer in particular?

In general transparency refers to concealment of the system from the user. Ideally the system would be perceived as a whole rather than as a collection of independent components.

There a number of different transparencies to consider:

* Access transparency enables local and remote resources to be accessed using identical operations.
* Location transparency enables resources to be accessed without knowledge of their physical or network location (for example, which building or IP address).
* Concurrency transparency enables several processes to operate concurrently using shared resources without interference between them.
* Replication transparency enables multiple instances of resources to be used to increase reliability and performance without knowledge of the replicas by users or application programmers.
* Failure transparency enables the concealment of faults, allowing users and application programs to complete their tasks despite the failure of hardware or software components.
* Mobility transparency allows the movement of resources and clients within a system without affecting the operation of users or programs.
* Performance transparency allows the system to be reconfigured to improve performance as loads vary.
* Scaling transparency allows the system and applications to expand in scale without change to the system structure or the application algorithms.
