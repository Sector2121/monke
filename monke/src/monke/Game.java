package monke;

import java.util.ArrayList;

public class Game {
	private Sun sun;
	private ArrayList<Asteroid> asteroids;
	private ArrayList<Settler> settlers;
	private ArrayList<Ufo> ufos;
	private ArrayList<Robot> robots;
	private ArrayList<Teleport> teleports;
	/**
	 * Konstruktor.
	 */
	public Game(){
		asteroids = new ArrayList<>();
		sun = new Sun(asteroids);
		settlers = new ArrayList<>();
		ufos = new ArrayList<>();
		robots = new ArrayList<>();
		teleports = new ArrayList<>();
	}
	
	public ArrayList<Ufo> GetUfos() {
		return ufos;
	}
	
	public Sun GetSun() {
		return sun;
	}
	
	/**
	 * Lepteti az osszes leptetheto dolgot.
	 */
	public void Step() {
		System.out.println("Next round!");
		for(Robot r : robots)
			r.Step();
		for(Ufo u : ufos)
			u.Step();
		for(Teleport t : teleports)
			t.Step();
	}
	/**
	 * Hozzaad a jatekhoz egy teleportot.
	 * @param t
	 */
	public void AddTeleport(Teleport t) {
		teleports.add(t);
	}
	/**
	 * Hozzaad a jatekhoz egy robotot.
	 * @param r
	 */
	public void AddRobot(Robot r) {
		robots.add(r);
	}
	/**
	 * Hozzaad a jatekhoz egy ufot.
	 * @param u
	 */
	public void AddUfo(Ufo u) {
		ufos.add(u);
	}
	/**
	 * Hozzaad a jatekhoz egy settlert.
	 * @param s
	 */
	public void AddSettler(Settler s) {
		settlers.add(s);
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
	 * Eltavolitja a kapott teleportot a jatekbol.
	 * @param t
	 */
	public void RemoveTeleport(Teleport t) {
		teleports.remove(t);
	}
	/**
	 * Eltavolitja a kapott settler-t a jatekbol.
	 * @param s
	 */
	public void RemoveSettler(Settler s) {
		settlers.remove(s);
	}
	/**
	 * Eltavolitja a kapott robotot a jatekbol.
	 * @param r
	 */
	public void RemoveRobot(Robot r) {
		robots.remove(r);
	}
	/**
	 * Eltavolitja a kapott ufot a jatekbol.
	 * @param u
	 */
	public void RemoveUfo(Ufo u) {
		ufos.remove(u);
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
		ufos.clear();
		robots.clear();
		teleports.clear();
	}
}
