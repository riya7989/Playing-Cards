package edu.northeastern.ccs.cs5500.homework5.suit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework5.InvalidSuit;

/**
 * Tests that verify whether the Suit of a card works as expected.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class SuitTest {

	/**
	 * Tests whether the suit class creates a suit as expected.
	 */
	@Test
	public void testSuit() {

		SuitEnum suitEnum = SuitEnum.HEART;
		Suit suit = new SuitClass(suitEnum);
		assertEquals("Incorrect suit name.", "heart", suit.getName());
		assertEquals("Incorrect suit symbol.", '\u2665', suit.getSymbol());
	}

	/**
	 * Tests whether the suit class creates a suit as expected again.
	 */
	@Test
	public void testSuitAgain() {

		SuitEnum suitEnum = SuitEnum.DIAMOND;
		Suit suit = new SuitClass(suitEnum);
		assertEquals("Incorrect suit name.", "diamond", suit.getName());
		assertEquals("Incorrect suit symbol.", '\u2666', suit.getSymbol());
	}
	
	/**
	 * Tests whether the compareTo method in Suit Class throws an exception as expected.
	 */
	@Test
	public void testSuitCompareToWithInvalidInput() {
		
		InvalidSuit testSuit = new InvalidSuit();
		SuitEnum suitEnum = SuitEnum.HEART;
		SuitClass newSuit = new SuitClass(suitEnum);
		String expected = "Cannot compare 2 different objects.";
		
		try {
			newSuit.compareTo(testSuit);
			fail("compareTo method did not throw an exception when it should");
		}
		catch(IllegalArgumentException ex) {
			assertEquals("compareTo method not working as expected", expected, ex.getMessage());
		}
	}

	/**
	 * Tests whether the getSuit method works as expected.
	 */
	@Test
	public void testGetSuit() {

		SuitEnum suitEnum = SuitClass.getSuit("Heart");
		assertEquals("Incorrect suit name.", "heart", suitEnum.getName());
		assertEquals("Incorrect suit symbol.", '\u2665', suitEnum.getSymbol());
	}

	/**
	 * Tests whether the getSuit method works as expected again.
	 */
	@Test
	public void testGetSuitAgain() {

		SuitEnum suitEnum = SuitClass.getSuit("CLub");
		assertEquals("Incorrect suit name.", "club", suitEnum.getName());
		assertEquals("Incorrect suit symbol.", '\u2663', suitEnum.getSymbol());
	}
	
	/** Tests whether the equals method in SuitClass works as expected. */
	@Test
	public void testSuitEquals() {
		
		SuitClass one = new SuitClass(SuitEnum.CLUB);
		SuitClass two = new SuitClass(SuitEnum.SPADE);
		
		boolean isSame = one.equals(two);
		
		assertEquals("equals method not working as expected", false, isSame);
	}
	
	/** Tests whether the equals method in SuitClass works as expected again. */
	@Test
	public void testSuitEqualsAgain() {
		
		SuitClass one = new SuitClass(SuitEnum.DIAMOND);
		SuitClass two = new SuitClass(SuitEnum.DIAMOND);
		
		boolean isSame = one.equals(two);
		
		assertEquals("equals method not working as expected", true, isSame);
	}
	
	/**
	 * Tests whether the hashCode method in SuitClass works as expected.
	 */
	@Test
	public void testSuitHashCode() {
		
		SuitClass one = new SuitClass(SuitEnum.DIAMOND);
		SuitClass two = new SuitClass(SuitEnum.HEART);
		
		assertNotEquals("hashCode method not working as expected", one.hashCode(), two.hashCode());
	}
	
	/**
	 * Tests whether the hashCode method in SuitClass works as expected.
	 */
	@Test
	public void testSuitHashCodeAgain() {
		
		SuitClass one = new SuitClass(SuitEnum.HEART);
		SuitClass two = new SuitClass(SuitEnum.HEART);
		
		assertEquals("hashCode method not working as expected", one.hashCode(), two.hashCode());
	}

}
