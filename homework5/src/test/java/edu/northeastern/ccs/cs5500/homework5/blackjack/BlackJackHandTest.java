package edu.northeastern.ccs.cs5500.homework5.blackjack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework5.card.Card;
import edu.northeastern.ccs.cs5500.homework5.card.CardClass;
import edu.northeastern.ccs.cs5500.homework5.deck.StandardDeckClass;

/**
 * Tests that verify whether the BlackJackHand class works as expected.
 * 
 * @author Riya Nadkarni
 * @version 10-25-2018
 */
public class BlackJackHandTest {

	/**
	 * Private class that initiates the required object before each test.
	 */
	private BlackJackHand testHand;

	/**
	 * Setup for each test.
	 */
	@Before
	public void setup() {
		testHand = new BlackJackHand();
	}

	/** Tests whether the default constructor works as expected. */
	@Test
	public void testDefualtConstructor() {

		assertEquals("Incorrect state initiated.", null, testHand.getState());
		assertEquals("Incorrect Player bet initiated.", 1, testHand.getPlayer().getBet());
	}

	/** Tests whether the constructor works as expected. */
	@Test
	public void testConstructor() {

		Player one = new Player();
		testHand = new BlackJackHand(one);
		assertEquals("Incorrect state initiated.", null, testHand.getState());
		assertEquals("Incorrect Player bet initiated.", 1, testHand.getPlayer().getBet());
		assertEquals("Incorrect player initiated.", true, one == testHand.getPlayer());
	}

	/** Tests whether the getHandValue method works as expected. */
	@Test
	public void testGetHandValue() {

		StandardDeckClass oneDeck = new StandardDeckClass();
		testHand.accept(oneDeck.pullCard());
		testHand.accept(oneDeck.pullCard());
		testHand.accept(oneDeck.pullCard());
		testHand.accept(oneDeck.pullCard());
		testHand.accept(oneDeck.pullCard());

		assertEquals("Incorrect hand value calculated.", 20, testHand.getHandValue());
	}

	/** Tests whether the getHandValue method works as expected with a soft hand. */
	@Test
	public void testGetHandValueWithASoftHand() {

		Card one = new CardClass("8", "spade");
		Card two = new CardClass("A", "heart");
		testHand.accept(one);
		testHand.accept(two);
		assertEquals("Incorrect hand value calculated.", 19, testHand.getHandValue());
	}

	/** Tests whether the getHandValue method works as expected with a hard hand. */
	@Test
	public void testGetHandValueWithAHardHand() {

		Card one = new CardClass("8", "spade");
		Card two = new CardClass("A", "heart");
		Card three = new CardClass("5", "club");
		testHand.accept(one);
		testHand.accept(two);
		testHand.accept(three);
		assertEquals("Incorrect hand value calculated.", 14, testHand.getHandValue());
	}

	/** Tests whether the getHandValue method works as expected with a hard hand. */
	@Test
	public void testGetHandValueWithAPair() {

		Card one = new CardClass("A", "spade");
		Card two = new CardClass("A", "heart");
		testHand.accept(one);
		testHand.accept(two);
		assertEquals("Incorrect hand value calculated.", 12, testHand.getHandValue());
	}

	/** Tests whether the isBusted method identifies a busted hand. */
	@Test
	public void testIsBusted() {
		
		Card one = new CardClass("8", "spade");
		Card two = new CardClass("9", "heart");
		Card three = new CardClass("5", "club");
		testHand.accept(one);
		testHand.accept(two);
		testHand.accept(three);
		int handValue = testHand.getHandValue();
		assertEquals("Incorrect hand value calculated.", 22, handValue);
		assertEquals("Busted hand not identified.", true, testHand.isBusted(handValue));
	}
	
	/** Tests whether the hasBlackJack method identifies a blackJack hand. */
	@Test
	public void testHasBlackJack() {
		
		Card one = new CardClass("8", "spade");
		Card two = new CardClass("9", "heart");
		Card three = new CardClass("3", "club");
		testHand.accept(one);
		testHand.accept(two);
		testHand.accept(three);
		int handValue = testHand.getHandValue();
		assertEquals("Incorrect hand value calculated.", 20, handValue);
		assertEquals("Busted hand not identified.", false, testHand.isBusted(handValue));
		assertEquals("Busted hand not identified.", false, testHand.hasBlackJack(handValue));
	}
	
	/** Tests whether the hasBlackJack method identifies a blackJack hand. */
	@Test
	public void testHasBlackJackAgain() {
		
		Card one = new CardClass("A", "spade");
		Card two = new CardClass("J", "heart");
		testHand.accept(one);
		testHand.accept(two);
		int handValue = testHand.getHandValue();
		assertEquals("Incorrect hand value calculated.", 21, handValue);
		assertEquals("Busted hand not identified.", true, testHand.hasBlackJack(handValue));
	}
	
