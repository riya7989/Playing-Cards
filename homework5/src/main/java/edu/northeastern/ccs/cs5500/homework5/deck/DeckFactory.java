package edu.northeastern.ccs.cs5500.homework5.deck;

/**
 * A factory that creates Standard decks.
 * 
 * @author Riya Nadkarni
 * @version 10-02-2018
 */
public class DeckFactory {

	/**
	 * Creates standard decks.
	 * 
	 * @return a standard deck
	 */
	public Deck makeDeck() {
		return new StandardDeckClass();
	}

	/**
	 * Creates a number of standard decks.
	 *
	 * @param numberOfDecks the number of decks
	 * @return a specified number of standard decks
	 * @throws IllegalArgumentException if the number of decks is less than 1
	 */
	public Deck makeDeck(int numberOfDecks) {

		if (numberOfDecks < 1) {
			throw new IllegalArgumentException("Minimum number of decks should be 1.");
		}
		return new StandardDeckClass(numberOfDecks);
	}

}
