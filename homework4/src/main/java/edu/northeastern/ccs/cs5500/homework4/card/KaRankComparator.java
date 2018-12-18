package edu.northeastern.ccs.cs5500.homework4.card;

import java.util.Comparator;

import edu.northeastern.ccs.cs5500.homework4.diErbao.Ka;

/**
 * The comparator class that sorts the Chinese cards by order of their rank.
 * 
 * @author Riya Nadkarni
 * @version 10-19-2018
 */
public class KaRankComparator implements Comparator<Ka> {

	@Override
	public int compare(Ka one, Ka two) {
		
		int result = 0;

		if (one.getRank() < two.getRank()) {
			result = -1;
		} else if (one.getRank() > two.getRank()) {
			result = 1;
		}

		return result;
		
	}


}
