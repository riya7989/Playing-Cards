package problem2;

/**
 * Interface implemented by the suit of a card.
 * 
 * @author Riya Nadkarni
 * @version 09-23-2018
 */
public interface Suit extends Comparable<Suit> {

	/**
	 * Accessor for the name of the symbol on a card.
	 * 
	 * @return the rank of the card
	 */
	String getName();

	/**
	 * Accessor for the symbol of a card.
	 * 
	 * @return the name of the symbol on the card
	 */
	char getSymbol();
}
