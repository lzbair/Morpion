public class Frame {
	private final int x;
	private final int y;
	private Token token;

	public Frame(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frame other = (Frame) obj;
		if (token != other.token)
			return false;
		return true;
	}

	public void fill(Token t) {
		if(token != null){
			throw new BoxAlreadySelectedException();
		}
		token = t;
	}

}
