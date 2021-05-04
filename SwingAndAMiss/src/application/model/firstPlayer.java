package application.model;

import java.util.Random;

public class firstPlayer {

	Coin coinToss;
	Players firstToBat;

	public firstPlayer() {
		this.coinToss = Coin.HEADS;
		this.firstToBat = Players.CPU;
	}

	public Coin getCoinToss() {
		return coinToss;
	}

	public Players getFirstToBat() {
		return firstToBat;
	}

	public void setCoinToss(Coin coinToss) {
		this.coinToss = coinToss;
	}

	public void setFirstToBat(Players firstToBat) {
		this.firstToBat = firstToBat;
	}

	public void FirstPlayFlip(Coin coinCall) {
		Coin coinFlip = flipCoin();
		if (coinCompare(coinCall, coinFlip)) {
			firstToBat = Players.PLAYER1;

		} else {
			firstToBat = Players.CPU;
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
