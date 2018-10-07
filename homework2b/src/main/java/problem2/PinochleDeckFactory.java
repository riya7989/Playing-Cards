package problem2;

/**
 * A factory that creates Pinochle decks.
 * 
 * @author Riya Nadkarni
 * @version 10-02-2018
 */
public class PinochleDeckFactory extends DeckFactory {

	/**
	 * Creates pinochle decks.
	 * 
	 * @return a pinochle deck
	 */
	@Override
	public Deck makeDeck() {
		return new PinochleDeckClass();
	}

	/**
	 * Creates a number of pinochle decks.
	 *
	 * @param numberOfDecks the number of decks
	 * @return a specified number of pinochle decks
	 * @throws IllegalArgumentException if the number of decks is less than 1
	 */
	@Override
	public Deck makeDeck(int numberOfDecks) {

		if (numberOfDecks < 1) {
			throw new IllegalArgumentException("Minimum number of decks should be 1.");
		}
		return new PinochleDeckClass(numberOfDecks);
	}
}
