package monke;

import java.util.ArrayList;
import java.util.Random;

public class Teleport implements Travel{
	private int id;
	private Asteroid asteroid;
	private Teleport pair;
	private boolean isMoving;
	
	public Teleport(int id) { //Konstruktor
		this.id = id; 															/*Ez meg kell!!!!!!!!!!!!!!*/
		asteroid = null;
		pair = null;
		isMoving = false;
	}
	
	public Teleport(int id, Teleport p){ //Konstruktor
		this.id = id; 															/*Ez meg kell!!!!!!!!!!!!!!!!!!!*/
		asteroid = null;
		pair = p;
		isMoving = false;
	}
	
	public Asteroid GetAsteroid() { //Visszaadja a teleport aszteroidajat
		return asteroid;
	}
	
	public void SetAsteroid(Asteroid a) { //Beallitja a teleport aszteroidajat a megkapottra
		asteroid = a;
	}
	
	public Teleport GetPair() { //Visszaadja a teleport teleportparjat
		return pair;
	}
	
	public void SetPair(Teleport t) { //Beallitja a teleport teleportparjat a megkapottra
		pair = t;
	}
	
	public void Accept(Creature c) { //Atkuldi az entitast a kapun es a maik kapu aszteroidajara rakja
		if(pair.GetAsteroid() != null) {
			pair.GetAsteroid().Accept(c);
		}
	}
	
	public void Move(Travel t) { //A teleport mozog
		if(asteroid != null)
			asteroid.RemoveNeighbor(t); 								/*Most ugy van h at tudnak menni a mozgo teleportok mas teleportokon mert igy tudtam megcsinalni*/
		t.AcceptTeleport(this);
	}
	
	public void Step() { //A teleport steppel
		if(isMoving) { //Ha a teleport mozog, akkor atlep egy random szomszedra
			Random rand = new Random();
			ArrayList<Travel> neighbors = asteroid.GetNeighbors();
			Travel t = neighbors.get(rand.nextInt(neighbors.size()));
			Move(t);
		}
	}
	
	@Override
	public void AcceptTeleport(Teleport t) { //Teleportkapu elfogadása
		pair.GetAsteroid().AcceptTeleport(t);
	}
	
	@Override
	public void SetIsMoving() { //Az isMoving booleant allitja
		isMoving = true;
	}
	
	@Override
	public void RemoveNeighbor(Travel t) {} //Szomszed eltavolitasa
	
}
