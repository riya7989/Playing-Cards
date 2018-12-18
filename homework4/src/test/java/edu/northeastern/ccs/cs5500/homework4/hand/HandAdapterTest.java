package edu.northeastern.ccs.cs5500.homework4.hand;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework4.card.Card;
import edu.northeastern.ccs.cs5500.homework4.card.CardAdapterClass;
import edu.northeastern.ccs.cs5500.homework4.deck.StandardDeckClass;
import edu.northeastern.ccs.cs5500.homework4.rank.RankClass;
import edu.northeastern.ccs.cs5500.homework4.rank.RankEnum;

/**
 * Tests that verify whether the HandAdapterClass works as expected.
 * 
 * @author Riya Nadkarni
 * @version 10-19-2018
 */
public class HandAdapterTest {

	/**
	 * Tests whether the HandAdapter constructor works as expected.
	 */
	@Test
	public void testHandAdapterConstructor() {
		
		IterableHand newHand = new HandAdapterClass();
		Card one = new CardAdapterClass(2, 0);
		Card two = new CardAdapterClass(7, 3);
		Card three = new CardAdapterClass(11, 1);
		Card four = new CardAdapterClass(12, 2);
		Card five = new CardAdapterClass(4, 3);
		Card six = new CardAdapterClass(5, 2);
		Card seven = new CardAdapterClass(10, 1);
		Card eight = new CardAdapterClass(0, 0);
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
	 * Test whether showCards method in the HandAdapter class works as expected.
	 */
	@Test
	public void testHandAdapterShowCards() {
		
		IterableHand newHand = new HandAdapterClass();
		Card one = new CardAdapterClass(2, 0);
		Card two = new CardAdapterClass(7, 3);
		Card three = new CardAdapterClass(11, 1);
		Card four = new CardAdapterClass(12, 2);
		Card five = new CardAdapterClass(4, 3);
		Card six = new CardAdapterClass(5, 2);
		
		newHand.accept(one);
		newHand.accept(two);
		newHand.accept(three);
		newHand.accept(four);
		newHand.accept(five);
		newHand.accept(six);
		
		List<Card> showHand = newHand.showCards();
		
		assertEquals("Incorrect hand created", "4", showHand.get(0).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", showHand.get(0).getSuit().getName());
		assertEquals("Incorrect hand created", "9", showHand.get(1).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "heart", showHand.get(1).getSuit().getName());
		assertEquals("Incorrect hand created", "K", showHand.get(2).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "diamond", showHand.get(2).getSuit().getName());
		assertEquals("Incorrect hand created", "A", showHand.get(3).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "club", showHand.get(3).getSuit().getName());
		assertEquals("Incorrect hand created", "6", showHand.get(4).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "heart", showHand.get(4).getSuit().getName());
		assertEquals("Incorrect hand created", "7", showHand.get(5).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "club", showHand.get(5).getSuit().getName());
	}
	
	/**
	 * Test whether pullCard method in the HandAdapter class works as expected.
	 */
	@Test
	public void testHandAdapterPullCard() {
	
		IterableHand newHand1 = new HandAdapterClass();
		Card one = new CardAdapterClass(2, 0);
		Card two = new CardAdapterClass(7, 3);
		Card three = new CardAdapterClass(11, 1);
		
		IterableHand newHand2 = new HandAdapterClass();
		Card four = new CardAdapterClass(12, 2);
		Card five = new CardAdapterClass(4, 3);
		Card six = new CardAdapterClass(5, 2);
		
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
	 * Test shuffle in HandAdapter. Testing it by comparing it to another hand with known
	 * order of cards and making sure that the number of cards in a different
	 * position are more than the number of Cards in the same position.
	 * Note - May fail at times if the shuffle method ends up changing the position of less than half number of cards.
	 * Note - Works 99% of the times.
	 */
	@Test
	public void testHandAdapterShuffle() {

		IterableHand newHand = new HandAdapterClass();
		newHand.accept(new CardAdapterClass(0, 0));
		newHand.accept(new CardAdapterClass(1, 0));
		newHand.accept(new CardAdapterClass(2, 0));
		newHand.accept(new CardAdapterClass(3, 0));
		newHand.accept(new CardAdapterClass(4, 0));
		newHand.accept(new CardAdapterClass(5, 0));

		newHand.shuffle();

		assertEquals("Shuffle method not working as expected", 6, newHand.showCards().size());

		HandClass testHand = new HandClass();
		testHand.accept(new CardAdapterClass(0, 0));
		testHand.accept(new CardAdapterClass(1, 0));
		testHand.accept(new CardAdapterClass(2, 0));
		testHand.accept(new CardAdapterClass(3, 0));
		testHand.accept(new CardAdapterClass(4, 0));
		testHand.accept(new CardAdapterClass(5, 0));

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
	 * Tests whether the accept card method in HandAdapter class works as expected.
	 */
	@Test
	public void testHandAdapterAcceptListOfCards() {

		IterableHand newHand = new HandAdapterClass();
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
	 * Tests whether the sort by rank method in HandAdapter class works as expected.
	 */
	@Test
	public void testHandAdapterSortByRank() {
	
		IterableHand newHand = new HandAdapterClass();
		
		newHand.accept(new CardAdapterClass(1, 0));
		newHand.accept(new CardAdapterClass(2, 0));
		newHand.accept(new CardAdapterClass(3, 0));
		newHand.accept(new CardAdapterClass(4, 0));
		newHand.accept(new CardAdapterClass(5, 0));
		newHand.accept(new CardAdapterClass(6, 0));
		newHand.accept(new CardAdapterClass(7, 0));
		newHand.accept(new CardAdapterClass(8, 0));
		newHand.accept(new CardAdapterClass(9, 0));
		newHand.accept(new CardAdapterClass(10, 0));
		newHand.accept(new CardAdapterClass(11, 0));
		newHand.accept(new CardAdapterClass(12, 0));
		newHand.accept(new CardAdapterClass(0, 0));
		newHand.accept(new CardAdapterClass(0, 1));
		
		newHand.shuffle();
		newHand.sort("BYrank");

		Card pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "2", pulled.getRank().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "2", pulled.getRank().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "3", pulled.getRank().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "4", pulled.getRank().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "5", pulled.getRank().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "6", pulled.getRank().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "7", pulled.getRank().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "8", pulled.getRank().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "9", pulled.getRank().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "10", pulled.getRank().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "J", pulled.getRank().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "Q", pulled.getRank().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "K", pulled.getRank().getName());
		pulled = newHand.pullCard();
		assertEquals("Incorrect sorted card order in hand", "A", pulled.getRank().getName());
	}
	
	/**
	 * Tests whether the sort by suit method in HandAdapter class works as expected.
	 */
	@Test
	public void testHandAdapterSortBySuit() {

		IterableHand newHand = new HandAdapterClass();
		
		newHand.accept(new CardAdapterClass(0, 0));
		newHand.accept(new CardAdapterClass(1, 0));
		newHand.accept(new CardAdapterClass(2, 0));
		newHand.accept(new CardAdapterClass(3, 0));
		newHand.accept(new CardAdapterClass(4, 0));
		newHand.accept(new CardAdapterClass(5, 0));
		newHand.accept(new CardAdapterClass(6, 0));
		newHand.accept(new CardAdapterClass(7, 0));
		newHand.accept(new CardAdapterClass(8, 0));
		newHand.accept(new CardAdapterClass(9, 0));
		newHand.accept(new CardAdapterClass(10, 0));
		newHand.accept(new CardAdapterClass(11, 0));
		newHand.accept(new CardAdapterClass(12, 0));
		newHand.accept(new CardAdapterClass(0, 1));
		
		newHand.shuffle();
		
		StandardDeckClass oneDeck = new StandardDeckClass();
		newHand.sort("bYsuIT");

		for (int i = 0; i < 13; i++) {
			Card handPulled = newHand.pullCard();
			Card deckPulled = oneDeck.pullCard();
			assertEquals("Incorrect sorted card order in hand at " + i, deckPulled.getSuit().getName(),
					handPulled.getSuit().getName());
		}
	}
	
	/**
	 * Tests whether the sort by both parameters in Hand class works as expected.
	 */
	@Test
//	@Ignore
	public void testSortByBothInHand() {

		IterableHand newHand = new HandAdapterClass();
		
		newHand.accept(new CardAdapterClass(0, 0));
		newHand.accept(new CardAdapterClass(1, 0));
		newHand.accept(new CardAdapterClass(2, 0));
		newHand.accept(new CardAdapterClass(3, 0));
		newHand.accept(new CardAdapterClass(4, 0));
		newHand.accept(new CardAdapterClass(5, 0));
		newHand.accept(new CardAdapterClass(6, 0));
		newHand.accept(new CardAdapterClass(7, 0));
		newHand.accept(new CardAdapterClass(8, 0));
		newHand.accept(new CardAdapterClass(9, 0));
		newHand.accept(new CardAdapterClass(10, 0));
		newHand.accept(new CardAdapterClass(11, 0));
		newHand.accept(new CardAdapterClass(12, 0));
		newHand.accept(new CardAdapterClass(0, 1));
		
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
	 * Tests the sort method in HandAdapter class with an illegal parameter.
	 */
	@Test
	public void testHandAdapterSortWithIllegalValue() {

		IterableHand newHand = new HandAdapterClass();
		
		newHand.accept(new CardAdapterClass(9, 0));
		newHand.accept(new CardAdapterClass(10, 0));
		newHand.accept(new CardAdapterClass(11, 0));
		newHand.accept(new CardAdapterClass(12, 0));
		newHand.accept(new CardAdapterClass(0, 1));

		String expected = "Cannot sort by value. Can only sort either by rank, suit or both.";
		try {
			newHand.sort("value");
			fail("sort method did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("Sort method not working as expected", expected, ex.getMessage());
		}
	}

	/**
	 * Tests whether the equals method in HandAdapter works as expected.
	 */
	@Test
	public void testHandAdapterEquals() {
		
		IterableHand newHand1 = new HandAdapterClass();
		Card one = new CardAdapterClass(0, 0);
		Card two = new CardAdapterClass(5, 1);
		Card three = new CardAdapterClass(9, 3);
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		
		IterableHand newHand2 = new HandAdapterClass();
		Card four = new CardAdapterClass(9, 3);
		Card five = new CardAdapterClass(7, 0);
		Card six = new CardAdapterClass(12, 2);
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);
		
		boolean isSame = newHand1.equals(newHand2);
		
		assertEquals("equals method not working as expected", false, isSame);
	}
	
	/**
	 * Tests whether the equals method in HandAdapter works as expected again.
	 */
	@Test
	public void testHandAdapterEqualsAgain() {
		
		IterableHand newHand1 = new HandAdapterClass();
		Card one = new CardAdapterClass(0, 0);
		Card two = new CardAdapterClass(5, 1);
		Card three = new CardAdapterClass(9, 3);
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		
		IterableHand newHand2 = new HandAdapterClass();
		Card four = new CardAdapterClass(0, 0);
		Card five = new CardAdapterClass(5, 1);
		Card six = new CardAdapterClass(9, 3);
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);
		
		boolean isSame = newHand1.equals(newHand2);
		
		assertEquals("equals method not working as expected", true, isSame);
	}
	
	/**
	 * Tests whether the hashCode method in HandAdapter works as expected.
	 */
	@Test
	public void testHandAdapterHashCode() {
		
		IterableHand newHand1 = new HandAdapterClass();
		Card one = new CardAdapterClass(0, 0);
		Card two = new CardAdapterClass(5, 1);
		Card three = new CardAdapterClass(9, 3);
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		
		IterableHand newHand2 = new HandAdapterClass();
		Card four = new CardAdapterClass(9, 3);
		Card five = new CardAdapterClass(7, 0);
		Card six = new CardAdapterClass(12, 2);
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);
			
		assertNotEquals("hashCode method not working as expected", newHand1.hashCode(), newHand2.hashCode());
	}
	
	/**
	 * Tests whether the hashCode method in HandAdapter works as expected again.
	 */
	@Test
	public void testHandAdapterHashCodeAgain() {
		
		IterableHand newHand1 = new HandAdapterClass();
		Card one = new CardAdapterClass(0, 0);
		Card two = new CardAdapterClass(5, 1);
		Card three = new CardAdapterClass(9, 3);
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		
		IterableHand newHand2 = new HandAdapterClass();
		Card four = new CardAdapterClass(0, 0);
		Card five = new CardAdapterClass(5, 1);
		Card six = new CardAdapterClass(9, 3);
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);
			
		assertEquals("hashCode method not working as expected", newHand1.hashCode(), newHand2.hashCode());
	}
	
	/**
	 * Test whether the hasCard method in HandAdapter class works as expected.
	 */
	@Test
	public void testHandAdapterHasCard() {

		IterableHand newHand1 = new HandAdapterClass();
		Card one = new CardAdapterClass(0, 0);
		Card two = new CardAdapterClass(5, 1);
		Card three = new CardAdapterClass(9, 3);
		
		IterableHand newHand2 = new HandAdapterClass();
		Card four = new CardAdapterClass(11, 2);
		Card five = new CardAdapterClass(7, 0);
		Card six = new CardAdapterClass(12, 2);
		
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);

		Card newCard = new CardAdapterClass(0, 0);
		boolean found1 = newHand1.hasCard(newCard);
		boolean found2 = newHand2.hasCard(newCard);

		assertEquals("hasCard method not working as expected", true, found1);
		assertEquals("hasCard method not working as expected", false, found2);
	}
	
	/**
	 * Test whether the hasCard method in HandAdapter class works as expected again.
	 */
	@Test
	public void testHandAdapterHasCardAgain() {

		IterableHand newHand1 = new HandAdapterClass();
		Card one = new CardAdapterClass(1, 0);
		Card two = new CardAdapterClass(5, 1);
		Card three = new CardAdapterClass(9, 3);
		
		IterableHand newHand2 = new HandAdapterClass();
		Card four = new CardAdapterClass(11, 2);
		Card five = new CardAdapterClass(7, 0);
		Card six = new CardAdapterClass(12, 2);
		
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);

		Card newCard = new CardAdapterClass(0, 0);
		boolean found1 = newHand1.hasCard(newCard);
		boolean found2 = newHand2.hasCard(newCard);

		assertEquals("hasCard method not working as expected", false, found1);
		assertEquals("hasCard method not working as expected", false, found2);
	}

