package bowling;

public class FinalFrame implements Frame
{

    private int score;

    @Override
    public void roll(int pins)
    {
        score += pins;
    }

    @Override
    public boolean isOver()
    {
        // TODO Auto-generated method stub
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
        return 0;
    }

    @Override
    public int strikeBonusForPreviousFrame()
    {
        return 0;
    }

    @Override
    public int spareBonusForPreviousFrame()
    {

        return 0;
    }
}
