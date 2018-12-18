package edu.northeastern.ccs.cs5500.homework3.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework3.deck.DeckFactory;
import edu.northeastern.ccs.cs5500.homework3.deck.EuchreDeckFactory;
import edu.northeastern.ccs.cs5500.homework3.deck.PinochleDeckFactory;
import edu.northeastern.ccs.cs5500.homework3.deck.VegasDeckFactory;

/**
 * Tests that verify whether the Game object works as expected.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class GameTest {

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

}
