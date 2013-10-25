package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game
{
    private List<Frame> frames = new ArrayList<Frame>();
    private boolean firstRoll = true;
    private int frameIndex = 0;

    public Game() {
        for (int f = 0; f < 10; f++)
            frames.add(new Frame());
    }

    public void roll(int pins)
    {
        Frame frame = getFrame();

        if (firstRoll) {
            firstRoll = false;
        } else {
            frameIndex++;
            firstRoll = true;
        }
        frame.roll(pins);
    }

    private Frame getFrame()
    {
        return frames.get(frameIndex);
    }

    public int score()
    {
        int score = 0;

        for(Frame frame : frames){
            score += frame.getScore();
        }

        return score;
    }

}