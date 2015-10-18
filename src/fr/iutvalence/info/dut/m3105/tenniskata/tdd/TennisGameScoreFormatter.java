package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

public class TennisGameScoreFormatter
{
	private final static String[] INDIVIDUAL_SCORE = new String[] { "love", "fifteen", "thirty", "forty" };
	
	public static String getFormattedScoreWhenNotTiedBelowDeuce(TennisGameScoredPoints scoredPoints)
	{
		return INDIVIDUAL_SCORE[scoredPoints.getServerScoredPoints()] + "-" + INDIVIDUAL_SCORE[scoredPoints.getReceiverScoredPoints()];
	}
	
	public static String getFormattedScoreWhenTiedBelowDeuce(TennisGameScoredPoints scoredPoints)
	{
		return INDIVIDUAL_SCORE[scoredPoints.getServerScoredPoints()] + "-all";
	}
	
	public static String formatDeuce()
	{
		return "deuce";
	}
	
	public static String getFormattedScoreWhenAdvantageIn()
	{
		return "advantage in";
	}
	
	public static String getFormattedScoreWhenAdvantageOut()
	{
		return "advantage out";
	}
	
	public static String getFormattedScoreWhenGameIn()
	{
		return "game in";
	}
	
	public static String getFormattedScoreWhenGameOut()
	{
		return "game out";
	}
}
