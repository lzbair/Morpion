import java.util.ArrayList;
import java.util.List;
;

public class Morpion {

	public static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	private final List<Player> players = new ArrayList<>();
	private final Grid grid;

	public Morpion(String grid, String player1, String player2) {
		int size = Integer.parseInt(grid.split("x")[0]);
		int qSize = size * size;
		this.players.add(player(player1, (qSize / 2) + qSize % 2));
		this.players.add(player(player2, (qSize / 2)));
		this.grid = new Grid(size);
	}

	public void play(String playerCode, String frameCode) {
		getPlayer(playerCode).play(grid, frame(frameCode));

	}


	public  String report(){
		return grid.report(players);
	}

	public String display() {
		return grid.display();
	}

	private Frame frame(String frameCode) {
		int x = Integer.parseInt(frameCode.split("x")[0]);
		int y = Integer.parseInt(frameCode.split("x")[1]);
		return new Frame(x, y);
	}

	private Player getPlayer(String player) {
		return this.players.get(players.indexOf(new Player(player, null, 0)));
	}

	private Player player(String player, int rounds) {
		String[] parts = player.split(":");
		String name = parts[0];
		String token = parts[1];
		return new Player(name, Token.valueOf(token), rounds);
	}
}
