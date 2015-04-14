/**
 * 
 */
package com.number.guess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Gopal
 * This class deals with prompting the user to guess the number and getting
 * the input from user
 */
public class NumberGuesser implements INumberGuesser{
	/** * Buffered reader to scan the input from console  */
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/** * Variable to store ready flag  */
	private boolean isReady = false;
	
	/** * Reference to   GuessNumberGenerator class */
	private GuessNumberGenerator guessNumberGenerator;
	
	/** * Getter for  GuessNumberGenerator */
	public GuessNumberGenerator getGuessNumberGenerator() {
		return guessNumberGenerator;
	}

	/** * Setter for  GuessNumberGenerator */
	public void setGuessNumberGenerator(GuessNumberGenerator guessNumberGenerator) {
		this.guessNumberGenerator = guessNumberGenerator;
	}
	
	/** * Method to validate the input string and returns boolean value */
	public boolean validateInput(String input){
		if(input != null){
			if(!input.equalsIgnoreCase(HIGHER)
					&& !input.equalsIgnoreCase(LOWER)
					&& !input.equalsIgnoreCase(YES)
					&& !input.equalsIgnoreCase(READY)
					&& !input.equalsIgnoreCase(QUIT)){
				System.out.println("Invalid input !!!");
				System.out.println("Please input only :" + HIGHER + " | " + LOWER + " | " + YES +" | " + READY +" | " + QUIT + "\n");
				return false;
			}
			return true;
		}
		return false;
		
	}
	
	/** * Method to read the input from user and call  GuessNumberGenerator to get
	 * next guess number to be prompted
	 */
	public void startGuessing(){
		System.out.println("Welcome " + "\n" 
							+"Please choose the number in Mind " + "Between 0-"+LIMIT + "\n" 
							+ "Are you Ready ? " + "\n");
		String input;
		int guessNum = 0;
		guessNumberGenerator = new GuessNumberGenerator();
		try {
			do{
				input = reader.readLine();
				boolean valid = validateInput(input);
				if(valid){
					if(!isReady && input.equalsIgnoreCase(READY)){
						isReady = true;
						guessNum = guessNumberGenerator.getRandomNumber();
						guessNumberGenerator.addGuessNumToHist(guessNum);
						prmptGuess(guessNum);
					}else if(isReady){
						if(input.equalsIgnoreCase(YES)){
							System.exit(1);
						}
						int nextGuessNum = guessNumberGenerator.getNextGuessNum(input, guessNum);
						guessNum = nextGuessNum;
						prmptGuess(nextGuessNum);
					}else{
						System.out.println("Invalid input at this moment");
					}
				}
			}while(!input.equalsIgnoreCase(QUIT));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/** * Method to prompt the user	 */
	private void prmptGuess(int number){
		System.out.println("Is the number in your Mind is : " + number + " ? " + "\n");
	}
	
	/** * Method to print the guess number history list	 */
	public void printNumberGuessHisrtory(){
		System.out.println(guessNumberGenerator.getGuessNumHist());
	}

}
