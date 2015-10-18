package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

public class TennisGame
{
	private TennisGameScoredPoints playerPoints;

	public TennisGame()
	{
		this.playerPoints = new TennisGameScoredPoints();	
	}

	public String getScore()
	{
		if (this.playerPoints.isTiedScore()) return getScoreWhenTied();

		return getScoreWhenNotTied();
	}
	
	private String getScoreWhenTied()
	{
		if (this.playerPoints.isDeuce()) return TennisGameScoreFormatter.formatDeuce();
		
		return TennisGameScoreFormatter.getFormattedScoreWhenTiedBelowDeuce(this.playerPoints);
	}

	private String getScoreWhenNotTied()
	{
		if (this.playerPoints.isGame()) return getScoreWhenGame();
		
		if (this.playerPoints.isAdvantage()) return getScoreWhenAdvantage();

		return TennisGameScoreFormatter.getFormattedScoreWhenNotTiedBelowDeuce(this.playerPoints);
	}

	private String getScoreWhenGame()
	{
		if (this.playerPoints.isGameIn()) return TennisGameScoreFormatter.getFormattedScoreWhenGameIn();
		return TennisGameScoreFormatter.getFormattedScoreWhenGameOut();
	}

	private String getScoreWhenAdvantage()
	{
		if (this.playerPoints.isAdvantageIn()) return TennisGameScoreFormatter.getFormattedScoreWhenAdvantageIn();
		return TennisGameScoreFormatter.getFormattedScoreWhenAdvantageOut();
	}

	public void serverHasScored()
	{
		this.playerPoints = this.playerPoints.getScoredPointsWhenServerScores();
	}

	public void receiverHasScored()
	{
		this.playerPoints =this.playerPoints.getScoredPointsWhenReceiverScores();
	}
}
