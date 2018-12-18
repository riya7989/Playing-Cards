package edu.northeastern.ccs.cs5500.homework5.blackjack;

import java.util.ArrayList;
import java.util.List;

import edu.northeastern.ccs.cs5500.homework5.card.Card;
import edu.northeastern.ccs.cs5500.homework5.deck.DeckFactory;
import edu.northeastern.ccs.cs5500.homework5.deck.VegasDeckFactory;
import edu.northeastern.ccs.cs5500.homework5.game.GameClass;

/**
 * Simulation of a game of blackjack / 21.
 * 
 * @author Riya Nadkarni
 * @version 10-13-2018
 */
public class BlackJackGame extends GameClass {

	/** The blackjack hand for players. */
	private List<BlackJackHand> blackJackHand;

	/** Controls who plays next (player or dealer). */
	private int currentTurn;

	/** The current playing entity (player/dealer). */
	private BlackJackHand currentPlayer;

	/**
	 * Default constructor for the blackjack game.
	 * 
	 * @param numberOfHands number of players in the game
	 */
	public BlackJackGame(int numberOfHands) {

		super(new VegasDeckFactory(), 1, checkNumberOfPlayers(numberOfHands), 2);
		blackJackHand = new ArrayList<>();
		currentTurn = 1;
		currentPlayer = null;
	}

	/**
	 * Constructor for the blackjack game.
	 * 
	 * @param numberOfHands number of players in the game
	 * @param deck          the factory that creates the deck
	 */
	public BlackJackGame(DeckFactory deck, int numberOfHands) {

		super(deck, 1, checkNumberOfPlayers(numberOfHands), 2);
		blackJackHand = new ArrayList<>();
		currentTurn = 1;
		currentPlayer = null;
	}

	/**
	 * Controls the number of hands/players to be between 1 and 5.
	 * 
	 * @param numberOfHands the number of hands to be validated
	 * @return total number Of Hands (players and the dealer)
	 */
	private static int checkNumberOfPlayers(int numberOfHands) {

		if (numberOfHands < 1 || numberOfHands > 5) {
			throw new IllegalArgumentException("Number of players should be between 1 and 5");
		}
		return (numberOfHands + 1);
	}

	@Override
	public void deal() {

		for (int i = 0; i < getNumberOfHands(); i++) {
			blackJackHand.add(new BlackJackHand());
		}

		getGameDeck().shuffle();

		for (int i = 0; i < getNumberOfCards(); i++) {
			for (int j = 0; j < getNumberOfHands(); j++) {
				Card pulled = getGameDeck().pullCard();
				blackJackHand.get(j).accept(pulled);
			}
		}
		currentPlayer = blackJackHand.get(currentTurn);
		commencePlayerGame();
	}

	/**
	 * Initiates and sets the state of the current player and checks for the face up
	 * card for further state transition.
	 */
	private void commencePlayerGame() {

		GameState newState = currentPlayer.initiateStates();
		changeState(newState);
		getFaceUpCard();
	}

	/**
	 * Decides whether the players turn is next or the dealer's. 0 being the dealer
	 * and the rest would be players.
	 */
	public void nextTurn() {

		int bustCount = getBustCount();
		int blackJackCount = getBlackJackCount();
		int standCount = getStandCount();

		if ((bustCount + blackJackCount + standCount) < (blackJackHand.size() - 1)) {
			currentTurn += 1;
			currentPlayer = blackJackHand.get(currentTurn);
			commencePlayerGame();
		} else if ((bustCount + blackJackCount) < (blackJackHand.size() - 1)) {
			currentTurn = 0;
			currentPlayer = blackJackHand.get(currentTurn);
			dealerGame();
		} else {
			checkWinner();
		}

	}

	/**
	 * Calculates the number of hands busted among the players.
	 * 
	 * @return total busted hands
	 */
	private int getBustCount() {

		int bustCount = 0;

		for (BlackJackHand currentHand : blackJackHand) {
			if (currentHand.getState() == BustState.getInstance()) {
				bustCount += 1;
			}
		}
		return bustCount;
	}

	/**
	 * Calculates the number of hands with a blackjack among the players.
	 * 
	 * @return total busted hands
	 */
	private int getBlackJackCount() {

		int blackJackCount = 0;

		for (BlackJackHand currentHand : blackJackHand) {
			if (currentHand.getState() == BlackJackState.getInstance()) {
				blackJackCount += 1;
			}
		}
		return blackJackCount;
	}

	/**
	 * Calculates the number of hands among the players that are standing.
	 * 
	 * @return total standing hands
	 */
	private int getStandCount() {

		int standCount = 0;

		for (BlackJackHand currentHand : blackJackHand) {
			if (currentHand.getState() == StandState.getInstance()) {
				standCount += 1;
			}
		}
		return standCount;
	}

	/**
	 * Mutator for the current player.
	 * 
	 * @param currentTurn the turn of the current playing hand
	 */
	protected void setCurrentPlayer(int currentTurn) {
		currentPlayer = blackJackHand.get(currentTurn);
	}

