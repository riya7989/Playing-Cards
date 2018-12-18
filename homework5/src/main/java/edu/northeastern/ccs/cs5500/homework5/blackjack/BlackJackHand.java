package edu.northeastern.ccs.cs5500.homework5.blackjack;

import edu.northeastern.ccs.cs5500.homework5.card.Card;
import edu.northeastern.ccs.cs5500.homework5.hand.IterableHandClass;
import edu.northeastern.ccs.cs5500.homework5.rank.Rank;
import edu.northeastern.ccs.cs5500.homework5.rank.RankClass;
import edu.northeastern.ccs.cs5500.homework5.rank.RankEnum;

/**
 * Represents a blackjack hand and keeps track of its state.
 * 
 * @author Riya Nadkarni
 * @version 10-18-2018
 */
public class BlackJackHand extends IterableHandClass {

	/** Current state of the hand. */
	private GameState state;

	/** Bet placed on the hand by the player. */
	private Player player;

	/**
	 * Default constructor for the blackjack hand.
	 */
	public BlackJackHand() {
		state = null;
		player = new Player();
	}

	/**
	 * Constructor for the blackjack hand.
	 * 
	 * @param playerValue new value of player
	 */
	public BlackJackHand(Player playerValue) {
		state = null;
		player = playerValue;
	}

	/**
	 * Accessor for the state of the hand.
	 * 
	 * @return the state of the hand
	 */
	public GameState getState() {
		return state;
	}

	/**
	 * Changes the state of the hand.
	 * 
	 * @param newState the new state of the hand
	 */
	public void setState(GameState newState) {
		state = newState;
	}

	/**
	 * Accessor for the player.
	 * 
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Calculates the total value of the player's hand.
	 * 
	 * @return total value of the hand
	 */
	public int getHandValue() {

		int handValue = 0;
		int aceCount = 0;

		for (Card currentCard : showCards()) {
			Rank rank = currentCard.getRank();
			if (rank.getName().equalsIgnoreCase("A")) {
				aceCount += 1;
			} else if (rank.getPips() == 0) {
				handValue += 10;
			} else {
				handValue += rank.getPips();
			}
		}

		for (int i = 0; i < aceCount; i++) {
			if (handValue + 11 > 21) {
				handValue += 1;
			} else {
				handValue += 11;
			}
		}
		return handValue;
	}

	/**
	 * Checks whether a particular hand is busted or not.
	 * 
	 * @param handValue the total value of the hand
	 * @return true is hand is busted, false otherwise
	 */
	public boolean isBusted(int handValue) {

		boolean isBusted = false;

		if (handValue > 21) {
			isBusted = true;
		}
		return isBusted;
	}

	/**
	 * Initiates the states of the hand.
	 * 
	 * @return new state of the hand
	 */
	public GameState initiateStates() {

		GameState newState = null;
		Rank hasPair = hasPair();

		int initialHandValue = getHandValue();
		if (hasASoftHand()) {
			newState = initiateSoftHandState(initialHandValue);
		} else if ((showCards().size() == 2) && (hasPair != null)) {
			newState = initiatePairHandState(hasPair);
		} else {
			newState = initiateHandState(initialHandValue);
		}
		return newState;
	}

	/**
	 * Checks whether a particular hand has a blackjack/21 value or not.
	 * 
	 * @param handValue the total value of the hand
	 * @return true is hand has a blackjack/21 value, false otherwise
	 */
	public boolean hasBlackJack(int handValue) {

		boolean hasBlackJack = false;

		if (handValue == 21) {
			hasBlackJack = true;
		}
		return hasBlackJack;
	}

	/**
	 * Checks whether the currentHand has a pair.
	 * 
	 * @return the rank if present in pair, null otherwise
	 */
	private Rank hasPair() {

		Rank result = null;

		RankEnum[] allRanks = { RankEnum.ACE, RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE, RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING };

		for (int i = 0; i < allRanks.length; i++) {
			Rank rank = new RankClass(allRanks[i]);
			if (occurrencesInHand(rank) == 2) {
				result = rank;
			}
		}

		return result;
	}

