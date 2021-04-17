package monke;

import java.util.ArrayList;
import java.util.Scanner;

public class Creature {
	protected Asteroid asteroid;
	private String name;
	
	
	public void Move(Travel t) { 
			boolean tf;
			tf = asteroid.CheckNeighbor(t); 
				if(tf) { 
					asteroid.Remove(this); 
					t.Accept(this); 
					
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
	
	public void SetAsteroid(Asteroid a) {
		asteroid = a;
	}
	
	
	public ArrayList<Resource> GetResources() { //ezt hagyd been lecci Palya koszipuszi - vitya
		return null;
	}
	

	
	public void Die() { 
		//placcs
	}
	
	public void Explode() {}
}
