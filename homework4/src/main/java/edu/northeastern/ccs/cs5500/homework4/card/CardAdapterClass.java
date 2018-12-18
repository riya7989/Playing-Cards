package edu.northeastern.ccs.cs5500.homework4.card;

import edu.northeastern.ccs.cs5500.homework4.diErbao.Ka;
import edu.northeastern.ccs.cs5500.homework4.diErbao.KaShiXia;
import edu.northeastern.ccs.cs5500.homework4.rank.Rank;
import edu.northeastern.ccs.cs5500.homework4.rank.RankClass;
import edu.northeastern.ccs.cs5500.homework4.rank.RankEnum;
import edu.northeastern.ccs.cs5500.homework4.suit.Suit;
import edu.northeastern.ccs.cs5500.homework4.suit.SuitClass;
import edu.northeastern.ccs.cs5500.homework4.suit.SuitEnum;

/**
 * Class that adapts a Chinese card into an American one.
 * @author Riya Nadkarni
 * @version 10-17-2018
 */
public class CardAdapterClass implements Card {

	/** The Chinese card we are adapting into an American one. */
	private Ka ka;
	
	/**
	 * Constructor for the card.
	 * @param rank	the rank of the card
	 * @param suit	the suit of the card
	 */
	public CardAdapterClass(int rank, int suit) {
		ka = new KaShiXia(rank, suit);
	}
	
	@Override
	public Rank getRank() {
				
		int rank = ka.getRank();
		
		Rank newRank = null;
		RankEnum[] allRanks = RankEnum.values();
		
		for (RankEnum currentRank : allRanks) {
			if (rank == currentRank.ordinal()) {
				newRank = new RankClass (currentRank);
			}
		}
		
		return newRank;
	}

	@Override
	public Suit getSuit() {
		
		int suit = ka.getSuit();
		
		Suit newSuit = null;
		SuitEnum[] allSuits = SuitEnum.values();
		
		for (SuitEnum currentSuit : allSuits) {
			if (suit == currentSuit.ordinal()) {
				newSuit = new SuitClass (currentSuit);
			}
		}
		
		return newSuit;
	}
	
	@Override
	public int compareTo(Card other) {

		int result = 0;

		int rankOrder = getRank().compareTo(other.getRank());
		int suitOrder = getSuit().compareTo(other.getSuit());

		if (rankOrder < 0) {
			result = -1;
		} else if (rankOrder > 0) {
			result = 1;
		} else {
			result = suitOrder;
		}

		return result;
	}
	
	@Override
	public boolean equals(Object other) {
		
		if (!(other instanceof CardAdapterClass)) {
			throw new IllegalArgumentException("Invalid card");
		}
		CardAdapterClass realCard = (CardAdapterClass) other;
		int rankNumber = -1;
		int suitNumber = -1;
		
		RankEnum[] allRanks = RankEnum.values();
		SuitEnum[] allSuits = SuitEnum.values();
		
		for (RankEnum rank : allRanks) {
			if (realCard.getRank().getName().equals(rank.getName())) {
				rankNumber = rank.ordinal();
			}
		}
		
		for (SuitEnum suit : allSuits) {
			if (realCard.getSuit().getName().equals(suit.getName())) {
				suitNumber = suit.ordinal();
			}
		}
		
		if (rankNumber == -1) {
			throw new IllegalArgumentException("Rank not found");
		} else if (suitNumber == -1) {
			throw new IllegalArgumentException("Suit not found");
		}
		return ka.equals(new KaShiXia(rankNumber, suitNumber));
	}
	
	@Override
	public int hashCode() {
		
		return ka.hashCode();
	}

}
