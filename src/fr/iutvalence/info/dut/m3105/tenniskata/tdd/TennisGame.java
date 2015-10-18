package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

public class TennisGame
{
	private static final int POINT_AMOUNT_FOR_ADVANTAGE_SCORE = 4;
	
	private static final int POINT_AMOUNT_FOR_GAME_SCORE = 4;

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
		return (this.serverPoints >= POINT_AMOUNT_FOR_DEUCE_SCORE);
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
		if (isGame()) return getScoreWhenGame();
		
		if (isAdvantage()) return getScoreWhenAdvantage();

		return getScoreWhenNotTiedBelowDeuce();
	}

	private String getScoreWhenGame()
	{
		if (isGameIn()) return "game in";
		return "game out";
	}

	private boolean isGame()
	{
		return (isGameIn() || isGameOut());
	}

	private boolean isGameIn()
	{
		if (this.serverPoints < POINT_AMOUNT_FOR_GAME_SCORE) return false;
		return (this.serverPoints > this.receiverPoints+1);
	}

	private boolean isGameOut()
	{
		if (this.receiverPoints < POINT_AMOUNT_FOR_GAME_SCORE) return false;
		return (this.receiverPoints > this.serverPoints+1);
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
		if (this.receiverPoints < POINT_AMOUNT_FOR_ADVANTAGE_SCORE) return false;
		return (this.receiverPoints == this.serverPoints+1);
	}

	private boolean isAdvantageIn()
	{
		if (this.serverPoints < POINT_AMOUNT_FOR_ADVANTAGE_SCORE) return false;
		return (this.serverPoints == this.receiverPoints+1);
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
