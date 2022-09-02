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
    \rhead{Distributed Systems, Assignment 2}
...

## Describe very briefly the system architecture of the Domain Name System (DNS) with a focus on:

* **What client/server roles do occur;**
* **where is replication,**
* **partitioning,**
* **or caching used!**

DNS is used to convert domain names into actual internet addresses. It is implemented as a server process that can be run on devices anywhere in the internet - at least two such devices exist in each specific domain.

For the individual domains we might partition them into smaller domains. In this case when a large domain contains multiple smaller domains it might be referred to as a forest.

For the servers in these domains we might see replication such that secondary servers replicate any changes that occur on a primary server. This kind of primary server would be the authoritative server on the network which is queried by resolver servers.

These servers are responsible for holding a partial map of their domain name tree and requests for the translation of domain names outside their portion of the tree by issuing requests to DNS servers in the relevant domains. The results of these requests would be where caching could be implemented so that future requests referring to the same domains can be resolved without referencing other servers. In fact DNS in general would not be functional without this kind of caching as querying root servers every time would cause a tremendous service access bottleneck.

The client role in all of this is described as any entity that queries for addresses from the domain.
