/**
 * Class that implements Text interface using arrays.
 * Author: Chris Weil
 */
package edu.ithaca.cweil.tfidf.text;

//import the needed packages
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayText implements Text {

    //set up properties of the class
    private String author;
    private String title;
    private String[] allWords;
    private String[] relevantWords;

    /**
     * Constructor method - overloaded
     * @param author String author of text
     * @param title String title of text
     */
    public ArrayText(String author, String title){
        this(author, title, 10);
    }

    /**
     * Constructor method - overloaded
     * @param author String author of text
     * @param title String title of text
     * @param numRelevantWords int, number of most relevant words to save (default is 10)
     */
    public ArrayText(String author, String title, int numRelevantWords){
        this.author = author;
        this.title = title;
        allWords = null;
        relevantWords = new String[numRelevantWords];
    }

    @Override
    /**
     * Counts the total number of words in the text
     * @return int, the total number of words in the text
     */
    public int countWords() {
        return allWords.length - 1;
    }

    @Override
    /**
     * Counds the number of times a specific word occurs in the text
     * @param word String, the word to count
     * @return int, the number of times word occurs in the text
     */
    public int singleWordCount(String word) {
        int total = 0;
        for (int i = 0; i<allWords.length; i++){
            if (allWords[i].equals(word)){ //check if the current word is the word you are looking for
                total++;
            }
        }
        return total;
    }

    @Override
    /**
     * Counts frequency of every word in the text, uses the tftdf methodology, and updates the most relevant words array
     * @return A map of all words along with their relative frequencies
     */
    public Map<String, Double> allWordsFrequency() {
        Map<String, Double> wordMap = new HashMap<>();
        for (int i = 0; i<allWords.length; i++){
            if (!wordMap.containsKey(allWords[i])){ //makes sure the word has not already been added to the map
                double count = (double) this.singleWordCount(allWords[i]); //cast to double to ensure that do not do integer division
                wordMap.put(allWords[i], Math.log(this.countWords() / count)); //add the word to the map with the tftdf value
            }
        }
        //reverse the map
        Map<Double, String> reverseWordMap = new HashMap<>();
        for(Map.Entry<String,Double> entry : wordMap.entrySet()){
            double i = 0.0;
            while(reverseWordMap.putIfAbsent(entry.getValue() + i, entry.getKey()) != null){ //sometimes have same value, so increase some by very small amount
                i = i + 0.0001; //should be ok for adding to most important array because either all will be added because they are very similar or if at end would have to pick which ones to add and this will do that for me
            }
        }
        Double[] reverseMapKeys = reverseWordMap.keySet().toArray(new Double[0]); //get the keys of the reversed map
        Arrays.sort(reverseMapKeys); //sort the keys so have correct ordering of tfidf
        for (int i = 0; i < relevantWords.length; i++){
            relevantWords[i] = reverseWordMap.get(reverseMapKeys[reverseMapKeys.length - 1 - i]); //update relevant words
        }
        return wordMap;
    }

    @Override
    /**
     * Reads from a text file all of the words of a text
     * Catches a FileNotFoundException if the file is unable to be found
     * @param filename String filename of the file with the text
     * @return boolean true if the file is successfully read, false if otherwise
     */
    public boolean inputText(String filename) {
        try {
            Scanner reader = new Scanner(new File(filename)); //open the file and scanner
            String allWordsString = "";
            while (reader.hasNextLine()) {
                String line = reader.nextLine(); //read the file
                line = line.replaceAll("\\p{Punct}", ""); //remove punctuation, newlines, set everything to lowercase
                line = line.replaceAll("\\n", "");
                line = line.toLowerCase();
                allWordsString = allWordsString + " " + line; //add newlines to string
            }
            allWords = allWordsString.split("\\s+"); //split the string of words by the whitespace
            reader.close(); //close the scanner
            return true;
        }
        catch (FileNotFoundException e) { //if file does not exist return false
            return false;
        }
    }

    @Override
    /**
     * Getter method
     * @return String author, the author of the text
     */
    public String getAuthor(){
        return author;
    }

    @Override
    /**
     * Getter method
     * @return String title, the title of the text
     */
    public String getTitle(){
        return title;
    }

    @Override
    /**
     * Getter method
     * @return array of Strings, containing the most important words (whose number is specified by its length)
     */
    public String[] getRelevantWords(){
        return relevantWords;
    }
    
}
