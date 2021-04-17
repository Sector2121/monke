package monke;

import java.util.ArrayList;
import java.util.Scanner;

public class Creature {
	protected Asteroid asteroid;
	private String name;
	
	public void Move(Travel t) { //A creature mozog
		boolean tf;
		tf = asteroid.CheckNeighbor(t); 
		if(tf) { //Ha egy szomszedra akar lepni, akkor atlep ra
			asteroid.Remove(this); 
			t.Accept(this); 
			System.out.println("Successfully moved!");
		}else { //Ha nem szomszedra akar lepni, akkor nem lep
			System.out.println("That asteroid is not a neighbor!");
		}
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
	
	public void SetAsteroid(Asteroid a) { //
		asteroid = a;
	}
	
	public ArrayList<Resource> GetResources() { //ezt hagyd been lecci Palya koszipuszi - vitya
		return null;
	}
	
	public void Die() { //A creature meghal
		asteroid.Remove(this);
		System.out.println("R.I.P." + name);
	}
	
	public void Explode() {} //A creature aszteroidaja felrobban
}
