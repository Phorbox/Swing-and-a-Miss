package application.model;

public class Option {
	// Ex: Batter and Pitcher
	public Choice[] choices;

	public Option() {
		choices = new Choice[3];
		genBatterOption();
	}

	public void genBatterOption() {
		// TODO Auto-generated method stub
		genRockPaperScissors();
		genBatterOutcome();

	}

	public void genBatterOutcome() {
		choices[0].genBatterRock();
		choices[1].genBatterPaper();
		choices[2].genBatterScissors();

	}

	public void genPitcherOption() {
		// TODO Auto-generated method stub
		genRockPaperScissors();

	}

	public void genRockPaperScissors() {
		// TODO Auto-generated method stub
		choices[0] = new Choice(Rps.ROCK, Rps.SCISSORS, Rps.PAPER, "Fastball","Power Swing");
		choices[1] = new Choice(Rps.PAPER, Rps.ROCK, Rps.SCISSORS,"Screwball","Wild Swing");
		choices[2] = new Choice(Rps.SCISSORS, Rps.PAPER, Rps.ROCK,"Curveball","Thoughtful Swing");

	}

	public void printOptions() {
		int i = 0;
		while (printCondition(i)) {
			// implement button update
			System.out.print(i+ " ");
			System.out.print(choices[i].Name);
			i++;
		}
		System.out.println("\n");

	}
	public Choice getChoice(int i) {
		return choices[i];
	}

	public boolean printCondition(int i) {
		if (i < 3) {
			return true;
		}
		return false;
	}

}
