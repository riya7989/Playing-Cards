package edu.northeastern.ccs.cs5500.homework5.hand;

/**
 * Interface for the iterator on a hand.
 * @author Riya Nadkarni
 * @version 10-30-2018
 * @param <T>	the type of element to iterate over
 */
public interface HandIterator<T> {

	/**
	 * Checks whether the collection has any more elements to iterate over.
	 * @return	true if more elements present, false otherwise.
	 */
	public boolean hasNext();
	
	/**
	 * Checks the next element to iterate over.
	 * @return	next element in the collection to iterate over
	 */
	public T next();
}
