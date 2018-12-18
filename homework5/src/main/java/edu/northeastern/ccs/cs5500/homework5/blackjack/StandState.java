package edu.northeastern.ccs.cs5500.homework5.blackjack;

/**
 * State of the game when the player decides to stand.
 * @author Riya Nadkarni
 * @version 10-25-2018
 */
public class StandState implements GameState {

	/** Holds the single instance of this state. */
	private static StandState uniqueInstance;
	
	/**
	 * Default constructor for the state.
	 */
	private StandState() {
		// nothing to do here
	}
	
	/**
	 * Method that returns an instance of the state, if its not previously created.
	 * @return	a unique instance of this state
	 */
	public static StandState getInstance() {
		
		if (uniqueInstance == null) {
			uniqueInstance = new StandState();
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
