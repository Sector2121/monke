package monke;

import java.util.ArrayList;
import java.util.Random;

public class Robot extends Creature{
	
	private Random rand = new Random();
	/**
	 * Konstruktor.
	 * @param a
	 */
	public Robot(Game game, Asteroid a, String name) {
		SetName(name);
		SetAsteroid(a);
		a.Accept(this);
		game.AddRobot(this);
	}
	/**
	*A robot fur.
	*/
	public void Drill() {
		asteroid.ReduceLayers();
	}
	/**
	*A robot lep.
	*Ha az aszteroidanak nincs kopenye akkor a robot atlep egy masik aszteroidara.
	*Ha az aszteroidanak van kopenye akkor a robot fur.
	*/
	public void Step() { 
		if(asteroid.GetLayers() > 0) {
			Drill();
		}
		else if(GetAsteroid().GetLayers() == 0) { 
			ArrayList<Travel> neighbors = asteroid.GetNeighbors();
			if(neighbors.size() > 0)
				Move(neighbors.get(0));
		}
	}
	/**
	*A robot aszteroidaja felrobban.
	*Ha az aszteroidanak nincs szomszedja, a robot meghal.
	*Ha az aszteroidanak van szomszedja, a robot atlep az egyikre.
	*/
	@Override
	public void Explode() { 
		ArrayList<Travel> neighbors = asteroid.GetNeighbors();
		if(neighbors.size() == 0) {
			Die();
		}
		else {
			Move(neighbors.get(rand.nextInt(neighbors.size()))); 
		}
	}
}
