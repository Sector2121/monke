package monke;

import java.util.ArrayList;
import java.util.Random;

public class Teleport implements Travel{
	private int id;
	private Asteroid asteroid;
	private Teleport pair;
	private boolean isMoving;
	
	public Teleport() { //Konstruktor
		id = 1; 															//Ez meg kell!!!!!!!!!!!!!!
		asteroid = null;
		pair = null;
		isMoving = false;
	}
	
	public Teleport(Teleport p){ //Konstruktor
		id = 1; 															//Ez meg kell!!!!!!!!!!!!!!!!!!!
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
	
	public Teleport GetPair() {
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
	
	public void Move(Travel t) {
		if(asteroid != null)
			asteroid.RemoveNeighbor(t);			//Most ugy van h at tudnak menni a mozgo teleportok mas teleportokon mert igy tudtam megcsinalni
		t.AcceptTeleport(this);
	}
	
	public void Step() {
		if(isMoving) {
			Random rand = new Random();
			ArrayList<Travel> neighbors = asteroid.GetNeighbors();
			Travel t = neighbors.get(rand.nextInt(neighbors.size()));
			Move(t);
		}
	}
	
	@Override
	public void AcceptTeleport(Teleport t) {
		pair.GetAsteroid().AcceptTeleport(t);;
	}
	
	@Override
	public void SetIsMoving() {
		isMoving = true;
	}
	
	@Override
	public void RemoveNeighbor(Travel t) {}
	
}
