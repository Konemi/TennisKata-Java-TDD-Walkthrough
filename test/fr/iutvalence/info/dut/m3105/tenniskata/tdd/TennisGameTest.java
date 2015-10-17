package fr.iutvalence.info.dut.m3105.tenniskata.tdd;


import static org.junit.Assert.*;
import org.junit.Test;

public class TennisGameTest
{
	@Test
	public void ifServerHasNotScoredAndReceiverHasNotScoredScoreShouldBe_love_all()
	{
		TennisGame tennisGame = new TennisGame();
		assertEquals(tennisGame.getScore(), "love-all");
	}
	
	@Test
	public void ifServerHasScored1TimeAndReceiverHasNotScoredScoreShouldBe_fifteen_love()
	{
		TennisGame tennisGame = new TennisGame();
		tennisGame.serverHasScored();
		assertEquals(tennisGame.getScore(), "fifteen-love");
	}
}
