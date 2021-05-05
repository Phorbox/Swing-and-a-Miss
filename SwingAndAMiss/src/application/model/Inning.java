package application.model;


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
        Bases = new boolean[]{false, false, false, false, false};
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

                break;
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

    //new batter is called by base, strike, and ball outcomes to reset strikes and balls
    private void newBatter() {
        this.strikes = 0;
        this.balls = 0;

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
}

