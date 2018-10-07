package problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The class that implements the Hand interface. It holds information about the
 * Hand of Cards.
 * 
 * @author Riya Nadkarni
 * @version 09-26-2018
 */
public class HandClass implements Hand {

	/** Collection of cards in a hand. */
	private List<Card> cards;

	/**
	 * Constructor for the hand class.
	 */
	public HandClass() {

		cards = new ArrayList<>();
	}

	@Override
	public List<Card> showCards() {

		List<Card> tempCards = new ArrayList<>();

		for (int i = 0; i < cards.size(); i++) {
			tempCards.add(cards.get(i));
		}
		return tempCards;
	}

	@Override
	public void accept(Card received) {

		cards.add(received);
	}

	@Override
	public void accept(List<Card> received) {

		for (int i = 0; i < received.size(); i++) {
			cards.add(received.get(i));
		}
	}

	@Override
	public Card pullCard() {
		return cards.remove(0);
	}

	@Override
	public boolean hasCard(Card toCheck) {
		boolean found = false;
		int index = 0;

		while (index < cards.size() && !found) {
			if ((cards.get(index).getRank().getName().equals(toCheck.getRank().getName()))
					&& (cards.get(index).getSuit().getName().equals(toCheck.getSuit().getName()))) 
			{
				found = true;
			}
			index += 1;
		}
		return found;
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
			Collections.sort(cards);
			break;

		default:
			throw new IllegalArgumentException(
					"Cannot sort by " + byOrder + ". Can only sort either by rank, suit or both.");
		}
	}

	/**
	 * Sorts the hand by order of suit.
	 */
	private void sortBySuit() {

		Comparator<Card> suitSort = new CardSuitComparator();
		Collections.sort(cards, suitSort);

	}

	/**
	 * Sorts the hand by order of rank.
	 */
	private void sortByRank() {

		Comparator<Card> rankSort = new CardRankComparator();
		Collections.sort(cards, rankSort);

	}

	@Override
	public void shuffle() {

		Collections.shuffle(cards);
	}

	/**
	 * Checks whether 2 hands are equal.
	 * 
	 * @param other the hand to compare to
	 * @return true if equal and false if not
	 */
	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof HandClass) {
			HandClass otherHand = (HandClass) other;
			result = (showCards().equals(otherHand.showCards()));
		}
		return result;
	}

	@Override
	public int hashCode() {
		return (showCards().hashCode());
	}

}
