package edu.northeastern.ccs.cs5500.homework3.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework3.card.Card;
import edu.northeastern.ccs.cs5500.homework3.rank.RankEnum;
import edu.northeastern.ccs.cs5500.homework3.suit.SuitEnum;

/**
 * Tests that verify whether the Vegas Deck object works as expected.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class VegasDeckTest {

	/**
	 * Tests whether the vegas Deck class creates the right deck.
	 */
	@Test
	public void testVegasDeck() {

		VegasDeckClass fourDeck = new VegasDeckClass();
		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 312, fourDeck.getLength());

		for (int k = 0; k < 6; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 13; j++) {
					Card pulled = fourDeck.pullCard();
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
		assertEquals("Incorrect official size of the deck", 312, fourDeck.officialSize());
	}
	
	/**
	 * Tests whether the Vegas Deck class creates the right decks (multiple).
	 */
	@Test
	public void testVegasDeckWithMultipleDecks() {

		VegasDeckClass fourDeck = new VegasDeckClass(5);
		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 260, fourDeck.getLength());

		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 13; j++) {
					Card pulled = fourDeck.pullCard();
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
		assertEquals("Incorrect official size of the deck", 312, fourDeck.officialSize());
	}

	/**
	 * Tests whether the deck handles error checking.
	 */
	@Test
	public void testVegasDeckWithInvalidNumberOfDecks() {

		String expected = "Minimum number of decks should be 2.";

		try {
			new VegasDeckClass(1);
			fail("Deck constructor did not throw an exception when it should have");
		} catch (IllegalArgumentException ex) {
			assertEquals("Incorrect number of decks created", expected, ex.getMessage());
		}
	}

	/**
	 * Tests whether the vegas deck gets shuffled as expected.
	 */
	@Test
	public void testVegasDeckShuffle() {

		VegasDeckClass fourDeck = new VegasDeckClass();
		fourDeck.shuffle();
		assertEquals("Incorrect number of cards in the deck", 312, fourDeck.getLength());
		assertEquals("Incorrect official size of the deck", 312, fourDeck.officialSize());
	}

	/**
	 * Tests whether the vegas deck gets sorted by rank as expected.
	 */
	@Test
	public void testVegasDeckSortByRank() {

		VegasDeckClass fourDeck = new VegasDeckClass();
		fourDeck.shuffle();
		fourDeck.sort("byranK");
		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };

		assertEquals("Incorrect number of cards in the deck", 312, fourDeck.getLength());

		for (int i = 0; i < 13; i++) {
			for (int k = 0; k < 6; k++) {
				for (int j = 0; j < 4; j++) {
					Card pulled = fourDeck.pullCard();
					assertEquals("Incorrect rank name of card " + (i + j + k + 1) + ".", rankEnum[i].getName(),
							pulled.getRank().getName());
					assertEquals("Incorrect rank pip of card " + (i + j + k + 1) + ".", rankEnum[i].getPips(),
							pulled.getRank().getPips());
				}
			}
		}
		assertEquals("Incorrect official size of the deck", 312, fourDeck.officialSize());
	}

	/**
	 * Tests whether the vegas deck gets sorted by suit as expected.
	 */
	@Test
	public void testVegasDeckSortBySuit() {

		VegasDeckClass fourDeck = new VegasDeckClass();
		fourDeck.shuffle();
		fourDeck.sort("BySuiT");

		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 312, fourDeck.getLength());

		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 6; k++) {
				for (int j = 0; j < 13; j++) {
					Card pulled = fourDeck.pullCard();
					assertEquals("Incorrect suit name of card " + (i + j + k + 1) + ".", suitEnum[i].getName(),
							pulled.getSuit().getName());
					assertEquals("Incorrect suit symbol of card " + (i + j + k + 1) + ".", suitEnum[i].getSymbol(),
							pulled.getSuit().getSymbol());
				}
			}
		}
		assertEquals("Incorrect official size of the deck", 312, fourDeck.officialSize());
	}

	/**
	 * Tests whether the vegas deck gets sorted by both parameters as expected.
	 */
	@Test
	public void testVegasDeckSortByBoth() {

		VegasDeckClass fourDeck = new VegasDeckClass();
		fourDeck.shuffle();
		fourDeck.sort("bYBOTh");
		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 312, fourDeck.getLength());

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 6; k++) {
					Card pulled = fourDeck.pullCard();
					assertEquals("Incorrect rank name of card " + (i + j + k + 1) + ".", rankEnum[i].getName(),
							pulled.getRank().getName());
					assertEquals("Incorrect rank pip of card " + (i + j + k + 1) + ".", rankEnum[i].getPips(),
							pulled.getRank().getPips());
					assertEquals("Incorrect suit name of card " + (i + j + k + 1) + ".", suitEnum[j].getName(),
							pulled.getSuit().getName());
					assertEquals("Incorrect suit symbol of card " + (i + j + k + 1) + ".", suitEnum[j].getSymbol(),
							pulled.getSuit().getSymbol());
				}
			}
		}
		assertEquals("Incorrect official size of the deck", 312, fourDeck.officialSize());
	}

	/**
	 * Tests the vegas deck sort method with an illegal parameter.
	 */
	@Test
	public void testVegasDeckSortWithIllegalValue() {

		VegasDeckClass fourDeck = new VegasDeckClass();
		String expected = "Cannot sort by NumBer. Can only sort either by rank, suit or both.";
		try {
			fourDeck.sort("NumBer");
			fail("sort method did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("Sort method not working as expected", expected, ex.getMessage());
		}
		assertEquals("Incorrect official size of the deck", 312, fourDeck.officialSize());
	}

	/**
	 * Tests whether the emptyDeck method in Vegas deck works as expected.
	 */
	@Test
	public void testEmptyVegasDeck() {

		VegasDeckClass fourDeck = new VegasDeckClass();
		boolean empty = fourDeck.emptyDeck();
		assertEquals("Incorrect number of cards in the deck", 312, fourDeck.getLength());
		assertEquals("Empty deck method not working as expected.", false, empty);
		assertEquals("Incorrect official size of the deck", 312, fourDeck.officialSize());
	}

	/**
	 * Tests whether the emptyDeck method in Vegas deck works as expected again.
	 */
	@Test
	public void testEmptyVegasDeckAgain() {

		VegasDeckClass fourDeck = new VegasDeckClass();
		assertEquals("Incorrect number of cards in the deck", 312, fourDeck.getLength());

		for (int i = 0; i < 312; i++) {
			fourDeck.pullCard();
		}
		assertEquals("Incorrect number of cards in the deck", 0, fourDeck.getLength());
		boolean empty = fourDeck.emptyDeck();
		assertEquals("Empty deck method not working as expected.", true, empty);
		assertEquals("Incorrect official size of the deck", 312, fourDeck.officialSize());
	}

	/**
	 * Tests whether the cutDeck method of Vegas Deck works as expected.
	 */
	@Test
	public void testCutVegasDeck() {

		VegasDeckClass fourDeck = new VegasDeckClass();
		fourDeck.cut(157);
		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 312, fourDeck.getLength());

		for (int k = 0; k < 6; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 13; j++) {
					Card pulled = fourDeck.pullCard();
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
		assertEquals("Incorrect official size of the deck", 312, fourDeck.officialSize());
	}

	/**
	 * Tests whether the pullCard method of vegas deck works as expected.
	 */
	@Test
	public void testVegasDeckPullCard() {

		VegasDeckClass fourDeck = new VegasDeckClass();
		Card pulled = fourDeck.pullCard();
		assertEquals("Incorrect number of cards in the deck", 311, fourDeck.getLength());
		assertEquals("Incorrect rank name of card pulled", "2", pulled.getRank().getName());
		assertEquals("Incorrect rank pip of card pulled", 2, pulled.getRank().getPips());
		assertEquals("Incorrect suit name of card pulled", "spade", pulled.getSuit().getName());
		assertEquals("Incorrect suit symbol of card pulled", '\u2660', pulled.getSuit().getSymbol());
		assertEquals("Incorrect official size of the deck", 312, fourDeck.officialSize());
	}

	/**
	 * Tests whether the right deck is created by the factory.
	 */
	@Test
	public void testVegasDeckFactory() {

		DeckFactory vegasFactory = new VegasDeckFactory();
		Deck testDeck = vegasFactory.makeDeck();

		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 312, testDeck.getLength());

		for (int k = 0; k < 6; k++) {
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
		assertEquals("Incorrect official size", 312, testDeck.officialSize());
	}

	/**
	 * Tests whether the right decks (multiple) are created by the factory.
	 */
	@Test
	public void testVegasDeckFactoryWithMultipleDecks() {

		DeckFactory vegasFactory = new VegasDeckFactory();
		Deck testDeck = vegasFactory.makeDeck(2);

		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 104, testDeck.getLength());

		for (int k = 0; k < 2; k++) {
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
		assertEquals("Incorrect official size", 312, testDeck.officialSize());
	}

	/**
	 * Tests whether the factory handles error checking.
	 */
	@Test
	public void testVegasDeckFactoryWithInvalidNumberOfDecks() {

		DeckFactory vegasFactory = new VegasDeckFactory();
		String expected = "Minimum number of decks should be 2.";

		try {
			vegasFactory.makeDeck(1);
			fail("Factory did not throw an exception when it should have");
		} catch (IllegalArgumentException ex) {
			assertEquals("Incorrect number of decks created", expected, ex.getMessage());
		}
	}
}
