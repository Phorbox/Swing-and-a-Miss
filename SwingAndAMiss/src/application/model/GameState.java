package application.model;

public class GameState {

	public String topLabel;

	public String botLabel;

	public String[] buttonLabels;

	public int[] topScore;
	public int[] botScore;

	public int topTotal;
	public int botTotal;

	public boolean[] outs;
	public boolean[] strike;
	public boolean[] ball;
	public boolean[] bases;

	public GameState() {
		this.topLabel = "";
		this.botLabel = "";
		this.buttonLabels = new String[] { "Rock", "Paper", "Scissors" };
		this.topScore = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		this.botScore = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		this.topTotal = 0;
		this.botTotal = 0;
		this.outs = new boolean[] { false, false };
		this.strike = new boolean[] { false, false };
		this.ball = new boolean[] { false, false, false };
		this.bases = new boolean[] { false, false, false };
	}

	public String getTopLabel() {
		return topLabel;
	}

	public String getBottomLabel() {
		return botLabel;
	}

	public int getUpperScore(int i) {
		return topScore[i];
	}

	public int getLowerScore(int i) {
		return botScore[i];
	}

	public int getTopTotalScore() {
		return topTotal;
	}

	public int getBottomTotal() {
		return botTotal;
	}

	public boolean getOuts(int i) {
		return outs[i];
	}

	public boolean getStrike(int i) {
		return strike[i];
	}

	public boolean getBall(int i) {
		return ball[i];
	}

	public boolean getBases(int i) {
		return bases[i];
	}

	public void setTopLabel(String topLabel) {
		this.topLabel = topLabel;
	}

	public void setBottomLabel(String bottomLabel) {
		this.botLabel = bottomLabel;
	}

	public void setUpperScore(int[] upperScore) {
		this.topScore = upperScore;
	}

	public void setLowerScore(int[] lowerScore) {
		this.botScore = lowerScore;
	}

	public void setTopTotalScore(int topTotalScore) {
		this.topTotal = topTotalScore;
	}

	public void setTopBottomScore(int topBottomScore) {
		this.botTotal = topBottomScore;
	}

	public void setOuts(boolean outs, int i) {
		this.outs[i] = outs;
	}

	public void setStrike(boolean strike, int i) {
		this.strike[i] = strike;
	}

	public void setBall(boolean ball, int i) {
		this.ball[i] = ball;
	}

	public void setBases(boolean bases, int i) {
		this.bases[i] = bases;
	}

	public void setToNewInning() {
		this.outs = new boolean[] { false, false };
		this.strike = new boolean[] { false, false };
		this.ball = new boolean[] { false, false, false };
		this.bases = new boolean[] { false, false, false };
	}

	public String getButtonLabels(int i) {
		return buttonLabels[i];
	}

	public void setButtonLabels(String buttonLabels, int i) {
		this.buttonLabels[i] = buttonLabels;
	}

	public void updateGameStatePlaces(Inning inningInfo) {
		updateOuts(inningInfo.outs);
		updateStrike(inningInfo.strikes);
		updateBall(inningInfo.balls);
		updateBases(inningInfo.Bases);

	}

	private void updateBases(boolean[] newBases) {
		int i;
		for (i = 0; i < 3; i++) {
			bases[i] = newBases[i + 1];
		}

	}

	private void updateBall(int newBalls) {
		int i;
		for (i = 0; i < newBalls - 1; i++) {
			ball[i] = true;
		}

	}

	private void updateStrike(int newStrikes) {
		int i;
		for (i = 0; i < newStrikes - 1; i++) {
			strike[i] = true;
		}
	}

	private void updateOuts(int newOuts) {
		int i;
		for (i = 0; i < newOuts - 1; i++) {
			outs[i] = true;
		}
	}

	public void updateGameStateScore(Inning inningInfo, int inningIndex, currentBatter whoIsBatting) {
		if (isTop(whoIsBatting)) {
			updateTopPoints(inningInfo, inningIndex, whoIsBatting);
			return;
		}
		updateBottomPoints(inningInfo, inningIndex, whoIsBatting);

	}

	private void updateTopPoints(Inning inningInfo, int inningIndex, currentBatter whoIsBatting) {
		updateTopScore(inningInfo, inningIndex);
		updateTopTotal();

	}

	private void updateTopTotal() {
		int i;
		topTotal = 0;
		for (i = 0; i < 9; i++) {
			topTotal += topScore[i];

		}

	}

	private void updateTopScore(Inning inningInfo, int inningIndex) {

		topScore[inningIndex] = inningInfo.points;
	}

	private void updateBottomPoints(Inning inningInfo, int inningIndex, currentBatter whoIsBatting) {
		updateBottomScore(inningInfo, inningIndex);
		updateBottomTotal();

	}

	private void updateBottomTotal() {
		int i;
		botTotal = 0;
		for (i = 0; i < 9; i++) {
			botTotal += botScore[i];

		}

	}

	private void updateBottomScore(Inning inningInfo, int inningIndex) {
		botScore[inningIndex] = inningInfo.points;

	}

	private boolean isTop(currentBatter whoIsBatting) {
		return whoIsBatting.Top == whoIsBatting.Batter;
	}

	public void SwitchLabels(Option player1, boolean isPlayerBatting) {
		int i = 0;
		// if player is batting

		if (isPlayerBatting) {
			for (i = 0; i < 3; i++) {
				buttonLabels[i] = player1.getChoice(i).battingName;

			}
			return;

		}
		for (i = 0; i < 3; i++) {
			buttonLabels[i] = player1.getChoice(i).pitchingName;

		}

	}

}