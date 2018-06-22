/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;



import java.util.List;

/**
 * GameManager handles of of the aspects of the game of Hangman
 * 
 * @author Tyler Arseneault
 */
public class GameManager {
    // Maximum number of incorrect guesses
    private final int GUESSES;
    
    // Object to handle the possible words in the game
    private Words words = new Words();
    
    // Object to handle all of the letters in the game
    private Letters letters = new Letters();
    
    // An array of characters that make up the goal word
    private final char[] word;
    
    // An array of characters to represent the successful guesses made
    private final char[] correct;
    
    // Total number of guesses made
    private int totalGuesses;
    
    // Number of correct guesses made
    private int correctGuesses;
    
    // Number of incorrect guesses made
    private int incorrectGuesses;
    
    // True if the game is still going, false if not
    private boolean play;
    
    /**
     * Constructor for the GameManager class
     */
    GameManager(){
        this.GUESSES = 7;
        
        this.words = new Words();
        this.letters = new Letters();
        this.word = words.getRandomWord().toCharArray();
        this.correct = new char[word.length];
        
        // Initialize the "correct" character array to all blanks
        for(int i = 0; i < this.correct.length; i++)
            this.correct[i] = '_';
        
        // All guessesstart at 0
        this.totalGuesses = 0;
        this.correctGuesses = 0;
        this.incorrectGuesses = 0;
        
        // When the game starts, we are playing it
        this.play = true;
    }
    
    /**
     * makeGuess
     * 
     * Make Guess handles the guess made by the player to determine if it 
     * was correct or not.
     * 
     * @param letter
     * @return True if the guess is correct, and false if it is not
     */
    public boolean makeGuess(Character letter){
        
        // Use the letter
        this.letters.useLetter(letter);
        
        // The guess is either correct (true), or incorrect (false)
        boolean isCorrect = correctGuess(letter);
        
        // If the guess was not correct, increment the incorrect guesses
        if(!isCorrect){
            this.incorrectGuesses++;
        }
        
        // When a valid guess is made, increment the total guesses
        this.totalGuesses++;
        
        return isCorrect;
    }
    
    /**
     * correctGuess
     * 
     * Determines if the guess a player makes is correct or not.
     * 
     * @param letter
     * @return True if the guess is correct, false if it is not
     */
    private boolean correctGuess(Character letter){
        // At first, assume the guess was incorrect
        boolean isCorrect = false;
        
        // If we find that letter in the word, the guess becomes correct
        // and we increment the correct guesses by the number of occurrences
        // of that letter
        for(int i = 0; i < this.word.length; i++){
            if(word[i] == letter){
                this.correct[i] = letter;
                this.correctGuesses++;
                isCorrect = true;
            }
        }
        
        return isCorrect;
    }
    
    /**
     * displayAvilableLetters
     * 
     * Intended as a helper function for the displayGame function.
     * This will display the letters that are still available.
     */
    private void displayAvailableLetters(){
        List availLetters = this.letters.getAvailableLetters();
        
        // loop through all of the available letters and print them
        System.out.print("Available letters: ");
        for(int i = 0; i < availLetters.size(); i++){
            System.out.print(availLetters.get(i) + " ");
        }
    }
    
    /**
     * displayUsedLetters
     * 
     * Intended as a helper function for the displayGame function.
     * This will display the letters that are no longer available.
     */
    private void displayUsedLetters(){
        List usedLetters = this.letters.getUsedLetters();
        
        // loop through the used letters and display them
        System.out.print("Used letters: ");
        for(int i = 0; i < usedLetters.size(); i++){
            System.out.print(usedLetters.get(i) + " ");
        }
    }
    
    /**
     * displayGuesses
     * 
     * Intended as a helper function for the displayGame function.
     * This will display the number of guesses the player has made, and the
     * number of incorrect guesses they have left.
     */
    private void displayGuesses(){
        int guessesLeft = this.GUESSES - this.incorrectGuesses;
        
        System.out.println("Guesses made: " + this.totalGuesses);
        System.out.println("Incorrect guesses left: " + guessesLeft);
        
    }
    
    /**
     * displayWord
     * 
     * Intended as a helper function for the displayGame function.
     * This will display the letters that have been guessed correctly.
     */
    private void displayWord(){
        
        // loop through the correct char array and display the characters
        for(int i = 0; i < this.correct.length; i++){
            System.out.print(correct[i] + " ");
        }
        
        System.out.println();
    }
    
    /**
     * displayGame
     * 
     * Displays all of the game information to the user for feedback.
     */
    public void displayGame(){
        displayWord();
        displayGuesses();
        displayAvailableLetters();
        System.out.println();
        displayUsedLetters();
        System.out.println();
    }
    
    /**
     * checkValid
     * 
     * Checks to see if the guess the player made is valid or not.
     * If the guess was made previously, it is not valid.
     * 
     * @param letter the character that the player is guessing
     * @return True if the guess was valid, false otherwise.
     */
    public boolean checkValid(Character letter){
        List avail = this.letters.getAvailableLetters();
        
        // if the letter guessed is still available, it is a valid guess
        if(avail.contains(letter))
            return true;
        
        return false;
    }
    
    /**
     * gameComplete
     * 
     * Used to determine if the game is complete or not.
     * If the player has guessed all of the letters in the word, they win.
     * If the player runs out of incorrect guesses, they lose.
     */
    public void gameComplete(){
        
        // if the word was guessed, or they ran out of incorrect guesses,
        // the game ends
        if(this.correctGuesses == this.word.length){
            setPlay(false);
            System.out.println("You win!");
        }else if(this.incorrectGuesses == this.GUESSES){
            setPlay(false);
            System.out.println("You lost!");
        }
        
        //display the stats one more time
        if(!play)
            displayGame();
    }
    
    /**
     * getPlay
     * 
     * @return Returns the value of the boolean play.
     */
    public boolean getPlay(){
        return play;
    }
    
    /**
     * setPlay
     * 
     * @param play set play to the boolean value passed as a parameter.
     */
    public void setPlay(boolean play){
        this.play = play;
    }
}
