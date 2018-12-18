package edu.northeastern.ccs.cs5500.homework5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.northeastern.ccs.cs5500.homework5.card.Card;
import edu.northeastern.ccs.cs5500.homework5.card.CardClass;
import edu.northeastern.ccs.cs5500.homework5.card.CardRankComparator;
import edu.northeastern.ccs.cs5500.homework5.card.CardSuitComparator;
import edu.northeastern.ccs.cs5500.homework5.deck.Deck;
import edu.northeastern.ccs.cs5500.homework5.rank.Rank;
import edu.northeastern.ccs.cs5500.homework5.rank.RankClass;
import edu.northeastern.ccs.cs5500.homework5.rank.RankEnum;
import edu.northeastern.ccs.cs5500.homework5.suit.Suit;
import edu.northeastern.ccs.cs5500.homework5.suit.SuitClass;
import edu.northeastern.ccs.cs5500.homework5.suit.SuitEnum;

/**
 * Class that mocks the functionality of a Deck for the purpose of testing the
 * BlackJackGame class.
 * 
 * @author Riya Nadkarni
 * @version 10-28-2018
 */
public class MockDeck implements Deck {

	/** The card collection making up a deck. */
	private List<Card> deck;

	/** The official number of cards in a particular deck. */
	private int officialSize;

	/**
	 * Default Constructor for the mock deck.
	 */
	public MockDeck() {
		this(1);
	}

	/**
	 * Constructor for the mock deck.
	 * 
	 * @param numberOfDecks the total number of decks
	 * @throws IllegalArgumentException if the number of decks is less than 1
	 */
	public MockDeck(int numberOfDecks) {

		deck = new ArrayList<>();

		if (numberOfDecks < 1) {
			throw new IllegalArgumentException("Minimum number of decks should be 1.");
		}

		RankEnum[] selectedRanks = { RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.ACE, RankEnum.QUEEN, RankEnum.EIGHT,
				RankEnum.SIX, RankEnum.EIGHT, RankEnum.TWO, RankEnum.JACK, RankEnum.FIVE, RankEnum.NINE, RankEnum.FOUR,
				RankEnum.NINE, RankEnum.TWO, RankEnum.THREE, RankEnum.ACE, RankEnum.KING };
		SuitEnum[] selectedSuits = { SuitEnum.SPADE, SuitEnum.HEART, SuitEnum.CLUB, SuitEnum.DIAMOND, SuitEnum.SPADE,
				SuitEnum.HEART, SuitEnum.CLUB, SuitEnum.DIAMOND, SuitEnum.SPADE, SuitEnum.HEART, SuitEnum.CLUB,
				SuitEnum.DIAMOND, SuitEnum.SPADE, SuitEnum.HEART, SuitEnum.CLUB, SuitEnum.DIAMOND, SuitEnum.HEART };

		int i = 0;
		int j = 0;

		while ((i < selectedRanks.length) && (j < selectedSuits.length)) {
			Rank cardRank = new RankClass(selectedRanks[i]);
			Suit cardSuit = new SuitClass(selectedSuits[j]);
			Card newCard = new CardClass(cardRank, cardSuit);
			accept(newCard);
			i += 1;
			j += 1;
		}
		setOfficialSize(17);
	}

	/**
	 * Mutator for the official size.
	 * 
	 * @param newSize new size of the deck
	 */
	protected void setOfficialSize(int newSize) {
		officialSize = newSize;
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
	public void shuffle() {
		deck.add(null);
		deck.remove(null);
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

	@Override
	public int getLength() {
		return deck.size();
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
		if (other instanceof MockDeck) {
			MockDeck otherDeck = (MockDeck) other;
			result = getCards().equals(otherDeck.getCards());
		}
		return result;
	}

	@Override
	public int hashCode() {
		return (getCards().hashCode());
	}

}
