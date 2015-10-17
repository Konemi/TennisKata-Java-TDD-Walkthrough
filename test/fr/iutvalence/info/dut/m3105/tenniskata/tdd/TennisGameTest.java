package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest
{
	private TennisGame tennisGame ;
	
	@Before
	public void newTennisGame()
	{
		this.tennisGame = new TennisGame();
	}
	
	@Test
	public void ifServerHasNotScoredAndReceiverHasNotScoredScoreShouldBe_love_all()
	{
		assertEquals(this.tennisGame.getScore(), "love-all");
	}
	
	@Test
	public void ifServerHasScored1TimeAndReceiverHasNotScoredScoreShouldBe_fifteen_love()
	{
		this.tennisGame.serverHasScored();
		assertEquals(this.tennisGame.getScore(), "fifteen-love");
	}
	
	@Test
	public void ifServerHasNotScoredAndReceiverHasScored1TimeScoreShouldBe_love_fifteen()
	{
		this.tennisGame.receiverHasScored();
		assertEquals(this.tennisGame.getScore(), "love-fifteen");
	}
}
