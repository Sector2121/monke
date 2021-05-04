package monke;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Creature {
	protected Game game;
	protected Asteroid asteroid;
	private String name;
	
	/**
	 * A creature mozog.
	 * Ha egy szomszedra akar lepni, akkor atlep ra.
	 * Ha nem szomszedra akar lepni, akkor nem lep.
	 * @param t
	 */
	public boolean Move(Travel t) {
		boolean tf;
		tf = asteroid.CheckNeighbor(t); 
		if(tf) {
			asteroid.Remove(this); 
			t.Accept(this); 
			return true;
		}
		return false;
	} 
	
	/**
	 * Visszaadja a creature nevet.
	 * @return A creature neve.
	 */
	public String GetName() {
		return name;
	}
	
	/**
	 * Beallitja a creature nevet.
	 * @param name
	 */
	public void SetName(String name) {
		this.name = name;
	}
	
	/**
	 * Visszaadja a creature aszteroidajat.
	 * @return A creature aszteroidaja.
	 */
	public Asteroid GetAsteroid() {
		return asteroid;
	}
	
	/**
	 * Beallitja a creature aszteroidajat.
	 * @param a
	 */
	public void SetAsteroid(Asteroid a) {
		asteroid = a;
	}
	
	/**
	 * Visszaad egy ures nyersanyaglistat.
	 * @return null
	 */
	public ArrayList<Resource> GetResources() { /*ezt hagyd been lecci Palya koszipuszi - vitya*/
		return null;
	}
	
	/**
	 * A creature meghal.
	 */
	public void Die() {
		asteroid.Remove(this);
		System.out.println("R.I.P." + name);
	}
	
	/**
	 * A creature aszteroidaja felrobban.
	 */
	abstract void Explode();
}
