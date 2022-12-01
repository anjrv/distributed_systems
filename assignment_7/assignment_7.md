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
    \rhead{Distributed Systems, Assignment 7}
...

## 1. Discuss briefly (=Yes, idempotent/No, not-idempotent, because ...) whether the following operations are idempotent:

* a) Pressing lift (elevator) request button
  - This is idempotent, the lift will always eventually come to that floor.
* b) Requesting a waiting number ticket in, e.g., a bank.
  - Not idempotent, state is incremented for each ticket request.
* c) Writing data to an absolute position in a file.
  - Writing to a specific location is idempotent, it does not depend on the write pointer.
* d) Appending data to the end of a file.
  - Appending to a file will change the length of the file and thus write to different locations for repeated operations. Not idempotent.
* e) The unreliable operation of flushing a toilet where everything may have been flushed after the first try, but where maybe also further tries are required.
  - Not idempotent. The action may work and it may not, for it to be idempotent the results should always be the same.

\pagebreak

## 2. Discuss whether it is a necessary condition for idempotence that the respective operation is not associated with any state.

A required condition of idempotence is that the effect of an operation is independent of previous operations. This requirement makes something like server state impossible.

## 3. Consider a web-based shopping system where items can be put into some virtual shopping cart and a „buy“ operation is used to order and pay the items in the shopping cart: Is the described „buy“ operation idempotent or not? If not, which behavior (that is in fact trivially part of the operation of buying the contents of a shopping cart at some checkout in a real supermarket) could be added to the „buy“ operation to make it idempotent?

The buy operation needs to guarantee that the user is only charged once for the initial contents of the cart. In real supermarkets this behavior would be guaranteed by the cart being emptied for each buy operation.

\pagebreak

## 4. A possibility to deal with the problem that not all operations are idempotent, is to use a history for the reply message at the server and the RRA protocol (running on top of unreliable lower layers) to decide when an entry from the history buyer may be discarded. Until when should a server store unacknowledged reply to data in the history buyer (assume an asynchronous system)?

Assuming no *acknowledge reply* message arrives the server should retain information until the timeout defined by the system has been reached. This can differ between systems.
