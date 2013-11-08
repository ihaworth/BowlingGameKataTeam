package bowling;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class FrameTest
{

    private Frame frame = new Frame();

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
        Frame nextFrame = mock(Frame.class);
        //TODO: mock the bonus
        frame.setNextFrame(nextFrame);
        frame.roll(10);
        assertThat(frame.calculateScore(), equalTo(17));
    }

}
