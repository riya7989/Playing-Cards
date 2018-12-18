package edu.northeastern.ccs.cs5500.homework4.card;

import java.util.Comparator;

import edu.northeastern.ccs.cs5500.homework4.diErbao.Ka;
import edu.northeastern.ccs.cs5500.homework4.diErbao.KaComparator;

/**
 * The comparator class that sorts the Chinese cards by order of their ranks and suits.
 * 
 * @author Riya Nadkarni
 * @version 10-19-2018
 */
public class KaRankAndSuitComparator implements Comparator<Ka> {

	@Override
	public int compare(Ka one, Ka two) {
		
		int result = 0;
		
		Comparator<Ka> rankCompare = new KaComparator();
		Comparator<Ka> suitCompare = new KaSuitComparator();
		

		int rankOrder = rankCompare.compare(one, two);
		int suitOrder = suitCompare.compare(one, two);

		if (rankOrder < 0) {
			result = -1;
		} else if (rankOrder > 0) {
			result = 1;
		} else {
			result = suitOrder;
		}

		return result;
	}

}
