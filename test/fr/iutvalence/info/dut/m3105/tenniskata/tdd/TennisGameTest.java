package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest
{
	private TennisGame tennisGame ;
	
	private void setPlayersPoints(int serverPoints, int receiverPoints)
	{
		this.setServerPoints(serverPoints);
		this.setReceiverPoints(receiverPoints);
	}
	
	private void setServerPoints(int points)
	{
		for (int point=0; point<points; point++)
			this.tennisGame.serverHasScored();
	}

	private void setReceiverPoints(int points)
	{
		for (int point=0; point<points; point++)
			this.tennisGame.receiverHasScored();
	}
	
	@Before
	public void newTennisGame()
	{
		this.tennisGame = new TennisGame();
	}
	
	@Test
	public void ifPointsScoredAre_0_0_ScoreShouldBe_love_all()
	{
		this.setPlayersPoints(0, 0);
		assertEquals(this.tennisGame.getScore(), "love-all");
	}
	
	@Test
	public void ifPointsScoredAre_1_0_ScoreShouldBe_fifteen_love()
	{
		this.setPlayersPoints(1, 0);
		assertEquals(this.tennisGame.getScore(), "fifteen-love");
	}
	
	@Test
	public void ifPointsScoredAre_0_1_ScoreShouldBe_love_fifteen()
	{
		this.setPlayersPoints(0, 1);
		assertEquals(this.tennisGame.getScore(), "love-fifteen");
	}
}
