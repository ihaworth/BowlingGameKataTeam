package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game
{
    private List<Frame> frames = new ArrayList<Frame>();
    private int frameIndex = 0;

    public Game() {
        initFrames();
    }

    private void initFrames() {
        for (int f = 0; f < 10; f++)
            frames.add(new Frame());

        for (int f = 0; f < 9; f++) {
            Frame frame = frames.get(f);
            frame.setNextFrame(frames.get(f+1));
        }
    }

    public void roll(int pins) {
        getFrame().roll(pins);

        if (getFrame().isOver())
            frameIndex++;
    }

    private Frame getFrame() {
        return frames.get(frameIndex);
    }

    public int score() {

        int score = 0;

        for (Frame frame: frames)
            score += frame.calculateScore();

        return score;
    }

}