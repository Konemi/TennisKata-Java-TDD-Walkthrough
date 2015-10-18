package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TennisGameTest
{
	private TennisGame tennisGame;

	private void setPlayersPoints(int serverPoints, int receiverPoints)
	{
		this.setServerPoints(serverPoints);
		this.setReceiverPoints(receiverPoints);
	}

	private void setServerPoints(int points)
	{
		for (int point = 0; point < points; point++)
			this.tennisGame.serverHasScored();
	}

	private void setReceiverPoints(int points)
	{
		for (int point = 0; point < points; point++)
			this.tennisGame.receiverHasScored();
	}
	
	@Test
	public void testScoresAgainstExpectations()
	{
		for (TennisGameScoreExpectation expectation: TennisGameScoreExpectation.values())
		{
			this.tennisGame = new TennisGame();
			this.testScoreAgainstExpectation(expectation);
		}		
	}
	
	private void testScoreAgainstExpectation(TennisGameScoreExpectation expectation)
	{
		this.setPlayersPoints(expectation.getServerPoints(), expectation.getReceiverPoints());
		assertEquals(this.tennisGame.getScore(), expectation.getExpectedScore());
	}
}
