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
	
	public void SetAsteroid(Asteroid a) {
		asteroid = a;
	}
	
	public Teleport GetPair() {
		return pair;
	}
	
	public void SetPair(Teleport t) {
		pair = t;
	}
	
	public Asteroid GetAsteroid() {
		return asteroid;
	}
	
	public void RemoveTpk() {
		
	}
	
	public void Accept(Creature c) {
		if(pair.GetAsteroid() != null) {
			c.SetAsteroid(pair.GetAsteroid());
		}
	}
	
}
