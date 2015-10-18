package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

public enum TennisGameScoreExpectation
{
	LOVE_ALL(0,0,"love-all"),
	FIFTEEN_LOVE(1,0,"fifteen-love"),
	LOVE_FIFTEEN(0,1,"love-fifteen");

	private final int serverPoints;
	
	private final int receiverPoints;
	
	private final String expectedScore;

	private TennisGameScoreExpectation(int serverPoints, int receiverPoints, String expectedScore)
	{
		this.serverPoints = serverPoints;
		this.receiverPoints = receiverPoints;
		this.expectedScore = expectedScore;
	}

	public int getServerPoints()
	{
		return this.serverPoints;
	}

	public int getReceiverPoints()
	{
		return this.receiverPoints;
	}

	public String getExpectedScore()
	{
		return this.expectedScore;
	}
}
