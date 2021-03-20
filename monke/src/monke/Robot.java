package monke;

import java.util.ArrayList;

public class Robot extends Creature{
	
	public Robot(Asteroid a) {
		System.out.println("\t\t\tRobot constructor was called");
		this.asteroid = a;
		a.Accept(this);
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
