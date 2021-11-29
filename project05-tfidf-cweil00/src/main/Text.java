package main;

import java.util.Collection;

public interface Text<T> {

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
     * Counts frequency of every word in the text
     * @return A collection of all words along with their relative frequencies
     */
    Collection<T> allWordsCount();

}