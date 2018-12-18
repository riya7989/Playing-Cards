package edu.northeastern.ccs.cs5500.homework3.hand;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework3.card.Card;
import edu.northeastern.ccs.cs5500.homework3.card.CardClass;
import edu.northeastern.ccs.cs5500.homework3.deck.DeckFactory;
import edu.northeastern.ccs.cs5500.homework3.deck.EuchreDeckFactory;
import edu.northeastern.ccs.cs5500.homework3.deck.StandardDeckClass;
import edu.northeastern.ccs.cs5500.homework3.game.GameClass;

/**
 * Tests that verify whether the Hand object works as expected.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class HandTest {

	/**
	 * Tests the setNumberOfHands method with an illegal input.
	 */
	@Test
	public void testSetNumberOfHandsWIthIllegalInput() {

		DeckFactory euchreFactory = new EuchreDeckFactory();
		GameClass newGame = new GameClass(euchreFactory, 1, 3, 8);
		String expected = "Number of hands more than can be accommodated in the cards from the deck.";

		try {
			newGame.setNumberOfHands(4);
			fail("setNumberOfHands method did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("setNumberOfHands method not working as expected.", expected, ex.getMessage());
		}
	}

	/**
	 * Tests the setNumberOfHands method with an illegal input again.
	 */
	@Test
	public void testSetNumberOfHandsWIthIllegalInputAgain() {

		DeckFactory euchreFactory = new EuchreDeckFactory();
		GameClass newGame = new GameClass(euchreFactory, 1, 3, 8);
		String expected = "Number of hands cannot be less than 1.";

		try {
			newGame.setNumberOfHands(0);
			fail("setNumberOfHands method did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("setNumberOfHands method not working as expected.", expected, ex.getMessage());
		}
	}

	/**
	 * Tests whether a hand gets created as expected.
	 */
	@Test
	public void testHand() {

		HandClass newHand = new HandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		Card four = new CardClass("J", "heart");
		Card five = new CardClass("9", "spade");
		Card six = new CardClass("A", "club");
		Card seven = new CardClass("K", "diamond");
		Card eight = new CardClass("5", "club");
		newHand.accept(one);
		newHand.accept(two);
		newHand.accept(three);
		newHand.accept(four);
		newHand.accept(five);
		newHand.accept(six);
		newHand.accept(seven);
		newHand.accept(eight);

		assertEquals("Incorrect card in hand", true, one.equals(newHand.pullCard()));
		assertEquals("Incorrect card in hand", true, two.equals(newHand.pullCard()));
		assertEquals("Incorrect card in hand", true, three.equals(newHand.pullCard()));
		assertEquals("Incorrect card in hand", true, four.equals(newHand.pullCard()));
		assertEquals("Incorrect card in hand", true, five.equals(newHand.pullCard()));
		assertEquals("Incorrect card in hand", true, six.equals(newHand.pullCard()));
		assertEquals("Incorrect card in hand", true, seven.equals(newHand.pullCard()));
		assertEquals("Incorrect card in hand", true, eight.equals(newHand.pullCard()));
	}

	/**
	 * Test whether showCards method in the Hand class works as expected.
	 */
	@Test
	public void testShowCardsInHand() {
		
		HandClass newHand = new HandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		Card four = new CardClass("K", "club");
		Card five = new CardClass("9", "spade");
		Card six = new CardClass("A", "club");
		
		newHand.accept(one);
		newHand.accept(two);
		newHand.accept(three);
		newHand.accept(four);
		newHand.accept(five);
		newHand.accept(six);
		
		List<Card> showHand = newHand.showCards();
		
		assertEquals("Incorrect hand created", "2", showHand.get(0).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", showHand.get(0).getSuit().getName());
		assertEquals("Incorrect hand created", "7", showHand.get(1).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "diamond", showHand.get(1).getSuit().getName());
		assertEquals("Incorrect hand created", "J", showHand.get(2).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "heart", showHand.get(2).getSuit().getName());
		assertEquals("Incorrect hand created", "K", showHand.get(3).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "club", showHand.get(3).getSuit().getName());
		assertEquals("Incorrect hand created", "9", showHand.get(4).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", showHand.get(4).getSuit().getName());
		assertEquals("Incorrect hand created", "A", showHand.get(5).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "club", showHand.get(5).getSuit().getName());
	}

	/**
	 * Test whether pullCard method in the Hand class works as expected.
	 */
	@Test
	public void testPullCardInHand() {
	
		HandClass newHand1 = new HandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		
		HandClass newHand2 = new HandClass();
		Card four = new CardClass("K", "club");
		Card five = new CardClass("9", "spade");
		Card six = new CardClass("A", "club");
		
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);
		
		Card handPulled1 = newHand1.pullCard();
		Card handPulled2 = newHand2.pullCard();

		assertEquals("Incorrect card pulled from hand 1", one.getRank().getName(),
				handPulled1.getRank().getName());
		assertEquals("Incorrect card pulled from hand 1", one.getSuit().getName(),
				handPulled1.getSuit().getName());
		assertEquals("Incorrect card pulled from hand 1", four.getRank().getName(),
				handPulled2.getRank().getName());
		assertEquals("Incorrect card pulled from hand 1", four.getSuit().getName(),
				handPulled2.getSuit().getName());
	}

	/**
	 * Test whether the hasCard method in Hand class works as expected.
	 */
	@Test
	public void testHasCardInHand() {

		HandClass newHand1 = new HandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		
		HandClass newHand2 = new HandClass();
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
	 * Test shuffle in hand. Testing it by comparing it to another hand with known
	 * order of cards and making sure that the number of cards in a different
	 * position are more than the number of Cards in the same position
	 */
	@Test
	public void testShuffleInHand() {

		HandClass newHand = new HandClass();
		newHand.accept(new CardClass("2", "spade"));
		newHand.accept(new CardClass("3", "spade"));
		newHand.accept(new CardClass("4", "spade"));
		newHand.accept(new CardClass("5", "spade"));
		newHand.accept(new CardClass("6", "spade"));
		newHand.accept(new CardClass("7", "spade"));

		newHand.shuffle();

		assertEquals("Shuffle method not working as expected", 6, newHand.showCards().size());

		HandClass testHand = new HandClass();
		testHand.accept(new CardClass("2", "spade"));
		testHand.accept(new CardClass("3", "spade"));
		testHand.accept(new CardClass("4", "spade"));
		testHand.accept(new CardClass("5", "spade"));
		testHand.accept(new CardClass("6", "spade"));
		testHand.accept(new CardClass("7", "spade"));

		int countSame = 0;
		int countDifferent = 0;

		for (int i = 0; i < 6; i++) {
			if (newHand.pullCard().equals(testHand.pullCard())) {
				countSame += 1;
			} else {
				countDifferent += 1;
			}
		}

		assertTrue("Shuffle method not working as expected", countSame < countDifferent);
	}

	/**
	 * Tests whether the accept card method in Hand class works as expected.
	 */
	@Test
	public void testAcceptListOfCards() {

		HandClass newHand = new HandClass();
		StandardDeckClass oneDeck = new StandardDeckClass();

		List<Card> testCards = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			testCards.add(oneDeck.getCards().get(i));
		}

		newHand.accept(testCards);

		List<Card> cards = newHand.showCards();

		assertEquals("Incorrect hand created", "2", cards.get(0).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", cards.get(0).getSuit().getName());
		assertEquals("Incorrect hand created", "3", cards.get(1).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", cards.get(0).getSuit().getName());
		assertEquals("Incorrect hand created", "4", cards.get(2).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", cards.get(0).getSuit().getName());
		assertEquals("Incorrect hand created", "5", cards.get(3).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", cards.get(3).getSuit().getName());
		assertEquals("Incorrect hand created", "6", cards.get(4).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", cards.get(4).getSuit().getName());
	}

	/**
	 * Tests whether the sort by rank method in Hand class works as expected.
	 */
	@Test
	public void testSortByRankInHand() {
	
		HandClass newHand = new HandClass();
		
		newHand.accept(new CardClass("3", "spade"));
		newHand.accept(new CardClass("4", "spade"));
		newHand.accept(new CardClass("5", "spade"));
		newHand.accept(new CardClass("6", "spade"));
		newHand.accept(new CardClass("7", "spade"));
		newHand.accept(new CardClass("8", "spade"));
		newHand.accept(new CardClass("9", "spade"));
		newHand.accept(new CardClass("10", "spade"));
		newHand.accept(new CardClass("J", "spade"));
		newHand.accept(new CardClass("Q", "spade"));
		newHand.accept(new CardClass("K", "spade"));
		newHand.accept(new CardClass("A", "spade"));
		newHand.accept(new CardClass("2", "spade"));
		newHand.accept(new CardClass("2", "diamond"));
		
		newHand.sort("BYrank");

		Card pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "2", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "2", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "diamond", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "3", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "4", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "5", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "6", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "7", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "8", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "9", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "10", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "J", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "Q", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "K", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "A", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
	}


	/**
	 * Tests whether the sort by suit method in Hand class works as expected.
	 */
	@Test
	public void testSortBySuitInHand() {

		HandClass newHand = new HandClass();
		
		newHand.accept(new CardClass("2", "spade"));
		newHand.accept(new CardClass("3", "spade"));
		newHand.accept(new CardClass("4", "spade"));
		newHand.accept(new CardClass("5", "spade"));
		newHand.accept(new CardClass("6", "spade"));
		newHand.accept(new CardClass("7", "spade"));
		newHand.accept(new CardClass("8", "spade"));
		newHand.accept(new CardClass("9", "spade"));
		newHand.accept(new CardClass("10", "spade"));
		newHand.accept(new CardClass("J", "spade"));
		newHand.accept(new CardClass("Q", "spade"));
		newHand.accept(new CardClass("K", "spade"));
		newHand.accept(new CardClass("A", "spade"));
		newHand.accept(new CardClass("2", "diamond"));
		
		StandardDeckClass oneDeck = new StandardDeckClass();
		newHand.sort("bYsuIT");

		for (int i = 0; i < 13; i++) {
			Card handPulled = newHand.pullCard();
			Card deckPulled = oneDeck.pullCard();
			assertEquals("Incorrect sorted card order in hand", deckPulled.getRank().getName(),
					handPulled.getRank().getName());
			assertEquals("Incorrect sorted card order in hand", deckPulled.getSuit().getName(),
					handPulled.getSuit().getName());
		}
	}

	/**
	 * Tests whether the sort by both parameters in Hand class works as expected.
	 */
	@Test
	public void testSortByBothInHand() {

		HandClass newHand = new HandClass();
		
		newHand.accept(new CardClass("2", "spade"));
		newHand.accept(new CardClass("3", "spade"));
		newHand.accept(new CardClass("4", "spade"));
		newHand.accept(new CardClass("5", "spade"));
		newHand.accept(new CardClass("6", "spade"));
		newHand.accept(new CardClass("7", "spade"));
		newHand.accept(new CardClass("8", "spade"));
		newHand.accept(new CardClass("9", "spade"));
		newHand.accept(new CardClass("10", "spade"));
		newHand.accept(new CardClass("J", "spade"));
		newHand.accept(new CardClass("Q", "spade"));
		newHand.accept(new CardClass("K", "spade"));
		newHand.accept(new CardClass("A", "spade"));
		newHand.accept(new CardClass("2", "diamond"));
		
		newHand.sort("BYboth");

		Card pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "2", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "2", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "diamond", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "3", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "4", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "5", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "6", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "7", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "8", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "9", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "10", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "J", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "Q", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "K", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "A", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
	}

	/**
	 * Tests the sort method in Hand class with an illegal parameter.
	 */
	@Test
	public void testSortInHandWithIllegalValue() {

		HandClass newHand = new HandClass();
		
		newHand.accept(new CardClass("J", "spade"));
		newHand.accept(new CardClass("Q", "spade"));
		newHand.accept(new CardClass("K", "spade"));
		newHand.accept(new CardClass("A", "spade"));
		newHand.accept(new CardClass("2", "diamond"));

		String expected = "Cannot sort by value. Can only sort either by rank, suit or both.";
		try {
			newHand.sort("value");
			fail("sort method did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("Sort method not working as expected", expected, ex.getMessage());
		}
	}
	
	/**
	 * Tests whether the equals method in HandClass works as expected.
	 */
	@Test
	public void testHandEquals() {
		
		HandClass newHand1 = new HandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		
		HandClass newHand2 = new HandClass();
		Card four = new CardClass("J", "heart");
		Card five = new CardClass("9", "spade");
		Card six = new CardClass("A", "club");
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);
		
		boolean isSame = newHand1.equals(newHand2);
		
		assertEquals("equals method not working as expected", false, isSame);
	}
	
	/**
	 * Tests whether the equals method in HandClass works as expected again.
	 */
	@Test
	public void testHandEqualsAgain() {
		
		HandClass newHand1 = new HandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		
		HandClass newHand2 = new HandClass();
		Card four = new CardClass("2", "spade");
		Card five = new CardClass("7", "diamond");
		Card six = new CardClass("J", "heart");
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);
		
		boolean isSame = newHand1.equals(newHand2);
		
		assertEquals("equals method not working as expected", true, isSame);
	}
	
	/**
	 * Tests whether the hashCode method in HandClass works as expected.
	 */
	@Test
	public void testHandHashCode() {
		
		HandClass newHand1 = new HandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		
		HandClass newHand2 = new HandClass();
		Card four = new CardClass("J", "heart");
		Card five = new CardClass("9", "spade");
		Card six = new CardClass("A", "club");
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);
			
		assertNotEquals("hashCode method not working as expected", newHand1.hashCode(), newHand2.hashCode());
	}
	
	/**
	 * Tests whether the hashCode method in HandClass works as expected again.
	 */
	@Test
	public void testHandHashCodeAgain() {
		
		HandClass newHand1 = new HandClass();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		
		HandClass newHand2 = new HandClass();
		Card four = new CardClass("2", "spade");
		Card five = new CardClass("7", "diamond");
		Card six = new CardClass("J", "heart");
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);
				
		assertEquals("equals method not working as expected", newHand1.hashCode(), newHand2.hashCode());
	}
	
}
