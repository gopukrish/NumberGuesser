/**
 * 
 */
package com.number.guess.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.number.guess.NumberGuesser;

/**
 * @author Gopal
 *
 */
public class NumberGuesserTest {
	
	private NumberGuesser numberGuesser;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		numberGuesser = new NumberGuesser();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		numberGuesser = null;
	}

	@Test
	public void testvalidateInput() {
		boolean res = numberGuesser.validateInput("higher");
		assertTrue(res);
		res = numberGuesser.validateInput("lower");
		assertTrue(res);
		res = numberGuesser.validateInput("ready");
		assertTrue(res);
		res = numberGuesser.validateInput("yes");
		assertTrue(res);
		res = numberGuesser.validateInput("quit");
		assertTrue(res);
		
		res = numberGuesser.validateInput(null);
		assertFalse(res);
		res = numberGuesser.validateInput("");
		assertFalse(res);
		res = numberGuesser.validateInput("input");
		assertFalse(res);
		
	}

}
