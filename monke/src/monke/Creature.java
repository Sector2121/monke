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
	
	public void Drill() {
		System.out.println("Drill was called");
		asteroid.GetLayers();
		Scanner myObj = new Scanner(System.in);
		int ertek = Integer.parseInt(myObj.nextLine());
		if (ertek<1) {
			return;
		}
		asteroid.GetCloseToSun();
		String napk�zels�g = myObj.nextLine();
		if(ertek>0) {
			asteroid.ReduceLayers(asteroid,ertek,napk�zels�g);
		}		
	}
	
	public void Die() {
		System.out.println("Die was called");
	}
	
	public void Explode() {}
}
