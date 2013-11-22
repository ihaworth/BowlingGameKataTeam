package bowling;

public interface Frame
{

    boolean isOver();

    int calculateScore();

    int secondRollOfDoubleStrikeBonus();

    int strikeBonusForPreviousFrame();

    int spareBonusForPreviousFrame();

    void roll(int pins);

}