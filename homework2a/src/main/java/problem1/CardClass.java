package problem1;

/**
 * The class that implements the Card interface. It holds information about the
 * Card.
 * 
 * @author Riya Nadkarni
 * @version 09-24-2018
 */
public class CardClass implements Card {

	/** Rank of the card. */
	private Rank rank;

	/** Suit of the card. */
	private Suit suit;

	/**
	 * Constructor for the Card.
	 * 
	 * @param rankValue new value of the rank of the card
	 * @param suitValue new value of the suit of the card
	 */
	public CardClass(Rank rankValue, Suit suitValue) {

		rank = rankValue;
		suit = suitValue;

	}

	/**
	 * Constructor for the Card.
	 * 
	 * @param rankValue new value of the rank of the card
	 * @param suitValue new value of the suit of the card
	 */
	public CardClass(String rankValue, String suitValue) {

		RankEnum tempRank = RankClass.getRank(rankValue);
		SuitEnum tempSuit = SuitClass.getSuit(suitValue);

		rank = new RankClass(tempRank);
		suit = new SuitClass(tempSuit);

	}

	@Override
	public Rank getRank() {
		return rank;
	}

	@Override
	public Suit getSuit() {
		return suit;
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

	/**
	 * Checks whether 2 cards are equal.
	 * 
	 * @param other the card to compare to
	 * @return true if equal and false if not
	 */
	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof CardClass) {
			CardClass otherCard = (CardClass) other;
			result = (getRank().getName().equals(otherCard.getRank().getName()))
					&& (getSuit().getName().equals(otherCard.getSuit().getName()));
		}
		return result;
	}

	@Override
	public int hashCode() {
		return (getRank().getName().hashCode() ^ getSuit().getName().hashCode());
	}

}