	/**
	 * Tests whether the card occurrence in HandAdapter is calculated as expected.
	 */
	@Test
	public void testHandAdapterCardOccurrences() {
		
		IterableHand newHand = new HandAdapterClass();
		Card one = new CardAdapterClass(1, 0);
		Card two = new CardAdapterClass(5, 3);
		Card three = new CardAdapterClass(9, 3);
		Card four = new CardAdapterClass(11, 2);
		Card five = new CardAdapterClass(5, 3);
		Card six = new CardAdapterClass(12, 2);
		Card seven = new CardAdapterClass(5, 3);
		
		newHand.accept(one);
		newHand.accept(two);
		newHand.accept(three);
		newHand.accept(four);
		newHand.accept(five);
		newHand.accept(six);
		newHand.accept(seven);
		
		int cardCount = newHand.occurrencesInHand(new CardAdapterClass(5, 3));
		
		assertEquals("Incorrect card occurrence", 3, cardCount);
	}
	
	/**
	 * Tests whether the card occurrence in HandAdapter is calculated as expected again.
	 */
	@Test
	public void testHandAdapterCardOccurrencesAgain() {
		
		IterableHand newHand = new HandAdapterClass();
		Card one = new CardAdapterClass(1, 0);
		Card two = new CardAdapterClass(5, 3);
		Card three = new CardAdapterClass(9, 3);
		Card four = new CardAdapterClass(11, 2);
		Card five = new CardAdapterClass(5, 3);
		Card six = new CardAdapterClass(12, 2);
		Card seven = new CardAdapterClass(5, 3);
		
		newHand.accept(one);
		newHand.accept(two);
		newHand.accept(three);
		newHand.accept(four);
		newHand.accept(five);
		newHand.accept(six);
		newHand.accept(seven);
		
		int cardCount = newHand.occurrencesInHand(new CardAdapterClass(6, 2));
		
		assertEquals("Incorrect card occurrence", 0, cardCount);
	}
	
