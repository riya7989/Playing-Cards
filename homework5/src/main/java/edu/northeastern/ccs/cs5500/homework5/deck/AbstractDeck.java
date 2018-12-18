package edu.northeastern.ccs.cs5500.homework5.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.northeastern.ccs.cs5500.homework5.card.Card;
import edu.northeastern.ccs.cs5500.homework5.card.CardRankComparator;
import edu.northeastern.ccs.cs5500.homework5.card.CardSuitComparator;

/**
 * The Abstract Deck class that creates and handles decks.
 * 
 * @author Riya Nadkarni
 * @version 10-01-2018
 */
public class AbstractDeck implements Deck {

	/** The card collection making up a deck. */
	private List<Card> deck;

	/** The official number of cards in a particular deck. */
	private int officialSize;

	/**
	 * Constructor for the deck.
	 */
	public AbstractDeck() {
		deck = new ArrayList<>();
		setOfficialSize(0);
	}

	@Override
	public void shuffle() {
		Collections.shuffle(deck);
	}

	@Override
	public void cut(int cutPoint) {

		for (int i = 1; i < cutPoint; i++) {
			Card removed = deck.remove(0);
			deck.add(removed);
		}
	}

	@Override
	public Card pullCard() {
		return deck.remove(0);

	}

	@Override
	public Boolean emptyDeck() {

		return (deck.isEmpty());
	}

	@Override
	public void sort(String byOrder) {

		switch (byOrder.toLowerCase()) {

		case "bysuit":
			sortBySuit();
			break;

		case "byrank":
			sortByRank();
			break;

		case "byboth":
			Collections.sort(deck);
			break;

		default:
			throw new IllegalArgumentException(
					"Cannot sort by " + byOrder + ". Can only sort either by rank, suit or both.");
		}
	}

	/**
	 * Sorts the deck by order of suit.
	 */
	private void sortBySuit() {

		Comparator<Card> suitSort = new CardSuitComparator();
		Collections.sort(deck, suitSort);
	}

	/**
	 * Sorts the deck by order of rank.
	 */
	private void sortByRank() {

		Comparator<Card> rankSort = new CardRankComparator();
		Collections.sort(deck, rankSort);
	}

	@Override
	public int getLength() {
		return deck.size();
	}

	/**
	 * Accepts cards into the deck.
	 * 
	 * @param card card to be added to the deck
	 */
	protected void accept(Card card) {
		deck.add(card);
	}

	@Override
	public List<Card> getCards() {

		List<Card> tempCards = new ArrayList<>();

		for (int i = 0; i < deck.size(); i++) {
			tempCards.add(deck.get(i));
		}
		return tempCards;
	}

	@Override
	public int officialSize() {
		return officialSize;
	}

	/**
	 * Mutator for the official size of the deck.
	 * 
	 * @param newOfficialSize new official size of the deck
	 */
	protected void setOfficialSize(int newOfficialSize) {
		officialSize = newOfficialSize;
	}

	/**
	 * Checks whether 2 cards are equal.
	 * 
	 * @param other the card to compare to
	 * @return true if equal and false if not
	 */
	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof AbstractDeck) {
			AbstractDeck otherDeck = (AbstractDeck) other;
			result = getCards().equals(otherDeck.getCards());
		}
		return result;
	}

	@Override
	public int hashCode() {
		return (getCards().hashCode());
	}

}
