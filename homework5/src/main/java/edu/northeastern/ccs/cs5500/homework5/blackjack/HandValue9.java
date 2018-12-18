package edu.northeastern.ccs.cs5500.homework5.blackjack;

/**
 * State of the game when the total value of the hand is 9.
 * @author Riya Nadkarni
 * @version 10-15-2018
 */
public class HandValue9 implements GameState {

	/** Holds the single instance of this state. */
	private static HandValue9 uniqueInstance;
	
	/**
	 * Default constructor for the state.
	 */
	private HandValue9() {
		// nothing to do here
	}
	
	/**
	 * Method that returns an instance of the state, if its not previously created.
	 * @return	a unique instance of this state
	 */
	public static HandValue9 getInstance() {
		
		if (uniqueInstance == null) {
			uniqueInstance = new HandValue9();
		}
		return uniqueInstance;
	}

	@Override
	public void faceUpCardTwo(BlackJackGame game) {
		game.hit();
	}

	@Override
	public void faceUpCardThree(BlackJackGame game) {
		game.hit();
	}

	@Override
	public void faceUpCardFour(BlackJackGame game) {
		game.hit();
	}

	@Override
	public void faceUpCardFive(BlackJackGame game) {
		game.hit();
	}

	@Override
	public void faceUpCardSix(BlackJackGame game) {
		game.hit();
	}

	@Override
	public void faceUpCardSeven(BlackJackGame game) {
		game.hit();
	}

	@Override
	public void faceUpCardEight(BlackJackGame game) {
		game.hit();
	}

	@Override
	public void faceUpCardNine(BlackJackGame game) {
		game.hit();
	}

	@Override
	public void faceUpCardTen(BlackJackGame game) {
		game.hit();
	}

	@Override
	public void faceUpCardAce(BlackJackGame game) {
		game.hit();
	}

}
