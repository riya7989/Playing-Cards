package problem2;

/**
 * The class that implements the Vegas interface. It simulates a deck of cards
 * in the Vegas Blackjack game.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class VegasDeckClass extends AbstractDeck implements Vegas {

	/**
	 * Constructor for the deck of cards.
	 */
	public VegasDeckClass() {
		this(6);
	}

	/**
	 * Constructor for the deck of cards.
	 * 
	 * @param numberOfDecks the number of standard decks
	 * @throws IllegalArgumentException if the number of decks is less than 2
	 */
	public VegasDeckClass(int numberOfDecks) {

		if (numberOfDecks < 2) {
			throw new IllegalArgumentException("Minimum number of decks should be 2.");
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
		setOfficialSize(312);
	}
}
