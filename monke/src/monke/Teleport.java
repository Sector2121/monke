package monke;

public class Teleport implements Travel{
	private int id;
	private Asteroid asteroid;
	private Teleport pair;
	
	public Teleport() { //Konstruktor
		System.out.println("\t\tTeleport constructor was called");
	}
	
	public Teleport(int i, Teleport p){ //Konstruktor
		System.out.println("\t\tTeleport constructor was called");
		id = i;
		asteroid = null;
		pair = p;
	}
	
	public void SetAsteroid(Asteroid a) { //Beállítja a teleport aszteroidáját a megkapottra
		System.out.println("\t\tTeleport set to asteroid!");
		asteroid = a;
	}
	
	public Teleport GetPair() {
		return pair;
	}
	
	public void SetPair(Teleport t) { //Beállítja a teleport teleportpárját a megkapottra
		System.out.println("\t\tTeleport pair set!");
		pair = t;
	}
	
	public Asteroid GetAsteroid() { //Visszaadja a teleport aszteroidáját
		System.out.println("\t\tGetAsteroid was called!");
		return asteroid;
	}
	
	public void RemoveTpk() {
		
	}
	
	public void Accept(Creature c) { //Elfogadja azt ami rá akar lépni
		System.out.println("\tTeleport accept was called!");
		/*if(pair.GetAsteroid() != null) {
			pair.GetAsteroid().AddCreature(c);;
			c.SetAsteroid(pair.GetAsteroid());	
		}*/
		Resource r = new Resource();
		Asteroid a = new Asteroid(r);
		a=pair.GetAsteroid();
		a.Accept1(c); //Meghívja az aszteroida acceptjét
		//System.out.println("\tCreature accepted to asteroid");
	
	}
	
}
