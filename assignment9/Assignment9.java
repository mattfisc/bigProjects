/*
 * By:     Matthew Fischer
 * Date:   04/11/2019
 */
package assignment9;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Assignment9 {

    public static void main(String[] args) {

        // Create hash map
        Map<String, Integer> map = new HashMap<String, Integer>();

        File file = new File("C:\\Users\\Matthew Fischer\\Desktop\\intensity.txt");
        Scanner readFile = null;
        ArrayList<String> arr = new ArrayList<String>();
        
        String word = "";
        
        try {
            readFile = new Scanner(file);

            // read file
            while (readFile.hasNext()) {
                arr.add(readFile.next());
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        
        // sort
        sort(arr);
        
        // hash map
        map = makeMap(arr);
       
        for (Map.Entry<String, Integer> key : map.entrySet()) {
            System.out.println(key.getKey() + ":" + key.getValue());
        }

    }

// ---------- removeSybols ------------
    public static String removeSymbols(String str) {
        String newWord = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                newWord += str.charAt(i);
            }
        }

        return newWord;
    }

    // --------- alphabatize ---------------
    public static void sort(ArrayList<String> arr){
        String temp = "";
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).compareTo(arr.get(i+1)) == 1){
                temp = arr.get(i);
                arr.set(i, arr.get(i+1));
                arr.set(i, temp);
            }
                
        }
    }
    
    // ------------ sortTree ------------------
    public static Map<String,Integer> makeMap(ArrayList<String> arr) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        
        for(int i = 0; i < arr.size(); i++){
            if(!map.containsKey(arr.get(i))){
                map.put(arr.get(i), 1);
            }
            else{
                map.put( arr.get(i), map.get(arr.get(i))+1 );
            }
        }
        return map;
    }
}
