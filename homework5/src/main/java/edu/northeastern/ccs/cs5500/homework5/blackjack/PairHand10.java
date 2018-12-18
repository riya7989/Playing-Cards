package edu.northeastern.ccs.cs5500.homework5.blackjack;

/**
 * State of the game when the hand contains a 10,10 pair.
 * @author Riya Nadkarni
 * @version 10-15-2018
 */
public class PairHand10 implements GameState {

	/** Holds the single instance of this state. */
	private static PairHand10 uniqueInstance;
	
	/**
	 * Default constructor for the state.
	 */
	private PairHand10() {
		// nothing to do here
	}
	
	/**
	 * Method that returns an instance of the state, if its not previously created.
	 * @return	a unique instance of this state
	 */
	public static PairHand10 getInstance() {
		
		if (uniqueInstance == null) {
			uniqueInstance = new PairHand10();
		}
		return uniqueInstance;
	}
	
	@Override
	public void faceUpCardTwo(BlackJackGame game) {
		game.changeState(StandState.getInstance());
		game.stand();
	}

	@Override
	public void faceUpCardThree(BlackJackGame game) {
		faceUpCardTwo(game);
	}

	@Override
	public void faceUpCardFour(BlackJackGame game) {
		faceUpCardTwo(game);
	}

	@Override
	public void faceUpCardFive(BlackJackGame game) {
		faceUpCardTwo(game);
	}

	@Override
	public void faceUpCardSix(BlackJackGame game) {
		faceUpCardTwo(game);
	}

	@Override
	public void faceUpCardSeven(BlackJackGame game) {
		faceUpCardTwo(game);
	}

	@Override
	public void faceUpCardEight(BlackJackGame game) {
		faceUpCardTwo(game);
	}

	@Override
	public void faceUpCardNine(BlackJackGame game) {
		faceUpCardTwo(game);
	}

	@Override
	public void faceUpCardTen(BlackJackGame game) {
		faceUpCardTwo(game);
	}

	@Override
	public void faceUpCardAce(BlackJackGame game) {
		faceUpCardTwo(game);
	}

}
