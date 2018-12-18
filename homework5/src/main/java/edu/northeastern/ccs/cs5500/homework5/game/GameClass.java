package edu.northeastern.ccs.cs5500.homework5.game;

import java.util.ArrayList;
import java.util.List;

import edu.northeastern.ccs.cs5500.homework5.card.Card;
import edu.northeastern.ccs.cs5500.homework5.deck.Deck;
import edu.northeastern.ccs.cs5500.homework5.deck.DeckFactory;
import edu.northeastern.ccs.cs5500.homework5.hand.Hand;
import edu.northeastern.ccs.cs5500.homework5.hand.HandClass;

/**
 * The class that implements the Game interface. It simulates a game of cards.
 * 
 * @author Riya Nadkarni
 * @version 09-23-2018
 *
 */
public class GameClass implements Game {

	/** The deck pertaining the game to be played. */
	private Deck gameDeck;

	/** Hand of cards in the game. */
	private List<Hand> gameHand;

	/** Total hands in the game. */
	private int numberOfHands;

	/** Number of cards in a hand. */
	private int numberOfCards;

	/**
	 * Default constructor.
	 */
	public GameClass() {
		
	}
	
	/**
	 * Constructor for the Game class.
	 * 
	 * @param deckType      the type of deck to be created
	 * @param numberOfDecks number of decks of the deck type
	 * @param numberOfHands number of hands in the game
	 * @param numberOfCards number of cards in a hand
	 * @throws IllegalArgumentException if number of decks is less than 1, number of
	 *                                  hands is negative or number of cards is
	 *                                  negative/more than the amount in deck
	 */
	public GameClass(DeckFactory deckType, int numberOfDecks, int numberOfHands, int numberOfCards) {

		if (numberOfDecks <= 0) {
			throw new IllegalArgumentException("Number of decks cannot be less than 1.");
		} else if (numberOfDecks == 1) {
			createDeck(deckType);
		} else {
			createDeck(deckType, numberOfDecks);
		}

		if (numberOfHands < 0) {
			throw new IllegalArgumentException("Number of hands cannot be less than 1.");
		} else {
			this.numberOfHands = numberOfHands;
		}

		if ((numberOfCards > gameDeck.getLength() / this.numberOfHands)) {
			throw new IllegalArgumentException("Number of cards cannot exceed the total from the deck.");
		} else if (numberOfCards <= 0) {
			throw new IllegalArgumentException("Number of cards cannot be less than 1.");
		} else {
			this.numberOfCards = numberOfCards;
		}

		gameHand = new ArrayList<>();
	}

	@Override
	public void createDeck(DeckFactory deckType) {

		gameDeck = deckType.makeDeck();
	}

	@Override
	public void createDeck(DeckFactory deckType, int numberOfDecks) {

		if (numberOfDecks < 2) {
			throw new IllegalArgumentException("Minimum number of decks should be 2.");
		} else {
			gameDeck = deckType.makeDeck(numberOfDecks);
		}
	}

	@Override
	public void setNumberOfHands(int numberOfHands) {

		if (numberOfHands <= 0) {
			throw new IllegalArgumentException("Number of hands cannot be less than 1.");
		} else if (numberOfHands > (gameDeck.getLength() / numberOfCards)) {
			throw new IllegalArgumentException(
					"Number of hands more than can be accommodated in the cards from the deck.");
		} else {
			this.numberOfHands = numberOfHands;
		}
	}

	@Override
	public void deal() {

		for (int i = 0; i < numberOfHands; i++) {
			gameHand.add(new HandClass());
		}

		for (int i = 0; i < numberOfCards; i++) {
			for (int j = 0; j < numberOfHands; j++) {
				Card pulled = gameDeck.pullCard();
				gameHand.get(j).accept(pulled);
			}
		}
	}

	/**
	 * Mutator for the number of cards.
	 *
	 * @param numberOfCards the new number of cards
	 * @throws IllegalArgumentException if the number of cards is negative/more than
	 *                                  the amount in deck
	 */
	protected void setNumberOfCards(int numberOfCards) {

		if ((numberOfCards > gameDeck.getLength() / this.numberOfHands)) {
			throw new IllegalArgumentException("Number of cards cannot exceed the total from the deck.");
		} else if (numberOfCards <= 0) {
			throw new IllegalArgumentException("Number of cards cannot be less than 1.");
		} else {
			this.numberOfCards = numberOfCards;
		}
	}

	/**
	 * Accessor for the number of hands.
	 *
	 * @return the number of hands
	 */
	public int getNumberOfHands() {
		return numberOfHands;
	}

	/**
	 * Accessor for the number of cards.
	 *
	 * @return the number of cards
	 */
	public int getNumberOfCards() {
		return numberOfCards;
	}

	/**
	 * Accessor for the game deck.
	 *
	 * @return the game deck
	 */
	public Deck getGameDeck() {
		return gameDeck;
	}

	/**
	 * Accessor for the game hand.
	 *
	 * @return the game hand
	 */
	public List<Hand> getGameHand() {

		List<Hand> tempHand = new ArrayList<>();

		for (int i = 0; i < gameHand.size(); i++) {
			tempHand.add(gameHand.get(i));
		}

		return tempHand;
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
		if (other instanceof GameClass) {
			GameClass othergame = (GameClass) other;
			result = getGameDeck().equals(othergame.getGameDeck());
		}
		return result;
	}

	@Override
	public int hashCode() {
		return (getGameDeck().hashCode());
	}
}
