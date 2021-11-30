/**
 * Tester for the Library classes
 * Author: Chris Weil
 */
package edu.ithaca.cweil.tfidf.library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;

import org.junit.jupiter.api.Test;

import edu.ithaca.cweil.tfidf.text.Text;
import edu.ithaca.cweil.tfidf.text.TextTest;

public class LibraryTest{

    @Test
    public void addAndAlphabetTest(){
        //TODO:
        //same as for textTest
        Library<String> libraryToTest = null;

        Text testText = null;
        URL path = TextTest.class.getResource("TestText.txt");
        testText.inputText(path.getFile());
        libraryToTest.addText(testText);
        assertEquals(107, libraryToTest.wordCount());
    }

}