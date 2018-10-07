package problem2;

/**
 * The class that implements the Euchre interface. It simulates a deck of cards
 * in the Euchre game.
 * 
 * @author Riya Nadkarni
 * @version 09-26-2018
 */
public class EuchreDeckClass extends AbstractDeck implements Euchre {

	/**
	 * Default Constructor for the deck of cards.
	 */
	public EuchreDeckClass() {
		this(1);
	}

	/**
	 * Constructor for the deck of cards.
	 * 
	 * @param numberOfDecks the total number of decks
	 * @throws IllegalArgumentException if the number of decks is less than 1
	 */
	public EuchreDeckClass(int numberOfDecks) {

		if (numberOfDecks < 1) {
			throw new IllegalArgumentException("Minimum number of decks should be 1.");
		}

		RankEnum[] allRanks = RankEnum.values();
		for (int i = 0; i < numberOfDecks; i++) {
			for (SuitEnum currentSuit : SuitEnum.values()) {
				for (int j = 7; j < allRanks.length; j++) {
					Rank cardRank = new RankClass(allRanks[j]);
					Suit cardSuit = new SuitClass(currentSuit);
					Card newCard = new CardClass(cardRank, cardSuit);
					accept(newCard);
				}
			}
		}
		setOfficialSize(24);
	}
}
