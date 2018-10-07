package problem1;

/**
 * The class that implements the Standard interface. It simulates a standard
 * Deck of Cards.
 * 
 * @author Riya Nadkarni
 * @version 09-24-2018
 */
public class StandardDeckClass extends AbstractDeck implements Standard {

	/**
	 * Default Constructor for the deck of cards.
	 */
	public StandardDeckClass() {
		this(1);
	}

	/**
	 * Constructor for the deck of cards.
	 * 
	 * @param numberOfDecks the total number of decks
	 * @throws IllegalArgumentException if the number of decks is less than 1
	 */
	public StandardDeckClass(int numberOfDecks) {

		if (numberOfDecks < 1) {
			throw new IllegalArgumentException("Minimum number of decks should be 1.");
		}

		for (int i = 0; i < numberOfDecks; i++) {
			for (SuitEnum currentSuit : SuitEnum.values()) {
				for (RankEnum currentRank : RankEnum.values()) {
					Rank cardRank = new RankClass(currentRank);
					Suit cardSuit = new SuitClass(currentSuit);
					Card newCard = new CardClass(cardRank, cardSuit);
					accept(newCard);
				}
			}
		}
		setOfficialSize(52);
	}

}
