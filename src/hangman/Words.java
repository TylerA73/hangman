/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 * Class that handles all of the possible words in the game of Hangman.
 * 
 * @author Tyler Arseneault
 */
public class Words {
    private String[] wordList;
    
    /**
     * Constructor for the Words class.
     */
    Words(){
        this.wordList = new String[]{"pour", "apparatus", "fireman", "control",
                        "pause", "squeal", "abrasive", "trouble", "assorted",
                        "spiders"};
    }
    
    /**
     * getRandomWord
     * 
     * A method that returns a random word from an array of strings.
     * 
     * @return String A random String from an array of Strings.
     */
    public String getRandomWord(){
        return wordList[(int)(Math.random() * wordList.length)];
    }
}
