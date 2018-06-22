/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class that handles the available and used letters of the game Hangman.
 *
 * @author Tyler Arseneault
 */
public class Letters {
    private List<Character> availableLetters, usedLetters;
    
    /**
     * Constructor for the Letters class
     */
    Letters(){
        Character[] letterList = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 
                                'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 
                                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
                                'y','z'};
        
        this.availableLetters = new ArrayList(Arrays.asList(letterList));
        this.usedLetters = new ArrayList();
    }
    
    /**
     * useLetter
     * 
     * Uses the letter selected by the player. This will take the letter
     * out of the list of available letters, and place it in the list
     * of letters used by the player.
     * 
     * @param letter letter to be used by the player
     */
    public void useLetter(Character letter){
        
        // take the letter out of the available letters, and put it into used
        this.availableLetters.remove(letter);
        this.usedLetters.add(letter);
    }
    
    /**
     * getAvailableLetters
     * 
     * @return Returns the List of Characters availableLetters
     */
    public List<Character> getAvailableLetters(){
        return this.availableLetters;
    }
    
    /**
     * getUsedLetters
     * 
     * @return Returns the List of Characters usedLetters
     */
    public List<Character> getUsedLetters(){
        return this.usedLetters;
    }
}
