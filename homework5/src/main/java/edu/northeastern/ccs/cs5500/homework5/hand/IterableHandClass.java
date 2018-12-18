package edu.northeastern.ccs.cs5500.homework5.hand;

import edu.northeastern.ccs.cs5500.homework5.card.Card;
import edu.northeastern.ccs.cs5500.homework5.rank.Rank;
import java.util.NoSuchElementException;

/**
 * Class that implements the iterations over the Hand to find desired elements.
 * 
 * @author Riya Nadkarni
 * @version 10-12-2018
 */
public class IterableHandClass extends HandClass implements IterableHand {

  @Override
  public boolean hasCard(Card toCheck) {
    boolean found = false;

    HandIterator<Card> cardIter = this.iterator();

    while (cardIter.hasNext()) {
      Card currentCard = cardIter.next();
      if (currentCard.equals(toCheck)) {
        found = true;
      }
    }
    return found;
  }

  @Override
  public int occurrencesInHand(Card toCheck) {

    int cardCount = 0;
    HandIterator<Card> cardIter = this.iterator();

    while (cardIter.hasNext()) {
      Card currentCard = cardIter.next();
      if (currentCard.equals(toCheck)) {
        cardCount += 1;
      }
    }
    return cardCount;
  }

  @Override
  public int occurrencesInHand(Rank toCheck) {

    int rankCount = 0;
    HandIterator<Card> rankIter = this.iterator();
    while (rankIter.hasNext()) {
      Rank currentRank = rankIter.next().getRank();
      if (currentRank.equals(toCheck)) {
        rankCount += 1;
      }
    }
    return rankCount;
  }

  @Override
  public HandIterator<Card> iterator() {
    return new HandCardIterator();
  }

  /**
   * Private class that helps iterate over a Hand.
   * 
   * @author Riya Nadkarni
   * @version 10-12-2018
   */
  private class HandCardIterator implements HandIterator<Card> {

    /** The current position. */
    private int cursor;

    /** Default constructor. */
    public HandCardIterator() {
      cursor = 0;
    }

    @Override
    public boolean hasNext() {
      return cursor < showCards().size();
    }

    @Override
    public Card next() {

      Card result = null;
      if (hasNext()) {
        result = showCards().get(cursor);
        cursor += 1;
      } else {
        throw new NoSuchElementException();
      }
      return result;
    }

  }

}
