import java.util.List;

public class Grid {
	private final Frame[][] frames;
	private Token winner;

	public Grid(int size) {
		frames = new Frame[size][size];
	}

	public void fill(Frame f, Token token) {
		if (winner != null) {
			throw new GridAlreadyAchievedException();
		}
		Frame frame = f.fetchForSimilar(frames);
		frame.fill(token);
		if (frame.willClose(frames)) {
			winner = token;
		}
	}

	public String report(List<Player> players) {
		if (winner != null) {
			return "Game Over," + winner(players) + "is a winner";
		}
		Player player1 = players.get(0);
		Player player2 = players.get(1);
		if (!player1.hasRounds() && !player1.hasRounds()) {
			return "Game Over, equality";
		}
		return player1.status() + ", " + player2.status();
	}

	private Player winner(List<Player> players) {
		for (Player player : players) {
			if (player.hasSameTokenAs(winner))
				return player;
		}
		return null;
	}

	public String display() {
		StringBuilder display = new StringBuilder();
		for (int i = 0; i < frames.length; i++) {
			for (int j = 0; j < frames.length - 1; j++) {
				display.append(frames[i][j]);
				display.append('|');
			}
			display.append(frames[i][frames.length - 1]);
			display.append(Morpion.LINE_SEPARATOR);
		}
		return display.toString();
	}
}
