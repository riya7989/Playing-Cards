package edu.northeastern.ccs.cs5500.homework5.blackjack;

/**
 * State of the game when the hand contains a 8,8 pair.
 * @author Riya Nadkarni
 * @version 10-15-2018
 */
public class PairHand8 implements GameState {

	/** Holds the single instance of this state. */
	private static PairHand8 uniqueInstance;
	
	/**
	 * Default constructor for the state.
	 */
	private PairHand8() {
		// nothing to do here
	}

	/**
	 * Method that returns an instance of the state, if its not previously created.
	 * @return	a unique instance of this state
	 */
	public static PairHand8 getInstance() {
		
		if (uniqueInstance == null) {
			uniqueInstance = new PairHand8();
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
		game.split();
	}

	@Override
	public void faceUpCardEight(BlackJackGame game) {
		game.split();
	}

	@Override
	public void faceUpCardNine(BlackJackGame game) {
		game.split();
	}

	@Override
	public void faceUpCardTen(BlackJackGame game) {
		game.split();
	}

	@Override
	public void faceUpCardAce(BlackJackGame game) {
		game.split();
	}

}
