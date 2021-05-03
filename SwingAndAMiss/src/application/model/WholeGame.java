package application.model;

import java.util.ArrayList;
import java.util.Random;

//This is the wholegame, may need to get partially moved to the controller function.
public class WholeGame {
	//two int array of score for the game, the scoreboard can reference this at n-1 for it
	public ArrayList<Integer> Score;
	//todo
	// public ArrayList<Integer> cpuScore;

	//inning whose info can be sent to the scoreboard
	public Inning currentInning;

	public int total;
	public int totalInnings;
	public int inningBattingOffset;
	public Players firstToBat;

	public WholeGame() {
		total = 0;
		totalInnings = 0;
		inningBattingOffset = 0;
		score = new ArrayList<Integer>();
	}

	public void gameLoop() {
		//i is the current inning number amongst all innings for the game minus 1
		int i = 0;
		// j represents that players alternate in one inning
		int j = 0;
		
		//TODO: set up inning prompt
		totalInnings = 1;
		
		//whoIsBatting gets reassigned right away
		Players whoIsBatting = Players.PLAYER1;

		while (gameEndTest(i)) {
			for (j = 0; j < 2; j++) {
				//To Do, create better alternation of player and CPU, 
				//j=0 is the top of an inning, j=1 is bottom of an inning 
				whoIsBatting = determineBatter(i + j);
				
				//
				currentInning = new Inning(whoIsBatting);
				
				
				if (whoIsBatting == Players.PLAYER1) {
					currentInning.playBatterInning();
				}

				
				if (whoIsBatting == Players.CPU) {
					currentInning.playPitcherInning();
				}
				//currently score needs to be seperated into two players
				addScore(currentInning.points);
			}
			currentInning = new Inning(whoIsBatting);

			i++;

		}
	}

	//total needs to be seperated into adding to the players score and the cpu score
	private void addScore(int points) {
		
		score.add(points);
		total += points;
	}

	// takes an inning number + top or bottom of inning to determine player adn return that player
	//i = Inning number + top or bottom number
	//return batting player
	private Players determineBatter(int i) {
		Players Batter = Players.PLAYER1;
		int conditionVariable = i + inningBattingOffset;
		conditionVariable = conditionVariable % 2;

		if (conditionVariable == 1) {
			Batter = Players.CPU;
		}
		return Batter;
	}

	//setup game would get inning count and flip coin, game loop is main game loop
	public void startGame() {
		setUpGame();
		gameLoop();

	}

	//TODO change inning set up to a prompt.
	public void setUpGame() {

		totalInnings = 2;
		getFirstPlayer();
	}

	//
	private void getFirstPlayer() {
		Coin coinCall = askPlayerForCoin();
		FirstPlayFlip(coinCall);

	}

	//TODO collect coin selection from a prompt from the controller class
	private Coin askPlayerForCoin() {
		// TODO Auto-generated method stub
		return null;
	}

	// if the current inning number is less than the total innings to be played, return true
	public boolean gameEndTest(int i) {
		return i < totalInnings;
	}

	//
	//coinCall is whether the player had called heads or tails
	//method will just set the player field of the class
	public void FirstPlayFlip(Coin coinCall) {
		Coin coinFlip = flipCoin();
		if (coinCompare(coinCall, coinFlip)) {
			firstToBat = Players.PLAYER1;
			inningBattingOffset = 0;
		} else {
			firstToBat = Players.CPU;
			inningBattingOffset = 1;
		}
	}

	// returns true if the coins are equal
	public boolean coinCompare(Coin aCoin, Coin bCoin) {
		return (aCoin == bCoin);
	}


	//gets a random number 0 or 1 nd converts it to a coin
	//return a coin
	public Coin flipCoin() {
		int check = randNum(2);
		if (check == 0) {
			return Coin.HEADS;
		}
		return Coin.TAILS;
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

}
