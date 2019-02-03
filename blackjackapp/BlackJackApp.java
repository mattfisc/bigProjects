/*
 * By:     Matthew Fischer
 * Date:   01/23/2019
 */
package blackjackapp;

import java.util.Scanner;

/**
 *
 * @author Matthew Fischer
 */
public class BlackJackApp {

   
    public static void main(String[] args) {
        // TASK 1: CREATE THE GAME ENGINE
        BlackJackEngine blackJack = new BlackJackEngine();

        // TASK 2: ALLOW THE USER TO PLAY AS MANY TIMES AS THEY WANT.
        for (int i = 1; ; i++) {
          System.out.println("\n\nB L A C K J A C K G A M E #" + i);
          blackJack.playGame();
          blackJack.callWinner();

          Scanner in = new Scanner(System.in);
          String another;
          System.out.print("Would you like to play another game? Enter yes to continue. ");
          another = in.nextLine();
          if (!another.toLowerCase().equals("yes"))
          break;
        }
        
      }
    
}

/*
----------------  build one --------------------------
run:


B L A C K J A C K G A M E #1
Player's  hand value: 11
	JACK OF CLUBS
	ACE OF HEARTS
The dealer's hand is: 
	Card 1 (isFaceDown)
	7 OF CLUBS

Do you want another card? HIT or STAY: hit
Card added: QUEEN OF HEARTS

Player hand value is: 21
Players hand value: 21
	JACK OF CLUBS
	ACE OF HEARTS
	QUEEN OF HEARTS
Dealers hand value: 9
	2 OF SPADES
	7 OF CLUBS
Player Wins
Would you like to play another game? Enter yes to continue. yes


B L A C K J A C K G A M E #2
Player's  hand value: 11
	ACE OF CLUBS
	10 OF CLUBS
The dealer's hand is: 
	Card 1 (isFaceDown)
	7 OF SPADES

Do you want another card? HIT or STAY: hit
Card added: 9 OF SPADES

Player hand value is: 20
Dealer takes a card: 4 OF HEARTS

Do you want another card? HIT or STAY: stay
Dealer takes a card: 4 OF DIAMONDS
Players hand value: 20
	ACE OF CLUBS
	10 OF CLUBS
	9 OF SPADES
Dealers hand value: 17
	2 OF CLUBS
	7 OF SPADES
	4 OF HEARTS
	4 OF DIAMONDS
Player Wins
Would you like to play another game? Enter yes to continue. yes


B L A C K J A C K G A M E #3
Player's  hand value: 14
	9 OF CLUBS
	5 OF CLUBS
The dealer's hand is: 
	Card 1 (isFaceDown)
	6 OF HEARTS

Do you want another card? HIT or STAY: stay
Dealer takes a card: 3 OF HEARTS

Do you want another card? HIT or STAY: stay
Dealer takes a card: 8 OF HEARTS
Players hand value: 14
	9 OF CLUBS
	5 OF CLUBS
Dealers hand value: 24
	7 OF SPADES
	6 OF HEARTS
	3 OF HEARTS
	8 OF HEARTS
Sorry. You lose.
Would you like to play another game? Enter yes to continue. BUILD STOPPED (total time: 2 minutes 46 seconds)

*/
