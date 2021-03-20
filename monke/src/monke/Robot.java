package monke;

import java.util.ArrayList;

public class Robot extends Creature{
	
	public Robot(Asteroid a) {
		System.out.println("\t\t\tRobot constructor was called");
		a.Accept(this);
	}
	Robot(){
		
	}
	@Override
	public void Die() {
		asteroid.Remove(null);
		System.out.println("\t\t\t\t\t\tRobot died!");
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