	/**
	 * Checks whether the currentHand has a soft hand (Ace valued at 11).
	 * 
	 * @return true if it does, false otherwise
	 */
	private boolean hasASoftHand() {

		boolean hasSoftHand = false;

		int aceCount = 0;
		int unwantedRankCount = 0;
		int wantedRankCount = 0;

		RankEnum[] unwantedRanks = { RankEnum.TEN, RankEnum.JACK, RankEnum.QUEEN, RankEnum.KING };
		RankEnum[] wantedRanks = { RankEnum.TWO, RankEnum.THREE, RankEnum.FOUR, RankEnum.FIVE, RankEnum.SIX,
				RankEnum.SEVEN, RankEnum.EIGHT, RankEnum.NINE };

		for (int i = 0; i < showCards().size(); i++) {
			for (int j = 0; j < unwantedRanks.length; j++) {
				if (showCards().get(i).getRank().getName().equals(unwantedRanks[j].getName())) {
					unwantedRankCount += 1;
				}
			}

			for (int k = 0; k < wantedRanks.length; k++) {
				if (showCards().get(i).getRank().getName().equals(wantedRanks[k].getName())) {
					wantedRankCount += 1;
				}
			}

		}

		Rank rank = new RankClass(RankEnum.ACE);
		aceCount += occurrencesInHand(rank);

		if ((aceCount == 1) && (unwantedRankCount == 0) && (wantedRankCount == 1)) {
			hasSoftHand = true;
		}
		return hasSoftHand;
	}

	/**
	 * Sets the state of each hand based on the initial hand value when the game
	 * starts.
	 * 
	 * @param initialHandValue initial value of each hand
	 * @return new state of the hand
	 */
	private GameState initiateHandState(int initialHandValue) {

		GameState newState = null;

		switch (initialHandValue) {

		case 5:
		case 6:
		case 7:
		case 8:
			newState = HandValue5to8.getInstance();
			break;
		case 9:
			newState = HandValue9.getInstance();
			break;
		case 10:
			newState = HandValue10.getInstance();
			break;
		case 11:
			newState = HandValue11.getInstance();
			break;
		case 12:
			newState = HandValue12.getInstance();
			break;
		case 13:
		case 14:
			newState = HandValue13to14.getInstance();
			break;
		case 15:
			newState = HandValue15.getInstance();
			break;
		case 16:
			newState = HandValue16.getInstance();
			break;
		case 17:
		case 18:
		case 19:
		case 20:
			newState = HandValue17to20.getInstance();
			break;
		case 21:
			newState = BlackJackState.getInstance();
			break;
		default:
			newState = BustState.getInstance();
			break;
		}
		return newState;
	}

	/**
	 * Sets the state of each hand (containing an Ace valued at 11) based on the
	 * initial hand value when the game starts.
	 * 
	 * @param initialHandValue initial value of each hand
	 * @return new state of the hand
	 */
	private GameState initiateSoftHandState(int initialHandValue) {

		GameState newState = null;

		switch (initialHandValue) {

		case 13:
		case 14:
			newState = SoftHandA2orA3.getInstance();
			break;
		case 15:
		case 16:
			newState = SoftHandA4orA5.getInstance();
			break;
		case 17:
			newState = SoftHandA6.getInstance();
			break;
		case 18:
			newState = SoftHandA7.getInstance();
			break;
		case 19:
			newState = SoftHandA8.getInstance();
			break;
		case 20:
			newState = SoftHandA9.getInstance();
			break;
		default:
			break;
		}
		return newState;
	}

	/**
	 * Sets the state of each hand (containing a pair) when the game starts.
	 * 
	 * @param pairRank the rank that is in par in the hand
	 * @return new state of the hand
	 */
	private GameState initiatePairHandState(Rank pairRank) {

		GameState newState = null;

		switch (pairRank.getName().toUpperCase()) {

		case "A":
			newState = PairHandA.getInstance();
			break;
		case "2":
		case "3":
			newState = PairHand2or3.getInstance();
			break;
		case "4":
			newState = PairHand4.getInstance();
			break;
		case "5":
			newState = PairHand5.getInstance();
			break;
		case "6":
			newState = PairHand6.getInstance();
			break;
		case "7":
			newState = PairHand7.getInstance();
			break;
		case "8":
			newState = PairHand8.getInstance();
			break;
		case "9":
			newState = PairHand9.getInstance();
			break;
		case "10":
			newState = PairHand10.getInstance();
			break;
		default:
			break;
		}
		return newState;
	}
	
	/**
	 * Checks whether 2 blackjack hands are equal.
	 * 
	 * @param other the hand to compare to
	 * @return true if equal and false if not
	 */
	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof BlackJackHand) {
			BlackJackHand otherHand = (BlackJackHand) other;
			result = (showCards().equals(otherHand.showCards()));
		}
		return result;
	}

	@Override
	public int hashCode() {
		return (showCards().hashCode());
	}

}
