package edu.northeastern.ccs.cs5500.homework5.blackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework5.MockBlackJackGame;

/**
 * Tests that verify whether the HandValue13to14 State works as expected.
 * @author Riya Nadkarni
 * @version 10-29-2018
 */
public class HandValue13to14Test {

	/** Tests the constructor to check whether multiple instances are created or not. */
	@Test
	public void testConstructor() {
		GameState oneState = HandValue13to14.getInstance();
		GameState twoState = HandValue13to14.getInstance();
		
		boolean isSame = oneState.equals(twoState);
		
		assertEquals("2 instances created instead of one.", true, isSame);
		
	}
	
	/** Tests whether the faceUpCardTwo method calls the correct method in Game. */
	@Test
	public void testFaceUpCardTwo() {
		MockBlackJackGame mockGame = new MockBlackJackGame(1);
		GameState oneState = HandValue13to14.getInstance();
		oneState.faceUpCardTwo(mockGame);
		assertEquals("Game method called incorrect number of times", 1, mockGame.getStandCounter());
	}
	
	/** Tests whether the faceUpCardThree method calls the correct method in Game. */
	@Test
	public void testFaceUpCardThree() {
		MockBlackJackGame mockGame = new MockBlackJackGame(1);
		GameState oneState = HandValue13to14.getInstance();
		oneState.faceUpCardThree(mockGame);
		assertEquals("Game method called incorrect number of times", 1, mockGame.getStandCounter());
	}
	
	/** Tests whether the faceUpCardFour method calls the correct method in Game. */
	@Test
	public void testFaceUpCardFour() {
		MockBlackJackGame mockGame = new MockBlackJackGame(1);
		GameState oneState = HandValue13to14.getInstance();
		oneState.faceUpCardFour(mockGame);
		assertEquals("Game method called incorrect number of times", 1, mockGame.getStandCounter());
	}
	
	/** Tests whether the faceUpCardFive method calls the correct method in Game. */
	@Test
	public void testFaceUpCardFive() {
		MockBlackJackGame mockGame = new MockBlackJackGame(1);
		GameState oneState = HandValue13to14.getInstance();
		oneState.faceUpCardFive(mockGame);
		assertEquals("Game method called incorrect number of times", 1, mockGame.getStandCounter());
	}
	
	/** Tests whether the faceUpCardSix method calls the correct method in Game. */
	@Test
	public void testFaceUpCardSix() {
		MockBlackJackGame mockGame = new MockBlackJackGame(1);
		GameState oneState = HandValue13to14.getInstance();
		oneState.faceUpCardSix(mockGame);
		assertEquals("Game method called incorrect number of times", 1, mockGame.getStandCounter());
	}
	
	/** Tests whether the faceUpCardSeven method calls the correct method in Game. */
	@Test
	public void testFaceUpCardSeven() {
		MockBlackJackGame mockGame = new MockBlackJackGame(1);
		GameState oneState = HandValue13to14.getInstance();
		oneState.faceUpCardSeven(mockGame);
		assertEquals("Game method called incorrect number of times", 1, mockGame.getHitCounter());
	}
	
	/** Tests whether the faceUpCardEight method calls the correct method in Game. */
	@Test
	public void testFaceUpCardEight() {
		MockBlackJackGame mockGame = new MockBlackJackGame(1);
		GameState oneState = HandValue13to14.getInstance();
		oneState.faceUpCardEight(mockGame);
		assertEquals("Game method called incorrect number of times", 1, mockGame.getHitCounter());
	}
	
	/** Tests whether the faceUpCardNine method calls the correct method in Game. */
	@Test
	public void testFaceUpCardNine() {
		MockBlackJackGame mockGame = new MockBlackJackGame(1);
		GameState oneState = HandValue13to14.getInstance();
		oneState.faceUpCardNine(mockGame);
		assertEquals("Game method called incorrect number of times", 1, mockGame.getHitCounter());
	}
	
	/** Tests whether the faceUpCardTen method calls the correct method in Game. */
	@Test
	public void testFaceUpCardTen() {
		MockBlackJackGame mockGame = new MockBlackJackGame(1);
		GameState oneState = HandValue13to14.getInstance();
		oneState.faceUpCardTen(mockGame);
		assertEquals("Game method called incorrect number of times", 1, mockGame.getHitCounter());
	}
	
	/** Tests whether the faceUpCardAce method calls the correct method in Game. */
	@Test
	public void testFaceUpCardAce() {
		MockBlackJackGame mockGame = new MockBlackJackGame(1);
		GameState oneState = HandValue13to14.getInstance();
		oneState.faceUpCardAce(mockGame);
		oneState.faceUpCardAce(mockGame);
		assertEquals("Game method called incorrect number of times", 2, mockGame.getHitCounter());
	}

}
