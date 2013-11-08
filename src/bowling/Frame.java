package bowling;

public class Frame
{
    private int scoreWithoutBonus;
    private int firstRollScore;
    private Frame nextFrame;
    private int rollCount = 0;

    public void roll(int pins)
    {
        if (isNewFrame()) {
            firstRollScore = pins;
        }

        rollCount ++;
        scoreWithoutBonus += pins;
    }

    private boolean isNewFrame()
    {
        return rollCount == 0;
    }

    public boolean isOver()
    {
        if(isStrike())
            return true;

        return rollCount == 2;
    }

    private boolean isStrike()
    {
        return firstRollScore == 10;
    }

    public int getFirstRollScore() {
        return firstRollScore;
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public int calculateScore()
    {
        int scoreWithBonus = scoreWithoutBonus;

        if (isSpare())
            scoreWithBonus += nextFrame.getFirstRollScore();

        return scoreWithBonus;
    }

    public boolean isSpare() {

        if(isStrike())
            return false;

        return scoreWithoutBonus == 10;
    }
}
