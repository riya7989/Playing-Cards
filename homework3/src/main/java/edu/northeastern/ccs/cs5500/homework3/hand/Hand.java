package edu.northeastern.ccs.cs5500.homework3.hand;

import java.util.List;

import edu.northeastern.ccs.cs5500.homework3.card.Card;

/**
 * Interface implemented by the Hand of cards.
 * 
 * @author Riya Nadkarni
 * @version 09-23-2018
 */
public interface Hand {

	/**
	 * Display of cards in the form of a list.
	 * 
	 * @return the list of cards in the hand
	 */
	List<Card> showCards();

	/**
	 * Adds new cards (won or replaced or received) to the hand.
	 * 
	 * @param received the card to be added to the hand
	 */
	void accept(Card received);

	/**
	 * Adds new cards (won or replaced or received) to the hand.
	 * 
	 * @param received the card to be added to the hand
	 */
	void accept(List<Card> received);

	/**
	 * Removes cards (played or passed) from the hand.
	 * 
	 * @return the card that was removed
	 */
	Card pullCard();

	/**
	 * Checks whether a particular card is in the hand or not.
	 * 
	 * @param toCheck the card to search for in the hand
	 * @return true if found, false otherwise
	 */
	boolean hasCard(Card toCheck);

	/**
	 * Sorts the hand by the order specified (by Suit/by Rank/by both).
	 * 
	 * @param byOrder the parameter by which to sort the hand
	 */
	void sort(String byOrder);

	/**
	 * Changes the order of cards in the deck in a random fashion.
	 */
	void shuffle();


}
