package edu.northeastern.ccs.cs5500.homework5;

import edu.northeastern.ccs.cs5500.homework5.deck.Deck;
import edu.northeastern.ccs.cs5500.homework5.deck.DeckFactory;

/**
 * Factory that creates the Mock decks.
 * @author Riya Nadkarni
 * @version 10-28-2018
 */
public class MockDeckFactory extends DeckFactory {

	/**
	 * Creates mock decks.
	 * 
	 * @return a mock deck
	 */
	@Override
	public Deck makeDeck() {
		return new MockDeck();
	}

	/**
	 * Creates a number of mock decks.
	 *
	 * @param numberOfDecks the number of decks
	 * @return a specified number of mock decks
	 * @throws IllegalArgumentException if the number of decks is less than 2
	 */
	@Override
	public Deck makeDeck(int numberOfDecks) {

		if (numberOfDecks < 2) {
			throw new IllegalArgumentException("Minimum number of decks should be 2.");
		}
		return new MockDeck(numberOfDecks);
	}

}
