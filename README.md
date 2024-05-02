# Battle The Bot!

Niko Johns, Jordan Okada, Joanna Parker

## Description
Battle the Bot! Test your battleship skills against a random forest trained as a battleship pro. 

We propose developing our own customizable decision tree library. In addition to simply creating decision tree and random forest classes, this library will have data loading, model running, and model evaluation functions. These will be customizable so that a user only needs to import this library to create, train, and test a decision tree. We will use the decision tree library to create and train a random forest to play battleship. We will also develop a battleship game framework that follows the rules of the classic game: two players, each with a 10-by-10 board and 10 ships of length two through six. This class will be used to generate various possible games to train the random forest. Our decision tree and random forest classes will be specifically designed to take in a game state: hits, misses, ship locations, and destroyed ships on the bot’s board; hits, misses, and destroyed ships locations on the human’s board. It will use this information to predict the best coordinate to hit on the human’s board. This library should be applicable to any two player game similar to battleship with a well-defined game state. We will also design a front-end user interface where a game can be played against the random forest.

## Languages
We will use Java for internal operations – the development of the decision tree class and logic of the game. We will use html for user interface development.

## Libraries and Frameworks 
We will use Spring Boot to host our web application and integrate the front and back end. We will use low level java libraries as helpers for our decision tree library, such as ArrayList and HashMap. 

## Functional Elements
Niko: Battleship game state class, player class.

Jordan: Board class, front end and back end integration, game graphics.

Joanna: Decision tree library, random forest creation and training, generating games to train random forest from battleship game framework.

## Design Patterns
- Observer: We will implement an audible observer pattern to listen to events such as turn, win, loss, move, and game board setup.
- Factory pattern: This will allow us to create players and ships without using the new keyword for each creation.
- Builder: Our builder pattern will create our game board using our factory pattern.
- Encapsulation: Users will not have access to the data structure of the decision tree, but can change it by modifying parameters through set functions.
- Delegation: The random forest class will delegate decision tree creation to the decision tree class, and both the random forest and decision tree classes will delegate low-level data structure management to private helper classes.
- Cohesion: The game framework will be broken into three classes: the board class, focused on the structure of a battleship board; the player class, focused on the state of the player; the game state class, focused on which player’s turn it is and win state.
- Loose Coupling: Changing one of the game classes will not require changes in the other classes.

## BDD Scenarios
- Strategy Pattern (Player's Turn): When a player takes their turn, they choose a cell to attack on the opponent’s board. The system updates the board based on whether it was a hit or a miss.
- Placing Ships: When a player chooses a row and a column to place a ship, the ship is placed on the selected coordinates if not already occupied.
- Hitting a Ship: When a player selects a coordinate that contains the opponent’s ship, the cell changes to indicate a hit ‘X’. The number of ships the opponent has decreases by one.
- Hittin a ship twice: A player will not be able to hit a ship twice.
- Game Setup: When the player chooses the game mode Player vs CPU, the player is prompted for information to fill out their board and the other board is generated randomly. When the player chooses the game mode Player vs Player, both players are prompted for information to fill out their board.
- Ship placement maximum: When a player is placing their ships on the board, they will not be able to click on more than four spaces before going to the next step



