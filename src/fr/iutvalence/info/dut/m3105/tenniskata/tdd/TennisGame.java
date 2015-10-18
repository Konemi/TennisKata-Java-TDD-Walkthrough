package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

public class TennisGame
{
	private static final int POINT_AMOUNT_FOR_ADVANTAGE_SCORE = 4;

	private static final int POINT_AMOUNT_FOR_DEUCE_SCORE = 3;

	private final static String[] INDIVIDUAL_SCORE = new String[] { "love", "fifteen", "thirty", "forty" };

	private int serverPoints;

	private int receiverPoints;

	public TennisGame()
	{
		this.serverPoints = 0;
		this.receiverPoints = 0;
	}

	public String getScore()
	{
		if (isTiedScore()) return getScoreWhenTied();

		return getScoreWhenNotTied();
	}

	private boolean isTiedScore()
	{		
		return this.serverPoints == this.receiverPoints;
	}
	
	private String getScoreWhenTied()
	{
		if (isDeuce()) return getScoreWhenDeuce();
		
		return getScoreWhenTiedScoreBelowDeuce();
	}

	private boolean isDeuce()
	{
		return this.serverPoints == POINT_AMOUNT_FOR_DEUCE_SCORE;
	}

	private String getScoreWhenDeuce()
	{
		return "deuce";
	}

	private String getScoreWhenTiedScoreBelowDeuce()
	{
		return INDIVIDUAL_SCORE[this.serverPoints] + "-all";
	}

	private String getScoreWhenNotTied()
	{
		if (isAdvantage()) return getScoreWhenAdvantage();

		return getScoreWhenNotTiedBelowDeuce();
	}

	private boolean isAdvantage()
	{
		return (isAdvantageIn() || isAdvantageOut());
	}

	private String getScoreWhenAdvantage()
	{
		if (isAdvantageIn()) return "advantage in";
		return "advantage out";
	}

	private String getScoreWhenNotTiedBelowDeuce()
	{
		return INDIVIDUAL_SCORE[this.serverPoints] + "-" + INDIVIDUAL_SCORE[this.receiverPoints];
	}

	private boolean isAdvantageOut()
	{
		return this.receiverPoints == POINT_AMOUNT_FOR_ADVANTAGE_SCORE;
	}

	private boolean isAdvantageIn()
	{
		return this.serverPoints == POINT_AMOUNT_FOR_ADVANTAGE_SCORE;
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
