package application.controller;

import java.io.FileNotFoundException;

import application.model.Coin;
import application.model.WholeGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class MainController {

	  @FXML
	    private Group batterPOV;

	    @FXML
	    private Group batterPitcher;

	    @FXML
	    private Group batterPitcherChar;

	    @FXML
	    private Group batterBatter;

	    @FXML
	    private Group batterBatterChar;

	    @FXML
	    private Group batterBase1;

	    @FXML
	    private Group batterBase1Char;

	    @FXML
	    private Group batterBase3;

	    @FXML
	    private Group batterBase3Char;

	    @FXML
	    private Group batterBase2;

	    @FXML
	    private Group batterBase2Char;

	    @FXML
	    private Group pitcherPOV;

	    @FXML
	    private Group pitcherMoundandField;

	    @FXML
	    private Group pitcherPitcher;

	    @FXML
	    private Polygon homePlate;

	    @FXML
	    private Group pitcherBatter;

	    @FXML
	    private Group pitcherBase1;

	    @FXML
	    private Group pitcherBase1Char;

	    @FXML
	    private Group pitcherBase2;

	    @FXML
	    private Group pitcherBase2Char;

	    @FXML
	    private Group pitchingSecond;

	    @FXML
	    private Group pitcherBase3;

	    @FXML
	    private Group pitcherBase3Char;

	    @FXML
	    private GridPane playerButtons;

	    @FXML
	    private Button buttonTop;

	    @FXML
	    private Button buttonMiddle;

	    @FXML
	    private Button buttonBottom;

	    @FXML
	    private Rectangle sceneCurtain;

	    @FXML
	    private Group gameEndScreen;

	    @FXML
	    private Rectangle endGameBackDrop;

	    @FXML
	    private Label winLose;

	    @FXML
	    private Button replayButton;

	    @FXML
	    private Group scoreBoard;

	    @FXML
	    private Group HomeAway;

	    @FXML
	    private Label HOME;

	    @FXML
	    private Label AWAY;

	    @FXML
	    private Group pointsBoard;

	    @FXML
	    private Group cpuLabels;

	    @FXML
	    private Label c1;

	    @FXML
	    private Label c2;

	    @FXML
	    private Label c3;

	    @FXML
	    private Label c4;

	    @FXML
	    private Label c5;

	    @FXML
	    private Label c6;

	    @FXML
	    private Label c7;

	    @FXML
	    private Label c8;

	    @FXML
	    private Label c9;

	    @FXML
	    private Label cTotal;

	    @FXML
	    private Group p1Labels;

	    @FXML
	    private Label p1;

	    @FXML
	    private Label p2;

	    @FXML
	    private Label p3;

	    @FXML
	    private Label p4;

	    @FXML
	    private Label p5;

	    @FXML
	    private Label p6;

	    @FXML
	    private Label p7;

	    @FXML
	    private Label p8;

	    @FXML
	    private Label p9;

	    @FXML
	    private Label pTotal;

	    @FXML
	    private Group inningsLabels;

	    @FXML
	    private Label pLabel;

	    @FXML
	    private Label cLabel;

	    @FXML
	    private Group inningLights;

	    @FXML
	    private Group outLights;

	    @FXML
	    private Circle out1;

	    @FXML
	    private Circle out2;

	    @FXML
	    private Group strikeLights;

	    @FXML
	    private Circle strike1;

	    @FXML
	    private Circle strike2;

	    @FXML
	    private Group ballLights;

	    @FXML
	    private Circle ball2;

	    @FXML
	    private Circle ball3;

	    @FXML
	    private Circle ball1;

	    @FXML
	    private Group HeadsorTails;

	    @FXML
	    private Group title;

	    @FXML
	    private Label Title;

	    @FXML
	    private Label instructions1;

	    @FXML
	    private Label instructions2;

	    @FXML
	    private Label instructions3;

	    @FXML
	    private Label finalCheckInning;

	    @FXML
	    private Label FinalCheckCoin;

	    @FXML
	    private Label finalCheckInning1;

	    @FXML
	    private Button Heads;

	    @FXML
	    private Button Tails;

	    @FXML
	    private Button inning1;

	    @FXML
	    private Button inning2;

	    @FXML
	    private Button inning3;

	    @FXML
	    private Button inning4;

	    @FXML
	    private Button inning5;

	    @FXML
	    private Button inning6;

	    @FXML
	    private Button inning7;

	    @FXML
	    private Button inning8;

	    @FXML
	    private Button inning9;

	    @FXML
	    private Button GoButton;

	    


	Label[] playerScores;
	Label[] cpuScores;
	Circle[] ballsLightsArray;
	Circle[] strikeLightsArray;
	Circle[] outLightsArray;
	Button[] choiceButtons;
	Group[] batterBasesArray;
	Group[] pitcherBasesArray;
	Button[] playInnings;
	Button[] coinChooser;

	WholeGame newGame;
	int inningsButtonPress;
	Coin coinChoice;

	Paint lightOff;

	Paint lightOn;

	int rpsIndex;
	boolean selected;

	@FXML
	void initialize() {
		playerScores = new Label[] { p1, p2, p3, p4, p5, p6, p7, p8, p9 };
		cpuScores = new Label[] { c1, c2, c3, c4, c5, c6, c7, c8, c9 };
		ballsLightsArray = new Circle[] { ball1, ball2, ball3 };
		strikeLightsArray = new Circle[] { strike1, strike2 };
		outLightsArray = new Circle[] { out1, out2 };
		choiceButtons = new Button[] { buttonTop, buttonMiddle, buttonBottom };
		batterBasesArray = new Group[] { batterBase1Char, batterBase2Char, batterBase3Char };
		pitcherBasesArray = new Group[] { pitcherBase1Char, pitcherBase2Char, pitcherBase3Char };
		playInnings = new Button[] { inning1, inning2, inning3, inning4, inning5, inning6, inning7, inning8, inning9 };
		coinChooser = new Button[] { Heads, Tails };
		inningsButtonPress = 1;
		coinChoice = Coin.HEADS;
		getLightColors();
		cleanSlate();
		selected = false;
		rpsIndex = 0;

	}

	@FXML
	void executeConfirm(ActionEvent event) {

	}

	@FXML
	void execute1Innings(ActionEvent event) {
		inputIntInnings(1);
	}

	@FXML
	void execute2Innings(ActionEvent event) {
		inputIntInnings(2);
	}

	@FXML
	void execute3Innings(ActionEvent event) {
		inputIntInnings(3);
	}

	@FXML
	void execute4Innings(ActionEvent event) {
		inputIntInnings(4);
	}

	@FXML
	void execute5Innings(ActionEvent event) {
		inputIntInnings(5);
	}

	@FXML
	void execute6Innings(ActionEvent event) {
		inputIntInnings(6);
	}

	@FXML
	void execute7Innings(ActionEvent event) {
		inputIntInnings(7);
	}

	@FXML
	void execute8Innings(ActionEvent event) {
		inputIntInnings(8);
	}

	@FXML
	void execute9Innings(ActionEvent event) {
		inputIntInnings(9);
	}

	void inputIntInnings(int i) {
		inningsButtonPress = i;
		finalCheckInning.setText(Integer.toString(i));

	}

	@FXML
	void executeGoButton(ActionEvent event) {
		startGame();

	}
	
	@FXML
    void replayGame(ActionEvent event) {
//    	gameEndScreen.setVisible(false);
//		initialize();
		System.exit(0);
    }

	private void startGame() {

		gameSetUp();
		newGame.makeNewInning();
//		nextButton();

	}

	private void nextButton() {
		chooseYourOption();
		homeText();
		newGame.determineOutcomeCall();
		awayText();

		if (newGame.gameInningTest()) {
			newGame.makeNewInning();
			newGame.switchSides();
			changeField();
			newGame.incrementInning();
		}
		copyGameState();
		if (newGame.gameEndTest()) {
			 endGame();
		}

	}

	private void endGame() {
		int j = inningsButtonPress;
		playerScores[j].setText("");
		cpuScores[j].setText("");
		int victory = newGame.comparePoints();
		colorEndScreen(victory);
		setWinLoseText(victory);
		gameEndScreen.setVisible(true);
		
	}

	private void setWinLoseText(int victory) {
		if(victory < 0) {
			winLose.setText("Lose");
		}else if(victory > 0) {
			winLose.setText("Win!");
		}else {
			winLose.setText("Drew");
		}
		
	}

	private void colorEndScreen(int victory) {
		if(victory < 0) {
			endGameBackDrop.setFill(lightOff);
		}
		
		
	}

	private void changeField() {
		if (newGame.isPlayerBatting()) {
			changeToBatter();
			return;
		}
		changeToPitcher();

	}

	private void awayText() {
		AWAY.setText(newGame.getOutcomeName());

	}

	void copyGameState() {
		copyScore();
		copyBases();
		copyOuts();
		copyBalls();
		copyStrikes();
		setActionButtonLabels();
	}

	private void copyScore() {
		copyTopScore();
		copyBottomScore();

	}

	private void copyTopScore() {
		int j = newGame.currentInningNumber;

		int temp = newGame.getUpperScore(j);


		playerScores[j].setText(Integer.toString(temp));

		temp = newGame.getUpperTotal();

		pTotal.setText(Integer.toString(temp));

	}

	private void copyBottomScore() {
		int j = newGame.currentInningNumber;

		int temp = newGame.getLowerScore(j);

		cpuScores[j].setText(Integer.toString(temp));


		temp = newGame.getLowerTotal();
		cTotal.setText(Integer.toString(temp));

	}

	private void copyBases() {
		int i;
		boolean j[] = newGame.getBases();
		if (newGame.isPlayerBatting()) {
			for (i = 0; i < 3; i++) {
				setBaseRunners(i, batterBasesArray, j[i + 1]);
			}
		} else {
			for (i = 0; i < 3; i++) {
				setBaseRunners(i, pitcherBasesArray, j[i + 1]);
			}
		}

	}

	private void setBaseRunners(int i, Group[] basesArray, boolean b) {
		basesArray[i].setVisible(b);

	}

	private void copyStrikes() {

		int j = newGame.getStrikes();

		turnlightOn(j, strikeLightsArray);

	}

	private void copyBalls() {
		int j = newGame.getBalls();

		turnlightOn(j, ballsLightsArray);

	}

	private void copyOuts() {
		int j = newGame.getOuts();
		turnlightOn(j, outLightsArray);

	}

	private void chooseYourOption() {
		newGame.playersChooseIndex(rpsIndex);

	}

	private void gameSetUp() {
		hideTitle();
		newGame = new WholeGame(inningsButtonPress);
		changeField();
		raiseCurtain();
		newGame.playBall();
		setTopAndBottomLabels();
		setActionButtonLabels();
	}

	private void setTopAndBottomLabels() {
		if(newGame.playerIsNotTopPlayer()) {
			pLabel.setText("CPU");
			cLabel.setText("P1");
		}
		
	}

	void setActionButtonLabels() {
		String[] newLabels;
		newLabels = newGame.getActionLabels();
		int i;
		for (i = 0; i < 3; i++) {
			choiceButtons[i].setText(newLabels[i]);
		}
	}

	@FXML
	void executeHeads(ActionEvent event) {
		inputCoin("Heads");
	}

	@FXML
	void executeTails(ActionEvent event) {
		inputCoin("Tails");
	}

	private void inputCoin(String string) {
		FinalCheckCoin.setText(string);
		setCoinChoice(string);

	}

	private void setCoinChoice(String string) {
		if (isCoinHeads(string)) {
			coinChoice = Coin.HEADS;
			return;
		}
		coinChoice = Coin.TAILS;
	}

	private boolean isCoinHeads(String string) {
		return string.equals("Heads");
	}

	@FXML
	void executePaper(ActionEvent event) {
		rpsIndex = 1;

		nextButton();
	}

	private void homeText() {
		if (newGame.isPlayerBatting()) {

			HOME.setText(newGame.CPUSelection.getPitchingName());
			return;
		}
		HOME.setText(newGame.CPUSelection.getBattingName());

	}

	@FXML
	void executeRock(ActionEvent event) {
		rpsIndex = 0;

		nextButton();
	}

	@FXML
	void executeScissors(ActionEvent event) {
		rpsIndex = 2;

		nextButton();

	}

	void turnlightOn(int index, Circle[] lightArray) {
		lightOff(lightArray);
		int i;
		for (i = 0; i < index; i++) {

			(lightArray[i]).setFill(lightOn);
		}

	}

	void lightOff(Circle[] lightArray) {
		int i;
		for (i = 0; i < lightArray.length; i++) {

			(lightArray[i]).setFill(lightOff);
		}
	}

	void getLightColors() {
		lightOff = out2.getFill();
		lightOn = out1.getFill();
		out1.setFill(lightOff);
	}

	void cleanSlate() {
		HeadsorTails.setVisible(true);
		dropCurtain();
		clearBases(batterBasesArray);
		clearBases(pitcherBasesArray);
		clearLights();
		clearScoreBoard();
	}

	private void clearScoreBoard() {
		clearUpperScore();
		clearLowerScore();
	}

	private void clearUpperScore() {
		int i;
		for (i = 0; i < 9; i++) {
			playerScores[i].setText("");
		}
		pTotal.setText("");
	}

	private void clearLowerScore() {
		int i;
		for (i = 0; i < 9; i++) {
			cpuScores[i].setText("");
		}
		cTotal.setText("");
	}

	void clearBases(Group[] baseArray) {
		int i;
		for (i = 0; i < 3; i++) {
			runnerOff(i, baseArray);
		}
	}

	void runnerOff(int index, Group[] baseArray) {
		baseArray[index].setVisible(false);
	}

	void runnerOn(int index, Group[] baseArray) {
		baseArray[index].setVisible(true);
	}

	void changeToBatter() {
		dropCurtain();
		pitcherPOV.setVisible(false);
		batterPOV.setVisible(true);
		clearBases(batterBasesArray);
		clearBases(pitcherBasesArray);
		raiseCurtain();
		clearLights();

	}

	void changeToPitcher() {
		dropCurtain();
		batterPOV.setVisible(false);
		pitcherPOV.setVisible(true);
		clearBases(batterBasesArray);
		clearBases(pitcherBasesArray);
		raiseCurtain();
		clearLights();

	}

	private void clearLights() {
		lightOff(outLightsArray);

		lightOff(strikeLightsArray);

		lightOff(ballsLightsArray);

	}

	void dropCurtain() {
		sceneCurtain.setVisible(true);
	}

	void raiseCurtain() {
		sceneCurtain.setVisible(false);
	}

	void hideTitle() {
		HeadsorTails.setVisible(false);
	}
}