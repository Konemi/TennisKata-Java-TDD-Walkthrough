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
	
	@Test
	public void testDeuceLoops()
	{
		TennisGame tennisGame = this.setAndTestDeuceScore();
		
		for (int loopTurns=0; loopTurns<10;loopTurns++)
		{
			testDeuceLoop(tennisGame);
		}
	}
	
	private TennisGame setAndTestDeuceScore()
	{
		int serverPoints = TennisGameScoreExpectation.DEUCE.getServerPoints();
		int receiverPoints = TennisGameScoreExpectation.DEUCE.getReceiverPoints();
		TennisGame tennisGame = TennisGameScoreSetter.getTennisGameWithGivenPointsScored(serverPoints, receiverPoints);
		assertEquals(tennisGame.getScore(), TennisGameScoreExpectation.DEUCE.getExpectedScore());
		return tennisGame;
	}
	
	private void testDeuceLoop(TennisGame tennisGame)
	{
		tennisGame.serverHasScored();
		assertEquals(tennisGame.getScore(), TennisGameScoreExpectation.AD_IN.getExpectedScore());
		tennisGame.receiverHasScored();
		assertEquals(tennisGame.getScore(), TennisGameScoreExpectation.DEUCE.getExpectedScore());
		tennisGame.receiverHasScored();
		assertEquals(tennisGame.getScore(), TennisGameScoreExpectation.AD_OUT.getExpectedScore());
		tennisGame.serverHasScored();
		assertEquals(tennisGame.getScore(), TennisGameScoreExpectation.DEUCE.getExpectedScore());
	}
}
