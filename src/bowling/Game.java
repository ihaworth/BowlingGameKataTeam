package bowling;

import java.util.LinkedList;
import java.util.List;

public class Game
{
    private List<Frame> frames = new LinkedList<Frame>();
    private int frameIndex = 0;

    public Game() {
        initFrames();
    }

    private void initFrames() {
        //        for (int f = 0; f < 9; f++)
        //            frames.add(new StandardFrame());
        //
        //        frames.add(new FinalFrame());
        //
        //        for (int f = 0; f < 9; f++) {
        //            Frame frame = frames.get(f);
        //            frame.setNextFrame(frames.get(f + 1));
        //        }

        Frame nextFrame = new FinalFrame();
        frames.add(nextFrame);

        for (int i = 8; i >= 0; i--) {
            StandardFrame frame = new StandardFrame();
            frame.setNextFrame(nextFrame);
            nextFrame = frame;
            frames.add(0, frame);
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