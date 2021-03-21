package monke;

import java.util.ArrayList;

public class Robot extends Creature{
	
	public Robot(Asteroid a) { //Konstruktor
		System.out.println("\tRobot constructor was called");
		a.Accept1(this);
		SetAsteroid1(a);
	}
	Robot(){
		
	}
	@Override
	public void Die() { //Meghal a robot
		asteroid.Remove(null); //Meghívja, hogy eltávolítódjon a robot az aszteroidáról
		System.out.println("\t\t\t\t\tRobot died!");
	}
	
	public void Step() { //Robot Step() fv-e
		if(GetAsteroid().GetLayers() == 0) { //Ha nincs köpenye akkor átlép másik aszteroidára
			ArrayList<Travel> neighbors = GetAsteroid().GetNeighbors();
			Move(neighbors.get(0));
		}
		if(GetAsteroid().GetLayers() > 0) { //Ha van köpenye akkor fúr
			Drill();
		}
		System.out.println("Robot stepped");
	}
}
