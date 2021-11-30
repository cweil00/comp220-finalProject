/**
 * Tester for the text classes
 * Author: Chris Weil
 */
package edu.ithaca.cweil.tfidf.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URL;
import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class TextTest {
    
    @Test
    public void smallTextTest(){
        Text textToTest = new ArrayText("Test Author", "Test Title"); //create a test text

        assertFalse(textToTest.inputText("FilenameThatDoesNotExist.txt")); //makes sure is false when a file is not found

        URL path = TextTest.class.getResource("TestText.txt"); //to get proper path to file (cannot have any spaces in path)
        assertTrue(textToTest.inputText(path.getFile())); //makes sure the file is found
        assertEquals(107, textToTest.countWords()); //makes sure the proper number of words is counted
        assertEquals(3, textToTest.singleWordCount("pineapple")); //makes sure that the word is counted the correct number of times
        assertEquals(1, textToTest.singleWordCount("thank"));
        Map<String, Double> wordMap = textToTest.allWordsFrequency();
        assertEquals(Double.valueOf(Math.log(107.0/3)), wordMap.get("pineapple")); //makes sure frequency map works as expected
        assertEquals(Double.valueOf(Math.log(107.0/1)), wordMap.get("thank"));
        assertTrue(Arrays.asList(textToTest.getRelevantWords()).contains("thank")); //makes sure most relevant words work as expected
        assertFalse(Arrays.asList(textToTest.getRelevantWords()).contains("a"));
        assertTrue(Arrays.asList(textToTest.getRelevantWords()).contains("pineapples"));
        assertEquals("Test Author", textToTest.getAuthor()); //testing getters
        assertEquals("Test Title", textToTest.getTitle());

        textToTest = new ArrayText("Test Author", "Test Title", 1); //testing overloaded constructor
        path = TextTest.class.getResource("TestText.txt"); //to get proper path to file (cannot have any spaces in path)
        assertTrue(textToTest.inputText(path.getFile())); //makes sure the file is found
        wordMap = textToTest.allWordsFrequency();
        assertTrue(Arrays.asList(textToTest.getRelevantWords()).contains("thank"));
        assertFalse(Arrays.asList(textToTest.getRelevantWords()).contains("pineapples")); //sees that a word that was previously important now does not make it into the array
    }

    @Test
    public void largeTextTest(){

        Text textToTest = new ArrayText("Shakespeare", "Hamlet", 5); //longer exerpt of text
        URL path = TextTest.class.getResource("HamletExcerpt.txt"); //makes sure everything still works correctly
        textToTest.inputText(path.getFile());
        assertEquals(783, textToTest.countWords());
        assertEquals(16, textToTest.singleWordCount("in"));
        Map<String, Double> wordMap = textToTest.allWordsFrequency();
        assertEquals(Double.valueOf(Math.log(783.0/16)), wordMap.get("in"));
        assertTrue(Arrays.asList(textToTest.getRelevantWords()).contains("neither"));
        assertFalse(Arrays.asList(textToTest.getRelevantWords()).contains("in"));

        smallTextTest(); //run old tests again
    }
}
