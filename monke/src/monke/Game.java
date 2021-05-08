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
	private String playerimg;
	private View view;
	private Settler onTurn;
	private int whichPlayer;
	/**
	 * Konstruktor.
	 */
	public Game(String img, ArrayList<String> players){
		whichPlayer = 0;
		sun = new Sun();
		asteroids = new ArrayList<>();
		settlers = new ArrayList<>();
		ufos = new ArrayList<>();
		robots = new ArrayList<>();
		teleports = new ArrayList<>();
		this.players = players;
		playerimg = img;
		view = new View(this);
		Init();
	}
	
	public void Init(){
		int asteroidCount = players.size() * 4;
		double inc = (double)(240 / (double)((double)players.size() * 0.2));
		if(inc < 60) inc = 60;
		double incy = 200;
		Random rand = new Random();
		int x=0;
		int y=40;
		for(int i=1;i<=asteroidCount;i++) {
			x += inc ;
			if(x > 1850) {
				x-=1850;
				y += incy;
			}
			int r = rand.nextInt(5);
			Iron ir = new Iron();
			Carbon c = new Carbon();
			Uranium u = new Uranium();
			Waterice w = new Waterice();
			if(r == 0) {
				Asteroid temp = new Asteroid(this, i, ir, x, y, view);
				asteroids.add(temp);
				view.AddDrawable(temp.GetView());
			}
				
			else if(r == 1) {
				Asteroid temp = new Asteroid(this, i, c, x, y, view);
				asteroids.add(temp);
				view.AddDrawable(temp.GetView());
			}
				
			else if(r == 2) {
				Asteroid temp = new Asteroid(this, i, u, x, y, view);
				asteroids.add(temp);
				view.AddDrawable(temp.GetView());
			}
				
			else if(r == 3) {
				Asteroid temp = new Asteroid(this, i, w, x, y, view);
				asteroids.add(temp);
				view.AddDrawable(temp.GetView());
			}
				
			else if(r == 4) {
				Asteroid temp = new Asteroid(this, i, null, x, y, view);
				asteroids.add(temp);
				view.AddDrawable(temp.GetView());
			}
			view.DrawAll();	
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
		
		int x0 = asteroids.get(0).GetView().GetX();
		int y0 = asteroids.get(0).GetView().GetY();
		
		int x1 = asteroids.get(asteroidCount-1).GetView().GetX();
		int y1 = asteroids.get(asteroidCount-1).GetView().GetY();
		
		for(int i=0;i<players.size();i++) {
			Settler temps = new Settler(this, players.get(i), x0, y0, view, playerimg);
			view.AddDrawable(temps.GetView());
			
			int j = i + 1;
			String ufoname = "Ufo-" + j;
			Ufo tempu = new Ufo(this, ufoname, x1, y1, view);
			view.AddDrawable(tempu.GetView());
		}
		onTurn = settlers.get(0);
		whichPlayer = 0;
		
		for(int i=0;i<settlers.size();i++) {
			asteroids.get(0).Accept(settlers.get(i));
			asteroids.get(asteroidCount-1).Accept(ufos.get(i));
		}
		

		for(Asteroid a : asteroids) {
			int r = rand.nextInt(4);
			if(r == 0)
				a.SetWeather("hot");
		}
		view.SetPlayer(settlers.get(0));
		view.DrawAll();	
		Play();
	}
	
	public void NextPlayer() { 
		if(whichPlayer == settlers.size()-1) {
			whichPlayer = -1;
			Step();
		}
			
		onTurn = settlers.get(++whichPlayer);
		view.GetGUI().SetPlayer(onTurn);
	}
	
	public void Play() {
		//while(true) {
			/*for(int i=0;i<settlers.size();i++) {
				if(settlers.get(i) == null)
					continue;
				boolean finished = false;
				onTurn = settlers.get(i);
				whichPlayer = i;*/
				//while(!finished) {
					//view.GetGUI().SetPlayer(onTurn);				
					//finished = true;
				//}
				/*view.DrawAll();
				continue;*/
			//}
			//Step();
			//if(settlers.size() == 0);
				//break;
		//}
	}
	
	public Settler GetOnTurn() {
		return onTurn;
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
		view.GetGUI().SetPlayer(onTurn);
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
	
	//Ez �j
	public void Reset() {
		System.out.println("Reset was successfull!");
		asteroids.clear();
		settlers.clear();
		ufos.clear();
		robots.clear();
		teleports.clear();
	}
}
