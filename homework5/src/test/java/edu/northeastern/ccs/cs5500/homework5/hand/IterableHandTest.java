package edu.northeastern.ccs.cs5500.homework5.hand;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework5.card.Card;
import edu.northeastern.ccs.cs5500.homework5.card.CardClass;
import edu.northeastern.ccs.cs5500.homework5.rank.Rank;
import edu.northeastern.ccs.cs5500.homework5.rank.RankClass;
import edu.northeastern.ccs.cs5500.homework5.rank.RankEnum;

/**
 * Tests that verify whether the Iterable Hand object works as expected.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class IterableHandTest {

	/**
	 * Test whether the hasCard method in Iterable Hand class works as expected.
	 */
	@Test
	public void testHasCardInHand() {

		IterableHandClass newHand1 = new IterableHandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		
		IterableHandClass newHand2 = new IterableHandClass();
		Card four = new CardClass("K", "club");
		Card five = new CardClass("9", "spade");
		Card six = new CardClass("A", "club");
		
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);

		CardClass newCard = new CardClass("2", "spade");
		boolean found1 = newHand1.hasCard(newCard);
		boolean found2 = newHand2.hasCard(newCard);

		assertEquals("hasCard method not working as expected", true, found1);
		assertEquals("hasCard method not working as expected", false, found2);
	}
	
	/**
	 * Test whether the hasCard method in Iterable Hand class works as expected again.
	 */
	@Test
	public void testHasCardInHandAgain() {

		IterableHandClass newHand1 = new IterableHandClass();
		Card one = new CardClass("3", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		
		IterableHandClass newHand2 = new IterableHandClass();
		Card four = new CardClass("K", "club");
		Card five = new CardClass("9", "spade");
		Card six = new CardClass("A", "club");
		
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);

		CardClass newCard = new CardClass("2", "spade");
		boolean found1 = newHand1.hasCard(newCard);
		boolean found2 = newHand2.hasCard(newCard);

		assertEquals("hasCard method not working as expected", false, found1);
		assertEquals("hasCard method not working as expected", false, found2);
	}
	
	/**
	 * Tests whether the card occurrence is calculated as expected.
	 */
	@Test
	public void testCardOccurrencesInHand() {
		
		IterableHandClass newHand = new IterableHandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "heart");
		Card three = new CardClass("J", "heart");
		Card four = new CardClass("K", "club");
		Card five = new CardClass("7", "heart");
		Card six = new CardClass("A", "club");
		Card seven = new CardClass("7", "heart");
		
		newHand.accept(one);
		newHand.accept(two);
		newHand.accept(three);
		newHand.accept(four);
		newHand.accept(five);
		newHand.accept(six);
		newHand.accept(seven);
		
		int cardCount = newHand.occurrencesInHand(new CardClass("7", "heart"));
		
		assertEquals("Incorrect card occurrence", 3, cardCount);
	}
	
	/**
	 * Tests whether the card occurrence is calculated as expected again.
	 */
	@Test
	public void testCardOccurrencesInHandAgain() {
		
		IterableHandClass newHand = new IterableHandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "heart");
		Card three = new CardClass("J", "heart");
		Card four = new CardClass("K", "club");
		Card five = new CardClass("7", "heart");
		Card six = new CardClass("A", "club");
		Card seven = new CardClass("7", "heart");
		
		newHand.accept(one);
		newHand.accept(two);
		newHand.accept(three);
		newHand.accept(four);
		newHand.accept(five);
		newHand.accept(six);
		newHand.accept(seven);
		
		CardClass test = new CardClass("8", "club");
		
		int cardCount = newHand.occurrencesInHand(test);
		
		assertEquals("Incorrect card occurrence", 0, cardCount);
	}
	
	/**
	 * Tests whether the rank occurrence is calculated as expected.
	 */
	@Test
	public void testRankOccurrencesInHand() {
		
		IterableHandClass newHand = new IterableHandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "heart");
		Card three = new CardClass("J", "heart");
		Card four = new CardClass("2", "club");
		Card five = new CardClass("2", "heart");
		Card six = new CardClass("A", "club");
		Card seven = new CardClass("2", "heart");
		
		newHand.accept(one);
		newHand.accept(two);
		newHand.accept(three);
		newHand.accept(four);
		newHand.accept(five);
		newHand.accept(six);
		newHand.accept(seven);
		
		int rankCount = newHand.occurrencesInHand(new RankClass(RankEnum.TWO));
		
		assertEquals("Incorrect rank occurrence", 4, rankCount);
	}
	
	/**
	 * Tests whether the rank occurrence is calculated as expected again.
	 */
	@Test
	public void testRankOccurrencesInHandAgain() {
		
		IterableHandClass newHand = new IterableHandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "heart");
		Card three = new CardClass("J", "heart");
		Card four = new CardClass("K", "club");
		Card five = new CardClass("7", "heart");
		Card six = new CardClass("A", "club");
		Card seven = new CardClass("7", "heart");
		
		newHand.accept(one);
		newHand.accept(two);
		newHand.accept(three);
		newHand.accept(four);
		newHand.accept(five);
		newHand.accept(six);
		newHand.accept(seven);
		
		RankEnum rankEnum = RankEnum.EIGHT;
		Rank rank = new RankClass(rankEnum);
		
		int rankCount = newHand.occurrencesInHand(rank);
		
		assertEquals("Incorrect rank occurrence", 0, rankCount);
	}
	
	/**
	 * Tests whether the rank and card occurrence is calculated as expected.
	 */
	@Test
	public void testBothOccurrencesInHand() {
		
		IterableHandClass newHand = new IterableHandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "heart");
		Card three = new CardClass("J", "heart");
		Card four = new CardClass("7", "club");
		Card five = new CardClass("2", "heart");
		Card six = new CardClass("A", "club");
		Card seven = new CardClass("7", "heart");
		
		newHand.accept(one);
		newHand.accept(two);
		newHand.accept(three);
		newHand.accept(four);
		newHand.accept(five);
		newHand.accept(six);
		newHand.accept(seven);
		
		int rankCount = newHand.occurrencesInHand(new RankClass(RankEnum.SEVEN));
		int cardCount = newHand.occurrencesInHand(new CardClass("7", "heart"));
		
		assertEquals("Incorrect rank occurrence", 3, rankCount);
		assertEquals("Incorrect card occurrence", 2, cardCount);
	}

}
