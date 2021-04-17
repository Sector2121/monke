package monke;

import java.util.ArrayList;

public class Game {
	private Sun sun;
	private ArrayList<Asteroid> asteroids;
	private ArrayList<Settler> settlers;
	
	public Game(){ //Konstruktor
		asteroids = new ArrayList<>();
		sun = new Sun(asteroids);
		settlers = new ArrayList<>();
	}
	
	public ArrayList<Settler> GetSettlers() { //Visszaadja a jatek settlereinek listajat
		return this.settlers;
	}
	
	public ArrayList<Asteroid> GetAsteroid() { //Visszaadja a jatek aszteroidainak listajat
		return this.asteroids;
	}
	
	public void RemoveAsteroid(Asteroid a) { //Eltavolitja a kapott aszteroidat a jatekbol
		asteroids.remove(a);
	}
	
	public void RemoveSettler(Settler s) { //Eltavolitja a kapott settler-t a jatekbol
		settlers.remove(s);
	}
	
	public boolean CheckSettlerLifeLines() { //Ellenorzi, hogy el-e meg settler
		if(settlers.isEmpty() == true) {//Ha nem el tobb settler, akkor false-t ad
			return false;
		}
		else {
			return true; //Ha meg el valaki akkor true
		}
	}
	
	public void EndGame() { //Jatek befejezese
		if(CheckSettlerLifeLines() == true) { //Meghivodott ez a fuggveny es meg elnek telepesek, igy nyertek
			System.out.println("A jateknak vege, a telepesek nyertek!");
		}
		else {//Meghivodott ez a fuggveny es nem elnek mar telepesek, igy vesztettek
			System.out.println("A jateknak vege, a telepesek veszitettek!");
		}
	}
	
	public void Start() {} //Jatek elinditasa
}
