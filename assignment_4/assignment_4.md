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

**1**

* Absent: Timing, Performance
* Present: Arbitrary, Omission

**2**

* Absent: Timing, Arbitrary
* Present: Omission, Performance
 
**When are these used in the Internet (IPv4). Justify your answers!** 

\pagebreak

## Assignment 5

### 1. Computer networks and their respective protocols have usually a layered architecture: Describe two advantages and one disadvantage of such a layered architecture.

Layers provide a separation of concerns. Layers speak with interfaces and are therefore independent. Going through each of the layers is time consuming so we take a performance hit.

### 2. Consider the following scenario: A huge amount of data (e.g. 256 Kilo Bytes) is transferred via TCP/IPv4 over an Ethernet to a router that routes it further into the Internet. Describe at which protocol layer(s) this data gets divided into smaller pieces and explain why this fragmentation is necessary at all.

* Network, Transport layers for fragmenting

What controls fragmenting, when should we fragment?
