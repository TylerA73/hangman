/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Tyler Arseneault
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Object that manages the game
        GameManager gm = new GameManager();
        
        // Handles the user input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // While playis true, continue playing the game
        while(gm.getPlay()){
            
            // Display the game information and instructions to the user
            gm.displayGame();
            System.out.print("Select a letter: ");

            // Try to get the user input
            // If it fails, print a stack trace
            try{
                // Get the next input and store it into the input variable
                String input = br.readLine();
                
                // If the input is too long or too short, it is not valid
                // Otherwise, continue
                if(input.length() != 1){
                    System.out.println("Please make a valid input only from the"
                                     + " available letters");
                }else{
                    // Convert the input into a single character
                    char guess = input.charAt(0);
                    
                    // If the guess is still available, it is valid
                    boolean valid = gm.checkValid(guess);
                    
                    // If the guess was valid, use it
                    if(valid){
                        gm.makeGuess(guess);
                    }else{
                        System.out.println("Not valid");
                    }
                }
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
            
            // Print an empty line for clean display purposes
            System.out.println();
            
            // Check to see if the game is complete.
            // If it is, finish.
            // If not, continue playing.
            gm.gameComplete();

        }
    }
    
}
