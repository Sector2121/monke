package monke;

import java.util.ArrayList;
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
	
	public void SetAsteroid1(Asteroid a) { //BeĂˇllĂ­tja az entitĂˇs 
		System.out.println("\t\tSetAsteroid was called");
		asteroid = a;
	}
	
	public ArrayList<Resource> GetResources() { //ezt hagyd been lecci Palya koszipuszi - vitya
		return null;
	}
	
	public void Drill() { //FĂşr az entitĂˇs
		System.out.println("Drill was called");
		asteroid.GetLayers();
		Scanner myObj = new Scanner(System.in);
		int ertek = Integer.parseInt(myObj.nextLine()); //BekĂ©ri, hogy mekkora az aszteroida kĂ¶penye
		if (ertek<1) { //Ha nincs kĂ¶penye, nem tĂ¶rtĂ©nik semmi
			return;
		}
		asteroid.GetCloseToSun();
		String napkozelseg = myObj.nextLine(); //BekĂ©ri, hogy az aszteroida napkĂ¶zeli-e
		if(ertek>0) { //CsĂ¶kkenti a kĂ¶penyt
			asteroid.ReduceLayers(asteroid,ertek,napkozelseg);
		}		
	}
	
	public void Die() { //Az entitĂˇs meghal
		System.out.println("Die was called");
	}
	
	public void Explode() {}
}
