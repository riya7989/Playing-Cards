package edu.northeastern.ccs.cs5500.homework5.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework5.card.Card;
import edu.northeastern.ccs.cs5500.homework5.card.CardClass;
import edu.northeastern.ccs.cs5500.homework5.rank.Rank;
import edu.northeastern.ccs.cs5500.homework5.rank.RankClass;
import edu.northeastern.ccs.cs5500.homework5.rank.RankEnum;
import edu.northeastern.ccs.cs5500.homework5.suit.Suit;
import edu.northeastern.ccs.cs5500.homework5.suit.SuitClass;
import edu.northeastern.ccs.cs5500.homework5.suit.SuitEnum;

/**
 * Tests that verify whether the Deck object works as expected.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class StandardDeckTest {

	/**
	 * Tests whether the Standard Deck class creates the right deck.
	 */
	@Test
	public void testStandardDeck() {

		StandardDeckClass oneDeck = new StandardDeckClass();
		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 52, oneDeck.getLength());

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Card pulled = oneDeck.pullCard();
				assertEquals("Incorrect rank name of card " + (i + j + 1) + ".", rankEnum[j].getName(),
						pulled.getRank().getName());
				assertEquals("Incorrect rank pip of card " + (i + j + 1) + ".", rankEnum[j].getPips(),
						pulled.getRank().getPips());
				assertEquals("Incorrect suit name of card " + (i + j + 1) + ".", suitEnum[i].getName(),
						pulled.getSuit().getName());
				assertEquals("Incorrect suit symbol of card " + (i + j + 1) + ".", suitEnum[i].getSymbol(),
						pulled.getSuit().getSymbol());
			}
		}
		assertEquals("Incorrect official size of the deck", 52, oneDeck.officialSize());
	}

	/**
	 * Tests whether the Standard Deck class creates the right decks (multiple).
	 */
	@Test
	public void testStandardDeckWithMultipleDecks() {

		StandardDeckClass oneDeck = new StandardDeckClass(2);
		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 104, oneDeck.getLength());

		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 13; j++) {
					Card pulled = oneDeck.pullCard();
					assertEquals("Incorrect rank name of card " + (i + j + k + 1) + ".", rankEnum[j].getName(),
							pulled.getRank().getName());
					assertEquals("Incorrect rank pip of card " + (i + j + k + 1) + ".", rankEnum[j].getPips(),
							pulled.getRank().getPips());
					assertEquals("Incorrect suit name of card " + (i + j + k + 1) + ".", suitEnum[i].getName(),
							pulled.getSuit().getName());
					assertEquals("Incorrect suit symbol of card " + (i + j + k + 1) + ".", suitEnum[i].getSymbol(),
							pulled.getSuit().getSymbol());
				}
			}
		}
		assertEquals("Incorrect official size of the deck", 52, oneDeck.officialSize());
	}

	/**
	 * Tests whether the deck handles error checking.
	 */
	@Test
	public void testStandardDeckWithInvalidNumberOfDecks() {

		String expected = "Minimum number of decks should be 1.";

		try {
			new StandardDeckClass(0);
			fail("Deck constructor did not throw an exception when it should have");
		} catch (IllegalArgumentException ex) {
			assertEquals("Incorrect number of decks created", expected, ex.getMessage());
		}
	}

	/**
	 * Tests whether the standard deck gets shuffled as expected. Testing it by
	 * comparing it to another Deck with known order of cards and making sure that
	 * the number of cards in a different position are more than the number of Cards
	 * in the same position.
	 * Note - May fail at times if the shuffle method ends up changing the position of less than half number of cards.
	 * Note - Works 99% of the times.
	 */
	@Test
	public void testStandardDeckShuffle() {

		StandardDeckClass oneDeck = new StandardDeckClass();
		oneDeck.shuffle();
		assertEquals("Incorrect number of cards in the deck", 52, oneDeck.getLength());

		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		StandardDeckClass testDeck = new StandardDeckClass();

		for (int i = 0; i < suitEnum.length; i++) {
			for (int j = 0; j < rankEnum.length; j++) {
				Rank cardRank = new RankClass(rankEnum[i]);
				Suit cardSuit = new SuitClass(suitEnum[i]);
				Card newCard = new CardClass(cardRank, cardSuit);
				testDeck.accept(newCard);
			}
		}

		int countSame = 0;
		int countDifferent = 0;

		for (int i = 0; i < oneDeck.getLength(); i++) {
			if (oneDeck.pullCard().equals(testDeck.pullCard())) {
				countSame += 1;
			} else {
				countDifferent += 1;
			}
		}
		assertTrue("Shuffle method not working as expected", countSame < countDifferent);
		assertEquals("Incorrect official size of the deck", 52, oneDeck.officialSize());
	}

	/**
	 * Tests whether the standard deck gets sorted by rank as expected.
	 */
	@Test
	public void testStandardDeckSortByRank() {

		StandardDeckClass oneDeck = new StandardDeckClass();
		oneDeck.shuffle();
		oneDeck.sort("BYRANK");
		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };

		assertEquals("Incorrect number of cards in the deck", 52, oneDeck.getLength());

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				Card pulled = oneDeck.pullCard();
				assertEquals("Incorrect rank name of card " + (i + j + 1) + ".", rankEnum[i].getName(),
						pulled.getRank().getName());
				assertEquals("Incorrect rank pip of card " + (i + j + 1) + ".", rankEnum[i].getPips(),
						pulled.getRank().getPips());
			}
		}
		assertEquals("Incorrect official size of the deck", 52, oneDeck.officialSize());
	}

	/**
	 * Tests whether the standard deck gets sorted by suit as expected.
	 */
	@Test
	public void testStandardDeckSortBySuit() {

		StandardDeckClass oneDeck = new StandardDeckClass();
		oneDeck.shuffle();
		oneDeck.sort("BySuit");
		
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 52, oneDeck.getLength());

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Card pulled = oneDeck.pullCard();
				assertEquals("Incorrect suit name of card " + (i + j + 1) + ".", suitEnum[i].getName(),
						pulled.getSuit().getName());
				assertEquals("Incorrect suit symbol of card " + (i + j + 1) + ".", suitEnum[i].getSymbol(),
						pulled.getSuit().getSymbol());
			}
		}
		assertEquals("Incorrect official size of the deck", 52, oneDeck.officialSize());
	}

	/**
	 * Tests whether the standard deck gets sorted by both parameters as expected.
	 */
	@Test
	public void testStandardDeckSortByBoth() {

		StandardDeckClass oneDeck = new StandardDeckClass();
		oneDeck.shuffle();
		oneDeck.sort("byboTH");
		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 52, oneDeck.getLength());

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				Card pulled = oneDeck.pullCard();
				assertEquals("Incorrect rank name of card " + (i + j + 1) + ".", rankEnum[i].getName(),
						pulled.getRank().getName());
				assertEquals("Incorrect rank pip of card " + (i + j + 1) + ".", rankEnum[i].getPips(),
						pulled.getRank().getPips());
				assertEquals("Incorrect suit name of card " + (i + j + 1) + ".", suitEnum[j].getName(),
						pulled.getSuit().getName());
				assertEquals("Incorrect suit symbol of card " + (i + j + 1) + ".", suitEnum[j].getSymbol(),
						pulled.getSuit().getSymbol());
			}
		}
		assertEquals("Incorrect official size of the deck", 52, oneDeck.officialSize());
	}

	/**
	 * Tests the standard deck sort method with an illegal parameter.
	 */
	@Test
	public void testStandardDeckSortWithIllegalValue() {

		StandardDeckClass oneDeck = new StandardDeckClass();
		String expected = "Cannot sort by color. Can only sort either by rank, suit or both.";
		try {
			oneDeck.sort("color");
			fail("sort method did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("Sort method not working as expected", expected, ex.getMessage());
		}
		assertEquals("Incorrect official size of the deck", 52, oneDeck.officialSize());
	}

	/**
	 * Tests whether the emptyDeck method in Standard deck works as expected.
	 */
	@Test
	public void testEmptyStandardDeck() {

		StandardDeckClass oneDeck = new StandardDeckClass();
		boolean empty = oneDeck.emptyDeck();
		assertEquals("Incorrect number of cards in the deck", 52, oneDeck.getLength());
		assertEquals("Empty deck method not working as expected.", false, empty);
		assertEquals("Incorrect official size of the deck", 52, oneDeck.officialSize());
	}

	/**
	 * Tests whether the emptyDeck method in Standard deck works as expected again.
	 */
	@Test
	public void testEmptyStandardDeckAgain() {

		StandardDeckClass oneDeck = new StandardDeckClass();
		assertEquals("Incorrect number of cards in the deck", 52, oneDeck.getLength());

		for (int i = 0; i < 52; i++) {
			oneDeck.pullCard();
		}
		assertEquals("Incorrect number of cards in the deck", 0, oneDeck.getLength());
		boolean empty = oneDeck.emptyDeck();
		assertEquals("Empty deck method not working as expected.", true, empty);
		assertEquals("Incorrect official size of the deck", 52, oneDeck.officialSize());
	}

	/**
	 * Tests whether the cutDeck method of Standard Deck works as expected.
	 */
	@Test
	public void testCutStandardDeck() {

		StandardDeckClass oneDeck = new StandardDeckClass();
		oneDeck.cut(14);
		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART, SuitEnum.SPADE };

		assertEquals("Incorrect number of cards in the deck", 52, oneDeck.getLength());

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Card pulled = oneDeck.pullCard();
				assertEquals("Incorrect rank name of card " + (i + j + 1) + ".", rankEnum[j].getName(),
						pulled.getRank().getName());
				assertEquals("Incorrect rank pip of card " + (i + j + 1) + ".", rankEnum[j].getPips(),
						pulled.getRank().getPips());
				assertEquals("Incorrect suit name of card " + (i + j + 1) + ".", suitEnum[i].getName(),
						pulled.getSuit().getName());
				assertEquals("Incorrect suit symbol of card " + (i + j + 1) + ".", suitEnum[i].getSymbol(),
						pulled.getSuit().getSymbol());
			}
		}
		assertEquals("Incorrect official size of the deck", 52, oneDeck.officialSize());
	}

	/**
	 * Tests whether the pullCard method of standard deck works as expected.
	 */
	@Test
	public void testStandardDeckPullCard() {

		StandardDeckClass oneDeck = new StandardDeckClass();
		Card pulled = oneDeck.pullCard();
		assertEquals("Incorrect number of cards in the deck", 51, oneDeck.getLength());
		assertEquals("Incorrect rank name of card pulled", "2", pulled.getRank().getName());
		assertEquals("Incorrect rank pip of card pulled", 2, pulled.getRank().getPips());
		assertEquals("Incorrect suit name of card pulled", "spade", pulled.getSuit().getName());
		assertEquals("Incorrect suit symbol of card pulled", '\u2660', pulled.getSuit().getSymbol());

		boolean found = false;
		int size = oneDeck.getLength();

		for (int i = 0; i < size; i++) {
			Card next = oneDeck.pullCard();
			if (pulled.equals(next)) {
				found = true;
			}
		}
		assertEquals("Card did not get pulled from deck", false, found);
		assertEquals("Incorrect official size of the deck", 52, oneDeck.officialSize());
	}
	
	/**
	 * Tests whether the right deck is created by the factory.
	 */
	@Test
	public void testDeckFactory() {

		DeckFactory standardFactory = new DeckFactory();
		Deck testDeck = standardFactory.makeDeck();

		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 52, testDeck.getLength());

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Card pulled = testDeck.pullCard();
				assertEquals("Incorrect rank name of card " + (i + j + 1) + ".", rankEnum[j].getName(),
						pulled.getRank().getName());
				assertEquals("Incorrect rank pip of card " + (i + j + 1) + ".", rankEnum[j].getPips(),
						pulled.getRank().getPips());
				assertEquals("Incorrect suit name of card " + (i + j + 1) + ".", suitEnum[i].getName(),
						pulled.getSuit().getName());
				assertEquals("Incorrect suit symbol of card " + (i + j + 1) + ".", suitEnum[i].getSymbol(),
						pulled.getSuit().getSymbol());
			}
		}
		assertEquals("Incorrect official size", 52, testDeck.officialSize());
	}

	/**
	 * Tests whether the right decks (multiple) are created by the factory.
	 */
	@Test
	public void testDeckFactoryWithMultipleDecks() {

		DeckFactory standardFactory = new DeckFactory();
		Deck testDeck = standardFactory.makeDeck(3);

		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 156, testDeck.getLength());

		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 13; j++) {
					Card pulled = testDeck.pullCard();
					assertEquals("Incorrect rank name of card " + (i + j + k + 1) + ".", rankEnum[j].getName(),
							pulled.getRank().getName());
					assertEquals("Incorrect rank pip of card " + (i + j + k + 1) + ".", rankEnum[j].getPips(),
							pulled.getRank().getPips());
					assertEquals("Incorrect suit name of card " + (i + j + k + 1) + ".", suitEnum[i].getName(),
							pulled.getSuit().getName());
					assertEquals("Incorrect suit symbol of card " + (i + j + k + 1) + ".", suitEnum[i].getSymbol(),
							pulled.getSuit().getSymbol());
				}
			}
		}
		assertEquals("Incorrect official size", 52, testDeck.officialSize());
	}

	/**
	 * Tests whether the factory handles error checking.
	 */
	@Test
	public void testDeckFactoryWithInvalidNumberOfDecks() {

		DeckFactory standardFactory = new DeckFactory();
		String expected = "Minimum number of decks should be 1.";

		try {
			standardFactory.makeDeck(0);
			fail("Factory did not throw an exception when it should have");
		} catch (IllegalArgumentException ex) {
			assertEquals("Incorrect number of decks created", expected, ex.getMessage());
		}
	}


}
