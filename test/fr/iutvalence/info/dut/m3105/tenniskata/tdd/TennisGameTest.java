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
}
