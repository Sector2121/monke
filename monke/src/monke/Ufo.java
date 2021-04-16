package monke;

import java.util.ArrayList;

public class Ufo extends Creature{
	
	public Ufo(Asteroid a) { //Konstruktor
		SetAsteroid(a);
		a.Accept(this);
	}
	
	public void Mine() { //Az ufo banyaszik
		asteroid.SetResource(null);
	}
	
	public void Step() { //Az ufo lep
		if(asteroid.GetLayers() == 0) { //Ha az aszteroidanak nincs kopenye akkor az ufo kibanyassza a nyersanyagat
			Mine();
		}
		if(asteroid.GetLayers() > 0) { //Ha az aszteroidanak van kopenye akkor az ufo lep
			ArrayList<Travel> neighbors = asteroid.GetNeighbors();
			Move(neighbors.get(0));
		}
	}
	
	@Override
	public void Explode() { //A robot aszteroidaja felrobban
		Die();
	}
}
