package problem1;

/**
 * Interface implemented by the Game of Cards.
 * 
 * @author Riya Nadkarni
 * @version 09-23-2018
 */
public interface Game {

	/**
	 * Creates a deck of a certain type.
	 * 
	 * @param deckType the type of deck to be created
	 * @throws IllegalArgumentException for invalid deckType
	 */
	void createDeck(String deckType);

	/**
	 * Creates deck as per the amount and type specified.
	 * 
	 * @param deckType      the type of deck to be created
	 * @param numberOfDecks number of decks to be created
	 * @throws IllegalArgumentException for invalid deckType or if number of decks
	 *                                  is less than 2
	 */
	void createDeck(String deckType, int numberOfDecks);

	/**
	 * Mutator for the number of hands in the game.
	 * 
	 * @param numberOfHands number of hands in the game
	 * @throws IlleglArgumentException if the number of hands is negative or more
	 *                                 than can be made out of the cards in the deck
	 */
	void setNumberOfHands(int numberOfHands);

	/**
	 * Deals the cards for the game.
	 */
	void deal();
}
