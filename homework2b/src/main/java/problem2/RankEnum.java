package problem2;

/**
 * Enumeration that holds the values to be given to the card rank.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public enum RankEnum {

	/** The rank two. */
	TWO("2", 2),

	/** The rank three. */
	THREE("3", 3),

	/** The rank four. */
	FOUR("4", 4),

	/** The rank five. */
	FIVE("5", 5),

	/** The rank six. */
	SIX("6", 6),

	/** The rank seven. */
	SEVEN("7", 7),

	/** The rank eight. */
	EIGHT("8", 8),

	/** The rank nine. */
	NINE("9", 9),

	/** The rank ten. */
	TEN("10", 10),

	/** The jack of cards. */
	JACK("J", 0),

	/** The queen of cards. */
	QUEEN("Q", 0),

	/** The king of cards. */
	KING("K", 0),

	/** The ace of cards. */
	ACE("A", 0);

	/** Name of the rank. */
	private final String rankName;

	/** Pip of the rank (if applicable). */
	private final int pips;

	/**
	 * Constructor for the rank.
	 * 
	 * @param rankValue the rank to be assigned to the card
	 * @param pipValue  the integer value of the rank
	 */
	private RankEnum(String rankValue, int pipValue) {

		rankName = rankValue;
		pips = pipValue;

	}

	/**
	 * Accessor for the name of the card rank.
	 * 
	 * @return name of the rank
	 */
	public String getName() {
		return rankName;
	}

	/**
	 * Accessor for the value of the rank.
	 * 
	 * @return value of the rank
	 */
	public int getPips() {
		return pips;
	}

}