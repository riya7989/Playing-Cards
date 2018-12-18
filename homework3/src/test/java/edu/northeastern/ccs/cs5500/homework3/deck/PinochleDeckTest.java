package edu.northeastern.ccs.cs5500.homework3.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework3.card.Card;
import edu.northeastern.ccs.cs5500.homework3.rank.RankEnum;
import edu.northeastern.ccs.cs5500.homework3.suit.SuitEnum;

/**
 * Tests that verify whether the Pinochle Deck object works as expected.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class PinochleDeckTest {

	/**
	 * Tests whether the Pinochle Deck class creates the right deck.
	 */
	@Test
	public void testPinochleDeck() {

		PinochleDeckClass threeDeck = new PinochleDeckClass();
		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 48, threeDeck.getLength());

		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 6; j++) {
					Card pulled = threeDeck.pullCard();
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
		assertEquals("Incorrect official size of the deck", 48, threeDeck.officialSize());
	}
	
	/**
	 * Tests whether the Pinochle Deck class creates the right decks (multiple).
	 */
	@Test
	public void testPinochleDeckWithMultipleDecks() {

		PinochleDeckClass threeDeck = new PinochleDeckClass(3);
		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 144, threeDeck.getLength());

		for (int k = 0; k < 2 * 3; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 6; j++) {
					Card pulled = threeDeck.pullCard();
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
		assertEquals("Incorrect official size of the deck", 48, threeDeck.officialSize());
	}

	/**
	 * Tests whether the deck handles error checking.
	 */
	@Test
	public void testPinochleDeckWithInvalidNumberOfDecks() {

		String expected = "Minimum number of decks should be 1.";

		try {
			new PinochleDeckClass(-1);
			fail("Deck constructor did not throw an exception when it should have");
		} catch (IllegalArgumentException ex) {
			assertEquals("Incorrect number of decks created", expected, ex.getMessage());
		}
	}

	/**
	 * Tests whether the pinochle deck gets shuffled as expected.
	 */
	@Test
	public void testPinochleDeckShuffle() {

		PinochleDeckClass threeDeck = new PinochleDeckClass();
		threeDeck.shuffle();
		assertEquals("Incorrect number of cards in the deck", 48, threeDeck.getLength());
		assertEquals("Incorrect official size of the deck", 48, threeDeck.officialSize());
	}

	/**
	 * Tests whether the pinochle deck gets sorted by rank as expected.
	 */
	@Test
	public void testPinochleDeckSortByRank() {

		PinochleDeckClass threeDeck = new PinochleDeckClass();
		threeDeck.shuffle();
		threeDeck.sort("BYRaNk");
		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };

		assertEquals("Incorrect number of cards in the deck", 48, threeDeck.getLength());

		for (int i = 0; i < 6; i++) {
			for (int k = 0; k < 2; k++) {
				for (int j = 0; j < 4; j++) {
					Card pulled = threeDeck.pullCard();
					assertEquals("Incorrect rank name of card " + (i + j + k + 1) + ".", rankEnum[i].getName(),
							pulled.getRank().getName());
					assertEquals("Incorrect rank pip of card " + (i + j + k + 1) + ".", rankEnum[i].getPips(),
							pulled.getRank().getPips());
				}
			}
		}
		assertEquals("Incorrect official size of the deck", 48, threeDeck.officialSize());
	}

	/**
	 * Tests whether the pinochle deck gets sorted by suit as expected.
	 */
	@Test
	public void testPinochleDeckSortBySuit() {

		PinochleDeckClass threeDeck = new PinochleDeckClass();
		threeDeck.shuffle();
		threeDeck.sort("bYSUIT");

		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 48, threeDeck.getLength());

		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 2; k++) {
				for (int j = 0; j < 6; j++) {
					Card pulled = threeDeck.pullCard();
					assertEquals("Incorrect suit name of card " + (i + j + k + 1) + ".", suitEnum[i].getName(),
							pulled.getSuit().getName());
					assertEquals("Incorrect suit symbol of card " + (i + j + k + 1) + ".", suitEnum[i].getSymbol(),
							pulled.getSuit().getSymbol());
				}
			}
		}
		assertEquals("Incorrect official size of the deck", 48, threeDeck.officialSize());
	}

	/**
	 * Tests whether the pinochle deck gets sorted by both parameters as expected.
	 */
	@Test
	public void testPinochleDeckSortByBoth() {

		PinochleDeckClass threeDeck = new PinochleDeckClass();
		threeDeck.shuffle();
		threeDeck.sort("byBoth");
		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 48, threeDeck.getLength());

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 2; k++) {
					Card pulled = threeDeck.pullCard();
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
		assertEquals("Incorrect official size of the deck", 48, threeDeck.officialSize());
	}

	/**
	 * Tests the pinochle deck sort method with an illegal parameter.
	 */
	@Test
	public void testPinochleDeckSortWithIllegalValue() {

		PinochleDeckClass threeDeck = new PinochleDeckClass();
		String expected = "Cannot sort by size. Can only sort either by rank, suit or both.";
		try {
			threeDeck.sort("size");
			fail("sort method did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("Sort method not working as expected", expected, ex.getMessage());
		}
		assertEquals("Incorrect official size of the deck", 48, threeDeck.officialSize());
	}

	/**
	 * Tests whether the emptyDeck method in Pinochle deck works as expected.
	 */
	@Test
	public void testPinochleEmptyDeck() {

		PinochleDeckClass threeDeck = new PinochleDeckClass();
		boolean empty = threeDeck.emptyDeck();
		assertEquals("Incorrect number of cards in the deck", 48, threeDeck.getLength());
		assertEquals("Empty deck method not working as expected.", false, empty);
		assertEquals("Incorrect official size of the deck", 48, threeDeck.officialSize());
	}

	/**
	 * Tests whether the emptyDeck method in Pinochle deck works as expected again.
	 */
	@Test
	public void testPinochleEmptyDeckAgain() {

		PinochleDeckClass threeDeck = new PinochleDeckClass();
		assertEquals("Incorrect number of cards in the deck", 48, threeDeck.getLength());

		for (int i = 0; i < 48; i++) {
			threeDeck.pullCard();
		}
		assertEquals("Incorrect number of cards in the deck", 0, threeDeck.getLength());
		boolean empty = threeDeck.emptyDeck();
		assertEquals("Empty deck method not working as expected.", true, empty);
		assertEquals("Incorrect official size of the deck", 48, threeDeck.officialSize());
	}

	/**
	 * Tests whether the cutDeck method of Pinochle Deck works as expected.
	 */
	@Test
	public void testCutPinochleDeck() {

		PinochleDeckClass threeDeck = new PinochleDeckClass();
		threeDeck.cut(25);
		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 48, threeDeck.getLength());

		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 6; j++) {
					Card pulled = threeDeck.pullCard();
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
		assertEquals("Incorrect official size of the deck", 48, threeDeck.officialSize());
	}

	/**
	 * Tests whether the pullCard method of pinochle deck works as expected.
	 */
	@Test
	public void testPinochleDeckPullCard() {

		PinochleDeckClass threeDeck = new PinochleDeckClass();
		Card pulled = threeDeck.pullCard();
		assertEquals("Incorrect number of cards in the deck", 47, threeDeck.getLength());
		assertEquals("Incorrect rank name of card pulled", "9", pulled.getRank().getName());
		assertEquals("Incorrect rank pip of card pulled", 9, pulled.getRank().getPips());
		assertEquals("Incorrect suit name of card pulled", "spade", pulled.getSuit().getName());
		assertEquals("Incorrect suit symbol of card pulled", '\u2660', pulled.getSuit().getSymbol());
		assertEquals("Incorrect official size of the deck", 48, threeDeck.officialSize());
	}
	
	/**
	 * Tests whether the right deck is created by the factory.
	 */
	@Test
	public void testPinochleDeckFactory() {

		DeckFactory pinochleFactory = new PinochleDeckFactory();
		Deck testDeck = pinochleFactory.makeDeck();

		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 48, testDeck.getLength());

		for (int k = 0; k < 2; k++) {
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
		assertEquals("Incorrect official size", 48, testDeck.officialSize());
	}

	/**
	 * Tests whether the right decks (multiple) are created by the factory.
	 */
	@Test
	public void testPinochleDeckFactoryWithMultipleDecks() {

		DeckFactory pinochleFactory = new PinochleDeckFactory();
		Deck testDeck = pinochleFactory.makeDeck(4);

		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 192, testDeck.getLength());

		for (int k = 0; k < 2 * 4; k++) {
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
		assertEquals("Incorrect official size", 48, testDeck.officialSize());
	}

	/**
	 * Tests whether the factory handles error checking.
	 */
	@Test
	public void testPinochleDeckFactoryWithInvalidNumberOfDecks() {

		DeckFactory pinochleFactory = new PinochleDeckFactory();
		String expected = "Minimum number of decks should be 1.";

		try {
			pinochleFactory.makeDeck(-1);
			fail("Factory did not throw an exception when it should have");
		} catch (IllegalArgumentException ex) {
			assertEquals("Incorrect number of decks created", expected, ex.getMessage());
		}
	}

}
