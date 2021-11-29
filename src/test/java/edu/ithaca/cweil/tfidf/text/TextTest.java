/**
 * Tester for the text classes
 * Author: Chris Weil
 */
package edu.ithaca.cweil.tfidf.text;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class TextTest {
    
    @Test
    public void textTest(){
        //TODO
        //Determine best type of text and change this from null
        Text textToTest = null;

        textToTest.inputText("TestText.txt");
        assertEquals(107, textToTest.countWords());
        assertEquals(3, textToTest.singleWordCount("pinapple"));
        Map<String, Integer> wordMap = textToTest.allWordsCount();
        assertEquals(Integer.valueOf(1), wordMap.get("pinapple")); //may change frequency here once have a better idea of how tfidf works
        //add more tests for all words count and other things about this text
    }
}
