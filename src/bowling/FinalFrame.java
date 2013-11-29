package bowling;

public class FinalFrame implements Frame
{

    private int score;
    private int rollCount;
    private int firstRollScore;
    private int secondRollScore;

    @Override
    public void roll(int pins)
    {
        if (rollCount == 0){
            firstRollScore = pins;
        } else if (rollCount == 1){
            secondRollScore = pins;
        }
        rollCount++;

        score += pins;
    }

    @Override
    public boolean isOver()
    {
        return false;
    }

    @Override
    public int calculateScore()
    {
        return score;
    }

    @Override
    public int secondRollOfDoubleStrikeBonus()
    {
        return firstRollScore;
    }

    @Override
    public int strikeBonusForPreviousFrame()
    {
        return firstRollScore + secondRollScore;
    }

    @Override
    public int spareBonusForPreviousFrame()
    {
        return firstRollScore;
    }
}
