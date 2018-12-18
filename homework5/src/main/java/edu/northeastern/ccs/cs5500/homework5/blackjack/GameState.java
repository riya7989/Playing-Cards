package edu.northeastern.ccs.cs5500.homework5.blackjack;

/**
 * Handles the various states of the blackjack game.
 * @author Riya Nadkarni
 * @version 10-15-2018
 */
public interface GameState {

	/**
	 * Change in state if the dealer's face-up card is 2.
	 * @param game	the blackjack game
	 */
	void faceUpCardTwo(BlackJackGame game);
	
	/**
	 * Change in state if the dealer's face-up card is 3.
	 * @param game	the blackjack game
	 */
	void faceUpCardThree(BlackJackGame game);
	
	/**
	 * Change in state if the dealer's face-up card is 4.
	 * @param game	the blackjack game
	 */
	void faceUpCardFour(BlackJackGame game);
	
	/**
	 * Change in state if the dealer's face-up card is 5.
	 * @param game	the blackjack game
	 */
	void faceUpCardFive(BlackJackGame game);
	
	/**
	 * Change in state if the dealer's face-up card is 6.
	 * @param game	the blackjack game
	 */
	void faceUpCardSix(BlackJackGame game);
	
	/**
	 * Change in state if the dealer's face-up card is 7.
	 * @param game	the blackjack game
	 */
	void faceUpCardSeven(BlackJackGame game);
	
	/**
	 * Change in state if the dealer's face-up card is 8.
	 * @param game	the blackjack game
	 */
	void faceUpCardEight(BlackJackGame game);
	
	/**
	 * Change in state if the dealer's face-up card is 9.
	 * @param game	the blackjack game
	 */
	void faceUpCardNine(BlackJackGame game);
	
	/**
	 * Change in state if the dealer's face-up card is either a Jack, Queen or King.
	 * @param game	the blackjack game
	 */
	void faceUpCardTen(BlackJackGame game);
	
	/**
	 * Change in state if the dealer's face-up card is an Ace.
	 * @param game	the blackjack game
	 */
	void faceUpCardAce(BlackJackGame game);
}
