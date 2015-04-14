/**
 * 
 */
package com.number.guess.test;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.number.guess.GuessNumberGenerator;

/**
 * @author Gopal
 * Test class for GuessNumberGenerator
 */
public class GuessNumberGeneratorTest {
	private GuessNumberGenerator guessNumberGen;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		guessNumberGen = new GuessNumberGenerator();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		guessNumberGen = null;
	}

	/**
	 * Test method for {@link com.number.guess.GuessNumberGenerator#setLstHighGuessNum(int)}.
	 */
	@Test
	public void testSetnGetLstHighGuessNum() {
		guessNumberGen.setLstHighGuessNum(53);
		assertEquals(guessNumberGen.getLstHighGuessNum(), 53);
	}

	/**
	 * Test method for {@link com.number.guess.GuessNumberGenerator#setLstLowerGuessNum(int)}.
	 */
	@Test
	public void testSetnGetLstLowerGuessNum() {
		guessNumberGen.setLstLowerGuessNum(100);
		assertEquals(guessNumberGen.getLstLowerGuessNum(), 100);
	}

	/**
	 * Test method for {@link com.number.guess.GuessNumberGenerator#getGuessNumHist()}.
	 */
	@Test
	public void testGetnSetGuessNumHist() {
		List<Integer> numList = new ArrayList<Integer>();
		guessNumberGen.setGuessNumHist(numList);
		assertEquals(guessNumberGen.getGuessNumHist(), numList);
		assertNotNull(guessNumberGen.getGuessNumHist());
		assertEquals(guessNumberGen.getGuessNumHist().size(), 0);
		numList.add(26);
		numList.add(10);
		guessNumberGen.setGuessNumHist(numList);
		assertEquals(guessNumberGen.getGuessNumHist(), numList);
		assertEquals(guessNumberGen.getGuessNumHist().size(), 2);
	}

	

	/**
	 * Test method for {@link com.number.guess.GuessNumberGenerator#addGuessNumToHist(int)}.
	 */
	@Test
	public void testAddGuessNumToHist() {
		List<Integer> numList = new ArrayList<Integer>();
		guessNumberGen.setGuessNumHist(numList);
		assertEquals(guessNumberGen.getGuessNumHist(), numList);
		assertNotNull(guessNumberGen.getGuessNumHist());
		assertEquals(guessNumberGen.getGuessNumHist().size(), 0);
		guessNumberGen.addGuessNumToHist(20);
		guessNumberGen.addGuessNumToHist(40);
		guessNumberGen.addGuessNumToHist(23);
		assertEquals(guessNumberGen.getGuessNumHist(), numList);
		assertEquals(guessNumberGen.getGuessNumHist().size(), 3);
	}

	
	/**
	 * Test method for {@link com.number.guess.GuessNumberGenerator#setChanged(boolean)}.
	 */
	@Test
	public void testSetnGetChanged() {
		guessNumberGen.setChanged(true);
		assertTrue(guessNumberGen.isChanged());
		guessNumberGen.setChanged(false);
		assertFalse(guessNumberGen.isChanged());
	}

	/**
	 * Test method for {@link com.number.guess.GuessNumberGenerator#getNextGuessNum(java.lang.String, int)}.
	 */
	@Test
	public void testGetNextGuessNum() {
		String input = "HIGHER";
		int guessNum = guessNumberGen.getNextGuessNum(input, 30);
		assertNotNull(guessNum);
		
		input = "LOWER";
		guessNum = guessNumberGen.getNextGuessNum(input, 56);
		assertNotNull(guessNum);
		
		input = "HIGHER";
		guessNumberGen.setChanged(true);
		guessNumberGen.setLstLowerGuessNum(64);
		guessNum = guessNumberGen.getNextGuessNum(input, 50 );
		assertNotNull(guessNum);
		
		input = "LOWER";
		guessNumberGen.setChanged(true);
		guessNumberGen.setLstHighGuessNum(153);
		guessNum = guessNumberGen.getNextGuessNum(input, 200 );
		assertNotNull(guessNum);
		
	}

	/**
	 * Test method for {@link com.number.guess.GuessNumberGenerator#getRandomNumber()}.
	 */
	@Test
	public void testGetRandomNumber() {
		int randNum = guessNumberGen.getRandomNumber();
		assertNotNull(randNum);
	}

}
