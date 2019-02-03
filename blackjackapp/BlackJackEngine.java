/*
 * By:     Matthew Fischer
 * Date:   01/23/2019
 */
package blackjackapp;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackEngine {
    // Data Members
    Deck myDeck;
    Scanner in = new Scanner(System.in);
    ArrayList<Card> playerHand;
    ArrayList<Card> dealerHand;
    
    // Default Constructor
    public BlackJackEngine(){
        // Create Deck
        myDeck = new Deck();
        
        
    }

    // Hit me
    public boolean hitMe(){
        boolean hit = false;
        
        System.out.print("\nDo you want another card? HIT or STAY: ");
        String answer = in.next().toLowerCase();
        
        if( answer.equals("hit") )
            hit = true;
        
        return hit;
    }
    
    
    // ----- playGame -------
    public void playGame(){
        // Start Game
        // Populate Cards in Deck
        myDeck.populate();
        // Shuffle Cards in Deck
        myDeck.shuffle();
        
        
        // Player gets two cards
        playerHand = new ArrayList<Card>();
        playerHand.add( myDeck.dealCard() );
        playerHand.add( myDeck.dealCard() );
        
        // Show Players Hand
        System.out.println("Player's  hand value: " + getHandValue(playerHand));
        showHand(playerHand);
        
        // Dealer gets two cards 
        dealerHand = new ArrayList<Card>();
        dealerHand.add( myDeck.dealCard() );
        dealerHand.get(0).setNotFaceUp(true);
        dealerHand.add( myDeck.dealCard() );
        // Show Dealers Hand
        System.out.println("The dealer's hand is: ");
        showHand(dealerHand);

        // player hit option
        boolean hit = true;
        while(hit){
            hit = hitMe();
            if(hit == true){
                playerHand.add( myDeck.dealCard() );
                System.out.println( "Card added: " + playerHand.get(playerHand.size()-1) + "\n");
                System.out.println("Player hand value is: " + getHandValue(playerHand) );
                
                if(getHandValue(playerHand) >= 21){
                    break;
                }
                
            } 
            // dealer hit option
            if(getHandValue(dealerHand) < 17 || getHandValue(dealerHand) > 21){
                dealerHand.add( myDeck.dealCard() );
                System.out.println("Dealer takes a card: " + dealerHand.get(dealerHand.size()-1) );
            }
        }
        
   
    }
    
    // callWinner
    public void callWinner(){
        System.out.println( "Players hand value: " + getHandValue(playerHand) );
        showHand(playerHand);
        
        System.out.println( "Dealers hand value: " + getHandValue(dealerHand) );
        
        // flip first card
        dealerHand.get(0).flip();
        showHand(dealerHand);
        
        // player winners
        if( getHandValue(playerHand) > getHandValue(dealerHand) && 
                getHandValue(playerHand) < 22){
            System.out.println("Player Wins");
        }
        else{
            // player loses
            if(getHandValue(playerHand) > 21)
                System.out.print("Player exceeded 21.  ");
            System.out.println("Sorry. You lose.");
        }
    }
    
    // getHandValue
    public int getHandValue(ArrayList<Card> hand){
        int value = 0;
        
        for(int i = 0; i < hand.size(); i++){
            value += hand.get(i).value();
        }
        
        return value;
    }
    
    // showHand
    public void showHand(ArrayList<Card> hand){
        
        for( int i = 0; i < hand.size(); i++ ){
            if( hand.get(i).isNotFaceUp() != true)
                System.out.println( "\t" + hand.get(i).toString() );
            else
                System.out.println("\tCard " + (i+1) + " (isFaceDown)");
                        
        }
    }
    
}
