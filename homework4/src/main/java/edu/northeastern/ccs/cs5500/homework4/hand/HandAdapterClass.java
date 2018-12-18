package edu.northeastern.ccs.cs5500.homework4.hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import edu.northeastern.ccs.cs5500.homework4.card.Card;
import edu.northeastern.ccs.cs5500.homework4.card.CardAdapterClass;
import edu.northeastern.ccs.cs5500.homework4.card.KaRankAndSuitComparator;
import edu.northeastern.ccs.cs5500.homework4.card.KaSuitComparator;
import edu.northeastern.ccs.cs5500.homework4.diErbao.Ka;
import edu.northeastern.ccs.cs5500.homework4.diErbao.KaShiXia;
import edu.northeastern.ccs.cs5500.homework4.diErbao.ShouShiXia;
import edu.northeastern.ccs.cs5500.homework4.rank.Rank;
import edu.northeastern.ccs.cs5500.homework4.rank.RankEnum;
import edu.northeastern.ccs.cs5500.homework4.suit.SuitEnum;

/**
 * Class that adapts a Chinese hand into an American one.
 * @author Riya Nadkarni
 * @version 10-19-2018
 */
public class HandAdapterClass implements IterableHand {

	/** The Chinese hand we are adapting into an American one. */
	private ShouShiXia shou;
	
	/**
	 * Default constructor for the hand.
	 */
	public HandAdapterClass() {
		shou = new ShouShiXia();
	}

	@Override
	public List<Card> showCards() {
		
		List<Ka> chineseCards = shou.showHand();
		
		List<Card> adaptedHand = new ArrayList<>();
	
		for (Ka card : chineseCards) {
			adaptedHand.add(new CardAdapterClass(card.getRank(), card.getSuit()));
		}
		return adaptedHand;
	}

	@Override
	public void accept(Card received) {
		
		shou.accept(convertCardToKa(received));
	}

	@Override
	public void accept(List<Card> received) {
		
		for (Card currentCard : received) {
			shou.accept(convertCardToKa(currentCard));
		}
	}

	@Override
	public Card pullCard() {
		
		Ka pulledKa = shou.pullKa();
		return new CardAdapterClass(pulledKa.getRank(), pulledKa.getSuit());
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
			sortByBoth();
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

		Comparator<Ka> suitSort = new KaSuitComparator();
		List<Ka> newShou = shou.showHand();
		Collections.sort(newShou, suitSort);
		
		int size = shou.getHandSize();

		for (int i = 0; i < size; i++) {
			shou.pullKa();
		}
		
		for (int i = 0; i < newShou.size(); i++) {
			shou.accept(newShou.get(i));
		}
	}

	/**
	 * Sorts the hand by order of rank.
	 */
	private void sortByRank() {
	
		shou.sort();

	}
	
	/**
	 * Sorts the hand by order of rank and suit.
	 */
	private void sortByBoth() {

		Comparator<Ka> dualSort = new KaRankAndSuitComparator();
		List<Ka> newShou = shou.showHand();
		Collections.sort(newShou, dualSort);
		
		int size = shou.getHandSize();
		for (int i = 0; i < size; i++) {
			shou.pullKa();
		}
		
		for (int i = 0; i < newShou.size(); i++) {
			shou.accept(newShou.get(i));
		}

	}

	@Override
	public void shuffle() {
		shou.shuffle();

	}

	@Override
	public boolean hasCard(Card toCheck) {
		
		return shou.hasKa(convertCardToKa(toCheck));
	}

	@Override
	public int occurrencesInHand(Card toCheck) {
		
		int cardCount = 0;
		HandIterator<Card> cardIter = this.iterator();

		while (cardIter.hasNext()) {
			Card currentCard = cardIter.next();
			if (currentCard.equals(toCheck)) {
				cardCount += 1;
			}
		}
		return cardCount;
	}

	@Override
	public int occurrencesInHand(Rank toCheck) {

		int rankCount = 0;
		HandIterator<Card> rankIter = this.iterator();
		while (rankIter.hasNext()) {
			Rank currentRank = rankIter.next().getRank();
			if (currentRank.equals(toCheck)) {
				rankCount += 1;
			}
		}
		return rankCount;
	}

	@Override
	public HandIterator<Card> iterator() {
		return new HandKaIterator();
	}
	
	/**
	 * Converts a given card to its Chinese equivalent (Ka).
	 * @param toConvert	the card to convert to a Ka
	 * @return	the Chinese equivalent of the card.
	 */
	private Ka convertCardToKa(Card toConvert) {
		
		int rankNumber = getRankNumber(toConvert);
		int suitNumber = getSuitNumber(toConvert);
		
		return new KaShiXia(rankNumber, suitNumber);
	}
	
	/**
	 * Retrieves the rank for a Ka corresponding to the Card.
	 * @param toConvert	the card
	 * @return the rank of the card
	 */
	private int getRankNumber(Card toConvert) {
		
		int rankNumber = -1;
		RankEnum[] allRanks = RankEnum.values();
		
		for (RankEnum rank : allRanks) {
			if (toConvert.getRank().getName().equals(rank.getName())) {
				rankNumber = rank.ordinal();
			}
		}
		
		if (rankNumber == -1) {
			throw new IllegalArgumentException("Rank could not correspond");
		}
		return rankNumber;
		
	}
	
	/**
	 * Retrieves the suit for a Ka corresponding to the Card.
	 * @param toConvert	the card
	 * @return the suit of the card
	 */
	private int getSuitNumber(Card toConvert) {
		
		int suitNumber = -1;
		SuitEnum[] allSuits = SuitEnum.values();
		
		for (SuitEnum suit : allSuits) {
			if (toConvert.getSuit().getName().equals(suit.getName())) {
				suitNumber = suit.ordinal();
			}
		}
		
		if (suitNumber == -1) {
			throw new IllegalArgumentException("Suit could not correspond");
		}
		return suitNumber;
		
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
		if (!(other instanceof HandAdapterClass)) {
			throw new IllegalArgumentException("Invalid hand");
		}
		HandAdapterClass otherHand = (HandAdapterClass) other;
		result = (showCards().equals(otherHand.showCards()));
		return result;
	}

	@Override
	public int hashCode() {
		return (showCards().hashCode());
	}
	
	/**
	 * Private class that helps iterate over a Hand.
	 * 
	 * @author Riya Nadkarni
	 * @version 10-12-2018
	 */
	private class HandKaIterator implements HandIterator<Card> {

		/** The current position. */
		private int cursor;

		/** Default constructor. */
		public HandKaIterator() {
			cursor = 0;
		}

		@Override
		public boolean hasNext() {
			return cursor < showCards().size();
		}

		@Override
		public Card next() {

			Card result = null;
			if (hasNext()) {
				result = showCards().get(cursor);
				cursor += 1;
			} else {
				throw new NoSuchElementException();
			}
			
			return result;
		}

	}
	
	
}
