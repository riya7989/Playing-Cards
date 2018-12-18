package edu.northeastern.ccs.cs5500.homework4.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


/**
 * Tests that verify that the CardAdapterClass works as expected.
 */
public class CardAdapterTest {

	/** Tests whether the adapted card is constructed as expected. */
	@Test
	public void testConstructor() {
		
		Card adaptedCard = new CardAdapterClass(1, 3);
		
		assertEquals("Incorrect rank of the adapted card." , "3", adaptedCard.getRank().getName());
		assertEquals("Incorrect suit of the adapted card." , "heart", adaptedCard.getSuit().getName());
		
	}
	
	/** Tests whether the adapted card is constructed as expected again. */
	@Test
	public void testCardAdapterConstructorAgain() {
		
		Card adaptedCard = new CardAdapterClass(9, 0);
		
		assertEquals("Incorrect rank of the adapted card." , "J", adaptedCard.getRank().getName());
		assertEquals("Incorrect suit of the adapted card." , "spade", adaptedCard.getSuit().getName());
		
	}
	
	/** Tests whether the adapted card throws exception for invalid rank. */
	@Test
	public void testCardAdapterConstructorWithInvalidRank() {
		
		String expected = "ill-formed card";
		
		try {
			new CardAdapterClass(13, 0);
			fail("CardAdapter constructor did not throw exception for invalid rank");
		}
		catch(IllegalArgumentException ex) {
			assertEquals("CardAdapter constructor formed card with invalid rank value.", expected, ex.getMessage());
		}
	}
	
	/** Tests whether the adapted card throws exception for invalid rank again. */
	@Test
	public void testCardAdapterConstructorWithInvalidRankAgain() {
		
		String expected = "ill-formed card";
		
		try {
			new CardAdapterClass(-1, 0);
			fail("CardAdapter constructor did not throw exception for invalid rank");
		}
		catch(IllegalArgumentException ex) {
			assertEquals("CardAdapter constructor formed card with invalid rank value.", expected, ex.getMessage());
		}
	}
	
	/** Tests whether the adapted card throws exception for invalid suit. */
	@Test
	public void testCardAdapterConstructorWithInvalidSuit() {
		
		String expected = "ill-formed ka";
		
		try {
			new CardAdapterClass(1, -1);
			fail("CardAdapter constructor did not throw exception for invalid suit");
		}
		catch(IllegalArgumentException ex) {
			assertEquals("CardAdapter constructor formed card with invalid suit value.", expected, ex.getMessage());
		}
	}
	
	/** Tests whether the adapted card throws exception for invalid suit again. */
	@Test
	public void testCardAdapterConstructorWithInvalidSuitAgain() {
		
		String expected = "ill-formed ka";
		
		try {
			new CardAdapterClass(1, 4);
			fail("CardAdapter constructor did not throw exception for invalid suit");
		}
		catch(IllegalArgumentException ex) {
			assertEquals("CardAdapter constructor formed card with invalid suit value.", expected, ex.getMessage());
		}
	}
	
	/** Tests whether the compareTo method works as expected. */
	@Test
	public void testCardAdapterCompareTo() {
		
		Card newCard = new CardClass ("7", "heart");
		Card adaptedCard = new CardAdapterClass(5, 3);
		int comparison = newCard.compareTo(adaptedCard);
		
		assertTrue("compareTo method not working as expected.", comparison == 0);
	}
	
	/** Tests whether the compareTo method works as expected again. */
	@Test
	public void testCardAdapterCompareToAgain() {
		
		Card newCard = new CardClass ("7", "heart");
		Card adaptedCard = new CardAdapterClass(2, 2);
		int comparison = newCard.compareTo(adaptedCard);
		
		assertTrue("compareTo method not working as expected.", comparison > 0);
	}
	
	/** Tests whether the compareTo method works with cards having same ranks. */
	@Test
	public void testCardAdapterCompareToWithSameRank() {
		
		Card newCard = new CardClass ("7", "diamond");
		Card adaptedCard = new CardAdapterClass(5, 2);
		int comparison = newCard.compareTo(adaptedCard);
		
		assertTrue("compareTo method not working as expected.", comparison < 0);
	}
	
	/**
	 * Tests the equals method in CardAdapterClass.
	 */
	@Test
	public void testCardAdapterEquals() {
		
		Card one = new CardAdapterClass(5, 2);
		Card two = new CardAdapterClass(4, 2);
		
		boolean isSame = one.equals(two);
		
		assertEquals("equals method not working as expected", false, isSame);
	}
	
	/**
	 * Tests the equals method in CardAdapterClass again.
	 */
	@Test
	public void testCardAdapterEqualsAgain() {
		
		Card one = new CardAdapterClass(1, 3);
		Card two = new CardAdapterClass(1, 3);
		
		boolean isSame = one.equals(two);
		
		assertEquals("equals method not working as expected", true, isSame);
	}

	/**
	 * Tests whether the hashCode method in CardClass works as expected.
	 */
	@Test
	public void testCardAdapterHashCode() {
		
		Card one = new CardAdapterClass(0, 2);
		Card two = new CardAdapterClass(1, 3);
		
		assertNotEquals("hashCode method not working as expected", one.hashCode(), two.hashCode());
	}
	
	/**
	 * Tests whether the hashCode method in CardClass works as expected again.
	 */
	@Test
	public void testCardAdapterHashCodeAgain() {
		
		Card one = new CardAdapterClass(0, 2);
		Card two = new CardAdapterClass(0, 2);
		
		assertEquals("hashCode method not working as expected", one.hashCode(), two.hashCode());
	}

}
