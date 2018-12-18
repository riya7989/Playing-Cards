package edu.northeastern.ccs.cs5500.homework3;

import edu.northeastern.ccs.cs5500.homework3.rank.Rank;

/**
 * Dummy class to make sure that the compareTo method in RankClass throws an exception as expected.
 * @author Riya Nadkarni
 * @version 10-02-2018
 */
public class InvalidRank implements Rank {

	@Override
	public int compareTo(Rank arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "Invalid Rank";
	}

	@Override
	public int getPips() {
		return '0';
	}

}
