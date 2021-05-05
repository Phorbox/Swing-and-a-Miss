package application.model;

import java.util.ArrayList;
import java.util.Random;

//This is the wholegame, may need to get partially moved to the controller function.
public class WholeGame {
	// gameState
	public GameState theGameState;

	public Inning currentInning;
	public Round CurrentRound;
	public Option Player1;
	public Option CPU;

	public Choice Player1Selection;
	public Choice CPUSelection;

	public int currentInningNumber;
	public int totalInnings;
	public firstPlayer firstToBat;
	private currentBatter whoIsBatting;
	Outcome currentOutcome;

	public WholeGame(int newTotalInnings) {
		theGameState = new GameState();
		currentInning = new Inning();
		currentInningNumber = 0;

		CurrentRound = null;
		Player1 = new Option();
		CPU = new Option();

		Player1Selection = null;
		CPUSelection = null;

		totalInnings = newTotalInnings;
		firstToBat = new firstPlayer();
		whoIsBatting = new currentBatter(firstToBat);
		currentOutcome = null;
	}

	public void playBall() {
		firstToBat.getFirstToBat();
		whoIsBatting = new currentBatter(firstToBat);

		theGameState.SwitchLabels(Player1, isPlayerBatting());
	}

	public void determineOutcomeCall() {
		determineOutcome(Player1Selection, CPUSelection);
		currentInning.applyOutcome(currentOutcome);
		theGameState.updateGameStatePlaces(currentInning);
		theGameState.updateGameStateScore(currentInning, currentInningNumber, whoIsBatting);

	}

	public void makeNewInning() {
		currentInning = new Inning();
	}

	public boolean gameInningTest() {
		return currentInning.checkInningEnd();

	}

	public boolean isPlayerBatting() {
		return whoIsBatting.Batter == Players.PLAYER1;
	}

	public void playersChooseIndex(int choice) {
		Player1Selection = Player1.getChoice(choice);
		CPUSelection = CPU.getChoice(comSelection());

	}

	public boolean gameEndTest() {
		return (currentInningNumber >= totalInnings) && (isTopofInning());
	}

	private boolean isTopofInning() {
		return whoIsBatting.Batter == whoIsBatting.Top;
	}

	public boolean gameContinueTest() {
		return currentInningNumber < totalInnings;
	}

	public int comSelection() {

		return randNum(3);
	}

	public int randNum(int cases) {
		Random rand = new Random();
		if (cases <= 1) {
			return 0;
		}
		return ((rand.nextInt(33 * cases)) % (cases));
	}

	public void determineOutcome(Choice batterChoice, Choice pitcherChoice) {
		currentOutcome = batterChoice.compareChoice(pitcherChoice);

	}

	public String[] getActionLabels() {
		theGameState.SwitchLabels(Player1, isPlayerBatting());
		return theGameState.buttonLabels;
	}

	public String getOutcomeName() {
		Umpire name = currentOutcome.Name;
		switch (name) {
		case STRIKE:
			return "Strike";
		case FOUL:

			return "Foul";
		case BASE:

			return "Base";
		case BALL:

			return "Ball";
		default:
			return "else";
		}
	}

	public int getOuts() {
		int outReturn = currentInning.outs;
		if (outReturn >= 3) {
			return 2;
		}
		return outReturn;
	}

	public int getBalls() {
		return currentInning.balls;
	}

	public int getStrikes() {
		return currentInning.strikes;
	}

	public boolean[] getBases() {
		return currentInning.Bases;
	}

	public int getUpperScore(int i) {
		return theGameState.getUpperScore(i);
	}

	public int getLowerScore(int i) {
		return theGameState.getLowerScore(i);
	}

	public int getUpperTotal() {
		return theGameState.getTopTotalScore();
	}

	public int getLowerTotal() {
		return theGameState.getBottomTotal();
	}

	public void switchSides() {
		whoIsBatting.changeSides();
	}

	public int comparePoints() {
		// TODO Auto-generated method stub
		Players topPlayer = whoIsBatting.Top;
		if (topPlayer == Players.PLAYER1) {
			return theGameState.topTotal - theGameState.botTotal;
		}
		if (topPlayer == Players.CPU) {
			return theGameState.botTotal - theGameState.topTotal;
		}
		return 0;
	}

	public void incrementInning() {
		boolean inningCondition = isTopofInning();
		if (inningCondition) {
			currentInningNumber++;
		}
		
	}

	public boolean playerIsNotTopPlayer() {
		// TODO Auto-generated method stub
		return whoIsBatting.Top != Players.PLAYER1;
	}

}
