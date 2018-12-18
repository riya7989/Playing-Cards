package edu.northeastern.ccs.cs5500.homework5.blackjack;

/**
 * State of the game when the hand contains a 5,5 pair.
 * @author Riya Nadkarni
 * @version 10-15-2018
 */
public class PairHand5 implements GameState {

	/** Holds the single instance of this state. */
	private static PairHand5 uniqueInstance;
	
	/**
	 * Default constructor for the state.
	 */
	private PairHand5() {
		// nothing to do here
	}

	/**
	 * Method that returns an instance of the state, if its not previously created.
	 * @return	a unique instance of this state
	 */
	public static PairHand5 getInstance() {
		
		if (uniqueInstance == null) {
			uniqueInstance = new PairHand5();
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
