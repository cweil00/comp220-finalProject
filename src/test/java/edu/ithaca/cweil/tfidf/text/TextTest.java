/**
 * Tester for the text classes
 * Author: Chris Weil
 */
package edu.ithaca.cweil.tfidf.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URL;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class TextTest {
    
    @Test
    public void textTest(){
        Text textToTest = new ArrayText("Test Author", "Test Title");

        assertFalse(textToTest.inputText("FilenameThatDoesNotExist.txt"));

        URL path = TextTest.class.getResource("TestText.txt");
        assertTrue(textToTest.inputText(path.getFile()));
        assertEquals(107, textToTest.countWords());
        assertEquals(3, textToTest.singleWordCount("pineapple"));
        Map<String, Double> wordMap = textToTest.allWordsFrequency();
        assertEquals(Double.valueOf(Math.log(107.0/3)), wordMap.get("pineapple"));
        //add more tests for all words count and other things about this text
    }
}
