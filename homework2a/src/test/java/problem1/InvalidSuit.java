package problem1;

/**
 * Dummy class to make sure that the compareTo method in SuitClass throws an exception as expected.
 * @author Riya Nadkarni
 * @version 10-02-2018
 */
public class InvalidSuit implements Suit {

	@Override
	public int compareTo(Suit o) {
		return 0;
	}

	@Override
	public String getName() {
		return "Invalid Suit";
	}

	@Override
	public char getSymbol() {
		return '0';
	}

}
