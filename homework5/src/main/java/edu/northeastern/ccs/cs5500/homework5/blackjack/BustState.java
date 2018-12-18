package edu.northeastern.ccs.cs5500.homework5.blackjack;

/**
 * State of the game when the total value of the hand is greater than 21.
 * @author Riya Nadkarni
 * @version 10-25-2018
 */
public class BustState implements GameState {

	/** Holds the single instance of this state. */
	private static BustState uniqueInstance;
	
	/**
	 * Default constructor for the state.
	 */
	private BustState() {
		// nothing to do here
	}
	
	/**
	 * Method that returns an instance of the state, if its not previously created.
	 * @return	a unique instance of this state
	 */
	public static BustState getInstance() {
		
		if (uniqueInstance == null) {
			uniqueInstance = new BustState();
		}
		return uniqueInstance;
	}
	
	@Override
	public void faceUpCardTwo(BlackJackGame game) {
		game.bust();
	}

	@Override
	public void faceUpCardThree(BlackJackGame game) {
		game.bust();
	}

	@Override
	public void faceUpCardFour(BlackJackGame game) {
		game.bust();
	}

	@Override
	public void faceUpCardFive(BlackJackGame game) {
		game.bust();
	}

	@Override
	public void faceUpCardSix(BlackJackGame game) {
		game.bust();
	}

	@Override
	public void faceUpCardSeven(BlackJackGame game) {
		game.bust();
	}

	@Override
	public void faceUpCardEight(BlackJackGame game) {
		game.bust();
	}

	@Override
	public void faceUpCardNine(BlackJackGame game) {
		game.bust();
	}

	@Override
	public void faceUpCardTen(BlackJackGame game) {
		game.bust();
	}

	@Override
	public void faceUpCardAce(BlackJackGame game) {
		game.bust();
	}

}
