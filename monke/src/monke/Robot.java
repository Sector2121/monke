package monke;

import java.util.ArrayList;
import java.util.Random;

public class Robot extends Creature{
	
	private Random rand = new Random();
	
	public Robot(Asteroid a) { //Konstruktor
		SetAsteroid(a);
		a.Accept(this);
	}
	
	public void Drill() { //A robot fur
		asteroid.ReduceLayers();
	}
	
	public void Step() { //A robot lep
		if(GetAsteroid().GetLayers() == 0) { //Ha az aszteroidanak nincs kopenye akkor a robot atlep egy masik aszteroidara
			ArrayList<Travel> neighbors = asteroid.GetNeighbors();
			Move(neighbors.get(0));
		}
		if(asteroid.GetLayers() > 0) { //Ha az aszteroidanak van kopenye akkor a robot fur
			Drill();
		}
	}
	
	@Override
	public void Explode() { //A robot aszteroidaja felrobban
		ArrayList<Travel> neighbors = asteroid.GetNeighbors();
		if(neighbors == null) { //Ha az aszteroidanak nincs szomszedja, a robot meghal
			Die();
		}
		else { //Ha az aszteroidanak van szomszedja, a robot atlep az egyikre
			Move(neighbors.get(rand.nextInt(neighbors.size()))); 
		}
	}
}
