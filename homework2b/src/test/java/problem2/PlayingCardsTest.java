package problem2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Tests that verify whether the Playing Cards program works as expected.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class PlayingCardsTest {

	/**
	 * Tests whether the rank class creates a rank as expected.
	 */
	@Test
	public void testRank() {

		RankEnum rankEnum = RankEnum.SEVEN;
		Rank rank = new RankClass(rankEnum);
		assertEquals("Incorrect rank name.", "7", rank.getName());
		assertEquals("Incorrect rank pip.", 7, rank.getPips());
	}

	/**
	 * Tests whether the rank class creates a rank as expected again.
	 */
	@Test
	public void testRankAgain() {

		RankEnum rankEnum = RankEnum.JACK;
		Rank rank = new RankClass(rankEnum);
		assertEquals("Incorrect rank name.", "J", rank.getName());
		assertEquals("Incorrect rank pip.", 0, rank.getPips());
	}
	
	/**
	 * Tests whether the compareTo method in Rank Class throws an exception as expected.
	 */
	@Test
	public void testRankCompareToWithInvalidInput() {
		
		InvalidRank testRank = new InvalidRank();
		RankEnum rankEnum = RankEnum.SEVEN;
		RankClass newRank = new RankClass(rankEnum);
		String expected = "Cannot compare 2 different objects.";
		
		try {
			newRank.compareTo(testRank);
			fail("compareTo method did not thro an exception when it should");
		}
		catch(IllegalArgumentException ex) {
			assertEquals("compareTo method not working as expected", expected, ex.getMessage());
		}
	}

	/**
	 * Tests whether the getRank method works as expected.
	 */
	@Test
	public void testGetRank() {

		RankEnum rankEnum = RankClass.getRank("9");
		assertEquals("Incorrect rank name.", "9", rankEnum.getName());
		assertEquals("Incorrect rank pip.", 9, rankEnum.getPips());
	}

	/**
	 * Tests whether the getRank method works as expected again.
	 */
	@Test
	public void testGetRankAgain() {

		RankEnum rankEnum = RankClass.getRank("5");
		assertEquals("Incorrect rank name.", "5", rankEnum.getName());
		assertEquals("Incorrect rank pip.", 5, rankEnum.getPips());
	}

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
			fail("compareTo method did not thro an exception when it should");
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
	public void testCardHashCode() {
		
		CardClass one = new CardClass("2", "club");
		CardClass two = new CardClass("3", "diamond");
		
		assertNotEquals("hashCode method not working as expected", one.hashCode(), two.hashCode());
	}
	
	/**
	 * Tests whether the hashCode method in CardClass works as expected again.
	 */
	public void testCardHashCodeAgain() {
		
		CardClass one = new CardClass("2", "club");
		CardClass two = new CardClass("2", "club");
		
		assertEquals("hashCode method not working as expected", one.hashCode(), two.hashCode());
	}
	
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
		oneDeck.sort("BYRANK");
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
	 * Tests whether the standard deck gets sorted by suit as expected.
	 */
	@Test
	public void testStandardDeckSortBySuit() {

		StandardDeckClass oneDeck = new StandardDeckClass();
		oneDeck.sort("BySuit");
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
	 * Tests whether the standard deck gets sorted by both parameters as expected.
	 */
	@Test
	public void testStandardDeckSortByBoth() {

		StandardDeckClass oneDeck = new StandardDeckClass();
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
		twoDeck.sort("byRANK");
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
	 * Tests whether the euchre deck gets sorted by suit as expected.
	 */
	@Test
	public void testEuchreDeckSortBySuit() {

		EuchreDeckClass twoDeck = new EuchreDeckClass();
		twoDeck.sort("BySuit");
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
	 * Tests whether the euchre deck gets sorted by both parameters as expected.
	 */
	@Test
	public void testEuchreDeckSortByBoth() {

		EuchreDeckClass twoDeck = new EuchreDeckClass();
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
		threeDeck.sort("BYRaNk");
		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 48, threeDeck.getLength());

		for (int i = 0; i < 6; i++) {
			for (int k = 0; k < 2; k++) {
				for (int j = 0; j < 4; j++) {
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
	 * Tests whether the pinochle deck gets sorted by suit as expected.
	 */
	@Test
	public void testPinochleDeckSortBySuit() {

		PinochleDeckClass threeDeck = new PinochleDeckClass();
		threeDeck.sort("bYSUIT");
		RankEnum[] rankEnum = { RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING,
				RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 48, threeDeck.getLength());

		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 2; k++) {
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
	 * Tests whether the pinochle deck gets sorted by both parameters as expected.
	 */
	@Test
	public void testPinochleDeckSortByBoth() {

		PinochleDeckClass threeDeck = new PinochleDeckClass();
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
		fourDeck.sort("byranK");
		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 312, fourDeck.getLength());

		for (int i = 0; i < 13; i++) {
			for (int k = 0; k < 6; k++) {
				for (int j = 0; j < 4; j++) {
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
	 * Tests whether the vegas deck gets sorted by suit as expected.
	 */
	@Test
	public void testVegasDeckSortBySuit() {

		VegasDeckClass fourDeck = new VegasDeckClass();
		fourDeck.sort("BySuiT");
		RankEnum[] rankEnum = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN,
				RankEnum.KING, RankEnum.ACE };
		SuitEnum[] suitEnum = { SuitEnum.SPADE, SuitEnum.DIAMOND, SuitEnum.CLUB, SuitEnum.HEART };

		assertEquals("Incorrect number of cards in the deck", 312, fourDeck.getLength());

		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 6; k++) {
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
	 * Tests whether the vegas deck gets sorted by both parameters as expected.
	 */
	@Test
	public void testVegasDeckSortByBoth() {

		VegasDeckClass fourDeck = new VegasDeckClass();
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
	 * Tests whether the equals method in AbstractDeckClass works as expected (using Standard Deck).
	 */
	@Test
	public void testDeckEquals() {
		
		StandardDeckClass oneDeck = new StandardDeckClass();
		StandardDeckClass testDeck = new StandardDeckClass();
		
		boolean isSame = oneDeck.equals(testDeck);
		
		assertEquals("equals method not working as expected", true, isSame);
		
	}
	
	/**
	 * Tests whether the equals method in AbstractDeckClass works as expected (using Standard Deck and Vegas Deck).
	 */
	@Test
	public void testDeckEqualsAgain() {
		
		StandardDeckClass oneDeck = new StandardDeckClass();
		VegasDeckClass testDeck = new VegasDeckClass();
		
		boolean isSame = oneDeck.equals(testDeck);
		
		assertEquals("equals method not working as expected", false, isSame);
	}
	
	/**
	 * Tests whether the hashcode method in AbstractDeckClass works as expected (using Standard Deck).
	 */
	@Test
	public void testDeckHashCode() {
		
		StandardDeckClass oneDeck = new StandardDeckClass();
		StandardDeckClass testDeck = new StandardDeckClass();
		
		assertEquals("hashcode method not working as expected", oneDeck.hashCode(), testDeck.hashCode());
	}
	
	/**
	 * Tests whether the hashcode method in AbstractDeckClass works as expected (using Standard Deck and Vegas Deck).
	 */
	@Test
	public void testDeckHashCodeAgain() {
		
		StandardDeckClass oneDeck = new StandardDeckClass();
		VegasDeckClass testDeck = new VegasDeckClass();
			
		assertNotEquals("hashCode method not working as expected", oneDeck.hashCode(), testDeck.hashCode());
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

	/**
	 * Test whether game class creates the right game.
	 */
	@Test
	public void testGameWithStandardDeck() {

		DeckFactory standardFactory = new DeckFactory();
		GameClass newGame = new GameClass(standardFactory, 1, 2, 25);
		newGame.deal();
		assertEquals("Incorrect number of cards dealt", 2, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 2, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 25, newGame.getNumberOfCards());
	}

	/**
	 * Test whether game class creates the right game.
	 */
	@Test
	public void testGameWithStandardDeckAgain() {

		DeckFactory standardFactory = new DeckFactory();
		GameClass newGame = new GameClass(standardFactory, 3, 6, 25);
		newGame.deal();
		assertEquals("Incorrect number of cards dealt", 6, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 6, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 25, newGame.getNumberOfCards());
	}

	/**
	 * Test game with standard deck and illegal number of decks.
	 */
	@Test
	public void testGameWithStandardDeckIllegalDeckNumber() {

		DeckFactory standardFactory = new DeckFactory();
		String expected = "Number of decks cannot be less than 1.";

		try {
			new GameClass(standardFactory, 0, 2, 25);
			fail("Game constructor did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("Game constructor method not working as expected", expected, ex.getMessage());
		}
	}

	/**
	 * Test game with standard deck and illegal number of decks.
	 */
	@Test
	public void testGameWithStandardDeckIllegalDeckNumberAgain() {

		DeckFactory standardFactory = new DeckFactory();
		GameClass newGame = new GameClass(standardFactory, 1, 2, 25);
		String expected = "Minimum number of decks should be 2.";

		DeckFactory standardFactory2 = new DeckFactory();

		try {
			newGame.createDeck(standardFactory2, 0);
			fail("createDeck method did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("createDeck method not working as expected", expected, ex.getMessage());
		}
	}

	/**
	 * Tests whether the createDeck method in Game class works as expected.
	 */
	@Test
	public void testCreateDeck() {

		DeckFactory euchreFactory = new EuchreDeckFactory();
		GameClass newGame = new GameClass(euchreFactory, 2, 2, 20);

		DeckFactory euchreFactory2 = new EuchreDeckFactory();
		newGame.createDeck(euchreFactory2, 2);
		newGame.setNumberOfHands(1);
		newGame.setNumberOfCards(15);
		newGame.deal();

		assertEquals("Incorrect number of cards dealt", 33, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 1, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 15, newGame.getNumberOfCards());

	}

	/**
	 * Test setNumberOfCards method in Game class with an illegal input.
	 */
	@Test
	public void testSetNumberOfCardsWithIllegalInput() {

		DeckFactory pinochleFactory = new PinochleDeckFactory();
		GameClass newGame = new GameClass(pinochleFactory, 1, 2, 20);
		String expected = "Number of cards cannot exceed the total from the deck.";

		try {
			newGame.setNumberOfCards(25);
			fail("Game constructor did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("Game constructor method not working as expected", expected, ex.getMessage());
		}
	}

	/**
	 * Test setNumberOfCards method in Game class with an illegal input again.
	 */
	@Test
	public void testSetNumberOfCardsWithIllegalInputAgain() {

		DeckFactory pinochleFactory = new PinochleDeckFactory();
		GameClass newGame = new GameClass(pinochleFactory, 1, 2, 20);
		String expected = "Number of cards cannot be less than 1.";

		try {
			newGame.setNumberOfCards(-2);
			fail("Game constructor did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("Game constructor method not working as expected", expected, ex.getMessage());
		}
	}

	/**
	 * Test game with standard deck and illegal number of hands.
	 */
	@Test
	public void testGameWithStandardDeckIllegalHandValue() {

		DeckFactory standardFactory = new DeckFactory();
		String expected = "Number of hands cannot be less than 1.";

		try {
			new GameClass(standardFactory, 1, -5, 25);
			fail("Game constructor did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("Game constructor method not working as expected", expected, ex.getMessage());
		}
	}

	/**
	 * Test game with standard deck and illegal number of cards.
	 */
	@Test
	public void testGameWithStandardDeckIllegalCardValue() {

		DeckFactory standardFactory = new DeckFactory();
		String expected = "Number of cards cannot exceed the total from the deck.";

		try {
			new GameClass(standardFactory, 1, 4, 25);
			fail("Game constructor did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("Game constructor method not working as expected", expected, ex.getMessage());
		}
	}

	/**
	 * Test game with standard deck and illegal number of cards again.
	 */
	@Test
	public void testGameWithStandardDeckIllegalCardValueAgain() {

		DeckFactory standardFactory = new DeckFactory();
		String expected = "Number of cards cannot be less than 1.";

		try {
			new GameClass(standardFactory, 1, 4, 0);
			fail("Game constructor did not throw an exception when it should have.");
		} catch (IllegalArgumentException ex) {
			assertEquals("Game constructor method not working as expected", expected, ex.getMessage());
		}
	}

	/**
	 * Test whether game class creates the right game.
	 */
	@Test
	public void testGameWithEuchreDeck() {

		DeckFactory euchreFactory = new EuchreDeckFactory();
		GameClass newGame = new GameClass(euchreFactory, 1, 3, 8);
		newGame.deal();
		assertEquals("Incorrect number of cards dealt", 0, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 3, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 8, newGame.getNumberOfCards());
	}

	/**
	 * Test whether game class creates the right game.
	 */
	@Test
	public void testGameWithEuchreDeckAgain() {

		DeckFactory euchreFactory = new EuchreDeckFactory();
		GameClass newGame = new GameClass(euchreFactory, 2, 3, 12);
		newGame.deal();
		assertEquals("Incorrect number of cards dealt", 12, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 3, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 12, newGame.getNumberOfCards());
	}

	/**
	 * Test whether game class creates the right game.
	 */
	@Test
	public void testGameWithPinochleDeck() {

		DeckFactory pinochleFactory = new PinochleDeckFactory();
		GameClass newGame = new GameClass(pinochleFactory, 1, 4, 10);
		newGame.deal();
		assertEquals("Incorrect number of cards dealt", 8, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 4, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 10, newGame.getNumberOfCards());
	}

	/**
	 * Test whether game class creates the right game.
	 */
	@Test
	public void testGameWithPinochleDeckAgain() {

		DeckFactory pinochleFactory = new PinochleDeckFactory();
		GameClass newGame = new GameClass(pinochleFactory, 2, 10, 9);
		newGame.deal();
		assertEquals("Incorrect number of cards dealt", 6, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 10, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 9, newGame.getNumberOfCards());
	}

	/**
	 * Test whether game class creates the right game.
	 */
	@Test
	public void testGameWithVegasDeck() {

		DeckFactory vegasFactory = new VegasDeckFactory();
		GameClass newGame = new GameClass(vegasFactory, 1, 3, 5);
		newGame.deal();
		assertEquals("Incorrect number of cards dealt", 297, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 3, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 5, newGame.getNumberOfCards());
	}

	/**
	 * Test whether game class creates the right game.
	 */
	@Test
	public void testGameWithVegasDeckAgain() {

		DeckFactory vegasFactory = new VegasDeckFactory();
		GameClass newGame = new GameClass(vegasFactory, 4, 5, 10);
		newGame.deal();
		assertEquals("Incorrect number of cards dealt", 158, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 5, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 10, newGame.getNumberOfCards());
	}
	
	/**
	 * Tests whether the equals method in GameClass works as expected.
	 */
	@Test
	public void testGameEquals() {
		
		DeckFactory vegasFactory = new VegasDeckFactory();
		DeckFactory standardFactory = new DeckFactory();
		GameClass poker = new GameClass(vegasFactory, 1, 3, 5);
		GameClass uno = new GameClass(standardFactory, 1, 3, 5);
		
		boolean isSame = poker.equals(uno);
		
		assertEquals("equals method not working as expected", false, isSame);
	}
	
	/**
	 * Tests whether the equals method in GameClass works as expected again.
	 */
	@Test
	public void testGameEqualsAgain() {
		
		DeckFactory vegasFactory = new VegasDeckFactory();
		DeckFactory vegasFactory2 = new VegasDeckFactory();
		
		GameClass poker = new GameClass(vegasFactory, 1, 3, 5);
		GameClass uno = new GameClass(vegasFactory2, 1, 3, 5);
		
		boolean isSame = poker.equals(uno);
		
		assertEquals("equals method not working as expected", true, isSame);
	}
	
	/**
	 * Tests whether the hashCode method in GameClass works as expected.
	 */
	@Test
	public void testGameHashCode() {
		
		DeckFactory vegasFactory = new VegasDeckFactory();
		DeckFactory standardFactory = new DeckFactory();
		
		GameClass poker = new GameClass(vegasFactory, 1, 3, 5);
		GameClass uno = new GameClass(standardFactory, 1, 3, 5);
		
		assertNotEquals("hashcode method not working as expected", poker.hashCode(), uno.hashCode());
	}
	
	/**
	 * Tests whether the hashCode method in GameClass works as expected again.
	 */
	@Test
	public void testGameHashCodeAgain() {
		
		DeckFactory vegasFactory = new VegasDeckFactory();
		DeckFactory vegasFactory2 = new VegasDeckFactory();
		
		GameClass poker = new GameClass(vegasFactory, 1, 3, 5);
		GameClass uno = new GameClass(vegasFactory2, 1, 3, 5);
			
		assertEquals("hashCode method not working as expected", poker.hashCode(), uno.hashCode());
	}

	/**
	 * Tests whether the setNumberOfHands method works as expected.
	 */
	@Test
	public void testSetNumberOfHands() {

		DeckFactory euchreFactory = new EuchreDeckFactory();
		GameClass newGame = new GameClass(euchreFactory, 1, 3, 8);
		newGame.setNumberOfHands(2);
		newGame.deal();
		assertEquals("Incorrect number of cards dealt", 8, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 2, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 8, newGame.getNumberOfCards());
	}

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

		DeckFactory standardFactory = new DeckFactory();
		GameClass newGame = new GameClass(standardFactory, 1, 2, 3);
		newGame.deal();
		List<Card> hand1 = newGame.getGameHand().get(0).showCards();
		List<Card> hand2 = newGame.getGameHand().get(1).showCards();

		assertEquals("Incorrect number of cards dealt", 46, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 2, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 3, newGame.getNumberOfCards());

		assertEquals("Incorrect hand created", "2", hand1.get(0).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", hand1.get(0).getSuit().getName());
		assertEquals("Incorrect hand created", "4", hand1.get(1).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", hand1.get(0).getSuit().getName());
		assertEquals("Incorrect hand created", "6", hand1.get(2).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", hand1.get(0).getSuit().getName());

		assertEquals("Incorrect hand created", "3", hand2.get(0).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", hand2.get(0).getSuit().getName());
		assertEquals("Incorrect hand created", "5", hand2.get(1).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", hand2.get(0).getSuit().getName());
		assertEquals("Incorrect hand created", "7", hand2.get(2).getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", hand2.get(0).getSuit().getName());
	}

	/**
	 * Test whether pullCard method in the Hand class works as expected.
	 */
	@Test
	public void testPullCardInHand() {

		DeckFactory standardFactory = new DeckFactory();
		GameClass newGame = new GameClass(standardFactory, 1, 2, 25);
		newGame.deal();
		List<Hand> hand = newGame.getGameHand();

		CardClass newCard1 = new CardClass("2", "spade");
		CardClass newCard2 = new CardClass("3", "spade");
		Card handPulled1 = hand.get(0).pullCard();
		Card handPulled2 = hand.get(1).pullCard();

		assertEquals("Incorrect number of cards dealt", 2, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 2, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 25, newGame.getNumberOfCards());
		assertEquals("Incorrect card pulled from hand 1", newCard1.getRank().getName(),
				handPulled1.getRank().getName());
		assertEquals("Incorrect card pulled from hand 1", newCard1.getSuit().getName(),
				handPulled1.getSuit().getName());
		assertEquals("Incorrect card pulled from hand 1", newCard2.getRank().getName(),
				handPulled2.getRank().getName());
		assertEquals("Incorrect card pulled from hand 1", newCard2.getSuit().getName(),
				handPulled2.getSuit().getName());
	}

	/**
	 * Test whether the hasCard method in Hand class works as expected.
	 */
	@Test
	public void testHasCardInHand() {

		DeckFactory standardFactory = new DeckFactory();
		GameClass newGame = new GameClass(standardFactory, 1, 2, 25);
		newGame.deal();
		List<Hand> hand = newGame.getGameHand();

		CardClass newCard = new CardClass("2", "spade");
		boolean found1 = hand.get(0).hasCard(newCard);
		boolean found2 = hand.get(1).hasCard(newCard);

		assertEquals("Incorrect number of cards dealt", 2, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 2, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 25, newGame.getNumberOfCards());
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

		DeckFactory standardFactory = new DeckFactory();
		GameClass newGame = new GameClass(standardFactory, 1, 1, 6);
		newGame.deal();
		List<Hand> hand = newGame.getGameHand();

		Hand hand1 = hand.get(0);
		hand1.shuffle();

		assertEquals("Incorrect number of cards dealt", 46, newGame.getGameDeck().getLength());
		assertEquals("Incorrect number of hands created", 1, newGame.getNumberOfHands());
		assertEquals("Incorrect number of cards per hand", 6, newGame.getNumberOfCards());
		assertEquals("Shuffle method not working as expected", 1, hand.size());

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
			if (hand1.pullCard().equals(testHand.pullCard())) {
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

		DeckFactory standardFactory = new DeckFactory();
		GameClass newGame = new GameClass(standardFactory, 1, 1, 14);
		newGame.deal();
		List<Hand> hand = newGame.getGameHand();

		Hand hand1 = hand.get(0);
		hand1.sort("BYrank");

		Card pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "2", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "2", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "diamond", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "3", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "4", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "5", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "6", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "7", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "8", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "9", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "10", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "J", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "Q", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "K", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "A", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
	}

	/**
	 * Tests whether the sort by suit method in Hand class works as expected.
	 */
	@Test
	public void testSortBySuitInHand() {

		DeckFactory standardFactory = new DeckFactory();
		GameClass newGame = new GameClass(standardFactory, 1, 1, 14);
		newGame.deal();
		List<Hand> hand = newGame.getGameHand();

		StandardDeckClass oneDeck = new StandardDeckClass();

		Hand hand1 = hand.get(0);
		hand1.sort("bYsuIT");

		for (int i = 0; i < 13; i++) {
			Card handPulled = hand1.pullCard();
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

		DeckFactory standardFactory = new DeckFactory();
		GameClass newGame = new GameClass(standardFactory, 1, 1, 14);
		newGame.deal();
		List<Hand> hand = newGame.getGameHand();

		Hand hand1 = hand.get(0);
		hand1.sort("BYboth");

		Card pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "2", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "2", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "diamond", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "3", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "4", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "5", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "6", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "7", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "8", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "9", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "10", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "J", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "Q", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "K", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
		pulled = hand1.pullCard();
		assertEquals("Incorrect sorted card order in hand", "A", pulled.getRank().getName());
		assertEquals("Incorrect sorted card order in hand", "spade", pulled.getSuit().getName());
	}

	/**
	 * Tests the sort method in Hand class with an illegal parameter.
	 */
	@Test
	public void testSortInHandWithIllegalValue() {

		DeckFactory standardFactory = new DeckFactory();
		GameClass newGame = new GameClass(standardFactory, 1, 1, 25);
		newGame.deal();
		List<Hand> hand = newGame.getGameHand();

		Hand hand1 = hand.get(0);
		String expected = "Cannot sort by value. Can only sort either by rank, suit or both.";
		try {
			hand1.sort("value");
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
