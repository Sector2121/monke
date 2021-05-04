package monke;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Game {
	private Sun sun;
	private ArrayList<Asteroid> asteroids;
	private ArrayList<Settler> settlers;
	private ArrayList<Ufo> ufos;
	private ArrayList<Robot> robots;
	private ArrayList<Teleport> teleports;
	private ArrayList<String> players;
	private ImageIcon playerimg;
	private View view;
	/**
	 * Konstruktor.
	 */
	public Game(String img, ArrayList<String> players){
		sun = new Sun();
		asteroids = new ArrayList<>();
		settlers = new ArrayList<>();
		ufos = new ArrayList<>();
		robots = new ArrayList<>();
		teleports = new ArrayList<>();
		this.players = players;
		if(img == "Steve")
			playerimg = new ImageIcon("steve.png");
		if(img == "Darth Vader")
			playerimg = new ImageIcon("darth vader.png");
		if(img == "Sweetie Belle")
			playerimg = new ImageIcon("sweetie belle.png");
		if(img == "Boba-feta")
			playerimg = new ImageIcon("boba fett.png");
		if(img == "Private")
			playerimg = new ImageIcon("private.png");
		view = new View();
		Init();
	}
	
	public void Init(){
		int asteroidCount = players.size() * 4;
		Random rand = new Random();
		for(int i=1;i<=asteroidCount;i++) {
			int r = rand.nextInt(5);
			Iron ir = new Iron();
			Carbon c = new Carbon();
			Uranium u = new Uranium();
			Waterice w = new Waterice();
			if(r == 0)
				asteroids.add(new Asteroid(this, i, ir));
			else if(r == 1)
				asteroids.add(new Asteroid(this, i, c));
			else if(r == 2)
				asteroids.add(new Asteroid(this, i, u));
			else if(r == 3)
				asteroids.add(new Asteroid(this, i, w));
			else if(r == 4)
				asteroids.add(new Asteroid(this, i, null));
		}
		
		sun.Init(asteroids);
		boolean b;
		while(true) {
			b = true;
			for(int i=0;i<asteroidCount;i++) {
				Asteroid a = asteroids.get(i);
				if(a.GetNeighbors().size() < 3) {
					b = false;
				}
			}
			if(!b) {
				for(int i=0;i<asteroidCount;i++) {
					Asteroid a = asteroids.get(i);
					Asteroid a2 = asteroids.get(rand.nextInt(asteroidCount));
					if(a != a2 && !a.CheckNeighbor(a2)) {
						a.AddNewNeighbor(a2);
						a2.AddNewNeighbor(a);
					}
				}
			}
			else {
				break;
			}
		}
		
		for(int i=0;i<players.size();i++) {
			settlers.add(new Settler(this, players.get(i)));
			int j = i + 1;
			String ufoname = "Ufo-" + j;
			ufos.add(new Ufo(this, ufoname));
		}
		
		for(int i=0;i<settlers.size();i++) {
			asteroids.get(0).AddCreature(settlers.get(i));
			asteroids.get(asteroidCount-1).AddCreature(ufos.get(i));
		}
		

		for(Asteroid a : asteroids) {
			int r = rand.nextInt(4);
			if(r == 0)
				a.SetWeather("hot");
		}
		
		
	}
	
	public void Play() {
		while(true) {
			for(int i=0;i<settlers.size();i++) {
				if(settlers.get(i) == null)
					continue;
				boolean finished = false;
				Settler s = settlers.get(i);
				while(!finished) {
					//GUIView
					
				}
				continue;
			}
			Step();
			if(settlers.size() == 0)
				break;
		}
	}
	
	public ArrayList<Ufo> GetUfos() {
		return ufos;
	}
	
	public Sun GetSun() {
		return sun;
	}
	
	public void AddAsteroid(Asteroid a) {
		System.out.println("Asteroid added!");
		asteroids.add(a);
	}
	
	public void SunStorm() {
		sun.SunStorm();
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
		boolean stillinside = true;
		int j = 0;
		int p;
		while(stillinside) {
			p = j;
			for(int i = p; i < asteroids.size(); i++) {
				if(i == asteroids.size()-1) {
					stillinside=false;
				}
					int temp = asteroids.size();
					asteroids.get(i).Step();
					if(temp != asteroids.size()) {
						break;
					}
				
				j++;
			}
		}
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
	
	//Ez új
	public void Reset() {
		System.out.println("Reset was successfull!");
		asteroids.clear();
		settlers.clear();
		ufos.clear();
		robots.clear();
		teleports.clear();
	}
}
