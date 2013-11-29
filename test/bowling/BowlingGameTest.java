package bowling;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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

    @Test
    public void testOneSpare()
    {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(0, 17);

        assertThat(game.score(), equalTo(16));
    }

    @Test
    public void testOneSpareAndAnotherRoll()
    {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        game.roll(4);
        rollMany(0, 16);

        assertThat(game.score(), equalTo(20));
    }

    @Test
    public void testTwoConsecutiveSpares()
    {
        game.roll(5);
        game.roll(5);

        game.roll(5);
        game.roll(5);

        game.roll(3);
        rollMany(0, 15);

        assertThat(game.score(), equalTo(31));
    }

    @Test
    public void testOneStrike()
    {
        game.roll(10);
        game.roll(3);
        game.roll(3);
        rollMany(0, 16);

        assertThat(game.score(), equalTo(22));
    }

    @Test
    public void testTwoConsecutiveStrikes() {
        game.roll(10);
        game.roll(10);
        rollMany(0, 16);

        assertThat(game.score(), equalTo(30));
    }

    @Test
    public void testTwoConsecutiveStrikesWithBonus() {
        game.roll(10);
        game.roll(10);
        game.roll(2);
        game.roll(3);
        rollMany(0, 14);

        assertThat(game.score(), equalTo(42));
    }


    @Test
    public void aSpareInTheLastFrameScoresItsBonusFromTheThirdRoll() {
        rollMany(0, 18);
        game.roll(4);
        game.roll(6);
        game.roll(2);

        assertThat(game.score(), equalTo(12));
    }

    @Test
    public void aStrikeInTheLastFrameScoresItsBonusFromTheNextTwoRolls() {
        rollMany(0, 18);
        game.roll(10);
        game.roll(6);
        game.roll(2);

        assertThat(game.score(), equalTo(18));
    }

    @Test
    public void aSpareInTheNinthFrameGetSpareBonusFromFinalFrame(){
        rollMany(0, 16);
        game.roll(5);
        game.roll(5);
        game.roll(1);
        game.roll(0);

        assertThat(game.score(), equalTo(12));
    }

    @Test
    public void aStrikeInTheNinthFrameGetStrikeBonusFromFinalFrame(){
        rollMany(0, 16);
        game.roll(10);
        game.roll(2);
        game.roll(1);

        assertThat(game.score(), equalTo(16));
    }

    @Test
    public void perfectGameScores300(){
        rollMany(10, 12);

        assertThat(game.score(), equalTo(300));
    }

    private void rollMany(int pins, int rolls)
    {
        for (int i = 0; i < rolls; i++)
        {
            game.roll(pins);
        }
    }
}
