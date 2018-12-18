package edu.northeastern.ccs.cs5500.homework3.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework3.rank.Rank;
import edu.northeastern.ccs.cs5500.homework3.rank.RankClass;
import edu.northeastern.ccs.cs5500.homework3.rank.RankEnum;
import edu.northeastern.ccs.cs5500.homework3.suit.Suit;
import edu.northeastern.ccs.cs5500.homework3.suit.SuitClass;
import edu.northeastern.ccs.cs5500.homework3.suit.SuitEnum;

/**
 * Tests that verify whether the Card object works as expected.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class CardTest {

	/**
	 * Tests whether the card class creates a card as expected.
	 */
	@Test
	public void testCard() {

		RankEnum rankEnum = RankEnum.ACE;
		Rank rank = new RankClass(rankEnum);
		SuitEnum suitEnum = SuitEnum.SPADE;
		Suit suit = new SuitClass(suitEnum);
		Card newCard = new CardClass(rank, suit);
		assertEquals("Incorrect rank name.", "A", newCard.getRank().getName());
		assertEquals("Incorrect rank pip.", 0, newCard.getRank().getPips());
		assertEquals("Incorrect suit name.", "spade", newCard.getSuit().getName());
		assertEquals("Incorrect suit symbol.", '\u2660', newCard.getSuit().getSymbol());
	}

	/**
	 * Tests whether the card class creates a card as expected again.
	 */
	@Test
	public void testCardAgain() {

		RankEnum rankEnum = RankEnum.KING;
		Rank rank = new RankClass(rankEnum);
		SuitEnum suitEnum = SuitEnum.CLUB;
		Suit suit = new SuitClass(suitEnum);
		Card newCard = new CardClass(rank, suit);
		assertEquals("Incorrect rank name.", "K", newCard.getRank().getName());
		assertEquals("Incorrect rank pip.", 0, newCard.getRank().getPips());
		assertEquals("Incorrect suit name.", "club", newCard.getSuit().getName());
		assertEquals("Incorrect suit symbol.", '\u2663', newCard.getSuit().getSymbol());
	}

	/**
	 * Tests whether the card class creates a card as expected again.
	 */
	@Test
	public void testCardOnceAgain() {

		RankEnum rankEnum = RankEnum.THREE;
		Rank rank = new RankClass(rankEnum);
		SuitEnum suitEnum = SuitEnum.DIAMOND;
		Suit suit = new SuitClass(suitEnum);
		Card newCard = new CardClass(rank, suit);
		assertEquals("Incorrect rank name.", "3", newCard.getRank().getName());
		assertEquals("Incorrect rank pip.", 3, newCard.getRank().getPips());
		assertEquals("Incorrect suit name.", "diamond", newCard.getSuit().getName());
		assertEquals("Incorrect suit symbol.", '\u2666', newCard.getSuit().getSymbol());
	}

	/**
	 * Tests whether the card class creates a card as expected with string as input.
	 */
	@Test
	public void testCardWithString() {

		Card newCard = new CardClass("6", "spade");
		assertEquals("Incorrect rank name.", "6", newCard.getRank().getName());
		assertEquals("Incorrect rank pip.", 6, newCard.getRank().getPips());
		assertEquals("Incorrect suit name.", "spade", newCard.getSuit().getName());
		assertEquals("Incorrect suit symbol.", '\u2660', newCard.getSuit().getSymbol());
	}

	/**
	 * Tests whether the card class creates a card as expected with string as input
	 * (again).
	 */
	@Test
	public void testCardWithStringAgain() {

		Card newCard = new CardClass("5", "heart");
		assertEquals("Incorrect rank name.", "5", newCard.getRank().getName());
		assertEquals("Incorrect rank pip.", 5, newCard.getRank().getPips());
		assertEquals("Incorrect suit name.", "heart", newCard.getSuit().getName());
		assertEquals("Incorrect suit symbol.", '\u2665', newCard.getSuit().getSymbol());
	}

	/**
	 * Tests whether the card class creates a card as expected with string as input
	 * (once again).
	 */
	@Test
	public void testCardWithStringOnceAgain() {

		Card newCard = new CardClass("Q", "diamond");
		assertEquals("Incorrect rank name.", "Q", newCard.getRank().getName());
		assertEquals("Incorrect rank pip.", 0, newCard.getRank().getPips());
		assertEquals("Incorrect suit name.", "diamond", newCard.getSuit().getName());
		assertEquals("Incorrect suit symbol.", '\u2666', newCard.getSuit().getSymbol());
	}
	
	/**
	 * Tests the equals method in CardClass.
	 */
	@Test
	public void testCardEquals() {
		
		CardClass one = new CardClass("2", "club");
		CardClass two = new CardClass("3", "diamond");
		
		boolean isSame = one.equals(two);
		
		assertEquals("equals method not working as expected", false, isSame);
	}
	
	/**
	 * Tests the equals method in CardClass again.
	 */
	@Test
	public void testCardEqualsAgain() {
		
		CardClass one = new CardClass("2", "club");
		CardClass two = new CardClass("2", "club");
		
		boolean isSame = one.equals(two);
		
		assertEquals("equals method not working as expected", true, isSame);
	}

	/**
	 * Tests whether the hashCode method in CardClass works as expected.
	 */
	@Test
	public void testCardHashCode() {
		
		CardClass one = new CardClass("2", "club");
		CardClass two = new CardClass("3", "diamond");
		
		assertNotEquals("hashCode method not working as expected", one.hashCode(), two.hashCode());
	}
	
	/**
	 * Tests whether the hashCode method in CardClass works as expected again.
	 */
	@Test
	public void testCardHashCodeAgain() {
		
		CardClass one = new CardClass("2", "club");
		CardClass two = new CardClass("2", "club");
		
		assertEquals("hashCode method not working as expected", one.hashCode(), two.hashCode());
	}
	
	/**
	 * Tests the card constructor with an invalid rank string as input.
	 */
	@Test
	public void testCardWithInvalidRankString() {
		
		String expected = "15 is not a valid Rank";
		
		try {
			new CardClass("15", "spade");
			fail("card constructor did not throw an exception when it should");
		}
		catch(IllegalArgumentException ex) {
			assertEquals("card constructor not working as expected", expected, ex.getMessage());
		}
	}
	
	/**
	 * Tests the card constructor with an invalid suit string as input.
	 */
	@Test
	public void testCardWithInvalidSuitString() {
		
		String expected = "Joker is not a valid Suit";
		
		try {
			new CardClass("7", "Joker");
			fail("card constructor did not throw an exception when it should");
		}
		catch(IllegalArgumentException ex) {
			assertEquals("card constructor not working as expected", expected, ex.getMessage());
		}
	}

}
