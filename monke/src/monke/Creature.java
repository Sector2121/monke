package monke;

import java.util.Scanner;

public class Creature {
	protected Asteroid asteroid;
	private String name;
	
	public void Move(Travel t) {
		asteroid.Remove(this);
		t.Accept(this);
		//...
	}
	
	public String GetName() {
		return name;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public Asteroid GetAsteroid() {
		return asteroid;
	}
	
	public void SetAsteroid(Asteroid a) {
		asteroid = a;
	}
	
	public void SetAsteroid1(Asteroid a) { //Beállítja az entitás 
		System.out.println("\t\tSetAsteroid was called");
		asteroid = a;
	}
	
	public void Drill() { //Fúr az entitás
		System.out.println("Drill was called");
		asteroid.GetLayers();
		Scanner myObj = new Scanner(System.in);
		int ertek = Integer.parseInt(myObj.nextLine()); //Bekéri, hogy mekkora az aszteroida köpenye
		if (ertek<1) { //Ha nincs köpenye, nem történik semmi
			return;
		}
		asteroid.GetCloseToSun();
		String napközelség = myObj.nextLine(); //Bekéri, hogy az aszteroida napközeli-e
		if(ertek>0) { //Csökkenti a köpenyt
			asteroid.ReduceLayers(asteroid,ertek,napközelség);
		}		
	}
	
	public void Die() { //Az entitás meghal
		System.out.println("Die was called");
	}
	
	public void Explode() {}
}
