package edu.northeastern.ccs.cs5500.homework5.blackjack;

/**
 * State of the game when the hand contains a 6,6 pair.
 * @author Riya Nadkarni
 * @version 10-15-2018
 */
public class PairHand6 implements GameState {

	/** Holds the single instance of this state. */
	private static PairHand6 uniqueInstance;
	
	/**
	 * Default constructor for the state.
	 */
	private PairHand6() {
		// nothing to do here
	}

	/**
	 * Method that returns an instance of the state, if its not previously created.
	 * @return	a unique instance of this state
	 */
	public static PairHand6 getInstance() {
		
		if (uniqueInstance == null) {
			uniqueInstance = new PairHand6();
		}
		return uniqueInstance;
	}
	
	@Override
	public void faceUpCardTwo(BlackJackGame game) {
		game.split();
	}

	@Override
	public void faceUpCardThree(BlackJackGame game) {
		game.split();
	}

	@Override
	public void faceUpCardFour(BlackJackGame game) {
		game.split();
	}

	@Override
	public void faceUpCardFive(BlackJackGame game) {
		game.split();
	}

	@Override
	public void faceUpCardSix(BlackJackGame game) {
		game.split();
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
