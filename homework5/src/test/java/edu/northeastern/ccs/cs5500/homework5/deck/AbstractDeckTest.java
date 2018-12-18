package edu.northeastern.ccs.cs5500.homework5.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;


/**
 * Tests that verify whether the Abstract Deck works as expected.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class AbstractDeckTest {

	/**
	 * Tests whether the equals method in AbstractDeckClass works as expected (using Standard Deck).
	 */
	@Test
	public void testDeckEquals() {
		
		StandardDeckClass oneDeck = new StandardDeckClass();
		StandardDeckClass testDeck = new StandardDeckClass();
		
		boolean isSame = oneDeck.equals(testDeck);
		
		assertEquals("equals method not working as expected", true, isSame);
		
	}
	
	/**
	 * Tests whether the equals method in AbstractDeckClass works as expected (using Standard Deck and Vegas Deck).
	 */
	@Test
	public void testDeckEqualsAgain() {
		
		StandardDeckClass oneDeck = new StandardDeckClass();
		VegasDeckClass testDeck = new VegasDeckClass();
		
		boolean isSame = oneDeck.equals(testDeck);
		
		assertEquals("equals method not working as expected", false, isSame);
	}
	
	/**
	 * Tests whether the hashcode method in AbstractDeckClass works as expected (using Standard Deck).
	 */
	@Test
	public void testDeckHashCode() {
		
		StandardDeckClass oneDeck = new StandardDeckClass();
		StandardDeckClass testDeck = new StandardDeckClass();
		
		assertEquals("hashcode method not working as expected", oneDeck.hashCode(), testDeck.hashCode());
	}
	
	/**
	 * Tests whether the hashcode method in AbstractDeckClass works as expected (using Standard Deck and Vegas Deck).
	 */
	@Test
	public void testDeckHashCodeAgain() {
		
		StandardDeckClass oneDeck = new StandardDeckClass();
		VegasDeckClass testDeck = new VegasDeckClass();
			
		assertNotEquals("hashCode method not working as expected", oneDeck.hashCode(), testDeck.hashCode());
	}

}
