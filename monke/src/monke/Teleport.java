package monke;

public class Teleport implements Travel{
	private int id;
	private Asteroid asteroid;
	private Teleport pair;
	
	public Teleport(int i, Asteroid a, Teleport p){
		id = i;
		asteroid = a;
		pair = p;
	}
	
	public void SetAsteroid(Asteroid a) {}
	public Teleport GetPair() {
		return null;
	}
	public void SetPair() {}
	public Asteroid GetAsteroid() {
		return null;
	}
	public void RemoveTpk() {}
	public void Accept() {}
	
}
