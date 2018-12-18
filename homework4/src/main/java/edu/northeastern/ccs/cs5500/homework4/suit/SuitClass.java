package edu.northeastern.ccs.cs5500.homework4.suit;

/**
 * The class that implements the Suit interface. It holds information about the
 * Suit of a Card.
 * 
 * @author Riya Nadkarni
 * @version 09-24-2018
 */
public class SuitClass implements Suit {

	/** The suit of the card. */
	private SuitEnum suit;

	/**
	 * Constructor for the card suit.
	 * 
	 * @param suitValue the value of the suit
	 */
	public SuitClass(SuitEnum suitValue) {

		suit = suitValue;
	}

	@Override
	public String getName() {
		return suit.getName();
	}

	@Override
	public char getSymbol() {
		return suit.getSymbol();
	}

	@Override
	public int compareTo(Suit other) {

		if (!(other instanceof SuitClass)) {
			throw new IllegalArgumentException("Cannot compare 2 different objects.");
		}
		SuitClass real = (SuitClass) other;
		return suit.compareTo(real.suit);
	}

	/**
	 * Returns the suit of the card based on the string parameter.
	 * 
	 * @param name the name denoting the suit
	 * @return the suit corresponding to the name
	 */
	public static SuitEnum getSuit(String name) {
		SuitEnum result = null;
		for (SuitEnum current : SuitEnum.values()) {
			if (name.equalsIgnoreCase(current.getName())) {
				result = current;
			}
		}
		return result;
	}
	
	/**
	 * Checks whether 2 suits are equal.
	 * 
	 * @param other the suit to compare to
	 * @return true if equal and false if not
	 */
	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof SuitClass) {
			SuitClass otherSuit = (SuitClass) other;
			result = (getName().equals(otherSuit.getName()));
		}
		return result;
	}

	@Override
	public int hashCode() {
		return (getName().hashCode());
	}

}