	/**
	 * Checks what the dealers face up card is.
	 * 
	 * @return the dealer's face up card
	 */
	public Card getFaceUpCard() {
		Card faceUp = blackJackHand.get(0).showCards().get(0);

		switch (faceUp.getRank().getName().toUpperCase()) {

		case "2":
			faceUpCardTwo();
			break;
		case "3":
			faceUpCardThree();
			break;
		case "4":
			faceUpCardFour();
			break;
		case "5":
			faceUpCardFive();
			break;
		case "6":
			faceUpCardSix();
			break;
		case "7":
			faceUpCardSeven();
			break;
		case "8":
			faceUpCardEight();
			break;
		case "9":
			faceUpCardNine();
			break;
		case "10":
		case "J":
		case "Q":
		case "K":
			faceUpCardTen();
			break;
		case "A":
			faceUpCardAce();
			break;
		default:
			break;
		}
		return faceUp;
	}

	/**
	 * Returns the current turn (player or dealer).
	 * 
	 * @return the number that corresponds to the player/dealer hand.
	 */
	public int getCurrentTurn() {
		return currentTurn;
	}

	/**
	 * Accessor for the current playing hand (player or dealer).
	 * 
	 * @return the current playing hand
	 */
	public BlackJackHand getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Accessor for the blackjack hand.
	 * 
	 * @return the blackjack hand
	 */
	public List<BlackJackHand> getBlackJackHand() {

		List<BlackJackHand> tempHand = new ArrayList<>();

		for (int i = 0; i < blackJackHand.size(); i++) {
			tempHand.add(blackJackHand.get(i));
		}

		return tempHand;

	}

	/**
	 * Changes the state of the hand.
	 * 
	 * @param newState new state of the hand
	 */
	public void changeState(GameState newState) {

		currentPlayer.setState(newState);
	}

	/**
	 * Adds a hand to the card from the deck.
	 */
	public void hit() {

		currentPlayer.accept(getGameDeck().pullCard());
		commencePlayerGame();
	}

	/**
	 * If the total value of the hand exceeds 21.
	 */
	public void bust() {

		currentPlayer.getPlayer().loseBet();
		nextTurn();
	}

	/**
	 * If the player has a pair and decides to split.
	 */
	public void split() {

		BlackJackHand splitHand = new BlackJackHand(currentPlayer.getPlayer());
		splitHand.getPlayer().addBet(1);

		splitHand.accept(currentPlayer.pullCard());
		blackJackHand.add((getCurrentTurn() + 1), splitHand);
		hit();
	}

	/**
	 * If the player decides not to not draw another card.
	 */
	public void stand() {
		nextTurn();
	}

	/**
	 * Change in state if the dealer's face-up card is 2.
	 */
	public void faceUpCardTwo() {

		currentPlayer.getState().faceUpCardTwo(this);
	}

	/**
	 * Change in state if the dealer's face-up card is 3.
	 */
	public void faceUpCardThree() {

		currentPlayer.getState().faceUpCardThree(this);
	}

	/**
	 * Change in state if the dealer's face-up card is 4.
	 */
	public void faceUpCardFour() {

		currentPlayer.getState().faceUpCardFour(this);
	}

	/**
	 * Change in state if the dealer's face-up card is 5.
	 */
	public void faceUpCardFive() {

		currentPlayer.getState().faceUpCardFive(this);
	}

	/**
	 * Change in state if the dealer's face-up card is 6.
	 */
	public void faceUpCardSix() {

		currentPlayer.getState().faceUpCardSix(this);
	}

	/**
	 * Change in state if the dealer's face-up card is 7.
	 */
	public void faceUpCardSeven() {

		currentPlayer.getState().faceUpCardSeven(this);
	}

	/**
	 * Change in state if the dealer's face-up card is 8.
	 */
	public void faceUpCardEight() {

		currentPlayer.getState().faceUpCardEight(this);
	}

	/**
	 * Change in state if the dealer's face-up card is 9.
	 */
	public void faceUpCardNine() {

		currentPlayer.getState().faceUpCardNine(this);
	}

	/**
	 * Change in state if the dealer's face-up card is either a Jack, Queen or King.
	 */
	public void faceUpCardTen() {

		currentPlayer.getState().faceUpCardTen(this);
	}

	/**
	 * Change in state if the dealer's face-up card is an Ace.
	 */
	public void faceUpCardAce() {

		currentPlayer.getState().faceUpCardAce(this);
	}

	/**
	 * The sequence that a dealer follows.
	 */
	public void dealerGame() {
		GameState newState = currentPlayer.initiateStates();
		changeState(newState);
		while (currentPlayer.getHandValue() < 21) {
			currentPlayer.accept(getGameDeck().pullCard());
		}
		newState = currentPlayer.initiateStates();
		changeState(newState);
		checkWinner();
	}

	/**
	 * Checks whether a particular hand has won.
	 * 
	 * // * @return true if won, false otherwise
	 */
	public void checkWinner() {

		for (int i = 1; i < blackJackHand.size(); i++) {
			int dealerHandValue = blackJackHand.get(0).getHandValue();
			int playerHandValue = blackJackHand.get(i).getHandValue();
			if (dealerHandValue > playerHandValue && (blackJackHand.get(0).hasBlackJack(dealerHandValue)
					&& !blackJackHand.get(i).hasBlackJack(playerHandValue))) 
			{
				blackJackHand.get(i).getPlayer().loseBet();
			}
		}
	}

	/**
	 * Checks whether 2 games are equal.
	 * 
	 * @param other the game to compare to
	 * @return true if equal and false if not
	 */
	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof BlackJackGame) {
			BlackJackGame othergame = (BlackJackGame) other;
			result = getGameDeck().equals(othergame.getGameDeck());
		}
		return result;
	}

	@Override
	public int hashCode() {
		return (getGameDeck().hashCode());
	}
}
