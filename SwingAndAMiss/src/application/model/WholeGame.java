package application.model;

import java.util.ArrayList;
import java.util.Random;

public class WholeGame {
	public ArrayList<Integer> score;
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
		int i = 0;
		int j = 0;
		totalInnings = 1;
		Players whoIsBatting = Players.PLAYER1;
		while (gameEndTest(i)) {
			for (j = 0; j < 2; j++) {
//				System.out.println("Inning:" + printVar);
				whoIsBatting = determineBatter(i + j);
//				System.out.println(whoIsBatting);
				currentInning = new Inning(whoIsBatting);
				if (whoIsBatting == Players.PLAYER1) {
					currentInning.playBatterInning();
				}
				if (whoIsBatting == Players.CPU) {
					currentInning.playPitcherInning();
				}
				addScore(currentInning.points);
			}
			// bottom of an inning;
			currentInning = new Inning(whoIsBatting);

			i++;

		}
	}

	private void addScore(int points) {
		// TODO Auto-generated method stub
		score.add(points);
		total += points;
	}

	private Players determineBatter(int i) {
		Players Batter = Players.PLAYER1;
		int conditionVariable = i + inningBattingOffset;
		conditionVariable = conditionVariable % 2;

		if (conditionVariable == 1) {
			Batter = Players.CPU;
		}
		return Batter;
	}

	public void startGame() {
		setUpGame();
		gameLoop();

	}

	public void setUpGame() {

		totalInnings = 2;
		getFirstPlayer();
	}

	private void getFirstPlayer() {
		Coin coinCall = askPlayerForCoin();
		FirstPlayFlip(coinCall);

	}

	private Coin askPlayerForCoin() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean gameEndTest(int i) {
		return i < totalInnings;
	}

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

	public boolean coinCompare(Coin aCoin, Coin bCoin) {
		return (aCoin == bCoin);
	}

	public Coin flipCoin() {
		int check = randNum(2);
		if (check == 0) {
			return Coin.HEADS;
		}
		return Coin.TAILS;
	}

	public int randNum(int cases) {
		Random rand = new Random();
		if (cases <= 1) {
			return 0;
		}
		return ((rand.nextInt(33 * cases)) % (cases));
	}

}
