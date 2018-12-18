package edu.northeastern.ccs.cs5500.homework5.blackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * Tests that verify whether the Player class works as expected.
 * @author Riya Nadkarni
 * @version	10-25-2018
 */
public class PlayerTest {

	/**
	 * Private class that initiates the required object before each test.
	 */
	private Player testPlayer;
	
	
	/**
	 * Setup for each test.
	 */
	@Before
	public void setup() {
		testPlayer = new Player();
	}
	
	/** Tests whether the constructor works as expected. */
	@Test
	public void testConstructor() {
		
		assertEquals("Incorrect bet value.", 1, testPlayer.getBet());
	}
	
	/** Tests whether the addBet method works as expected. */
	@Test
	public void testAddBet() {
		
		testPlayer.addBet(1);
		testPlayer.addBet(2);
		assertEquals("Incorrect bet value.", 4, testPlayer.getBet());
	}
	
	/** Tests whether the loseBet method works as expected. */
	@Test
	public void testLoseBet() {
		
		testPlayer.addBet(3);
		testPlayer.loseBet();
		assertEquals("Incorrect bet value.", 3, testPlayer.getBet());
	}

}
