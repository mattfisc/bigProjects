/*
 * By:     Matthew Fischer
 * Date:   
 */
package assignment8program2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Matthew Fischer
 */
public class TestDrive {
    
    public MorseTree tree;
    public File file;
    public Scanner readFromFile;
    
    // Constructor
    public TestDrive(){
        tree = new MorseTree();
        file = new File("morseText.txt");
        readFromFile = null;
        
        fillTree();
    }
    
    // fill tree
    public void fillTree(){

        //data members        
        char newChar = '\0';
        String mCode = "";
        
        
        try{
            readFromFile = new Scanner(file);
            
            // read line
            while( readFromFile.hasNextLine() ){
                // get Letter
                newChar = readFromFile.next().charAt(0);
                // get Morse Code String
                mCode = readFromFile.next();
                
                // insert into Morse Tree
                tree.insertNode(newChar,mCode);
            }
            
        }catch(IOException e){
            System.out.println("File not found");
        }
    }
    
    // Decoder
    public void decoder(String mCode){
        System.out.println("Morse Code: " + mCode 
                + "\nMeaning: " + tree.decodeMCode(mCode));
    }
}
