package application.model;

import java.util.Random;
import java.util.Scanner;

public class Inning {
	int outs;
	int strikes;
	int balls;
	int points;
	int RoundNumber;
	boolean EndInningBool;

	boolean[] Bases;
	Players playerBatting;

	Option batterSelection;

	Option pitcherSelection;

	public Inning(Players whoIsBatting) {
		outs = 0;
		strikes = 0;
		balls = 0;
		points = 0;
		EndInningBool = false;

		Bases = new boolean[] { false, false, false, false, false };

		batterSelection = new Option();
		batterSelection.genBatterOption();

		pitcherSelection = new Option();
		pitcherSelection.genPitcherOption();

		playerBatting = whoIsBatting;
	}

	public void printInning() {

		System.out.println("outs:" + outs);
		System.out.println("strikes:" + strikes);
		System.out.println("balls:" + balls);
		System.out.println("points:" + points);
		System.out.println("RoundNumber:" + RoundNumber);
		System.out.println("Bases:" + Bases[0] + " 1st " + Bases[1] + " 2nd " + Bases[2] + " 3rd " + Bases[3] + " "
				+ Bases[4] + "\n");
	}

	public void playBatterInning() {
		System.out.print("batting\n");
		int playerSelectionIndex;
		int comSelectionIndex;
		Outcome tempOutcome;
		Round inningRound;

		while (!EndInningBool) {

//			playerSelectionIndex = playerSelection();
//			comSelectionIndex = comSelection();
//			System.out.println(comSelectionIndex);

			playerSelectionIndex = comSelection();
			System.out.println(playerSelectionIndex);
			comSelectionIndex = comSelection();
			System.out.println(comSelectionIndex);

			inningRound = makeRound(playerSelectionIndex, comSelectionIndex);
			tempOutcome = inningRound.playRound();
			applyOutcome(tempOutcome);
			tempOutcome.printOutcome();
			printInning();
		}

	}

	public void playPitcherInning() {
		System.out.print("pitching\n");
		int playerSelectionIndex;
		int comSelectionIndex;
		Outcome tempOutcome;
		Round inningRound;
		System.out.println(!EndInningBool);
		while (!EndInningBool) {

//			playerSelectionIndex = playerSelection();
//			comSelectionIndex = comSelection();
//			System.out.println(comSelectionIndex);

			playerSelectionIndex = comSelection();
			System.out.println(playerSelectionIndex);
			comSelectionIndex = comSelection();
			System.out.println(comSelectionIndex);

			inningRound = makeRound(comSelectionIndex, playerSelectionIndex);
			tempOutcome = inningRound.playRound();
			applyOutcome(tempOutcome);
			tempOutcome.printOutcome();
			printInning();
		}

	}

	public void applyOutcome(Outcome tempOutcome) {
		Umpire name = tempOutcome.Name;
		int strength = tempOutcome.value;

		switch (name) {
		case STRIKE:

			incrementStrike(strength);
			break;
		case FOUL:

			incrementFoul(strength);
			break;
		case BASE:

			increaseBase(strength);
			break;
		case BALL:

			incrementBall(strength);
			break;
		default:
			// Java code
			;
		}
	}

	private void incrementBall(int strength) {
		balls += strength;
		if (balls >= 4) {
			increaseBase(1);
			newBatter();
		}

	}

	private void incrementFoul(int strength) {
		strikes += strength;
		if (strikes >= 3) {
			strikes = 2;
		}
	}

	private void incrementStrike(int strength) {
		strikes += strength;
		if (strikes >= 3) {
			incrementOuts(1);
			newBatter();
		}
	}

	private void incrementOuts(int strength) {
		outs += strength;
		if (outs >= 3) {
			outs = 0;
			endInning();
		}
	}

	private void endInning() {
		EndInningBool = true;
	}


	private void increaseBase(int strength) {
		int i;
		int j;
		Bases[0] = true;
		for (j = 0; j < strength; j++) {
			for (i = 4; i > 0; i--) {
				incrementBase(i);
				homeRun();
			}
		}
		newBatter();
	}

	private void newBatter() {
		strikes = 0;
		balls = 0;

	}

	public void homeRun() {
		if (Bases[4]) {
			Bases[4] = false;
			points++;
		}
	}

	public boolean baseRunCondition(int i) {
		return Bases[i - 1];
	}

	private void incrementBase(int index) {
		if (baseRunCondition(index)) {
			Bases[index] = true;
			Bases[index - 1] = false;
		}
	}

	//

	public Round makeRound(int batterIndex, int pitcherIndex) {
		Choice battersChoice = batterSelection.choices[batterIndex];
		Choice pitchersChoice = pitcherSelection.choices[pitcherIndex];
		Round inningRound = new Round(battersChoice, pitchersChoice);
		return inningRound;
	}

	public int playerSelection() {
//		printPlayerSelection();
		int chosen = chooseOption();
		return chosen;
	}

	public void printPlayerSelection() {
		if (isPlayerBatting()) {
			batterSelection.printOptions();
		} else {
			pitcherSelection.printOptions();
		}
	}

	public int chooseOption() {
		Scanner baseballScan = new Scanner(System.in);
		int toReturn = baseballScan.nextInt();
		return toReturn;
	}

	public boolean isPlayerBatting() {
		return playerBatting == Players.PLAYER1;
	}

	void printSelection() {

	}

	public Choice playerChoiceFromOption(int index, Option choiceList) {
		Choice returnChoice;
		returnChoice = choiceList.choices[index];
		return returnChoice;

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
}
