Simulateur d'aéroport
==========

Principes généraux 
----------

You must simulate runway usage at an airport by determining which planes take off or land on each
runway.  Each plane that takes off flies to another airport and each plane that lands has taken
off from a separate airport.

The airport simulator is a turn­based simulator. Within each turn a number of events,
specified below, occur.  A clock (an integer) is kept to track the number of turns.  Each turn
takes one clock tick.  Your simulator needs to determine which planes land and take off at
each turn.

A plane may be sitting on the ground waiting to take off or a plane may be in the air waiting
to land.  The planes in the air have a non­negative integer amount of fuel.  During each turn
the fuel of each in­air plane is reduced by one.  Once a plane in the air reaches zero fuel that
plane must land before the next turn or that plane will crash.  A priority queue, using fuel as
priority, must be used to track planes waiting to land.  This allows planes to land in priority
order (zero fuel has highest priority, 1 unit has the next priority, etc.).
A non­priority queue must be used to track planes waiting to take off.  Planes take off in the
order in which they entered the system (FIFO).  Both queues must store the clock tick (an
integer) in which the given plane enters the system. 
The airport has three runways.  During each turn, each runway may either land exactly one
plane or allow exactly one plane to take off.  A runway may not both land and launch a
plane in the same turn.  A runway may also sit idle for a turn if no plane needs to land or
take off.

Détails de la simulation
----------

The clock starts at 1.

A turn includes the following events in the following order:
1. Read a line of data from the file “data/airport.txt”.  Each line describes airplanes that are
joining the take off queue and airplanes have arrived and need to land.  Further, the
amount of fuel on board for each newly arrived “need to land” plane is provided. Each
plane arrives with a positive, non­zero integer amount of fuel.  No fuel is assigned to
planes that need to take off.  At most, 3 planes may join the take off queue and an
additional 3 planes may arrive needing to land (for a total of 6 new planes in the system
per turn).  It is also possible that zero planes enter the system at a given turn.
2. Enter the new planes into their appropriate data structures.
3. Decrement each “need to land” plane's fuel by 1 (including those that just arrived).
4. Those planes that “need to land” with a fuel value of zero must be assigned runways for
landing.  When all three runways are full any remaining planes in the air with zero fuel
crash.
5. If step 4 did not use all three runways, the remaining runways are used.  Service (land or
take off) the plane at the head of the larger queue and remove that plane from its queue.
If the queues are the same size, land a plane.  Repeat step 5 until all runways are used or
both queues are empty.
6. Print the results for the events of this turn.
7. Increment the clock by 1.
8. Return to step 1.  Stop the simulation when both the file is exhausted and both queues
are empty.

