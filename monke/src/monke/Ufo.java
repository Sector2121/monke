package monke;

import java.util.ArrayList;

public class Ufo extends Creature{
	
	/**
	*Konstruktor
	*/
	public Ufo() {
	}
	
	/**
	*Az ufo banyaszik.
	*/
	public void Mine() { //Az ufo banyaszik
		asteroid.SetResource(null);
		System.out.println("Resource mined!");
	}
	
	/**
	 * Az ufo lep.
	 * Ha az aszteroidanak nincs kopenye akkor az ufo kibanyassza a nyersanyagat.
	 * Ha az aszteroidanak van kopenye akkor az ufo lep.
	 */
	public void Step() {
		if(asteroid.GetLayers() == 0) {
			Mine();
		}
		if(asteroid.GetLayers() > 0) {
			ArrayList<Travel> neighbors = asteroid.GetNeighbors();
			Move(neighbors.get(0));
		}
	}
	
	/**
	 * A robot aszteroidaja felrobban
	 */
	@Override
	public void Explode() {
		Die();
	}
}
