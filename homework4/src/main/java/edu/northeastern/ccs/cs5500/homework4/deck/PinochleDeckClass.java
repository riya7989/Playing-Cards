package edu.northeastern.ccs.cs5500.homework4.deck;

import edu.northeastern.ccs.cs5500.homework4.card.Card;
import edu.northeastern.ccs.cs5500.homework4.card.CardClass;
import edu.northeastern.ccs.cs5500.homework4.rank.Rank;
import edu.northeastern.ccs.cs5500.homework4.rank.RankClass;
import edu.northeastern.ccs.cs5500.homework4.rank.RankEnum;
import edu.northeastern.ccs.cs5500.homework4.suit.Suit;
import edu.northeastern.ccs.cs5500.homework4.suit.SuitClass;
import edu.northeastern.ccs.cs5500.homework4.suit.SuitEnum;

/**
 * The class that implements the Pinochle interface. It simulates a deck of
 * cards in the Pinochle game.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class PinochleDeckClass extends AbstractDeck implements Pinochle {

	/**
	 * Default Constructor for the deck of cards.
	 */
	public PinochleDeckClass() {
		this(1);
	}

	/**
	 * Constructor for the deck of cards.
	 * 
	 * @param numberOfDecks the total number of decks
	 * @throws IllegalArgumentException if the number of decks is less than 1
	 */
	public PinochleDeckClass(int numberOfDecks) {

		if (numberOfDecks < 1) {
			throw new IllegalArgumentException("Minimum number of decks should be 1.");
		}

		RankEnum[] allRanks = RankEnum.values();

		for (int i = 0; i < 2 * numberOfDecks; i++) {
			for (SuitEnum currentSuit : SuitEnum.values()) {
				for (int j = 7; j < allRanks.length; j++) {
					Rank cardRank = new RankClass(allRanks[j]);
					Suit cardSuit = new SuitClass(currentSuit);
					Card newCard = new CardClass(cardRank, cardSuit);
					accept(newCard);
				}
			}
		}
		setOfficialSize(48);
	}
}
