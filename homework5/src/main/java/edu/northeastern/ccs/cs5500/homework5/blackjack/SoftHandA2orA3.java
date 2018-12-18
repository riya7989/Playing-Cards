package edu.northeastern.ccs.cs5500.homework5.blackjack;

/**
 * State of the game when the hand is soft with either an (A and 2) OR an (A and 3).
 * @author Riya Nadkarni
 * @version 10-15-2018
 */
public class SoftHandA2orA3 implements GameState {

	/** Holds the single instance of this state. */
	private static SoftHandA2orA3 uniqueInstance;
	
	/**
	 * Default constructor for the state.
	 */
	private SoftHandA2orA3() {
		// nothing to do here
	}
	
	/**
	 * Method that returns an instance of the state, if its not previously created.
	 * @return	a unique instance of this state
	 */
	public static SoftHandA2orA3 getInstance() {
		
		if (uniqueInstance == null) {
			uniqueInstance = new SoftHandA2orA3();
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
