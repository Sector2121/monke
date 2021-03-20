package monke;

public class Teleport implements Travel{
	private int id;
	private Asteroid asteroid;
	private Teleport pair;
	
	public Teleport() {
		System.out.println("\t\t\tTeleport constructor was called");
	}
	
	public Teleport(int i, Teleport p){
		id = i;
		asteroid = null;
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
			pair.GetAsteroid().AddCreature(c);;
			c.SetAsteroid(pair.GetAsteroid());
			
		}
	}
	
}
