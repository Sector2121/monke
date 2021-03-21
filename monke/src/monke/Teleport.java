package monke;

public class Teleport implements Travel{
	private int id;
	private Asteroid asteroid;
	private Teleport pair;
	
	public Teleport() {
		System.out.println("\t\tTeleport constructor was called");
	}
	
	public Teleport(int i, Teleport p){
		System.out.println("\t\tTeleport constructor was called");
		id = i;
		asteroid = null;
		pair = p;
	}
	
	public void SetAsteroid(Asteroid a) {
		System.out.println("\t\tTeleport set to asteroid!");
		asteroid = a;
	}
	
	public Teleport GetPair() {
		return pair;
	}
	
	public void SetPair(Teleport t) {
		System.out.println("\t\tTeleport pair set!");
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
