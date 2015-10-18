package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

public class TennisGameScoredPoints
{
	private static final int POINT_AMOUNT_FOR_DEUCE_SCORE = 3;
	
	private static final int POINT_AMOUNT_FOR_ADVANTAGE_SCORE = 4;
	
	private static final int POINT_AMOUNT_FOR_GAME_SCORE = 4;
	
	private final int serverScoredPoints;
	
	private final int receiverScoredPoints;
	
	public TennisGameScoredPoints()
	{
		this.serverScoredPoints = 0;
		this.receiverScoredPoints = 0;
	}
	
	private TennisGameScoredPoints(int serverScoredPoints, int receiverScoredPoints)
	{
		this.serverScoredPoints = serverScoredPoints;
		this.receiverScoredPoints = receiverScoredPoints;
	}

	public TennisGameScoredPoints getScoredPointsWhenServerScores()
	{
		return new TennisGameScoredPoints(this.serverScoredPoints+1, this.receiverScoredPoints);
	}

	public TennisGameScoredPoints getScoredPointsWhenReceiverScores()
	{
		return new TennisGameScoredPoints(this.serverScoredPoints, this.receiverScoredPoints+1);
	}
	
	public int getServerScoredPoints()
	{
		return this.serverScoredPoints;
	}

	public int getReceiverScoredPoints()
	{
		return this.receiverScoredPoints;
	}
	
	public boolean isTiedScore()
	{		
		return this.serverScoredPoints == this.receiverScoredPoints;
	}
	
	public boolean isDeuce()
	{
		return (this.serverScoredPoints >= POINT_AMOUNT_FOR_DEUCE_SCORE);
	}
	
	public boolean isAdvantage()
	{
		return (isAdvantageIn() || isAdvantageOut());
	}
	
	public boolean isAdvantageIn()
	{
		if (this.serverScoredPoints < POINT_AMOUNT_FOR_ADVANTAGE_SCORE) return false;
		return (this.serverScoredPoints == this.receiverScoredPoints+1);
	}
	
	public boolean isAdvantageOut()
	{
		if (this.receiverScoredPoints < POINT_AMOUNT_FOR_ADVANTAGE_SCORE) return false;
		return (this.receiverScoredPoints == this.serverScoredPoints+1);
	}
	
	public boolean isGame()
	{
		return (isGameIn() || isGameOut());
	}

	public boolean isGameIn()
	{
		if (this.serverScoredPoints < POINT_AMOUNT_FOR_GAME_SCORE) return false;
		return (this.serverScoredPoints > this.receiverScoredPoints+1);
	}

	public boolean isGameOut()
	{
		if (this.receiverScoredPoints < POINT_AMOUNT_FOR_GAME_SCORE) return false;
		return (this.receiverScoredPoints > this.serverScoredPoints+1);
	}	
}