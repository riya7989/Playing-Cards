package edu.northeastern.ccs.cs5500.homework5.blackjack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework5.MockDeckFactory;
import edu.northeastern.ccs.cs5500.homework5.card.Card;
import edu.northeastern.ccs.cs5500.homework5.deck.Deck;
import edu.northeastern.ccs.cs5500.homework5.deck.DeckFactory;
import edu.northeastern.ccs.cs5500.homework5.deck.VegasDeckClass;


/**
 * Tests that verify whether the BlackJackGame class works as expected.
 * 
 * @author Riya Nadkarni
 * @version 10-25-2018
 */
public class BlackJackGameTest {

	/** Tests whether the constructor creates the right game. */
	@Test
	public void testConstructor() {

		BlackJackGame testGame = new BlackJackGame(5);
		assertEquals("Incorrect game created.", new VegasDeckClass(), testGame.getGameDeck());
		assertEquals("Incorrect number of hands.", 6, testGame.getNumberOfHands());
		assertEquals("Incorrect number of cards in each hand.", 2, testGame.getNumberOfCards());
		assertEquals("Incorrect turn number.", 1, testGame.getCurrentTurn());
		assertEquals("Incorrect current player.", null, testGame.getCurrentPlayer());
		assertEquals("Incorrect hand size", 0, testGame.getGameHand().size());

	}

	/** Tests the constructor with invalid number of hands. */
	@Test
	public void testConstructorWithInvalidNumberOfHands() {

		String expected = "Number of players should be between 1 and 5";

		try {
			new BlackJackGame(6);
			fail("Game constructor did not throw and exception when it should");
		} catch (IllegalArgumentException ex) {
			assertEquals("Game created with incorrect number of hands.", expected, ex.getMessage());
		}
	}

	/** Tests the constructor with invalid number of hands again. */
	@Test
	public void testConstructorWithInvalidNumberOfHandsAgain() {

		String expected = "Number of players should be between 1 and 5";

		try {
			new BlackJackGame(-6);
			fail("Game constructor did not throw and exception when it should");
		} catch (IllegalArgumentException ex) {
			assertEquals("Game created with incorrect number of hands.", expected, ex.getMessage());
		}
	}

