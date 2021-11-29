/**
 * Tester for the Library classes
 * Author: Chris Weil
 */
package edu.ithaca.cweil.tfidf.library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.ithaca.cweil.tfidf.text.Text;

public class LibraryTest{

    @Test
    public void addAndAlphabetTest(){
        //TODO:
        //same as for textTest
        Library<String> libraryToTest = null;

        Text testText = null;
        testText.inputText("TestText.txt");
        libraryToTest.addText(testText);
        assertEquals(107, libraryToTest.wordCount());
    }

}