package edu.northeastern.ccs.cs5500.homework4.card;

import edu.northeastern.ccs.cs5500.homework4.rank.Rank;
import edu.northeastern.ccs.cs5500.homework4.suit.Suit;

/**
 * Interface implemented by a card.
 * 
 * @author Riya Nadkarni
 * @version 09-23-2018
 */
public interface Card extends Comparable<Card> {

	/**
	 * Accessor for the rank of a card.
	 * 
	 * @return the rank of a card
	 */
	Rank getRank();

	/**
	 * Accessor for the suit of a card.
	 * 
	 * @return the suit of a card
	 */
	Suit getSuit();

}
