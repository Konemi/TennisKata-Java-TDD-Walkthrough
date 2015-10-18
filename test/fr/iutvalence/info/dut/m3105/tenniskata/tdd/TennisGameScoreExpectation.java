package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

public enum TennisGameScoreExpectation
{
	LOVE_ALL(0,0,"love-all"),
	LOVE_FIFTEEN(0,1,"love-fifteen"),
	LOVE_THIRTY(0,2,"love-thirty"),
	LOVE_FORTY(0,3,"love-forty"),
	FIFTEEN_LOVE(1,0,"fifteen-love"),
	FIFTEEN_ALL(1,1,"fifteen-all"),
	FIFTEEN_THIRTY(1,2,"fifteen-thirty"),
	FIFTEEN_FORTY(1,3,"fifteen-forty"),
	THIRTY_LOVE(2,0,"thirty-love"),
	THIRTY_FIFTEEN(2,1,"thirty-fifteen"),
	THIRTY_ALL(2,2,"thirty-all"),
	THIRTY_FORTY(2,3,"thirty-forty"),
	DEUCE(3,3,"deuce");

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
