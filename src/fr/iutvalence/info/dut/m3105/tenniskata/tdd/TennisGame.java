package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

public class TennisGame
{
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
		if (this.serverPoints == 3)
			return "deuce";
		else
			return INDIVIDUAL_SCORE[this.serverPoints]+"-all";
	}

	private String getScoreWhenNotTied()
	{
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
