package problem2;

/**
 * Enumeration that holds the values to be given to the card suit.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public enum SuitEnum {

	/** The black spade suit. */
	SPADE("spade", '\u2660'),

	/** The black diamond suit. */
	DIAMOND("diamond", '\u2666'),

	/** The black club suit. */
	CLUB("club", '\u2663'),

	/** The black heart suit. */
	HEART("heart", '\u2665');

	/** Name of the suit. */
	private final String suitName;

	/** Symbol of the suit. */
	private final char symbol;

	/**
	 * Constructor for the suit for a card.
	 * 
	 * @param suit   the suit of the card
	 * @param symbol the symbol corresponding to the suit
	 */
	private SuitEnum(String suit, char symbol) {
		suitName = suit;
		this.symbol = symbol;
	}

	/**
	 * Accessor for the name of the card suit.
	 * 
	 * @return name of the suit
	 */
	public String getName() {
		return suitName;
	}

	/**
	 * Accessor for the symbol representing the suit.
	 * 
	 * @return symbol representing the suit
	 */
	public char getSymbol() {
		return symbol;
	}

}
