Simulateur d'aéroport
==========

Description générale
----------

Ce simulateur permet d'émuler les pistes d'atterrissage et de décollage d'un aéroport.
Chaque avion qui décolle se dirige vers un autre aéroport, et chaque avion qui atérrit provient d'un autre aéroport.

Le simulateur fonctionne en mode tour par tour : chaque tour déclenche une série d'évènements décrite qui sera
détaillée plus bas, et qui permet de déterminer quels avions doivent atterrir ou décoller.
Une horloge (un entier) permet de mémoriser le nombre de tours (chaque tour incrémente l'horloge de 1).

Un avion a 2 états principaux : au sol en attente de décollage, ou en vol en attente d'atterrissage.
Les avions en vol ont un stock de fuel positif (peut être 0).
Chaque tour décrémente le stock de fuel des avions en vol (de 1 pour un avion "normal").
Lorsque le stock de fuel d'un avion atteint 0, l'avion doit atterrir avant le prochain tour, sans quoi il crashera ! 
Une file de priorité (Priority Queue) est utilisée pour prioriser les avions en vol qui ont le moins de fuel, afin
que ceux-ci puissent atterrir en premier.
Une file classique (Queue) est utilisée pour stocker les avions au sol en attente de décollage.

L'aéroport que nous simulons possède 3 pistes. 
Pendant chaque tour, chaque piste peut soit faire décoller, soit faire atterrir un avion (mais pas les deux à la fois).
Une piste peut aussi être inactive si aucun avion ne doit décoller ou atterir pendant un tour.

L'horloge est initialisée à 1, et la simulation s'arrête lorsque toutes les files d'avions sont vides.

Déroulement d'un tour
----------

Chaque tour dans le simulateur est composé des étapes suivantes :
1. Génération de nouveaux avions pour alimenter la simulation.
Pour cela, la méthode AirportSimulator::simulateTurnWithNewPlaces prend en paramètre le nombre d'avions
en vol en attente d'atterrissage, le nombre d'avions au sol en attente de décollage, et les stocks de fuel
initiaux des avions en vol (le stock de fuel des avions au sol n'est pas important pour la simulation).
En fonction du type d'avion généré, la file appropriée est mise à jour. 
Il est possible de ne générer aucun nouvel avion pendant un tour de simulation, en utilisant directement la méthode
AirportSimulator::simulateTurn
2. Décrémenter le stock de fuel de tous les avions en vol (y compris ceux venant d'être générés au début du tour)
3. Les avions en vol avec un stock de fuel à 0 doivent atterrir en urgence sur une des pistes de l'aéroport. 
Si toutes les pistes sont occupées, l'avion crashe !
Dans les deux cas, l'avion est supprimé de la file d'atterrissage
4. Si des pistes n'ont pas été utilisées lors de l'étape précédente, elles sont utilisées comme suit :
    - Faire atterrir un avion si les files de décollage et d'atterrissage ont la même taille ou que
    la file d'atterrissage est plus grande que la file de décollage
    - Faire décoller un avion si la file de décollage est plus grande que la file d'atterrissage
Dans tous les cas, l'avion est supprimé de la file correspondante
5. Incrementer l'horloge.


Annexes
----------

- [Doc Java 8](https://docs.oracle.com/javase/8/docs/api/)
- [Doc Java 11](https://docs.oracle.com/en/java/javase/11/docs/api/)
- [Doc Java 13](https://docs.oracle.com/en/java/javase/13/docs/api/)
- [Doc JUnit 4.13](https://junit.org/junit4/javadoc/latest/index.html)
