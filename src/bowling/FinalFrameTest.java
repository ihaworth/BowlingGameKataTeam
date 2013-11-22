package bowling;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class FinalFrameTest
{

    private FinalFrame frame = new FinalFrame();

    @Test
    public void gutterFrameScoresZero()
    {
        frame.roll(0);
        frame.roll(0);
        assertThat(frame.calculateScore(),equalTo(0));
    }

    @Test
    public void onePinWithEachRollScoresTwo() {
        frame.roll(1);
        frame.roll(1);
        assertThat(frame.calculateScore(),equalTo(2));
    }

    @Test
    public void rollingASpareScoresABonusFromAnExtraRoll(){
        frame.roll(3);
        frame.roll(7);
        frame.roll(2);
        assertThat(frame.calculateScore(),equalTo(12));
    }

    @Test
    public void rollingAStrikeScoresABonusFromTheNext2Rolls(){
        frame.roll(10);
        frame.roll(7);
        frame.roll(2);
        assertThat(frame.calculateScore(),equalTo(19));
    }

    @Test
    public void spareBonusForThePreviousFrameIsTheFirstRoll(){
        frame.roll(5);
        frame.roll(2);
        assertThat(frame.spareBonusForPreviousFrame(), equalTo(5));
    }
}
