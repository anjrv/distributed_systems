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
    \rhead{Distributed Systems, Assignment 18}
...

## 1. Consider a view-synchronous multicast service for a multicast group containing processes p, q and r: Assume that the network connection (e.g. a connecting router) that connects p to the other processes permanently fails immediately after p sent a view-synchronous multicast message, i.e. the message has already been received by the view-synchronous multicast service that is running on p's network segment, however that service will not be able to deliver it to q nor r.

*Explain which messages (e.g.: no message at all, view notifcations, the actual multicast messages, etc.) will be sent by the view-synchronous multicast service to p! If multiple messages are sent: describe also in which order these are sent!*

\
The message is sent while in view *(p, q, r)* but it is never sent outside the local network to *q, r* no messages would be delivered and the view would be updated to *q, r*.

\pagebreak

## 2. Consider a system replicating data based on the gossip architecture described in the lecture: Assume at a given time, a front end has vector timestamp (3, 5, 7) representing the version of the data it has received from members of a group of three replica managers. At the same time, the three replica managers have value vector timestamps (5, 2, 8), (4, 5, 6) and (4, 5, 8), respectively.

\

### a. Which replica manager(s) could immediately satisfy a query from the front end and what is the resulting time stamp at the front end?

The condition for immediately satisfying a query is that the replica manager has seen as many updates or more than the front end. The third replica manager could therefore respond without having to queue the query. Since this is a query and not an update the replica manager will send the time stamp reflecting it's current version. The time stamp at the front end would then be updated to match that replica manager and would be updated to (4, 5, 8).

\

### b. Which replica manager(s) could immediately incorporate an update from that front end?

In a similar manner as queries a replica manager can only immediately incorporate an update if all causally previous messages have been seen. Because of this it is also the third replica manager that could immediately incorporate an update without having to wait for messages from the other replica managers. It would increment its timestamp and respond.
