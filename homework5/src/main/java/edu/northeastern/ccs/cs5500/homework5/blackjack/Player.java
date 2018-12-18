package edu.northeastern.ccs.cs5500.homework5.blackjack;

/**
 * Simulates the player in blackJack.
 * 
 * @author Riya Nadkarni
 * @version 10-24-2018
 */
public class Player {

	/** Tracks the amount of money won/lost. */
	private int bet;

	/**
	 * Constructor for the Player.
	 */
	public Player() {
		bet = 1;
	}

	/**
	 * Accessor for the bet placed on the hand.
	 * 
	 * @return bet for the particular hand
	 */
	public int getBet() {
		return bet;
	}

	/**
	 * Set the value of the bet on the hand.
	 * 
	 * @param newBet new bet on the hand
	 */
	public void addBet(int newBet) {
		bet += newBet;
	}

	/**
	 * Reduces 1 dollar if the player loses the hand.
	 */
	public void loseBet() {
		if (bet > 0) {
			bet -= 1;
		}
	}
}
