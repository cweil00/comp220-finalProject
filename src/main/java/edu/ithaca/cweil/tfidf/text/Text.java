/**
 * Interface for Text class
 * Author: Chris Weil
 */
package edu.ithaca.cweil.tfidf.text;

import java.util.Map;

public interface Text {

    /**
     * Counts the total number of words in the text
     * @return the total number of words in the text
     */
    int countWords();

    /**
     * Counds the number of times a specific word occurs in the text
     * @param word the word to count
     * @return the number of times word occurs in the text
     */
    int singleWordCount(String word);

    /**
     * Counts frequency of every word in the text, uses the tfidf methodology, and updates the most relevant words array
     * @return A collection of all words along with their relative frequencies
     */
    Map<String, Double> allWordsFrequency();

    /**
     * Reads from a text file all of the words of a text
     * Catches a FileNotFoundException if the file is unable to be found
     * @param filename filename of the file with the text
     * @return true if the file is successfully read, false if otherwise
     */
    boolean inputText(String filename);

    /**
     * Getter method
     * @return String author, the author of the text
     */
    String getAuthor();

    /**
     * Getter method
     * @return String title, the title of the text
     */
    String getTitle();

    /**
     * Getter method
     * @return array of Strings, containing the most important words (whose number is specified by its length)
     */
    String[] getRelevantWords();

}