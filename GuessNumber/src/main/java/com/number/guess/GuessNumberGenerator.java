/**
 * 
 */
package com.number.guess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Gopal
 * This class deals with calculation of next number to be prompted for 
 * user for guessing 
 */
public class GuessNumberGenerator implements INumberGuesser {
	
	/** * Flag to store change from higher to lower state initially	 */
	private boolean isChanged = false;
	
	/** * Variable to store last input string  */
	private String lstInputStr;
	
	/** * Variable to store last higher guessed number  */
	private int lstHighGuessNum;
	
	/** * Variable to store last lower guessed number  */
	private int lstLowerGuessNum;
	
	/** * Variable to store guessed numbers history  */
	private List<Integer> guessNumHist = new ArrayList<Integer>();

	/**
	 * Get Last High Guess Number
	 */
	public int getLstHighGuessNum() {
		return lstHighGuessNum;
	}
	
	/**
	 * Set Last High Guess Number
	 */
	public void setLstHighGuessNum(int lstHighGuessNum) {
		this.lstHighGuessNum = lstHighGuessNum;
	}
	
	/**
	 * Get Last Lower Guess Number
	 */
	public int getLstLowerGuessNum() {
		return lstLowerGuessNum;
	}
	
	/**
	 * Set Last Lower Guess Number
	 */
	public void setLstLowerGuessNum(int lstLowerGuessNum) {
		this.lstLowerGuessNum = lstLowerGuessNum;
	}
	
	/**
	 * Get Guess Number History List
	 */
	public List<Integer> getGuessNumHist() {
		return guessNumHist;
	}
	
	/**
	 * Set Guess Number History List
	 */
	public void setGuessNumHist(List<Integer> guessNumHist) {
		this.guessNumHist = guessNumHist;
	}
	
	/**
	 * Add To Guess Number History List
	 */
	public void addGuessNumToHist(int guessNum){
		guessNumHist.add(guessNum);
	}
	
	/**
	 * Check for isChanged flag
	 */
	public boolean isChanged() {
		return isChanged;
	}
	
	/**
	 * Set isChanged flag
	 */
	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}
	
	/**
	 * This method returns the next guess to be prompted 
	 * based on last higher/lower guess number and input 
	 * from user
	 */
	public int getNextGuessNum(String input,int guessedNum){
		int nextGuessNum = 0;
		
		if(input != null && input.equalsIgnoreCase(HIGHER)){
			lstHighGuessNum = guessedNum;
			
			if(isChanged){
				nextGuessNum = (lstHighGuessNum + lstLowerGuessNum)/2;
			}else{
				nextGuessNum = lstHighGuessNum * 2;
				if(lstInputStr == null || lstInputStr.equalsIgnoreCase(HIGHER))
					isChanged = false;
				else
					isChanged = true;
			}
			
		}else if(input != null && input.equalsIgnoreCase(LOWER)){
			lstLowerGuessNum = guessedNum;
			if(isChanged){
				nextGuessNum = (lstHighGuessNum + lstLowerGuessNum)/2;
			}else{
				nextGuessNum = lstLowerGuessNum / 2;
				if(lstInputStr == null || lstInputStr.equalsIgnoreCase(LOWER))
					isChanged = false;
				else
					isChanged = true;
			}
		}
		lstInputStr = input;
		return nextGuessNum;
	}
	
	/**
	 * Method returns the random number between
	 * the limit defined
	 */
	public int getRandomNumber(){
		Random rand = new Random();
		return rand.nextInt(LIMIT);
	}
	
}
