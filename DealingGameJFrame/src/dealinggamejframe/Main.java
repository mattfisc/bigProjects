/*
 * By:     Matthew Fischer
 * Date:   
 */
package dealinggamejframe;

import javax.swing.JFrame;

/**
 *
 * @author Matthew Fischer
 */
public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Deck of Cards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Display());
        frame.pack();
        frame.setVisible(true);
        
    }
    
}
