package edu.northeastern.ccs.cs5500.homework5.hand;

import edu.northeastern.ccs.cs5500.homework5.card.Card;
import edu.northeastern.ccs.cs5500.homework5.rank.Rank;

/**
 * Interface that allows iterations over the hand to find certain elements.
 * 
 * @author Riya Nadkarni
 * @version 10-12-2018
 */
public interface IterableHand extends Hand, HandIterable<Card> {

  @Override
  boolean hasCard(Card toCheck);

  /**
   * Determine whether a Card is contained in the Hand.
   * 
   * @param toCheck the Card to search for
   * @return total number of occurrences of the Card in the Hand
   */
  int occurrencesInHand(Card toCheck);

  /**
   * Determine whether a Rank is contained in the Hand.
   * 
   * @param toCheck the Rank to search for
   * @return total number of occurrences of the Rank in the Hand
   */
  int occurrencesInHand(Rank toCheck);

}
