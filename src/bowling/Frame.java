package bowling;

public class Frame
{
    private int scoreWithoutBonus;
    private boolean firstRoll = true;
    private int firstRollScore;
    private Frame nextFrame;

    public void roll(int pins)
    {
        if (firstRoll) {
            firstRoll = false;
            firstRollScore = pins;
        } else {
            firstRoll = true;
        }

        scoreWithoutBonus += pins;
    }

    public boolean isOver() {
        return firstRoll;
    }

    private boolean isSpare() {
        return scoreWithoutBonus == 10;
    }

    public int getFirstRollScore() {
        return firstRollScore;
    }

    public void setNextFrame(Frame nextFrame)
    {
        this.nextFrame = nextFrame;
    }

    public int calculateScore()
    {
        int scoreWithBonus = scoreWithoutBonus;

        if (isSpare())
            scoreWithBonus += nextFrame.getFirstRollScore();

        return scoreWithBonus;
    }
}
