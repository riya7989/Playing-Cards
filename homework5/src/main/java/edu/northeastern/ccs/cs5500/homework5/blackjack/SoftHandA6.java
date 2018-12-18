package edu.northeastern.ccs.cs5500.homework5.blackjack;

/**
 * State of the game when the hand is soft with an A and 6.
 * @author Riya Nadkarni
 * @version 10-15-2018
 */
public class SoftHandA6 implements GameState {

	/** Holds the single instance of this state. */
	private static SoftHandA6 uniqueInstance;
	
	/**
	 * Default constructor for the state.
	 */
	private SoftHandA6() {
		// nothing to do here
	}
	
	/**
	 * Method that returns an instance of the state, if its not previously created.
	 * @return	a unique instance of this state
	 */
	public static SoftHandA6 getInstance() {
		
		if (uniqueInstance == null) {
			uniqueInstance = new SoftHandA6();
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
