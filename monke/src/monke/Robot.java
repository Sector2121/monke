package monke;

import java.util.ArrayList;

public class Robot extends Creature{
	
	public Robot(String name, Asteroid a) {
		this.SetName(name);
		this.SetAsteroid(a);
		System.out.println("Robot created");
	}
	
	@Override
	public void Die() {
		GetAsteroid().Remove(this);
		System.out.println("Robot died");
	}
	
	public void Step() {
		if(GetAsteroid().GetLayers() == 0) {
			ArrayList<Travel> neighbors = GetAsteroid().GetNeighbors();
			Move(neighbors.get(0));
		}
		if(GetAsteroid().GetLayers() > 0) {
			Drill();
		}
		System.out.println("Robot stepped");
	}
}
