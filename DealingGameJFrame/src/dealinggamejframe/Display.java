/*
 * By:     Matthew Fischer
 * Date:   
 */
package dealinggamejframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JPanel implements ActionListener {
    
    JButton dealCard;
    JLabel showCard;
    
    Deck deck;
    
    
    public Display(){
        dealCard = new JButton("Deck of Cards");
        showCard = new JLabel("Discard pile");
        
        // size
        setPreferredSize(new Dimension(500,500));
        
        setLayout(null);
        setBackground(Color.gray);
        
        add(dealCard);
        add(showCard);
        
        dealCard.addActionListener(this);
        
        dealCard.setBounds(10, 10, 200, 30);
        showCard.setBounds(10,10,200,200);
        
        deck = new Deck();
        deck.populate();
        deck.shuffle();
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        showCard.setText(deck.dealCard().toString());
    }
    
}
