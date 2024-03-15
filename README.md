# **Connect Four: Java Implementation**

This guide covers the setup and usage of a simple Connect Four game implemented in Java. The game features a text-based user interface (TextUI) for interaction, allowing players to take turns dropping colored discs into a vertically suspended 7x6 grid. The objective is for a player to connect four of their discs vertically, horizontally, or diagonally before their opponent.

**Requirements:**
- Java Development Kit (JDK) installed on your system.
- Basic knowledge of compiling and running Java programs via the command line or your preferred Integrated Development Environment (IDE).
- Project Structure
- The project is split into two main files:

TextUI.java: Contains the logic for the user interface, game mechanics, saving and loading game states.
***ConnectFour.java: The runner class that initiates the game.***


## Getting Started

**Step 1: Setup**
Ensure you have the Java Development Kit (JDK) installed. Clone or download the source code files TextUI.java and ConnectFour.java to your local machine.

**Step 2: Compilation**
Navigate to the directory containing the downloaded files and compile both Java files. Open your command line or terminal and run:

1. bash
2. Copy code
3. javac connectfour/TextUI.java connectfour/ConnectFour.java
This compiles the TextUI.java and ConnectFour.java files, generating .class files for each.

**Step 3: Running the Game**
After successful compilation, run the game using the following command in the terminal:

1. bash
2. Copy code
3. java connectfour.ConnectFour

## **Game Play**
Upon starting the game, you'll be greeted with instructions and the current state of the game board. Here's how to play:

1. Choose a Column: Enter a column number (0-6) to drop your piece into the desired column.
2. Save Game: Enter 7 at any time to save the current game state. You'll be prompted to name your save file.
3. Load Game: Currently, loading a game requires modifying TextUI.java to read a specific save file at the start of the game.

The game alternates turns between two players, referred to as "Red" and "Blue," represented by "R" and "B" on the game board. The first player to connect four of their pieces vertically, horizontally, or diagonally wins.

**Features**
- Dynamic Game Board: Tracks each player's moves and updates the board accordingly.
- Win Detection: Automatically detects and announces when a player has won.
- Save/Load Game: Allows saving the game state to a file and loading it.
= Ending the Game

The game loop will continue until a player wins or the board is filled. To exit the game prematurely, use your terminal or command prompt's standard methods for terminating a running program.

Contributing
Feel free to fork the project, make improvements, and submit pull requests. This simple implementation is a great starting point for those looking to explore game development with Java.