	/** Tests whether the deal method works as expected. */
	@Test
	public void testDeal() {
		DeckFactory mockFactory = new MockDeckFactory();
		BlackJackGame testGame = new BlackJackGame(mockFactory, 2);
		Deck mockDeck = mockFactory.makeDeck();
		boolean sameDeck = mockDeck.equals(testGame.getGameDeck());
		assertEquals("Incorrect game created.", true, sameDeck);
		assertEquals("Incorrect deck length.", 17, testGame.getGameDeck().getLength());
		testGame.deal();
		assertEquals("Incorrect number of hands.", 3, testGame.getNumberOfHands());
		assertEquals("Incorrect number of cards in each hand.", 2, testGame.getNumberOfCards());

		BlackJackHand dealer = testGame.getBlackJackHand().get(0);
		BlackJackHand player1 = testGame.getBlackJackHand().get(1);
		BlackJackHand player2 = testGame.getBlackJackHand().get(2);
		BlackJackHand player3 = testGame.getBlackJackHand().get(3);
		BlackJackHand player4 = testGame.getBlackJackHand().get(4);

		assertEquals("Incorrect card 1 rank in dealer's hand", "7", dealer.showCards().get(0).getRank().getName());
		assertEquals("Incorrect card 1 suit in dealer's hand", "spade", dealer.showCards().get(0).getSuit().getName());
		assertEquals("Incorrect card 2 rank in dealer's hand", "Q", dealer.showCards().get(1).getRank().getName());
		assertEquals("Incorrect card 2 suit in dealer's hand", "diamond",
				dealer.showCards().get(1).getSuit().getName());
		assertEquals("Incorrect card 3 rank in dealer's hand", "3", dealer.showCards().get(2).getRank().getName());
		assertEquals("Incorrect card 3 suit in dealer's hand", "club", dealer.showCards().get(2).getSuit().getName());
		assertEquals("Incorrect card 4 rank in dealer's hand", "A", dealer.showCards().get(3).getRank().getName());
		assertEquals("Incorrect card 4 suit in dealer's hand", "diamond",
				dealer.showCards().get(3).getSuit().getName());
		assertEquals("Incorrect card 1 rank in player1's hand", "8", player1.showCards().get(0).getRank().getName());
		assertEquals("Incorrect card 1 suit in player1's hand", "club", player1.showCards().get(0).getSuit().getName());
		assertEquals("Incorrect card 2 rank in player1's hand", "2", player1.showCards().get(1).getRank().getName());
		assertEquals("Incorrect card 2 suit in player1's hand", "diamond",
				player1.showCards().get(1).getSuit().getName());
		assertEquals("Incorrect card 3 rank in player1's hand", "J", player1.showCards().get(2).getRank().getName());
		assertEquals("Incorrect card 3 suit in player1's hand", "spade",
				player1.showCards().get(2).getSuit().getName());
		assertEquals("Incorrect card 1 rank in player2's hand", "8", player2.showCards().get(0).getRank().getName());
		assertEquals("Incorrect card 1 suit in player2's hand", "spade",
				player2.showCards().get(0).getSuit().getName());
		assertEquals("Incorrect card 2 rank in player2's hand", "5", player2.showCards().get(1).getRank().getName());
		assertEquals("Incorrect card 2 suit in player2's hand", "heart",
				player2.showCards().get(1).getSuit().getName());
		assertEquals("Incorrect card 3 rank in player2's hand", "9", player2.showCards().get(2).getRank().getName());
		assertEquals("Incorrect card 3 suit in player2's hand", "club", player2.showCards().get(2).getSuit().getName());
		assertEquals("Incorrect card 1 rank in player3's hand", "8", player3.showCards().get(0).getRank().getName());
		assertEquals("Incorrect card 1 suit in player3's hand", "heart",
				player3.showCards().get(0).getSuit().getName());
		assertEquals("Incorrect card 2 rank in player3's hand", "4", player3.showCards().get(1).getRank().getName());
		assertEquals("Incorrect card 2 suit in player3's hand", "diamond",
				player3.showCards().get(1).getSuit().getName());
		assertEquals("Incorrect card 3 rank in player3's hand", "9", player3.showCards().get(2).getRank().getName());
		assertEquals("Incorrect card 3 suit in player3's hand", "spade",
				player3.showCards().get(2).getSuit().getName());
		assertEquals("Incorrect card 1 rank in player4's hand", "A", player4.showCards().get(0).getRank().getName());
		assertEquals("Incorrect card 1 suit in player4's hand", "club", player4.showCards().get(0).getSuit().getName());
		assertEquals("Incorrect card 2 rank in player4's hand", "6", player4.showCards().get(1).getRank().getName());
		assertEquals("Incorrect card 2 suit in player4's hand", "heart",
				player4.showCards().get(1).getSuit().getName());
		assertEquals("Incorrect card 3 rank in player4's hand", "2", player4.showCards().get(2).getRank().getName());
		assertEquals("Incorrect card 3 suit in player4's hand", "heart",
				player4.showCards().get(2).getSuit().getName());

		assertEquals("Incorrect state of dealer's hand", BlackJackState.getInstance(), dealer.getState());
		assertEquals("Incorrect state of player1's hand", StandState.getInstance(), player1.getState());
		assertEquals("Incorrect state of player2's hand", BustState.getInstance(), player2.getState());
		assertEquals("Incorrect state of player3's hand", BlackJackState.getInstance(), player3.getState());
		assertEquals("Incorrect state of player4's hand", StandState.getInstance(), player4.getState());
	}

	/** Tests whether the getFaceUpCard method works as expected. */
	@Test
	public void testGetFaceUpCard() {

		DeckFactory mockFactory = new MockDeckFactory();
		BlackJackGame testGame = new BlackJackGame(mockFactory, 2);
		testGame.deal();
		Card faceUp = testGame.getFaceUpCard();

		assertEquals("Incorrect face up card rank", "7", faceUp.getRank().getName());
		assertEquals("Incorrect face up card suit", "spade", faceUp.getSuit().getName());
	}

	/** Tests whether the hit function works as expected. */
	@Test
	public void testHit() {

		DeckFactory mockFactory = new MockDeckFactory();
		BlackJackGame testGame = new BlackJackGame(mockFactory, 2);
		testGame.deal();
		BlackJackHand lastPlayer = testGame.getBlackJackHand().get(0);
		assertEquals("Incorrect rank of card before hit", "A", lastPlayer.showCards().get(3).getRank().getName());
		assertEquals("Incorrect rank of card before hit", "diamond", lastPlayer.showCards().get(3).getSuit().getName());
		testGame.hit();
		assertEquals("Incorrect rank of card after hit", "K", lastPlayer.showCards().get(4).getRank().getName());
		assertEquals("Incorrect rank of card after hit", "heart", lastPlayer.showCards().get(4).getSuit().getName());
	}

	/** Tests nextTurn when all players are done playing. */
	@Test
	public void testNextTurn() {

		DeckFactory mockFactory = new MockDeckFactory();
		BlackJackGame testGame = new BlackJackGame(mockFactory, 2);
		testGame.deal();
		testGame.nextTurn();
		assertEquals("Incorrect next turn", 0, testGame.getCurrentTurn());
	}

