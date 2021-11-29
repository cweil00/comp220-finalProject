package main;

import java.util.Collection;

public interface Library<T> {

    /**
     * Creates a string with all of the texts in alphabetical order
     * @return the string with all the texts in alphabetical order
     */
    String alphabetize();

    /**
     * Counts all the words in all the texts in the library
     * @return The total word count of the library
     */
    int wordCount();

    /**
     * Add a new text to the library
     * @param newText the new next to add
     * @return true if successful, false if not
     */
    boolean addText(Text<T> newText);

    /**
     * Removes a text from the library
     * @param textToRemove text to remove from library
     * @return true if successful, false if not
     */
    boolean removeText(Text<T> textToRemove);

    /**
     * Creates a collection of words that are the most important for the given text
     * @param text the text to find the most important words of
     * @param numWords number of most important words to find
     * @return A collection of the most important words for the text
     */
    Collection<T> mostRelevantWordsForText(int numWords, Text<T> text);

    /**
     * Creates a collection of texts that are the most important for a given word
     * @param numTexts number of most important texts to find
     * @param word word to use to find most relevant texts
     * @return a collection of the most important texts for a given word
     */
    Collection<T> mostRelevantTexts(int numTexts, String word);
    
}
