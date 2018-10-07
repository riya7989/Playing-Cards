package problem2;

/**
 * A factory that creates Euchre decks.
 * 
 * @author Riya Nadkarni
 * @version 10-02-2018
 */
public class EuchreDeckFactory extends DeckFactory {

	/**
	 * Creates euchre decks.
	 * 
	 * @return a euchre deck
	 */
	@Override
	public Deck makeDeck() {
		return new EuchreDeckClass();
	}

	/**
	 * Creates a number of euchre decks.
	 *
	 * @param numberOfDecks the number of decks
	 * @return a specified number of euchre decks
	 * @throws IllegalArgumentException if the number of decks is less than 1
	 */
	@Override
	public Deck makeDeck(int numberOfDecks) {

		if (numberOfDecks < 1) {
			throw new IllegalArgumentException("Minimum number of decks should be 1.");
		}
		return new EuchreDeckClass(numberOfDecks);
	}
}
