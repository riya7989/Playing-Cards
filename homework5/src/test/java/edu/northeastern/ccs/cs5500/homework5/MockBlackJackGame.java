package edu.northeastern.ccs.cs5500.homework5;

import edu.northeastern.ccs.cs5500.homework5.blackjack.BlackJackGame;
import edu.northeastern.ccs.cs5500.homework5.blackjack.GameState;

/**
 * Class created for the purpose of testing the BlackJackGame class.
 * @author Riya Nadkarni
 * @version 10-26-2018
 */
public class MockBlackJackGame extends BlackJackGame {
	
	/** Counts the number of times hit() was called. */
	private int hitCounter;
	
	/** Counts the number of times bust() was called. */
	private int bustCounter;
	
	/** Counts the number of times split() was called. */
	private int splitCounter;
	
	/** Counts the number of times stand() was called. */
	private int standCounter;

	/**
	 * Default constructor for the blackjack game.
	 * 
	 * @param numberOfHands number of players in the game
	 */
	public MockBlackJackGame(int numberOfHands) {

		super(numberOfHands);
	}

	/**
	 * Accessor for the hitCounter.
	 * @return	number of times hit was called
	 */
	public int getHitCounter() {
		return hitCounter;
	}
	
	/**
	 * Accessor for the bustCounter.
	 * @return	number of times bust was called
	 */
	public int getBustCounter() {
		return bustCounter;
	}
	
	/**
	 * Accessor for the splitCounter.
	 * @return	number of times split was called
	 */
	public int getSplitCounter() {
		return splitCounter;
	}
	
	/**
	 * Accessor for the standCounter.
	 * @return	number of times stand was called
	 */
	public int getStandCounter() {
		return standCounter;
	}

	/**
	 * Changes the state of the hand.
	 * 
	 * @param newState new state of the hand
	 */
	@Override
	public void changeState(GameState newState) {
		//nothing to be done
	}
	
	/**
	 * Adds a hand to the card from the deck.
	 */
	@Override
	public void hit() {

		hitCounter += 1;
	}

	/**
	 * If the total value of the hand exceeds 21.
	 */
	@Override
	public void bust() {

		bustCounter += 1;
	}

	/**
	 * If the player has a pair and decides to split.
	 */
	@Override
	public void split() {

		splitCounter += 1;
		hit();
	}

	/**
	 * If the player decides not to not draw another card.
	 */
	@Override
	public void stand() {
		standCounter += 1;
	}

}
