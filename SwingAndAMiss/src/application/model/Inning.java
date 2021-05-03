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

	//an inning plays until there are three outs, this inning is played when the player is batting
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
	
		//an inning plays until there are three outs, this inning is played when the player is pitching. (when the player is NOT batting)
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
	
	//switch case to apply an outcome to the appropriate field 
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
	
	//4 balls will give the batter a base, 4 balls will reset balls and strikes
	private void incrementBall(int strength) {
		balls += strength;
		if (balls >= 4) {
			increaseBase(1);
			newBatter();
		}
		
	}
	
	//fouls are strikes that can never out a player
	private void incrementFoul(int strength) {
		strikes += strength;
		if (strikes >= 3) {
			strikes = 2;
		}
	}
	
	//strikes will out a player on the third strike, 3 strikes will reset balls and strikes 
	private void incrementStrike(int strength) {
		strikes += strength;
		if (strikes >= 3) {
			incrementOuts(1);
			newBatter();
		}
	}
	
	//upon reaching 3 outs, the inning will end
	private void incrementOuts(int strength) {
		outs += strength;
		if (outs >= 3) {
			outs = 0;
			endInning();
		}
	}
	
	//endInning will set the ending status of an inning to true (WIll END)
	private void endInning() {
		EndInningBool = true;
	}
	
	//increases the bases of all runners, if a runner gets to the fourth base (home), then they score a homerun, this will reset balls and strikes 
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
	
	//new batter is called by base, strike, and ball outcomes to reset strikes and balls
	private void newBatter() {
		strikes = 0;
		balls = 0;
		
	}

	//sets base 4 (home) to false, and adds a point to be batting player's score
	public void homeRun() {
		if (Bases[4]) {
			Bases[4] = false;
			points++;
		}
	}
	
	// checks to see if a base has a runner that can run to it
	public boolean baseRunCondition(int i) {
		return Bases[i - 1];
	}
	
	//moves a runner to the next base if there is a runer there
	private void incrementBase(int index) {
		if (baseRunCondition(index)) {
			Bases[index] = true;
			Bases[index - 1] = false;
		}
	}
	
	//returns an Round from the index of the choice of the batter and pitcher
	public Round makeRound(int batterIndex, int pitcherIndex) {
		Choice battersChoice = batterSelection.choices[batterIndex];
		Choice pitchersChoice = pitcherSelection.choices[pitcherIndex];
		Round inningRound = new Round(battersChoice, pitchersChoice);
		return inningRound;
	}
	
	//returns an integer for what the player chose
	public int playerSelection() {
		//		printPlayerSelection();
		int chosen = chooseOption();
		return chosen;
	}
	
	//prints the players options
	//TODO change to write to the buttons on the scene
	public void printPlayerSelection() {
		if (isPlayerBatting()) {
			batterSelection.printOptions();
		} else {
			pitcherSelection.printOptions();
		}
	}
	
	//TODO change to a selection from the buttons on the scene
	public int chooseOption() {
		Scanner baseballScan = new Scanner(System.in);
		int toReturn = baseballScan.nextInt();
		return toReturn;
	}
	
	//returns true if the current batting player is the player
	public boolean isPlayerBatting() {
		return playerBatting == Players.PLAYER1;
	}
	
	void printSelection() {
		
	}
	//returns a players choice from an option and index
	//index is the index of the choice amongst the option
	//choiceList contains a list of choices for the index to reference
	public Choice playerChoiceFromOption(int index, Option choiceList) {
		Choice returnChoice;
		returnChoice = choiceList.choices[index];
		return returnChoice;
		
	}
	
	//a cpu chooses amongst three choices 0,1,2
	//returns a random int 0,1,2
	public int comSelection() {
		
		return randNum(3);
	}
	
	//generates a random number  0 to cases-1
	//cases is the number of possibilites
	// returns a random number  0 to cases-1
	public int randNum(int cases) {
		Random rand = new Random();
		if (cases <= 1) {
			return 0;
		}
		return ((rand.nextInt(33 * cases)) % (cases));
	}

	//TODO write inning info to scoreboard
	public void printInning() {
	
		System.out.println("outs:" + outs);
		System.out.println("strikes:" + strikes);
		System.out.println("balls:" + balls);
		System.out.println("points:" + points);
		System.out.println("RoundNumber:" + RoundNumber);
		System.out.println("Bases:" + Bases[0] + " 1st " + Bases[1] + " 2nd " + Bases[2] + " 3rd " + Bases[3] + " "
				+ Bases[4] + "\n");
	}
}
