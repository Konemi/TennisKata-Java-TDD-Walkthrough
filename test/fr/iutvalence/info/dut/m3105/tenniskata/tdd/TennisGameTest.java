package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TennisGameTest
{
	private static final int TURN_AMOUNT_IN_LOOP = 10;

	@Test
	public void testScoresAgainstExpectations()
	{
		for (TennisGameScoreExpectation expectation : TennisGameScoreExpectation.values())
			setAndTestScoreAgainstExpectation(expectation);
	}

	private static TennisGame setAndTestScoreAgainstExpectation(TennisGameScoreExpectation expectation)
	{		
		TennisGame tennisGame = TennisGameScoreSetter.getTennisGameWithGivenPointsScored(expectation.getServerPoints(), expectation.getReceiverPoints());
		assertScoreIsAsExpected(tennisGame, expectation);
		return tennisGame;
	}

	private static void assertScoreIsAsExpected(TennisGame tennisGame, TennisGameScoreExpectation expectation)
	{
		assertEquals(tennisGame.getScore(), expectation.getExpectedScore());
	}
	
	@Test
	public void testDeuceLoops()
	{
		TennisGame tennisGame = setAndTestScoreAgainstExpectation(TennisGameScoreExpectation.DEUCE);
		
		for (int loopTurns=0; loopTurns<TURN_AMOUNT_IN_LOOP;loopTurns++)
			testDeuceLoop(tennisGame);
	}
	
	private void testDeuceLoop(TennisGame tennisGame)
	{
		tennisGame.serverHasScored();
		assertScoreIsAsExpected(tennisGame, TennisGameScoreExpectation.AD_IN);
		
		tennisGame.receiverHasScored();
		assertScoreIsAsExpected(tennisGame, TennisGameScoreExpectation.DEUCE);
		
		tennisGame.receiverHasScored();
		assertScoreIsAsExpected(tennisGame, TennisGameScoreExpectation.AD_OUT);
		
		tennisGame.serverHasScored();
		assertScoreIsAsExpected(tennisGame, TennisGameScoreExpectation.DEUCE);
	}
	
	@Test
	public void testGameAfterAdvantage()
	{
		testGameInAfterAdvantage();
		testGameOutAfterAdvantage();
	}

	private void testGameInAfterAdvantage()
	{
		TennisGame tennisGame = setAndTestScoreAgainstExpectation(TennisGameScoreExpectation.AD_IN);
		tennisGame.serverHasScored();
		assertScoreIsAsExpected(tennisGame, TennisGameScoreExpectation.GAME_IN_0);
	}
	
	private void testGameOutAfterAdvantage()
	{
		TennisGame tennisGame = setAndTestScoreAgainstExpectation(TennisGameScoreExpectation.AD_OUT);
		tennisGame.receiverHasScored();
		assertScoreIsAsExpected(tennisGame, TennisGameScoreExpectation.GAME_OUT_0);
	}
}
