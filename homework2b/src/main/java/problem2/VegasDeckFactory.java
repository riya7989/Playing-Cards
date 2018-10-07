package problem2;

/**
 * A factory that creates Vegas decks.
 * 
 * @author Riya Nadkarni
 * @version 10-02-2018
 */
public class VegasDeckFactory extends DeckFactory {

	/**
	 * Creates vegas decks.
	 * 
	 * @return a vegas deck
	 */
	@Override
	public Deck makeDeck() {
		return new VegasDeckClass();
	}

	/**
	 * Creates a number of vegas decks.
	 *
	 * @param numberOfDecks the number of decks
	 * @return a specified number of vegas decks
	 * @throws IllegalArgumentException if the number of decks is less than 2
	 */
	@Override
	public Deck makeDeck(int numberOfDecks) {

		if (numberOfDecks < 2) {
			throw new IllegalArgumentException("Minimum number of decks should be 2.");
		}
		return new VegasDeckClass(numberOfDecks);
	}
}
