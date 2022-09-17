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
      \rhead{Distributed Systems, Assignment 4 and 5}
...

## Assignment 4

**Which types of failure are present and which are absent for:**
 
1. **UDP**
2. **TCP**

**When these are used in IPv4. Justify your answers!**

\

Both of these would be in use in an asynchronous system and because of this `timing failures are absent` for both protocols.

* **UDP**: This is a lightweight protocol with no ordering of messages, no tracking connections or other guarantees. As a result common `performance failures are absent` from this protocol but on the other hand due to lack of guarantees datagrams might arrive corrupted which would mean that `arbitrary failures are present`. Messages may also be dropped entirely which means that `omission failures are present` as well.
* **TCP:** This is a reliable but rather heavyweight protocol which ensures that messages are sent in an ordered sequence and that the messages that are sent remain correct by offering ways to resend packets. The fact that packets can be lost and have to be requested again indicates that despite reliability improvements `omission failures are present` but this additional focus on reliability does mean that messages arrive in the same form they are sent which means that `arbitrary failures are not present`. The cost of sending acknowledgements back and forth to set up a connection and resending data does mean that we will see a performance drop and as a result `performance failures are present`.

\pagebreak

## Assignment 5

### 1. Computer networks and their respective protocols have usually a layered architecture: Describe two advantages and one disadvantage of such a layered architecture.

**Advantages:**

* Having a layered model makes it possible to separate concerns and provide access using interfaces making communication between layers effectively generic. This also means that changes or problems in one layer do not have a large impact on other layers.
* These layers are generally extensible. They may provide protocols such as TCP/IP but there are many solutions that extend this protocol such as HTTP and FTP.

**Disadvantages:**

* Due to the layers being separate we end up duplicating some of what they do and creating extra overhead, if these were more strongly coupled we could get away with less error checking for example.

\pagebreak

### 2. Consider the following scenario: A huge amount of data (e.g. 256 Kilo Bytes) is transferred via TCP/IPv4 over an Ethernet to a router that routes it further into the Internet. Describe at which protocol layer(s) this data gets divided into smaller pieces and explain why this fragmentation is necessary at all.

When a packet arrives at the network layer the MTU of the packet is checked. If the packet has to pass through a link that has a smaller MTU than the packet we received it becomes necessary to check whether fragmenting the packet is an option. If the packet does not allow fragmenting we have to simply drop the packet, otherwise the network layer decides the size of the fragments, assigns the relevant header and sends them on to the next layer.

If a host receives a fragmented packet it has to reassemble the packet and pass it to the higher protocol layer. Reassembly might also happen within an intermediate router.

It is worth nothing that this kind of fragmenting does not work for something like UDP however. In such a case we could also see data chunking in the transport layer.

