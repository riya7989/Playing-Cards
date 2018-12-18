package edu.northeastern.ccs.cs5500.homework4.diErbao;

import java.util.Comparator;

/** 
 * Comparator for Ka.
 * 
 * @see java.util.Comparator#compare(T, T)
 */
public class KaComparator implements Comparator<Ka> {

	
	@Override
	public int compare(Ka one, Ka two) {
		
        int result = 1;
        
		if (one.getRank() < two.getRank()) {
            result = -1;
		}
        
        if (one.getRank() == two.getRank()) {
            result = 0;
        }
        
        return result;
    }

}
