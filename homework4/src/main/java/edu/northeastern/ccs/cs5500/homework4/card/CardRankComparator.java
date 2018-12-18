package edu.northeastern.ccs.cs5500.homework4.card;

import java.util.Comparator;

/**
 * The comparator class that sorts the deck by order of their ranks.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class CardRankComparator implements Comparator<Card> {

	@Override
	public int compare(Card one, Card two) {

		return one.getRank().compareTo(two.getRank());

	}
}
