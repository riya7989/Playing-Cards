package edu.northeastern.ccs.cs5500.homework5.hand;

/**
 * The iterable interface for a hand.
 * @author Riya Nadkarni
 * @version 10-30-2018
 * @param <T>	the element to iterate over
 */
public interface HandIterable<T> {

	/** The actual iterator.
	 * 
	 * @return	instance of iterator for the hand
	 */
	HandIterator<T> iterator();
}
