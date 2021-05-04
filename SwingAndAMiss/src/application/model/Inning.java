package application.model;

import java.util.Random;
import java.util.Scanner;

public class Inning {
	int outs;
	int strikes;
	int balls;
	int points;
	boolean[] Bases;

	public Inning() {

		this.outs = 0;
		this.strikes = 0;
		this.balls = 0;
		this.points = 0;
		Bases = new boolean[] { false, false, false, false, false };
	}

	public boolean checkInningEnd() {
		return outs >= 3;
	}

	public void printInning() {

		System.out.println("outs:" + outs);
		System.out.println("strikes:" + strikes);
		System.out.println("balls:" + balls);
		System.out.println("points:" + points);
		System.out.println("Bases:" + Bases[0] + " 1st " + Bases[1] + " 2nd " + Bases[2] + " 3rd " + Bases[3] + " "
				+ Bases[4] + "\n");
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
			break;
		}
		printInning();
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
}

