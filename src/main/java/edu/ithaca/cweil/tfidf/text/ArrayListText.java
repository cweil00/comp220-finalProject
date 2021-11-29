package edu.ithaca.cweil.tfidf.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ArrayListText implements Text {

    private String author;
    private String title;
    private List<String[]> allWords;
    private List<String> relevantWords;

    public ArrayListText(String author, String title){
        this.author = author;
        this.title = title;
        allWords = new ArrayList<>();
        relevantWords = new ArrayList<>();
    }

    @Override
    public int countWords() {
        int total = 0;
        for (int i = 0; i<allWords.size(); i++){
            total = total + allWords.get(i).length;
        }
        return total;
    }

    @Override
    public int singleWordCount(String word) {
        int total = 0;
        for (int i = 0; i<allWords.size(); i++){
            for (int j = 0; j < allWords.get(i).length; j++){
                if (allWords.get(i)[j].equals(word)){
                    total++;
                }
            }
        }
        return total;
    }

    @Override
    public Map<String, Integer> allWordsCount() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean inputText(String filename) {
        try {
            Scanner reader = new Scanner(new File(filename));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                allWords.add(line.split("\\s+"));
            }
            return true;
        }
        catch (FileNotFoundException e) {
            return false;
        }
    }

    public String getAuthor(){
        return author;
    }

    public String getTitle(){
        return title;
    }
    
}
