# DesignPatterns-SER316-aarif

My adaptation of the RPG Dungeon Crawler game is inspired by one of my favorite fictional series called "A Court of Thorns and Roses". I will be implementing character classes and types, weapons and skills, and basic layout of the floors and evironment, roughly based on the dystopian world depicted in these books. The three design patterns I plan to implement from the Gang of Four include:

1. Factory Pattern:
   I used the Factory pattern to implement the first three requirements. The set up of my pattern was referenced by the class diagram and examples on https://www.blackwasp.co.uk/FactoryMethod.aspx. The character creation, type creation, and enemy creation were all done using this pattern. The factory pattern made a good choice as I was able to make concrete and base classes and then build them up for several character types and enemies. It made the process smooth and less time-consuming as the base for each class was already set in the interface and it only needed to be implemented. My code that follows this design pattern is under a package called "Factory" under my source code. 
   
2. Decorator Pattern:
   I used the Decorator pattern layout described in https://www.blackwasp.co.uk/Decorator.aspx as well. The class diagrams especially were very useful and enlightning. To make use of the Decorator pattern, I used it in the creation of my Items and weapons, and to create my shops and chests. Using the decorator pattern here was a good idea since I was able to make one Item interface and use it design almost all my weapons. It was an efficient use of the design pattern. All my code that follows the decorator pattern is under the decorator package in my source code.
   
3. Observer Pattern:
   I used the observer pattern to implement requirements 8, 10, and 11. Implementing the cycles and floors was made a lot easier using this pattern as the floors and cycles needed to be changed constantly accoridng to the game setup. This is done best using the observer pattern as the whole scenario regarding the change would be changed as well. I used https://www.blackwasp.co.uk/Observer.aspx as my primary resource for getting familiar with these design patterns.

Link to Screencast:
https://www.loom.com/share/77130c5c86f34de68085262bba0d3575
