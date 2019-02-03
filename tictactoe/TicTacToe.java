 /** CSIS-113B-3923
 * Name: Matthew Fischer
 * ID: 0549714
 * Date: 05/06/2018
 * Description: GUI program for TicTacToe.  Created the program with two 2D
 * arrays.  The program is extended from JFrame and implemented with 
 * ActionListener and MouseListener.  
 **/

package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


// extend JFrame and implement events: action listener and mouse listener
public class TicTacToe extends JFrame implements ActionListener, MouseListener 
{
    // get Pane
    Container content = this.getContentPane();
    
    // create button
    JButton play = new JButton("Restart");
    
    // create panel
    JPanel p = new JPanel();
    
    // create Jlabel for game status
    JLabel status = new JLabel("Welcome to TicTacToe", JLabel.CENTER);
    
    // create 2D arrays
    JLabel[][] grid = new JLabel[3][3];// 2d object array
    char[][] game = new char[3][3];// 2d char array
    
    int numClicks = 0;// store number of clicks
    boolean isDone = false;// is game over
    boolean isXTurn = true;// X always goes first

    // create font for status
    Font fntStatus = new Font("Helvetica",Font.BOLD,12);// status label font
    
    
    
    public TicTacToe()
    {
        // create gui window
        this.createWindow();
        
        // add status window
        content.add(status,BorderLayout.NORTH);
        
        // status label details
        status.setOpaque(true);// make status visible
        status.setFont(fntStatus);// set font
        status.setBackground(Color.yellow);// set background color yellow
        
        // panel details
        p.setLayout(new GridLayout(3,3,3,3));// grid layout
        p.setBackground(Color.black);// set background color black
        
        // add panel to content
        content.add(p, BorderLayout.CENTER);
        
        // add button to restart game
        content.add(play, BorderLayout.SOUTH);
        play.addActionListener(this);
        
        
//creating grid throught nested for loop 
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                // create JLabel object in each grid index
                grid[row][col] = new JLabel(" ");
                
                // label attached to mouse click
                grid[row][col].addMouseListener(this);
                grid[row][col].setOpaque(true);// set text visible
                grid[row][col].setBackground(Color.white);//set background color
                
                // set label font
                grid[row][col].setFont(new Font("Helvetica", Font.BOLD, 32));
                
               
                p.add(grid[row][col]);// add grid label to panel
                
                // initialize char game 2d array
                game[row][col] = ' ';// set game array to char ' '
            }
        }
        
    }
    
    public void createWindow()
    {
        // create program window
        this.setVisible(true);// set window visible
        this.setSize(300, 300);// set window size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set window will close on exiting button
        this.setTitle("TicTacToe");// set window title
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        resetGame();// reset game
        status.setText("'X's turn");// x's turn output
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        
        if(isDone) 
            resetGame();// if game is done reset game
        
        JLabel clicked = (JLabel) e.getSource();
        
        next:
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                if(clicked == grid[row][col])
                {
                    // clicking on previous label
                    if(!" ".equals(clicked.getText())) {
                        status.setText("Invalid Move");// invalid move
                        break next;// break
                    } 
                    
                    else if(" ".equals(clicked.getText()) && isXTurn == true)
                    {
                        clicked.setText("X");// set X
                        clicked.setForeground(Color.RED); // set X color red
                        game[row][col] = 'X';// set 'X' game char array
                    }
                    
                    // 'O's turn
                    else
                    {
                        clicked.setText("O");// set O
                        clicked.setForeground(Color.BLUE);// set O color
                        game[row][col] = 'O';// game array save char O
                    }
                    // 'X's turn
                    // d. Toggle isXTurn, increment numClicks
                    isXTurn = !isXTurn;
                    numClicks++;
                    // Check to see if game is over after each click
                    gameOver();
                }
            }
        }
            
    }
   
    public void gameOver()
    {
        char winner = ' ';// store winning player 'X' or 'O'
        
        // Check first diagonal
        if(game[0][0] == game[1][1] && game[0][0] == game[2][2])
        {
            winner = game[0][0];// set winner
        }
        
        // check second diagonal
        else if(game[2][0] == game[1][1] && game[2][0] == game[0][2])
        {
            winner = game[2][0];// set winner
        }
        
        // check rows and columns
        else if(winner == ' ')
        {
            for(int row = 0; row < 3; row++)
            {
                for(int col = 0; col < 3; col++)
                {
                    // check rows for winner
                    if(game[row][0] != ' ' && game[row][0] == game[row][1] 
                            && game[row][0] == game[row][2])
                    {
                        winner = game[row][0];// set winner
                    }
                    
                    // check for column winner
                    else if(game[0][row] != ' ' && game[0][row] == game[1][row] && game[0][row] == game[2][row])
                    {
                        winner = game[0][row];// set winner
                    }
                }
            }
        }
        
        // check for tie
        if(winner == ' ' && numClicks == 9)
        {
            isDone = true;// game ends
            status.setText("Tie Game");// status label outputs
            
        }
        
        // check for a winner
        else if(winner != ' ')
        {
            // label outputs winner
            status.setText("Game Over " + winner + " Won!!!");
        }
        
        // whose turn
        else
        {
            // X's turn
            if(isXTurn == true)
            {
                status.setText("X's Turn");// label outputs turn
                isDone = false;// game is not over
            }
            
            // O's Turn
            else
            {
                status.setText("O's Turn");// label outputs turn
                isDone = false;// game is not over
            }
        }
    }
    
    // reset game 
    public void resetGame()
    {
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                grid[row][col].setText(" ");// set all grid labels to " "
                game[row][col] = ' ';// set all game char to ' '
                numClicks = 0;// reset count to zero
                isXTurn = true;// X starts game
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {

    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {

    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {

    }

    @Override
    public void mouseExited(MouseEvent e) 
    {

    }
    
   
    
    public static void main(String[] args) 
    {
        TicTacToe t = new TicTacToe();// create instance of class
    }
    
}
