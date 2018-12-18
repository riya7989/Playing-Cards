package edu.northeastern.ccs.cs5500.homework5.blackjack;

/**
 * State of the game when the total value of the hand is 21.
 * @author Riya Nadkarni
 * @version 10-25-2018
 */
public class BlackJackState implements GameState {

	/** Holds the single instance of this state. */
	private static BlackJackState uniqueInstance;
	
	/**
	 * Default constructor for the state.
	 */
	private BlackJackState() {
		// nothing to do here
	}
	
	/**
	 * Method that returns an instance of the state, if its not previously created.
	 * @return	a unique instance of this state
	 */
	public static BlackJackState getInstance() {
		
		if (uniqueInstance == null) {
			uniqueInstance = new BlackJackState();
		}
		return uniqueInstance;
	}
	
	@Override
	public void faceUpCardTwo(BlackJackGame game) {
		game.stand();
	}

	@Override
	public void faceUpCardThree(BlackJackGame game) {
		game.stand();
	}

	@Override
	public void faceUpCardFour(BlackJackGame game) {
		game.stand();
	}

	@Override
	public void faceUpCardFive(BlackJackGame game) {
		game.stand();
	}

	@Override
	public void faceUpCardSix(BlackJackGame game) {
		game.stand();
	}

	@Override
	public void faceUpCardSeven(BlackJackGame game) {
		game.stand();
	}

	@Override
	public void faceUpCardEight(BlackJackGame game) {
		game.stand();
	}

	@Override
	public void faceUpCardNine(BlackJackGame game) {
		game.stand();
	}

	@Override
	public void faceUpCardTen(BlackJackGame game) {
		game.stand();
	}

	@Override
	public void faceUpCardAce(BlackJackGame game) {
		game.stand();
	}


}
