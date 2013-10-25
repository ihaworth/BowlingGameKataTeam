package bowling;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Ignore;
import org.junit.Test;

public class BowlingGameTest
{

    private Game game = new Game();

    @Test
    public void gutterGameScoresZero()
    {
        rollMany(0, 20);

        assertThat(game.score(), equalTo(0));
    }

    @Test
    public void onePinWithEveryRollScoresTwenty()
    {
        rollMany(1, 20);

        assertThat(game.score(), equalTo(20));
    }

    @Ignore
    @Test
    public void testOneSpare()
    {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(0, 17);

        assertThat(game.score(), equalTo(16));
    }

    private void rollMany(int pins, int rolls)
    {
        for (int i = 0; i < rolls; i++)
        {
            game.roll(pins);
        }
    }
}
