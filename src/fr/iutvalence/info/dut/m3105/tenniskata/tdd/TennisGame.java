package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

public class TennisGame
{
	private static final int POINT_AMOUNT_FOR_ADVANTAGE_SCORE = 4;

	private static final int POINT_AMOUNT_FOR_DEUCE_SCORE = 3;

	private final static String[] INDIVIDUAL_SCORE = new String[] {"love", "fifteen", "thirty", "forty"};
	
	private int serverPoints;
	
	private int receiverPoints;
	
	public TennisGame()
	{
		this.serverPoints = 0;
		this.receiverPoints = 0;
	}
	
	public String getScore()
	{
		if (playersHaveScoredSameAmountOfPoints()) 
			return getScoreWhenTied();
		
		return getScoreWhenNotTied();
	}

	private boolean playersHaveScoredSameAmountOfPoints()
	{
		return this.serverPoints == this.receiverPoints;
	}
	
	private String getScoreWhenTied()
	{
		if (this.serverPoints == POINT_AMOUNT_FOR_DEUCE_SCORE)
			return "deuce";
		else
			return INDIVIDUAL_SCORE[this.serverPoints]+"-all";
	}

	private String getScoreWhenNotTied()
	{
		if (this.serverPoints == POINT_AMOUNT_FOR_ADVANTAGE_SCORE)
			return "advantage in";
		if (this.receiverPoints == POINT_AMOUNT_FOR_ADVANTAGE_SCORE)
			return "advantage out";
		
		return INDIVIDUAL_SCORE[this.serverPoints]+"-"+INDIVIDUAL_SCORE[this.receiverPoints];
	}

	public void serverHasScored()
	{
		this.serverPoints++;
	}

	public void receiverHasScored()
	{
		this.receiverPoints++;		
	}
}
