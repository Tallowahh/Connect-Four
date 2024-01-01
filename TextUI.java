package connectfour;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class TextUI{

    private Board game = new Board();
    private Scanner userIn = new Scanner(System.in);
    private int userChoice = 1;
    private int[] capacity = {5, 5, 5, 5, 5, 5, 5};
    private int flip = 0;
    private int i;
    private int j;
    private int userinput;
    private boolean gamewon = false;
    private boolean inputC = false;
    private String filename;
    private String[][] savedboard;
    private String[][] pieces;
    private HashMap<Integer, Integer> position = new HashMap<Integer, Integer>();

    public String saveGame(String[][] boardsave){
        System.out.println("What would you like to name the Save File?");
        filename = userIn.next();
        
        System.out.println("Filename Chosen is " + filename);

        try {
            FileWriter filewrite = new FileWriter(filename);
            PrintWriter writer = new PrintWriter(filewrite);
            for (i = 5; i >= 0; i--) {
                for (j = 0; j < 7; j++) {
                    if (boardsave[i][j].equals("R")) {
                        writer.print("1");
                        writer.print(", ");
                    } else if (boardsave[i][j].equals("B")) {
                        writer.print("2");
                        writer.print(", ");
                    } else if (boardsave[i][i].equals("-")) {
                        writer.print("0");
                        writer.print(", ");
                    }
                }
                
            }
            System.out.println("Game Saved");
            writer.close();
        } catch (Exception e) {
            System.out.println("Something went wrong accessing the file.");
        }
        return filename;
    }

    public String[][] loadGame(String file) { //Load the game from the save file
        savedboard = game.getBoard();
        try {
            String filecontent;
            int k = 0;
            File myfile = new File(file);
            userIn = new Scanner(myfile);
            System.out.println("File to be read is: " + file);
                try (BufferedReader read = new BufferedReader(new FileReader(myfile))) {
                    String sline;
                    while ((sline = read.readLine()) != null) {
                        System.out.println(sline);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    userIn.next();
                }     
            System.out.println();
            userIn.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            userIn.next();
           // e.printStackTrace();
          }
        return pieces;
    }

    public void gameLoop() {
        boolean win = false;
        while (userChoice != 2) {
            if (flip == 0) {
                System.out.println("Welcome to Connect 4!");
                System.out.println("To play, select a column from 0 - 6 to place your piece.");
                System.out.println("Enter 7 to save the game at any time.");
                System.out.println("It's " + game.getToken()[flip % 2] + "'s turn.");
                printBoard(game.setBoard());
            }            
            updateCapacity(getInput()); 
            printBoard(game.getBoard()); 
            
            if (flip >= 6) {
                win = gameWin(game.getBoard());
                if (win) {
                    while(!inputC) {
                        System.out.print("Enter any number other than 2 to play again: ");
                        try {
                            userChoice = userIn.nextInt();
                            inputC = true;
                            flip = 0;                            
                            for (i = 0; i < 7; i++) {
                                capacity[i] = 5;
                            }
                        } catch (Exception e) {
                            System.out.println("Please enter a Number.");
                            inputC = false;
                            userIn.next();
                            continue;
                        }                       
                    }
                } 
                if (inputC) {
                    System.out.println("\n");
                    inputC = false;
                    continue;
                } 
                if (userChoice == 2) {
                    break;
                }              
            } 
            flip++;
        }   
        System.out.println("Game Exited.");             
    }

    public boolean horizontalWin(String[][] currentboard) {
        currentboard = game.getBoard();
        String token = game.getToken()[flip % 2];

        for(i = 5; i >= 0; i--) {
            for(j = 0; j < 7; j++) {
                try {
                    if (currentboard[i][j] == token) {
                        if (currentboard[i][j + 1] == token && currentboard[i][j + 2] == token
                        && (currentboard[i][j + 3] == token)) {
                            gamewon = true;
                            break;
                        } 
                    }
                } catch (Exception e) {
                    gamewon = false;
                }
            }
            if (gamewon) {
                break;
            }
        }
        if (gamewon) {
            System.out.println(token + " is the Winner!");
            return true;
        }                
        return false;
    }

    public boolean verticalWin(String[][] currentboard) {
        currentboard = game.getBoard();
        String token = game.getToken()[flip % 2];
        for (j = 0; j < 7; j++) {
            for (i = 5; i >= 0; i--) {
                try {
                    if (currentboard[i][j] == token && currentboard[i + 1][j] == token
                    && currentboard[i + 2][j] == token && currentboard[i + 3][j] == token) {
                        gamewon = true;
                        break;
                    }
                } catch (Exception e) {
                    gamewon = false;
                }
                }
                if (gamewon) {
                    break;
                }
        }
        if (gamewon) {
            System.out.println(token + " is the Winner!");
            return true;
        }
        return false;
    }

    public boolean diagonalWin(String[][] currentboard) {
        currentboard = game.getBoard();
        String token = game.getToken()[flip %2];
        for (i = 5; i >= 0; i--) {
            for (j = 0; j < 7; j++) {
                try {
                    if (currentboard[i][j] == token && currentboard[i + 1][j + 1] == token
                    && currentboard[i + 2][j + 2] == token && currentboard[i + 3][j + 3] == token) {
                        gamewon = true;
                        break;
                    }
                } catch (Exception e) {
                    gamewon = false;
                }
                try {
                    if (currentboard[i][j] == token && currentboard[i - 1][j + 1] == token
                    && currentboard[i - 2][j + 2] == token && currentboard[i - 3][j + 3] == token) {
                        gamewon = true;
                        break;
                    }
                } catch (Exception e) {
                    gamewon = false;
                }
            }
            if (gamewon) {
                break;
            }
        }
        if (gamewon) {
            System.out.println(token + " is the Winner!");
            return true;
        }
        return false;
    }

    public boolean gameWin(String[][] currentboard) {
        if (verticalWin(currentboard) || horizontalWin(currentboard) || diagonalWin(currentboard)){
            return true;
        }
        return false;
    }
    
    
    public String[][] updateBoard(int x, int y, String[][] currentboard) {
        currentboard[x][y] = game.getToken()[flip % 2];
        return currentboard;
    }

    public boolean checkCapacity(int column) { //Check to see if the capacity of the column is full (6)
        if (capacity[column] < 0) {
            System.out.print("The Capacity for Column " + column + " is " + (capacity[column] + 1));
            System.out.println(" (Full). Please select another Column.");
            return false;
        } else {
            System.out.println("The Capacity for Column " + column + " is now " + (capacity[column]));
            return true;
        }
    }
    
    public int updateCapacity(int input) { //Update the capacity of the column chosen
        if (checkCapacity(input)){
            position.put(input, capacity[input]); //Assign the capacity to the position in the Hashmap
            updateBoard(capacity[input], input, game.getBoard()); //Update the Board with Red or Blue in Cell
            capacity[input]--; //Decrease the capacity of the input
            if (flip > 0) {
                System.out.println("It's " + game.getToken()[flip % 2] + "'s turn"); 
            }
        }
        return capacity[input];
    }
    
    public void checkInput() {
        boolean save = false;
        if (userinput == 7) {
            filename = saveGame(game.getBoard());
            save = true;
        }   
        if (userinput == 8 && save) {
                System.out.println("Game Loaded");
        }     
    }

    public void setInput() {
        System.out.print("Select a column from 0 - 6: ");
        try {
            userinput = userIn.nextInt();
            while(userinput < 0 || userinput > 6) {
                System.out.print("Selection out of bounds. Select a position between 0 - 6: ");
                userinput = userIn.nextInt();
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public int getInput() {
        return userinput;
    }
    public void printBoard(String[][] board) {
        board = game.getBoard();
        for (i = 0; i < 6; i++) {
            System.out.print("| ");
            for (j = 0; j < 7; j++) {
                System.out.print(board[i][j]);
                if (j < 6) {
                    System.out.print(" | ");
                }
            }
            System.out.print(" |");
            System.out.println("\n|___|___|___|___|___|___|___|");
        }
        System.out.println("| 0 | 1 | 2 | 3 | 4 | 5 | 6 |");
    }

}