	/** Tests whether the initiateStates method works for hand value 17 to 20. */
	@Test
	public void testInitiateStates17to20() {

		Card one = new CardClass("8", "spade");
		Card two = new CardClass("A", "heart");
		Card three = new CardClass("10", "club");
		testHand.accept(one);
		testHand.accept(two);
		testHand.accept(three);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = HandValue17to20.getInstance();
		assertEquals("Incorrect hand value calculated.", 19, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works for hand value 16. */
	@Test
	public void testInitiateStates16() {

		Card one = new CardClass("7", "spade");
		Card two = new CardClass("9", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = HandValue16.getInstance();
		assertEquals("Incorrect hand value calculated.", 16, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works for hand value 15. */
	@Test
	public void testInitiateStates15() {

		Card one = new CardClass("7", "spade");
		Card two = new CardClass("8", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = HandValue15.getInstance();
		assertEquals("Incorrect hand value calculated.", 15, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works for hand value 13 to 14. */
	@Test
	public void testInitiateStates13to14() {

		Card one = new CardClass("8", "spade");
		Card two = new CardClass("A", "heart");
		Card three = new CardClass("5", "club");
		testHand.accept(one);
		testHand.accept(two);
		testHand.accept(three);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = HandValue13to14.getInstance();
		assertEquals("Incorrect hand value calculated.", 14, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works for hand value 12. */
	@Test
	public void testInitiateStates12() {

		Card one = new CardClass("10", "spade");
		Card two = new CardClass("2", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = HandValue12.getInstance();
		assertEquals("Incorrect hand value calculated.", 12, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works for hand value 11. */
	@Test
	public void testInitiateStates11() {

		Card one = new CardClass("2", "spade");
		Card two = new CardClass("9", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = HandValue11.getInstance();
		assertEquals("Incorrect hand value calculated.", 11, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works for hand value 10. */
	@Test
	public void testInitiateStates10() {

		Card one = new CardClass("4", "spade");
		Card two = new CardClass("6", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = HandValue10.getInstance();
		assertEquals("Incorrect hand value calculated.", 10, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works for hand value 9. */
	@Test
	public void testInitiateStates9() {

		Card one = new CardClass("4", "spade");
		Card two = new CardClass("5", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = HandValue9.getInstance();
		assertEquals("Incorrect hand value calculated.", 9, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works for hand value 5 to 8. */
	@Test
	public void testInitiateStates5to8() {

		Card one = new CardClass("3", "spade");
		Card two = new CardClass("4", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = HandValue5to8.getInstance();
		assertEquals("Incorrect hand value calculated.", 7, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works for hand value 21. */
	@Test
	public void testInitiateStatesBlackJack() {

		Card one = new CardClass("A", "spade");
		Card two = new CardClass("J", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = BlackJackState.getInstance();
		assertEquals("Incorrect hand value calculated.", 21, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works for hand value > 21. */
	@Test
	public void testInitiateStatesBust() {

		Card one = new CardClass("10", "spade");
		Card two = new CardClass("J", "heart");
		Card three = new CardClass("2", "diamond");
		testHand.accept(one);
		testHand.accept(two);
		testHand.accept(three);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = BustState.getInstance();
		assertEquals("Incorrect hand value calculated.", 22, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with soft hand A and 8. */
	@Test
	public void testInitiateStatesWithSoftHandA8() {

		Card one = new CardClass("8", "spade");
		Card two = new CardClass("A", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = SoftHandA8.getInstance();
		assertEquals("Incorrect hand value calculated.", 19, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with soft hand A and 9. */
	@Test
	public void testInitiateStatesWithSoftHandA9() {

		Card one = new CardClass("9", "spade");
		Card two = new CardClass("A", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = SoftHandA9.getInstance();
		assertEquals("Incorrect hand value calculated.", 20, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with soft hand A and 7. */
	@Test
	public void testInitiateStatesWithSoftHandA7() {

		Card one = new CardClass("7", "spade");
		Card two = new CardClass("A", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = SoftHandA7.getInstance();
		assertEquals("Incorrect hand value calculated.", 18, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with soft hand A and 6. */
	@Test
	public void testInitiateStatesWithSoftHandA6() {

		Card one = new CardClass("6", "spade");
		Card two = new CardClass("A", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = SoftHandA6.getInstance();
		assertEquals("Incorrect hand value calculated.", 17, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with soft hand A,4 or A,5. */
	@Test
	public void testInitiateStatesWithSoftHandA4orA5() {

		Card one = new CardClass("5", "spade");
		Card two = new CardClass("A", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = SoftHandA4orA5.getInstance();
		assertEquals("Incorrect hand value calculated.", 16, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with soft hand A,2 or A,3. */
	@Test
	public void testInitiateStatesWithSoftHandA2orA3() {

		Card one = new CardClass("2", "spade");
		Card two = new CardClass("A", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = SoftHandA2orA3.getInstance();
		assertEquals("Incorrect hand value calculated.", 13, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with pair A, A. */
	@Test
	public void testInitiateStatesWithPairHandA() {

		Card one = new CardClass("A", "spade");
		Card two = new CardClass("A", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = PairHandA.getInstance();
		assertEquals("Incorrect hand value calculated.", 12, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with pair 2, 2 or 3, 3. */
	@Test
	public void testInitiateStatesWithPairHand2or3() {

		Card one = new CardClass("2", "spade");
		Card two = new CardClass("2", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = PairHand2or3.getInstance();
		assertEquals("Incorrect hand value calculated.", 4, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with pair 4, 4. */
	@Test
	public void testInitiateStatesWithPairHand4() {

		Card one = new CardClass("4", "spade");
		Card two = new CardClass("4", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = PairHand4.getInstance();
		assertEquals("Incorrect hand value calculated.", 8, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with pair 5, 5. */
	@Test
	public void testInitiateStatesWithPairHand5() {

		Card one = new CardClass("5", "spade");
		Card two = new CardClass("5", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = PairHand5.getInstance();
		assertEquals("Incorrect hand value calculated.", 10, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with pair 6, 6. */
	@Test
	public void testInitiateStatesWithPairHand6() {

		Card one = new CardClass("6", "spade");
		Card two = new CardClass("6", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = PairHand6.getInstance();
		assertEquals("Incorrect hand value calculated.", 12, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with pair 7, 7. */
	@Test
	public void testInitiateStatesWithPairHand7() {

		Card one = new CardClass("7", "spade");
		Card two = new CardClass("7", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = PairHand7.getInstance();
		assertEquals("Incorrect hand value calculated.", 14, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with pair 8, 8. */
	@Test
	public void testInitiateStatesWithPairHand8() {

		Card one = new CardClass("8", "spade");
		Card two = new CardClass("8", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = PairHand8.getInstance();
		assertEquals("Incorrect hand value calculated.", 16, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with pair 9, 9. */
	@Test
	public void testInitiateStatesWithPairHand9() {

		Card one = new CardClass("9", "spade");
		Card two = new CardClass("9", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = PairHand9.getInstance();
		assertEquals("Incorrect hand value calculated.", 18, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/** Tests whether the initiateStates method works as expected with pair 10, 10. */
	@Test
	public void testInitiateStatesWithPairHand10() {

		Card one = new CardClass("10", "spade");
		Card two = new CardClass("10", "heart");
		testHand.accept(one);
		testHand.accept(two);
		GameState currentState = testHand.initiateStates();
		testHand.setState(currentState);
		GameState newState = PairHand10.getInstance();
		assertEquals("Incorrect hand value calculated.", 20, testHand.getHandValue());
		assertEquals("Incorrect state initiated.", newState, testHand.getState());
	}
	
	/**
	 * Tests whether the equals method in BlackJackHand works as expected.
	 */
	@Test
	public void testEquals() {
		
		BlackJackHand newHand1 = new BlackJackHand();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		
		BlackJackHand newHand2 = new BlackJackHand();
		Card four = new CardClass("J", "heart");
		Card five = new CardClass("9", "spade");
		Card six = new CardClass("A", "club");
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);
		
		boolean isSame = newHand1.equals(newHand2);
		
		assertEquals("equals method not working as expected", false, isSame);
	}
	
	/**
	 * Tests whether the equals method in BlackJackHand works as expected again.
	 */
	@Test
	public void testEqualsAgain() {
		
		BlackJackHand newHand1 = new BlackJackHand();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		
		BlackJackHand newHand2 = new BlackJackHand();
		Card four = new CardClass("2", "spade");
		Card five = new CardClass("7", "diamond");
		Card six = new CardClass("J", "heart");
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);
		
		boolean isSame = newHand1.equals(newHand2);
		
		assertEquals("equals method not working as expected", true, isSame);
	}
	
	/**
	 * Tests whether the hashCode method in BlackJackHand works as expected.
	 */
	@Test
	public void testHashCode() {
		
		BlackJackHand newHand1 = new BlackJackHand();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		
		BlackJackHand newHand2 = new BlackJackHand();
		Card four = new CardClass("J", "heart");
		Card five = new CardClass("9", "spade");
		Card six = new CardClass("A", "club");
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);
			
		assertNotEquals("hashCode method not working as expected", newHand1.hashCode(), newHand2.hashCode());
	}
	
	/**
	 * Tests whether the hashCode method in BlackJackHand works as expected again.
	 */
	@Test
	public void testHashCodeAgain() {
		
		BlackJackHand newHand1 = new BlackJackHand();
		Card one = new CardClass("2", "spade");
		Card two = new CardClass("7", "diamond");
		Card three = new CardClass("J", "heart");
		newHand1.accept(one);
		newHand1.accept(two);
		newHand1.accept(three);
		
		BlackJackHand newHand2 = new BlackJackHand();
		Card four = new CardClass("2", "spade");
		Card five = new CardClass("7", "diamond");
		Card six = new CardClass("J", "heart");
		newHand2.accept(four);
		newHand2.accept(five);
		newHand2.accept(six);
				
		assertEquals("equals method not working as expected", newHand1.hashCode(), newHand2.hashCode());
	}
	
}