	/**
	 * Tests whether the rank occurrence in HandAdapter is calculated as expected.
	 */
	@Test
	public void testHandAdapterRankOccurrences() {
		
		IterableHand newHand = new HandAdapterClass();
		Card one = new CardAdapterClass(9, 0);
		Card two = new CardAdapterClass(5, 3);
		Card three = new CardAdapterClass(9, 3);
		Card four = new CardAdapterClass(11, 2);
		Card five = new CardAdapterClass(9, 3);
		Card six = new CardAdapterClass(12, 2);
		Card seven = new CardAdapterClass(9, 3);
		
		newHand.accept(one);
		newHand.accept(two);
		newHand.accept(three);
		newHand.accept(four);
		newHand.accept(five);
		newHand.accept(six);
		newHand.accept(seven);
		
		int rankCount = newHand.occurrencesInHand(new RankClass(RankEnum.JACK));
		
		assertEquals("Incorrect rank occurrence", 4, rankCount);
	}
	
	/**
	 * Tests whether the rank occurrence in HandAdapter is calculated as expected.
	 */
	@Test
	public void testHandAdapterRankOccurrencesAgain() {
		
		IterableHand newHand = new HandAdapterClass();
		Card one = new CardAdapterClass(9, 0);
		Card two = new CardAdapterClass(5, 3);
		Card three = new CardAdapterClass(9, 3);
		Card four = new CardAdapterClass(11, 2);
		Card five = new CardAdapterClass(9, 3);
		Card six = new CardAdapterClass(12, 2);
		Card seven = new CardAdapterClass(9, 3);
		
		newHand.accept(one);
		newHand.accept(two);
		newHand.accept(three);
		newHand.accept(four);
		newHand.accept(five);
		newHand.accept(six);
		newHand.accept(seven);
		
		int rankCount = newHand.occurrencesInHand(new RankClass(RankEnum.NINE));
		
		assertEquals("Incorrect rank occurrence", 0, rankCount);
	}
	
	/**
	 * Tests whether the rank and card occurrence in HandAdapter is calculated as expected.
	 */
	@Test
	public void testHandAdapterBothOccurrences() {
		
		IterableHandClass newHand = new IterableHandClass();
		Card one = new CardAdapterClass(0, 0);
		Card two = new CardAdapterClass(5, 3);
		Card three = new CardAdapterClass(9, 3);
		Card four = new CardAdapterClass(5, 2);
		Card five = new CardAdapterClass(0, 3);
		Card six = new CardAdapterClass(12, 2);
		Card seven = new CardAdapterClass(5, 3);
		
		newHand.accept(one);
		newHand.accept(two);
		newHand.accept(three);
		newHand.accept(four);
		newHand.accept(five);
		newHand.accept(six);
		newHand.accept(seven);
		
		int rankCount = newHand.occurrencesInHand(new RankClass(RankEnum.SEVEN));
		int cardCount = newHand.occurrencesInHand(new CardAdapterClass(5, 3));
		
		assertEquals("Incorrect rank occurrence", 3, rankCount);
		assertEquals("Incorrect card occurrence", 2, cardCount);
	}
}
