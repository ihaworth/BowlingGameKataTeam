package bowling;

public class Frame
{

    private int score;

    public int getScore()
    {
        return score;
    }

    public void roll(int pins)
    {
        score += pins;

    }

}
