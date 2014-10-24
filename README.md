WumpusWorld
===========

An implementation of the classic game Wumpus World, that allows an agent to move freely in user-defined levels, in order to find the treasure, while trying to avoid deep pits and the mighty Wumpus.
The agent's moves are based on a knowledge base that contains information about the world that he has discovered so far. First Order Logic was used for the representation of the knowledge base and the Forward Chaining algorithm was developed in order for the agent to "take decisions".

You can create you own world by editing the file res/world.xml

Then run the main class src/wumpus/journey/Journey.java and see every step of the agent while he wanders around the board.


#### Note : If the board is carefully created and the agent does not have to make random moves due to uncertainty, he will definitely find the gold!
