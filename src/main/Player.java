
public class Player {
	private final String name;
	private final Token token;
	private  int rounds;
	public Player(String name, Token token, int rounds) {
		this.name = name;
		this.token = token;
		this.rounds = rounds;
	}
	
	public void play(Grid g, Frame f){
		g.fill(f,token);
		rounds--;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String status() {
		return rounds + " games for " + name;
	}


	public boolean hasSameTokenAs(Token t) {
		return t == token;
	}

	public boolean hasRounds() {
		return rounds > 0;
	}
	
	@Override
	public String toString() {
		return " " + name+ " ";
	}
	

}
