public class Frame {
	private final int x;
	private final int y;
	private Token token;

	public Frame(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void fill(Token t) {
		if (token != null) {
			throw new BoxAlreadySelectedException();
		}
		token = t;
	}

	public boolean empty() {
		return token == null;
	}

	public boolean hasSameTokenAs(Token t) {
		return token == t;
	}

	public boolean willClose(Frame[][] frames) {
		boolean row = true;
		boolean col = true;
		boolean dia = true;
		for (int i = 0; i < frames.length; i++) {
			if (frames[i][i] == null || !frames[i][i].hasSameTokenAs(token))
				dia = false;
			if ((frames[x][i] == null || !frames[x][i].hasSameTokenAs(token))) {
				row = false;
			}
			if ((frames[i][y] == null || !frames[i][y].hasSameTokenAs(token))) {
				col = false;
			}
		}

		return row || col || dia;

	}

	@Override
	public String toString() {
		return token != null ? token.name() : " ";
	}

	public Frame fetchForSimilar(Frame[][] frames) {
		if (frames[x][y] == null) {
			frames[x][y] = new Frame(x, y);
		}
		return frames[x][y];
	}

}
