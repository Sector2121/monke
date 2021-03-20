package monke;

import java.util.ArrayList;

public class Robot extends Creature{
	
	public Robot() {
		System.out.println("\tBuildRobot was called");
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
