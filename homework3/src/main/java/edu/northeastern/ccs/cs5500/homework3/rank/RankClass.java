package edu.northeastern.ccs.cs5500.homework3.rank;


/**
 * The class that implements the Rank interface. It holds information about the
 * Rank of a Card.
 * 
 * @author Riya Nadkarni
 * @version 09-24-2018
 */
public class RankClass implements Rank {

	/** The rank associated with a card. */
	private RankEnum rank;

	/**
	 * Constructor for the rank of the card.
	 * 
	 * @param rankValue the rank value of the card
	 */
	public RankClass(RankEnum rankValue) {

		rank = rankValue;
	}

	@Override
	public String getName() {
		return rank.getName();
	}

	@Override
	public int getPips() {
		return rank.getPips();
	}

	/**
	 * Returns the rank of the card based on the string parameter.
	 * 
	 * @param name the name denoting the rank
	 * @return the rank corresponding to the name
	 */
	public static RankEnum getRank(String name) {
		RankEnum result = null;
		boolean found = false;

		RankEnum[] allRanks = RankEnum.values();
		int index = 0;

		while (index < allRanks.length && !found) {
			if (name.equalsIgnoreCase(allRanks[index].getName())) {
				result = allRanks[index];
				found = true;
			}
			index += 1;
		}

		return result;
	}

	@Override
	public int compareTo(Rank other) {

		if (!(other instanceof RankClass)) {
			throw new IllegalArgumentException("Cannot compare 2 different objects.");
		}
		RankClass real = (RankClass) other;
		return rank.compareTo(real.rank);
	}
	
	/**
	 * Checks whether 2 ranks are equal.
	 * 
	 * @param other the rank to compare to
	 * @return true if equal and false if not
	 */
	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof RankClass) {
			RankClass otherRank = (RankClass) other;
			result = (getName().equals(otherRank.getName()));
		}
		return result;
	}

	@Override
	public int hashCode() {
		return (getName().hashCode());
	}

}
