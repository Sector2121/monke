package monke;

import java.util.ArrayList;

public class Game {
	private Sun sun;
	private ArrayList<Asteroid> asteroids;
	private ArrayList<Settler> settlers;
	/**
	 * Konstruktor.
	 */
	public Game(){
		asteroids = new ArrayList<>();
		sun = new Sun(asteroids);
		settlers = new ArrayList<>();
	}
	/**
	 * Visszaadja a jatek settlereinek listajat.
	 * @return Jatek settler listaja.
	 */
	public ArrayList<Settler> GetSettlers() {
		return this.settlers;
	}
	/**
	 * Visszaadja a jatek aszteroidainak listajat.
	 * @return Jatek aszteroida listaja.
	 */
	public ArrayList<Asteroid> GetAsteroid() {
		return this.asteroids;
	}
	/**
	 * Eltavolitja a kapott aszteroidat a jatekbol.
	 * @param a
	 */
	public void RemoveAsteroid(Asteroid a) {
		asteroids.remove(a);
	}
	/**
	 * Eltavolitja a kapott settler-t a jatekbol.
	 * @param s
	 */
	public void RemoveSettler(Settler s) {
		settlers.remove(s);
	}
	/**
	 * Ellenorzi, hogy el-e meg settler.
	 * @return Ha nem el tobb settler, akkor false-t ad, ha meg el valaki akkor true.
	 */
	public boolean CheckSettlerLifeLines() {
		if(settlers.isEmpty() == true) {
			return false;
		}
		else {
			return true;
		}
	}
	/**
	 * Jatek befejezese.
	 * Meghivodott ez a fuggveny es meg elnek telepesek, igy nyertek.
	 * Meghivodott ez a fuggveny es nem elnek mar telepesek, igy vesztettek.
	 */
	public void EndGame() {
		if(CheckSettlerLifeLines() == true) {
			System.out.println("A jateknak vege, a telepesek nyertek!");
		}
		else {
			System.out.println("A jateknak vege, a telepesek veszitettek!");
		}
	}
	/**
	 * Jatek elinditasa.
	 */
	public void Start() {}
	
	//Ez �j
	public void Reset() { //K�ne t�rolni az ufokat, robtokat, hogy resetn�l �k is kit�rl�djenek vagy ha az aszteroid�kat t�r�lj�k �k is elt�nnek?
		//De ha most nem akkor amikor steppelj�k �ket, akkor is t�rolni k�ne �ket valahol, nem?
		asteroids.clear();
		settlers.clear();
	}
}
