package edu.northeastern.ccs.cs5500.homework5.rank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.northeastern.ccs.cs5500.homework5.InvalidRank;
/**
 * Tests that verify whether the Rank of a card works as expected.
 * 
 * @author Riya Nadkarni
 * @version 09-28-2018
 */
public class RankTest {

	/**
	 * Tests whether the rank class creates a rank as expected.
	 */
	@Test
	public void testRank() {

		RankEnum rankEnum = RankEnum.SEVEN;
		Rank rank = new RankClass(rankEnum);
		assertEquals("Incorrect rank name.", "7", rank.getName());
		assertEquals("Incorrect rank pip.", 7, rank.getPips());
	}

	/**
	 * Tests whether the rank class creates a rank as expected again.
	 */
	@Test
	public void testRankAgain() {

		RankEnum rankEnum = RankEnum.JACK;
		Rank rank = new RankClass(rankEnum);
		assertEquals("Incorrect rank name.", "J", rank.getName());
		assertEquals("Incorrect rank pip.", 0, rank.getPips());
	}
	
	/**
	 * Tests whether the compareTo method in Rank Class throws an exception as expected.
	 */
	@Test
	public void testRankCompareToWithInvalidInput() {
		
		InvalidRank testRank = new InvalidRank();
		RankEnum rankEnum = RankEnum.SEVEN;
		RankClass newRank = new RankClass(rankEnum);
		String expected = "Cannot compare 2 different objects.";
		
		try {
			newRank.compareTo(testRank);
			fail("compareTo method did not thro an exception when it should");
		}
		catch(IllegalArgumentException ex) {
			assertEquals("compareTo method not working as expected", expected, ex.getMessage());
		}
	}

	/**
	 * Tests whether the getRank method works as expected.
	 */
	@Test
	public void testGetRank() {

		RankEnum rankEnum = RankClass.getRank("9");
		assertEquals("Incorrect rank name.", "9", rankEnum.getName());
		assertEquals("Incorrect rank pip.", 9, rankEnum.getPips());
	}

	/**
	 * Tests whether the getRank method works as expected again.
	 */
	@Test
	public void testGetRankAgain() {

		RankEnum rankEnum = RankClass.getRank("5");
		assertEquals("Incorrect rank name.", "5", rankEnum.getName());
		assertEquals("Incorrect rank pip.", 5, rankEnum.getPips());
	}
	
	/** Tests whether the equals method in RankClass works as expected. */
	@Test
	public void testRankEquals() {
		
		RankClass one = new RankClass(RankEnum.EIGHT);
		RankClass two = new RankClass(RankEnum.ACE);
		
		boolean isSame = one.equals(two);
		
		assertEquals("equals method not working as expected", false, isSame);
	}
	
	/** Tests whether the equals method in RankClass works as expected again. */
	@Test
	public void testRankEqualsAgain() {
		
		RankClass one = new RankClass(RankEnum.JACK);
		RankClass two = new RankClass(RankEnum.JACK);
		
		boolean isSame = one.equals(two);
		
		assertEquals("equals method not working as expected", true, isSame);
	}
	
	/**
	 * Tests whether the hashCode method in RankClass works as expected.
	 */
	@Test
	public void testRankHashCode() {
		
		RankClass one = new RankClass(RankEnum.TWO);
		RankClass two = new RankClass(RankEnum.SEVEN);
		
		assertNotEquals("hashCode method not working as expected", one.hashCode(), two.hashCode());
	}
	
	/**
	 * Tests whether the hashCode method in RankClass works as expected again.
	 */
	@Test
	public void testRankHashCodeAgain() {
		
		RankClass one = new RankClass(RankEnum.QUEEN);
		RankClass two = new RankClass(RankEnum.QUEEN);
		
		assertEquals("hashCode method not working as expected", one.hashCode(), two.hashCode());
	}
}
