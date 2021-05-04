package application.model;

public class currentBatter {
	Players Batter;
	playerPosition labelPosition;
	Players Top;

	public currentBatter(firstPlayer firstToBat) {
		Batter = firstToBat.firstToBat;
		Top = firstToBat.firstToBat;
	}

	public Players getBatter() {
		return Batter;
	}

	public void setBatter(Players newbatter) {
		Batter = newbatter;
	}

	public playerPosition getlabelPosition() {
		return labelPosition;
	}

	public void setlabelPosition(playerPosition newlabelPosition) {
		labelPosition = newlabelPosition;
	}

	public void changeSides() {
		this.changePlayers();
	}

	private void changePlayers() {
		if (this.Batter == Players.PLAYER1) {
			this.Batter = Players.CPU;
		}
		if (this.Batter == Players.CPU) {
			this.Batter = Players.PLAYER1;
		}

	}


	public String toString() {
		if (Batter == Players.PLAYER1) {
			return "Player";
		}
		return "cpu";
	}

}
