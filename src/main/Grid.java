import java.util.HashSet;
import java.util.List;
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
			if (frame.hashCode() == f.hashCode())
				return frame;
		}
		throw new IllegalTargetFrameException();
	}

	public String report(List<Player> players) {
		if (achieved()) {
			return winner(players);
		}
		return players.get(0).status() + ", " + players.get(0).status();
	}

	private boolean achieved() {
		// TODO Auto-generated method stub
		return false;
	}

	private Player winner(List<Player> players) {
		for (int i = 0; i < Math.sqrt(frames.size()); i++) {
			for (int j = 0; j < Math.sqrt(frames.size()); j++){
			targetFrame(new Frame(i, ))
			}
		}
		return null;
	}
}
