package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TennisGameTest
{
	@Test
	public void testScoresAgainstExpectations()
	{
		for (TennisGameScoreExpectation expectation : TennisGameScoreExpectation.values())
			testScoreAgainstExpectation(expectation);
	}

	private static void testScoreAgainstExpectation(TennisGameScoreExpectation expectation)
	{		
		TennisGame tennisGame = TennisGameScoreSetter.getTennisGameWithGivenPointsScored(expectation.getServerPoints(), expectation.getReceiverPoints());
		assertEquals(tennisGame.getScore(), expectation.getExpectedScore());
	}
}
