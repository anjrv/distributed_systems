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
* b) Requesting a waiting number ticket in, e.g., a bank. 
* c) Writing data to an absolute position in a file. 
* d) Appending data to the end of a file.
* e) The unreliable operation of flushing a toilet where everything may have been flushed after the first try, but where maybe also further tries are required.

## 2. Discuss whether it is a necessary condition for idempotence that the respective operation is not associated with any state.

## 3. Consider a web-based shopping system where items can be put into some virtual shopping cart and a „buy“ operation is used to order and pay the items in the shopping cart: Is the described „buy“ operation idempotent or not? If not, which behavior (that is in fact trivially part of the operation of buying the contents of a shopping cart at some checkout in a real supermarket) could be added to the „buy“ operation to make it idempotent?

## 4. A possibility to deal with the problem that not all operations are idempotent, is to use a history for the reply message at the server and the RRA protocol (running on top of unreliable lower layers) to decide when an entry from the history buyer may be discarded. Until when should a server store unacknowledged reply to data in the history buyer (assume an asynchronous system)?  