	/**
	 * Tests whether the bust method reduces the player's bet amount by $1 and
	 * passes the turn to the next player. Note - May fail sometimes if the player
	 * hand is dealt a busted hand from the start. In that case nextTurn will call
	 * the dealer's hand instead of the player's.
	 */
	@Test
	public void testBust() {

		DeckFactory mockFactory = new MockDeckFactory();
		BlackJackGame testGame = new BlackJackGame(mockFactory, 2);
		testGame.deal();

		Player dealer = testGame.getBlackJackHand().get(0).getPlayer();
		Player player1 = testGame.getBlackJackHand().get(1).getPlayer();
		Player player2 = testGame.getBlackJackHand().get(2).getPlayer();
		Player player3 = testGame.getBlackJackHand().get(3).getPlayer();
		Player player4 = testGame.getBlackJackHand().get(4).getPlayer();

		assertEquals("Incorrect dealer bet amount", 1, dealer.getBet());
		assertEquals("Incorrect player 1 bet amount", 1, player1.getBet());
		assertEquals("Incorrect player 2 bet amount", 1, player2.getBet());
		assertEquals("Incorrect player 3 bet amount", 1, player3.getBet());
		assertEquals("Incorrect player 4 bet amount", 0, player4.getBet());

	}

	/** Tests whether the split method splits the hand if it contains a pair. */
	@Test
	public void testSplit() {

		DeckFactory mockFactory = new MockDeckFactory();
		BlackJackGame testGame = new BlackJackGame(mockFactory, 2);
		testGame.deal(); // player 1 gets a Pair of 8,8 which splits and 1 of them again hits an 8. So
							// another split.

		Player dealer = testGame.getBlackJackHand().get(0).getPlayer();
		Player player1 = testGame.getBlackJackHand().get(1).getPlayer();
		Player player2 = testGame.getBlackJackHand().get(2).getPlayer();
		Player player3 = testGame.getBlackJackHand().get(3).getPlayer();
		Player player4 = testGame.getBlackJackHand().get(4).getPlayer();

		assertEquals("Split method created a new player for the split hand", true, player1.equals(player2));
		assertEquals("Split method created a new player for the split hand", true, player2.equals(player3));
		assertEquals("Split method created a new player for the split hand", true, player1.equals(player3));
		assertEquals("Split method created a new player for the split hand", false, player1.equals(dealer));
		assertEquals("Split method created a new player for the split hand", false, player1.equals(player4));
	}
	
	/**
	 * Tests whether the equals method in BlackJackGame works as expected.
	 */
	@Test
	public void testEquals() {
		
		DeckFactory mockFactory = new MockDeckFactory();
		DeckFactory standardFactory = new DeckFactory();
		BlackJackGame poker = new BlackJackGame(mockFactory, 1);
		BlackJackGame uno = new BlackJackGame(standardFactory, 1);
		
		boolean isSame = poker.equals(uno);
		
		assertEquals("equals method not working as expected", false, isSame);
	}
	
	/**
	 * Tests whether the equals method in BlackJackGame works as expected again.
	 */
	@Test
	public void testEqualsAgain() {
		
		DeckFactory mockFactory = new MockDeckFactory();
		DeckFactory mockFactory2 = new MockDeckFactory();
		
		BlackJackGame poker = new BlackJackGame(mockFactory, 3);
		BlackJackGame uno = new BlackJackGame(mockFactory2, 3);
		
		boolean isSame = poker.equals(uno);
		
		assertEquals("equals method not working as expected", true, isSame);
	}
	
	/**
	 * Tests whether the hashCode method in BlackJackGame works as expected.
	 */
	@Test
	public void testHashCode() {
		
		DeckFactory mockFactory = new MockDeckFactory();
		DeckFactory standardFactory = new DeckFactory();
		BlackJackGame poker = new BlackJackGame(mockFactory, 1);
		BlackJackGame uno = new BlackJackGame(standardFactory, 1);
		
		assertNotEquals("hashcode method not working as expected", poker.hashCode(), uno.hashCode());
	}
	
	/**
	 * Tests whether the hashCode method in BlackJackGame works as expected again.
	 */
	@Test
	public void testHashCodeAgain() {
		
		DeckFactory mockFactory = new MockDeckFactory();
		DeckFactory mockFactory2 = new MockDeckFactory();
		
		BlackJackGame poker = new BlackJackGame(mockFactory, 3);
		BlackJackGame uno = new BlackJackGame(mockFactory2, 3);
			
		assertEquals("hashCode method not working as expected", poker.hashCode(), uno.hashCode());
	}

}
