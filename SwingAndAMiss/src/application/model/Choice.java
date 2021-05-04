package application.model;

import java.util.ArrayList;
import java.util.Random;

public class Choice {

	//name of current choice
	Rps Name;
	//name of what it beats 
	Rps Beats;
	//name of what it loses to
	Rps Loses;
	// all game play decisions are made in terms of the batter;
	public ArrayList<Outcome> resultBeats;
	public ArrayList<Outcome> resultTies;
	public ArrayList<Outcome> resultLoses;

	String pitchingName;

	String battingName;

	public Choice(Rps rock, Rps scissors, Rps paper, String pName, String bName) {
		Name = rock;
		Beats = scissors;
		Loses = paper;
		resultBeats = new ArrayList<Outcome>();
		resultTies = new ArrayList<Outcome>();
		resultLoses = new ArrayList<Outcome>();
		pitchingName = pName;
		battingName = bName;
		
	}

	// Rock is supposed to be a power swing
	// batter's rock will have the outcomes attached to it.
	// MAYBE add different outcomes
	public String getPitchingName() {
		return pitchingName;
	}
	
	public String getBattingName() {
		return battingName;
	}
	
	public void setPitchingName(String pitchingName) {
		this.pitchingName = pitchingName;
	}
	
	public void setBattingName(String battingName) {
		this.battingName = battingName;
	}
	public void genBatterRock() {
		// ex: fast swing
		Outcome tempResult;
		tempResult = new Outcome(Umpire.BASE, 2);
		resultBeats.add(tempResult);
		tempResult = new Outcome(Umpire.FOUL, 1);
		resultTies.add(tempResult);
		tempResult = new Outcome(Umpire.STRIKE, 1);
		resultLoses.add(tempResult);

	}

	// paper is supposed to be an accurate swing
	// batter's paper will have the outcomes attached to it.
	// MAYBE add different outcomes
	public void genBatterPaper() {
		// ex: slow swing
		Outcome tempResult;
		tempResult = new Outcome(Umpire.BASE, 1);
		resultBeats.add(tempResult);
		tempResult = new Outcome(Umpire.FOUL, 1);
		resultTies.add(tempResult);
		tempResult = new Outcome(Umpire.STRIKE, 1);
		resultLoses.add(tempResult);

	}

	// scissors is supposed to be an slow/no swing
	// batter's paper will have the outcomes attached to it.
	// MAYBE add different outcomes
	public void genBatterScissors() {
		// ex: no swing
		Outcome tempResult;
		tempResult = new Outcome(Umpire.BALL, 1);
		resultBeats.add(tempResult);
		tempResult = new Outcome(Umpire.FOUL, 1);
		resultTies.add(tempResult);
		tempResult = new Outcome(Umpire.STRIKE, 1);
		resultLoses.add(tempResult);
	}

	//Comapres a pitcher's choice to the batters and determines the outcome of the swing
	// pitcherChosenName = a whole choice
	//return is the outCome from comparison
	public Outcome compareChoice(Choice pitcherChosenName) {
		if (testBeats(pitcherChosenName.Name)) {
			return randOutcome(resultBeats);
		}
		if (testTies(pitcherChosenName.Name)) {
			return randOutcome(resultTies);
		}
		if (testLoses(pitcherChosenName.Name)) {
			return randOutcome(resultLoses);
		}
		return null;
	}


	//will generate a random outcome from an array list of outcomes.
	//currently there is only one outcome for any swing
	// listOfOutcomes is an array list of possible outcomes from a single swing
	// return a single outcome
	public Outcome randOutcome(ArrayList<Outcome> listOfOutcomes) {
		int size = listOfOutcomes.size();
		return listOfOutcomes.get(randNum(size));
	}

	//generates a random number  0 to cases-1
	//cases is the number of possibilites
	// returns a random number  0 to cases-1
	public int randNum(int cases) {
		Random rand = new Random();
		if (cases <= 1) {
			return 0;
		}
		return ((rand.nextInt(33 * cases)) % (cases - 1));
	}


	//if pitcherChosenName matches a particular characteristic of the choice
	// what the pitcher selected
	// returns true if equal
	public boolean testBeats(Rps pitcherChosenName) {
		return Beats == pitcherChosenName;
	}

	//if pitcherChosenName matches a particular characteristic of the choice
	// what the pitcher selected
	// returns true if equal
	public boolean testTies(Rps pitcherChosenName) {
		return Name == pitcherChosenName;
	}

	//if pitcherChosenName matches a particular characteristic of the choice
	// what the pitcher selected
	// returns true if equal
	public boolean testLoses(Rps pitcherChosenName) {
		return Loses == pitcherChosenName;
	}

	public void printChoice() {
		System.out.println(Name);
		System.out.println(Beats);
		System.out.println(Loses);

	}

}
