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

## Describe very briefly the system architecture of the Domain Name System

DNS is used to convert domain names into actual internet addresses. It is implemented as a server process that can be run on devices anywhere in the internet. When someone enters a website address into a browser there are actually multiple servers that might be queried. These are:

* **Resolver server:**
  - Receives the initial request and does the grunt work in figuring out the actual address of the website
* **Root server:**
  - Receives the first request, this is what the resolver is directed to with the hidden period at the end of every website request. The root server will let the resolver server know the address of the top level domain server that stores the information about the requested site.
* **Top level domain server:**
  - These servers oversee the addresses for their domains, e.g. .com, .net or .is. This is the kind of server that will be queried next by the resolver server to obtain the location of the authoritative name server.
* (Registrar):
  - This middle step oversees updating the list of authoritative name servers a top level domain server should use.
* **Authoritative name server:**
  - This is the server queried to obtain the location, or IP address, of the initially sought after website.

\pagebreak

As can be seen from the descriptions of the server roles in most of these interactions the resolver will act as a client for most of these interactions. This resolver server might also be the initial users own personal computer or, more likely, a server run by the internet service provider. Every step along the way this resolver server will cache all the results such that it does not have to go throughout this entire tree every time. The other servers listed initially may also cache a subset of this information for the same purpose.

The structure of a domain namespace is effectively a tree, we have the root which delegates to top level domain servers for the aforementioned .com, .net, .is and other top level domains. But these top level domains would would also be partitioned further. Using the example from the video seen in class, i.e. example.com this would be a second level domain which could also have further sub domains like mail.example.com or simply www.example.com.

For all of these namespace zones we would often have a set of authoritative servers, one primary and one secondary, to ensure we have produce a backup replication of our records. It is also possible for an authoritative name server to be authoritative for more than one zone, e.g. when DNS services are provided by a third party such as an ISP. In reality there is more than just this kind of replication. We effectively replicate every step of our DNS name resolution by caching every step of the way by caching responses as mentioned earlier.

