
public class Player {
	private final String name;
	private final Token token;
	public Player(String name, Token token) {
		this.name = name;
		this.token = token;
	}
	
	public void play(Grid g, Frame f){
		g.fill(f,token);
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
	
	

}
