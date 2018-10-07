package problem1;

import java.util.List;

/**
 * Interface implemented by the deck of cards.
 * 
 * @author Riya Nadkarni
 * @version 09-23-2018
 */
public interface Deck {

	/**
	 * Changes the order of cards in the deck in a random fashion.
	 */
	void shuffle();

	/**
	 * Sorts the deck by the order specified (by Suit/by Rank/by both).
	 * 
	 * @param byOrder parameter to sort by
	 * @throws IllegalArgumentException if the parameter is other than rank, suit or
	 *                                  both
	 */
	void sort(String byOrder);

	/**
	 * Cuts the deck in 2 parts.
	 * 
	 * @param cutPoint the point at which to cut the deck
	 */
	void cut(int cutPoint);

	/**
	 * Removes cards (played or passed) from the hand.
	 * 
	 * @return the card that was removed
	 */
	Card pullCard();

	/**
	 * Checks whether the deck is empty.
	 * 
	 * @return true if empty, false otherwise
	 */
	Boolean emptyDeck();

	/**
	 * Official number of cards in a particular deck.
	 * 
	 * @return length the number of cards in the deck.
	 */
	int officialSize();

	/**
	 * Accessor for the collection of cards making up the deck.
	 * 
	 * @return cards in the deck
	 */
	List<Card> getCards();

	/**
	 * Accessor for the length of card collection, i.e., the total number of cards
	 * in the deck.
	 * 
	 * @return length the number of cards in the deck.
	 */
	int getLength();

}
