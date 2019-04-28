/*
 * By:     Matthew Fischer
 * Date:   
 */
package assignment9;

/**
 *
 * @author Matthew Fischer
 */
public class Word {
    private String word;
    
    public Word(String w){
        word = w;
    }
    
    // getters and setters

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    
    // toString
    public String toString(Word w){
        return w.word;
    }
    
    
    // leave out symbols
    public void removeSymbols(){
        String checkWord = this.getWord();
        String newWord = "";
        for(int i = 0; i < checkWord.length(); i++){
            if(Character.isLetter(checkWord.charAt(i)))
                newWord += checkWord.charAt(i);
            
        }
    }
}
