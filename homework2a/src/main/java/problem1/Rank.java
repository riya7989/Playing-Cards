package problem1;

/**
 * Interface implemented by the rank of a card.
 * 
 * @author Riya Nadkarni
 * @version 09-23-2018
 */
public interface Rank extends Comparable<Rank> {

	/**
	 * Accessor for the name of the rank of a card.
	 * 
	 * @return the name of the rank of the card
	 */
	String getName();

	/**
	 * Accessor for the pip of a card.
	 * 
	 * @return the integer value of a card
	 */
	int getPips();

}
