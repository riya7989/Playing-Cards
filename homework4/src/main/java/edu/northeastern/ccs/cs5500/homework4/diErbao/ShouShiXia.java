/**
 * 
 */
package edu.northeastern.ccs.cs5500.homework4.diErbao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The hand implementation.
 * @author yì xiē rén
 */

public class ShouShiXia implements Shou {

	/** Initializes and Instantiates the hand. */
	private List<Ka> shou = new ArrayList<Ka>();
	
	/*
	 * 
	 * @see diErBao.Shou#accept(diErBao.Ka)
	 */
	@Override
	public void accept(Ka renHeKa) {

		shou.add(renHeKa);
	}

	/*
	 * 
	 * @see diErBao.Shou#pullCard()
	 */
	@Override
	public Ka pullKa() {

		return shou.remove(0);
	}

	@Override
	public Ka pullKa(Ka renHeKa) {
		/*
		 * @see diErBao.Shou#hasCard(diErBao.Ka)
		 */
		int position = findKa(renHeKa);
		
		Ka result = shou.remove(position);

		if (position == -1) {
			result = null;
		}

		return result;
	}

	/**
	 * Finds a particular card in the hand.
	 * @param renHeKa a card
	 * @return if the hand contains the card, returns the position of that card within the
	 *         hand. -1 means card was not found.
	 */
	private int findKa(Ka renHeKa) {

		int result = -1; // card not found
		
		for (int i = 0; i < shou.size(); i++) {
			if (renHeKa.equals(shou.get(i))) {
				result = i;
			}
		}
		return result; 
	}

	@Override
	public Boolean hasKa(Ka renHeKa) {

		return (findKa(renHeKa) != -1);
	}

	/*
	 * 
	 * @see diErBao.Shou#sort()
	 */
	/**
	 *   uses radix sort.  Built assuming Ka specification.
	 **/

	@Override
	public void sort() {

		// work on a copy of the hand

		List<Ka> arr = new ArrayList<Ka>(shou);

		int numberBase = 2;   

		// Find the largest number in the list

		Ka maxCard = Collections.max(arr, new KaComparator());

		// calculate the number of bits needed to represent the largest number in the list
		
		int numberOfBits = (int) (Math.log(maxCard.getRank()) / Math.log(2)) + 1;

		int p = 0; // power of numberBase for isolating digits

		while ((int) Math.pow(numberBase, numberOfBits) - (int) Math.pow(numberBase, p) > 0) {

			arr = countingSort(arr, (int) Math.pow(numberBase, p));
			p++;
		}

		// copy result back into hand
		for (int i = 0; i < arr.size(); i++) {
			shou.set(i, arr.get(i));
		}
	}

	/**
	 * Private helper method for sorting the list of cards (Hand).
	 * @param arr list of cards (Hand) to be sorted
	 * @param p	power of numberBase for isolating digits
	 * @return	sorted list of cards (Hand)
	 */
	private List<Ka> countingSort(List<Ka> arr, int p) {

		int numberBase = 2;

		List<Ka> output = new ArrayList<Ka>(arr);
		
		// count over the input whose numbers end in a given digit {0, ...numberBase} 
		int count[] = new int[numberBase]; 

		for (int i = 0; i < arr.size(); i++) {
			count[(arr.get(i).getRank() / p) % numberBase]++;
		}
		
		// Applying counting sort so now the array contains actual position of the digits
		for (int i = 1; i < numberBase; i++) {
			count[i] += count[i - 1];
		}

		for (int i = arr.size() - 1; i >= 0; i--) {

			output.set(count[(arr.get(i).getRank() / p) % numberBase] - 1, arr.get(i));
			count[(arr.get(i).getRank() / p) % numberBase]--;
		}
		
		return output;
	}

	/**
	 * Accessor for the size of the hand.
	 * @return size of the hand
	 */
	public int getHandSize() {
		return shou.size();
	}

	/**
	 * Shuffles the hand.
	 */
	public void shuffle() {
		Collections.shuffle(shou);
	}

	/**
	 * Displays the hand.
	 * @return	a clone of the hand
	 */
	@SuppressWarnings("unchecked")
	public List<Ka> showHand() {
		
		return (List<Ka>) ((ArrayList<Ka>) shou).clone();
	}

}
