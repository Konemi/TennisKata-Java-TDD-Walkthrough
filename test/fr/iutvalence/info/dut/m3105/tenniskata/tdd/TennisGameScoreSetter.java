package fr.iutvalence.info.dut.m3105.tenniskata.tdd;

public class TennisGameScoreSetter
{	
	public static TennisGame getTennisGameWithGivenPointsScored(int serverPoints, int receiverPoints)
	{
		TennisGame tennisGame = new TennisGame();
		setServerPoints(tennisGame, serverPoints);
		setReceiverPoints(tennisGame,receiverPoints);
		return tennisGame;
	}

	private static void setServerPoints(TennisGame tennisGame, int points)
	{
		for (int point = 0; point < points; point++)
			tennisGame.serverHasScored();
	}

	private static void setReceiverPoints(TennisGame tennisGame, int points)
	{
		for (int point = 0; point < points; point++)
			tennisGame.receiverHasScored();
	}
}
