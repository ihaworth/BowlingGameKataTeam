package bowling;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class StandardFrameTest
{
    private StandardFrame frame = new StandardFrame();
    private Frame nextFrame = mock(StandardFrame.class);

    @Before
    public void setUp()
    {
        frame.setNextFrame(nextFrame);
    }

    @Test
    public void isOverWhenAStrikeIsRolled()
    {
        frame.roll(10);
        assertThat("Expected frame to be over", frame.isOver(), is(true));
    }

    @Test
    public void isNotASpareWhenAStrikeIsRolled()
    {
        frame.roll(10);
        assertThat("Expected not to be a spare", frame.isSpare(), is(false));
    }

    @Test
    public void scoresAStrikeBonusFromTheNextFrameIfItIsAStrike()
    {
        when(nextFrame.strikeBonusForPreviousFrame()).thenReturn(7);

        frame.roll(10);
        assertThat(frame.calculateScore(), equalTo(17));
    }

    @Test
    public void whenAskedForAStrikeBonusReturnTheNonBonusFrameScore()
    {
        frame.roll(3);
        frame.roll(4);

        assertThat(frame.strikeBonusForPreviousFrame(), equalTo(7));
    }

    @Test
    public void returnTheNonBonusFrameScorePlusTheNextFrameSpareScoreIfTheFrameIsAStrike()
    {
        when(nextFrame.secondRollOfDoubleStrikeBonus()).thenReturn(2);

        frame.roll(10);

        assertThat(frame.strikeBonusForPreviousFrame(), equalTo(12));
    }

    @Test
    public void theSecondRollOfADoubleStrikeBonusIsTheFirstRollOfTheFrame() {

        frame.roll(1);
        frame.roll(2);

        assertThat(frame.secondRollOfDoubleStrikeBonus(), equalTo(1));

    }

}
