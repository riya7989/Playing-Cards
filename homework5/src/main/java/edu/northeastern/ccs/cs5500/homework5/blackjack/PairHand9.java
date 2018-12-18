package edu.northeastern.ccs.cs5500.homework5.blackjack;

/**
 * State of the game when the hand contains a 9,9 pair.
 * @author Riya Nadkarni
 * @version 10-15-2018
 */
public class PairHand9 implements GameState {

	/** Holds the single instance of this state. */
	private static PairHand9 uniqueInstance;
	
	/**
	 * Default constructor for the state.
	 */
	private PairHand9() {
		// nothing to do here
	}

	/**
	 * Method that returns an instance of the state, if its not previously created.
	 * @return	a unique instance of this state
	 */
	public static PairHand9 getInstance() {
		
		if (uniqueInstance == null) {
			uniqueInstance = new PairHand9();
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
		game.changeState(StandState.getInstance());
		game.stand();
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
		faceUpCardSeven(game);
	}

	@Override
	public void faceUpCardAce(BlackJackGame game) {
		faceUpCardSeven(game);
	}

}
