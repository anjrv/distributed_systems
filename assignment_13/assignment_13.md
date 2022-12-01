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
    \rhead{Distributed Systems, Assignment 13}
...

*Consider a peer-to-peer overlay network with 4 Bit GUIDs (i.e. GUIDs are 0..15, 0 and 15 being direct neighbours). Some nodes of the underlying IPv4 network have joined the overlay network and were assigned GUIDs as shown in the figure (dashed circle). The underlying physical network structure (including IPv4 addresses of nodes) is depicted as well (solid lines). A direct physical network connection between two nodes has the network distance of one “hop” (for example, the shortest network distance between 1.1.1.1 and 1.1.1.2 is 1 hop, between 1.1.1.2 and 1.1.4.2 is 4 hops, etc.).*
 
*Assume a simple routing overlay where each node has a routing table consisting of four (GUID, IP address) entries: the two direct neighbours to the “left” and the “right” and the two “4th-next” 1 neighbours to the “left” and the “right”. (For example, the routing table of the node with GUID 0 has entries for GUIDs 1, 14, 5, 11.). Overlay routing is performed in a way that a message is always routed to that node contained in the routing table whose GUID is numerically closest to GUID of the target node.*

\

\begin{figure}
\centering
\includegraphics[width=100mm]{table.png}
\end{figure}

\pagebreak

## 1. Describe for the sources and targets listed in (a) and (b): 

* which route does the routing overlay select?
* what is the contents of the routing tables of the nodes along the route?
* how many network hops does the routing overlay need?
* how many network hops would the shortest route have if no overlay routing would be used, but the shortest network path?

### (a) Message to be routed from node with GUID 0 to GUID 4.

* 0 -> 5 -> 4
* 14, 1, 5, 11 -> 7, 4, 12, 0 -> 5, 2, 14, 11
* 7 hops for overlay
* 4 for shortest network path

### (b) Message to be routed from node with GUID 5 to GUID 14.

* 5 -> 12 -> 13 -> 14
* 7, 4, 12, 0 -> 11, 13, 5, 1 -> 12, 14, 7, 2 -> 13, 0, 9, 4
* 8 for overlay
* 4 for shortest network path

## 2. Describe a simple solution how a node could route a message if it detects that an intermediate node to which a message shall be routed turns out to be unavailable. 

It could offset by one in the wrong direction to shift which intermediate nodes are used.
