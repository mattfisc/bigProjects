// Matthew Fischer
// Extra Credit

package tictactoegame;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

    public static Scanner in = new Scanner(System.in);
    public static Random rnd = new Random();
    
    public static void main(String[] args) {
        // variables
        int row = 0;
        int col = 0;
        char winner = ' ';
        // initialize board
        char[][] board = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        while(winner == ' ') {
        // display board
        display(board);
        // players turn
        turn(board);
        // computer turn
        computerTurn(board);
        // check for end
        winner = endCheck(board);
    }
        
    System.out.println("The winner is " + winner);
    if(winner == 'X')
        System.out.println("Congrates you won!!!");
    else
        System.out.println("Sorry you lost. Try again.");
    // display board
    display(board);
    
    }
    
    //----------- player turn -------------------------------------
    public static void turn(char[][] board) {
        // Declare variables
        char player = 'X';
        boolean turn = true;
        int pos1 = 0;
        int pos2 = 0;
        System.out.println("\n");

        // player turn
        while(turn) {
            
            // enter position
            System.out.println("Enter row: 0-2");
            pos1 = input();
            System.out.println("Enter col: 0-2");
            pos2 = input();
            
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(board[pos1][pos2] == ' ') {
                        board[pos1][pos2] = player;
                        turn = false;
                    }
                }
            }
            
            if(turn)
                System.out.println("Move taken try again");
            }
        }
     
    //-------------------------- input ------------------------------------
    public static int input() {
        int pos = 0;
        do{
        pos = in.nextInt();
        }while(pos > 2 & pos < 0);
        return pos;
    }
    
    //---------------- display -----------------------------------
    public static void display(char[][] board) {
        
        // display board
        for(int i = 0; i < 3; i++) {
            System.out.println(" -----------");
            for(int j = 0; j < 3; j++) {
                System.out.print( "| " + board[i][j] + " " );
                if(j == 2)
                    System.out.print("|\n");
            }
            if(i == 2)
                System.out.print(" -----------");
        }
    }
    
    //-------------------- computer turn ----------------------------
    public static void computerTurn(char[][] board) {
        // Declare variables
        boolean turn = true;
        
        
        // random not smart 
        while(turn) {

            // random spot
            
            // position
            int pos1 = rnd.nextInt(3);
            int pos2 = rnd.nextInt(3);

            // place 'O'
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(board[pos1][pos2] == ' ') {
                        board[pos1][pos2] = 'O';
                        turn = false;
                    }
                }
            }

            
        }
    }
    public static char endCheck(char[][] board) {

        // Declare variables
        char winner = ' ';

        // rows winner
        if(board[0][0] == board[0][1] &&  board [0][0] == board[0][2]) {
            winner = board[0][0];
        }
        else if(board[1][0] == board[1][1] && board[0][0] == board[1][2]) {
            winner = board[1][0];
        }
        else if(board[2][0] == board[2][1] && board[2][0] == board[2][2]) {
            winner = board[2][0];
        }

        // diagonal winner
        else if(board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            winner = board[1][1];
        }
        else if(board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            winner = board[1][1];
        }

        // col winner
        if(board[0][0] == board[1][0] &&  board [0][0] == board[2][0]) {
            winner = board[0][0];
        }
        else if(board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
            winner = board[0][1];
        }
        else if(board[0][2] == board[1][2] && board[0][2] == board[2][2]) {
            winner = board[0][2];
        }
        
        return winner;
    }
}
/*
------------------------- build 1 -----------------------------------------
run:
 -----------
|   |   |   |
 -----------
|   |   |   |
 -----------
|   |   |   |
 -----------

Enter row: 0-2
1
Enter col: 0-2
1
 -----------
| O |   |   |
 -----------
|   | X |   |
 -----------
|   |   |   |
 -----------

Enter row: 0-2
2
Enter col: 0-2
1
 -----------
| O |   |   |
 -----------
|   | X |   |
 -----------
|   | X | O |
 -----------

Enter row: 0-2
0
Enter col: 0-2
1
The winner is X
Congrates you won!!!
 -----------
| O | X |   |
 -----------
|   | X |   |
 -----------
| O | X | O |
 -----------BUILD SUCCESSFUL (total time: 2 minutes 12 seconds)

------------------------------- Build 2 --------------------------------
run:
 -----------
|   |   |   |
 -----------
|   |   |   |
 -----------
|   |   |   |
 -----------

Enter row: 0-2
0 1
Enter col: 0-2
 -----------
|   | X |   |
 -----------
|   |   |   |
 -----------
|   |   | O |
 -----------

Enter row: 0-2
1 1
Enter col: 0-2
 -----------
|   | X |   |
 -----------
|   | X |   |
 -----------
|   | O | O |
 -----------

Enter row: 0-2
0 0
Enter col: 0-2
 -----------
| X | X |   |
 -----------
|   | X | O |
 -----------
|   | O | O |
 -----------

Enter row: 0-2
1 0
Enter col: 0-2
The winner is O
Sorry you lost. Try again.
 -----------
| X | X |   |
 -----------
| X | X | O |
 -----------
| O | O | O |
 -----------BUILD SUCCESSFUL (total time: 35 seconds)

-------------------------------------------------------------------------
*/