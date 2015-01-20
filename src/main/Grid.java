import java.util.HashSet;

import java.util.Set;

public class Grid {
	private final Set<Frame> frames = new HashSet<>();

	public Grid(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Frame frame = new Frame(i, j);
				frames.add(frame);
			}
		}
	}

	public void fill(Frame f, Token t) {
		targetFrame(f).fill(t);
	}

	private Frame targetFrame(Frame f) {
		for (Frame frame : frames) {
			if (frame.equals(f))
				return frame;
		}
		throw new IllegalTargetFrameException();
	}
}
