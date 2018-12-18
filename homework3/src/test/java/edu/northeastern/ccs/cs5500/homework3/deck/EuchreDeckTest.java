package edu.northeastern.ccs.cs5500.homework3.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework3.card.Card;
import edu.northeastern.ccs.cs5500.homework3.rank.RankEnum;
import edu.northeastern.ccs.cs5500.homework3.suit.SuitEnum;

/**
 * Tests that verify whether the Euchre Deck object works as expected.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class EuchreDeckTest {

	/**
	 * Tests whether the Euchre Deck class creates the right deck.
	 */
	@Test
	public void testEuchreDeck() {

		EuchreDeckClass twoDeck = new EuchreDeckClass();
		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 24, twoDeck.getLength());

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				Card pulled = twoDeck.pullCard();
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
		assertEquals("Incorrect official size of the deck", 24, twoDeck.officialSize());
	}
	
	/**
	 * Tests whether the Euchre Deck class creates the right decks (multiple).
	 */
	@Test
	public void testEuchreDeckWithMultipleDecks() {

		EuchreDeckClass twoDeck = new EuchreDeckClass(4);
		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 96, twoDeck.getLength());

		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 6; j++) {
					Card pulled = twoDeck.pullCard();
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
		assertEquals("Incorrect official size of the deck", 24, twoDeck.officialSize());
	}

	/**
	 * Tests whether the deck handles error checking.
	 */
	@Test
	public void testEuchreDeckWithInvalidNumberOfDecks() {

		String expected = "Minimum number of decks should be 1.";

		try {
			new EuchreDeckClass(-5);
			fail("Deck constructor did not throw an exception when it should have");
		} catch (IllegalArgumentException ex) {
			assertEquals("Incorrect number of decks created", expected, ex.getMessage());
		}
	}

	/**
	 * Tests whether the euchre deck gets shuffled as expected.
	 */
	@Test
	public void testEuchreDeckShuffle() {

		EuchreDeckClass twoDeck = new EuchreDeckClass();
		twoDeck.shuffle();
		assertEquals("Incorrect number of cards in the deck", 24, twoDeck.getLength());
		assertEquals("Incorrect official size of the deck", 24, twoDeck.officialSize());
	}

	/**
	 * Tests whether the euchre deck gets sorted by rank as expected.
	 */
	@Test
	public void testEuchreDeckSortByRank() {

		EuchreDeckClass twoDeck = new EuchreDeckClass();
		twoDeck.shuffle();
		twoDeck.sort("byRANK");
		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };

		assertEquals("Incorrect number of cards in the deck", 24, twoDeck.getLength());

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				Card pulled = twoDeck.pullCard();
				assertEquals("Incorrect rank name of card " + (i + j + 1) + ".", rankEnum[i].getName(),
						pulled.getRank().getName());
				assertEquals("Incorrect rank pip of card " + (i + j + 1) + ".", rankEnum[i].getPips(),
						pulled.getRank().getPips());
			}
		}
		assertEquals("Incorrect official size of the deck", 24, twoDeck.officialSize());
	}

	/**
	 * Tests whether the euchre deck gets sorted by suit as expected.
	 */
	@Test
	public void testEuchreDeckSortBySuit() {

		EuchreDeckClass twoDeck = new EuchreDeckClass();
		twoDeck.shuffle();
		twoDeck.sort("BySuit");
	
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 24, twoDeck.getLength());

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				Card pulled = twoDeck.pullCard();
				assertEquals("Incorrect suit name of card " + (i + j + 1) + ".", suitEnum[i].getName(),
						pulled.getSuit().getName());
				assertEquals("Incorrect suit symbol of card " + (i + j + 1) + ".", suitEnum[i].getSymbol(),
						pulled.getSuit().getSymbol());
			}
		}
		assertEquals("Incorrect official size of the deck", 24, twoDeck.officialSize());
	}

	/**
	 * Tests whether the euchre deck gets sorted by both parameters as expected.
	 */
	@Test
	public void testEuchreDeckSortByBoth() {

		EuchreDeckClass twoDeck = new EuchreDeckClass();
		twoDeck.shuffle();
		twoDeck.sort("BYboTH");
		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 24, twoDeck.getLength());

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				Card pulled = twoDeck.pullCard();
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
		assertEquals("Incorrect official size of the deck", 24, twoDeck.officialSize());
	}

	/**
	 * Tests the euchre deck sort method with an illegal parameter.
	 */
	@Test
	public void testEuchreDeckSortWithIllegalValue() {

		EuchreDeckClass twoDeck = new EuchreDeckClass();
		String expected = "Cannot sort by shape. Can only sort either by rank, suit or both.";
		try {
			twoDeck.sort("shape");
			fail("sort method did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("Sort method not working as expected", expected, ex.getMessage());
		}
		assertEquals("Incorrect official size of the deck", 24, twoDeck.officialSize());
	}

	/**
	 * Tests whether the emptyDeck method in Euchre deck works as expected.
	 */
	@Test
	public void testEuchreEmptyDeck() {

		EuchreDeckClass twoDeck = new EuchreDeckClass();
		boolean empty = twoDeck.emptyDeck();
		assertEquals("Incorrect number of cards in the deck", 24, twoDeck.getLength());
		assertEquals("Empty deck method not working as expected.", false, empty);
		assertEquals("Incorrect official size of the deck", 24, twoDeck.officialSize());
	}

	/**
	 * Tests whether the emptyDeck method in Euchre deck works as expected again.
	 */
	@Test
	public void testEuchreEmptyDeckAgain() {

		EuchreDeckClass twoDeck = new EuchreDeckClass();
		assertEquals("Incorrect number of cards in the deck", 24, twoDeck.getLength());

		for (int i = 0; i < 24; i++) {
			twoDeck.pullCard();
		}
		assertEquals("Incorrect number of cards in the deck", 0, twoDeck.getLength());
		boolean empty = twoDeck.emptyDeck();
		assertEquals("Empty deck method not working as expected.", true, empty);
		assertEquals("Incorrect official size of the deck", 24, twoDeck.officialSize());
	}

	/**
	 * Tests whether the cutDeck method of Euchre Deck works as expected.
	 */
	@Test
	public void testCutEuchreDeck() {

		EuchreDeckClass twoDeck = new EuchreDeckClass();
		twoDeck.cut(7);
		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART, SuitEnum.SPADE };

		assertEquals("Incorrect number of cards in the deck", 24, twoDeck.getLength());

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				Card pulled = twoDeck.pullCard();
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
		assertEquals("Incorrect official size of the deck", 24, twoDeck.officialSize());
	}

	/**
	 * Tests whether the pullCard method of euchre deck works as expected.
	 */
	@Test
	public void testEuchreDeckPullCard() {

		EuchreDeckClass twoDeck = new EuchreDeckClass();
		Card pulled = twoDeck.pullCard();
		assertEquals("Incorrect number of cards in the deck", 23, twoDeck.getLength());
		assertEquals("Incorrect rank name of card pulled", "9", pulled.getRank().getName());
		assertEquals("Incorrect rank pip of card pulled", 9, pulled.getRank().getPips());
		assertEquals("Incorrect suit name of card pulled", "spade", pulled.getSuit().getName());
		assertEquals("Incorrect suit symbol of card pulled", '\u2660', pulled.getSuit().getSymbol());
		assertEquals("Incorrect official size of the deck", 24, twoDeck.officialSize());
	}
	
	/**
	 * Tests whether the right deck is created by the factory.
	 */
	@Test
	public void testEuchreDeckFactory() {

		DeckFactory euchreFactory = new EuchreDeckFactory();
		Deck testDeck = euchreFactory.makeDeck();

		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 24, testDeck.getLength());

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
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
		assertEquals("Incorrect official size", 24, testDeck.officialSize());
	}

	/**
	 * Tests whether the right decks (multiple) are created by the factory.
	 */
	@Test
	public void testEuchreDeckFactoryWithMultipleDecks() {

		DeckFactory euchreFactory = new EuchreDeckFactory();
		Deck testDeck = euchreFactory.makeDeck(5);

		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 120, testDeck.getLength());

		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 6; j++) {
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
		assertEquals("Incorrect official size", 24, testDeck.officialSize());
	}

	/**
	 * Tests whether the factory handles error checking.
	 */
	@Test
	public void testEuchreDeckFactoryWithInvalidNumberOfDecks() {

		DeckFactory euchreFactory = new EuchreDeckFactory();
		String expected = "Minimum number of decks should be 1.";

		try {
			euchreFactory.makeDeck(-5);
			fail("Factory did not throw an exception when it should have");
		} catch (IllegalArgumentException ex) {
			assertEquals("Incorrect number of decks created", expected, ex.getMessage());
		}
	}

}
