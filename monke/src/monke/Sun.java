package monke;

import java.util.ArrayList;
import java.util.Random;

public class Sun {
	private ArrayList<Asteroid> asteroids;
	private boolean sunStormNextRound;
	
	/**
	 * Konstruktor.
	 * @param asteroids
	 */
	public Sun(ArrayList<Asteroid> asteroids) {
		this.asteroids = asteroids;
		this.sunStormNextRound = false;
	}
	
	/**
	 * Beallitja az uj napkozeli aszteroidat.
	 * Beallitja hot-ra.
	 * Hozzaadja a megkapott aszteroidat a nap aszteroidaihoz (napkozeliekhez).
	 * Visszaallitja az eddigit normal-ra.
	 * Torli az eddigi aszteroidat a listarol.
	 */
	public void GetNewAsteroids() {
		int db = 0;
		for(Asteroid a : asteroids) {
			db++;
		}
		for(int i = 0; i < db; i++) {
			if(asteroids.get(i).GetNeighbors() == null) {}
			else {
				for(Travel t : asteroids.get(i).GetNeighbors()) {
					if(t.GetWeather() != null)
						while(t.GetWeather() != "hot") {
							SetHot((Asteroid) t);
							asteroids.add((Asteroid) t);
							break;
						}
				}
				SetNormal(asteroids.get(i));
				asteroids.remove(asteroids.get(i));
			}
		}
	}
	
	/**
	 * Minden napkozeli aszteroidara meghivja a napvihart.
	 */
	public void SunStorm() {
		System.out.println("Sunstorm started!");
		for(Asteroid a : asteroids) {
			a.SunStorm();
		}
	}
	
	/**
	 * Beallitja a homersekletet critical-ra.
	 * @param a
	 */
	public void SetCritical(Asteroid a) {
		a.SetWeather("critical");
	}
	
	/**
	 * Beallitja a homersekletet normal-ra.
	 * @param a
	 */
	public void SetNormal(Asteroid a) {
		a.SetWeather("normal");
	}
	
	/**
	 * Beallitja a homersekletet hot-ra.
	 * @param a
	 */
	public void SetHot(Asteroid a) {
		a.SetWeather("hot");
	}
	
	/**
	 * Lep a Nap.
	 * Ha napvihar van, akkor mindegyik aszteroidajara meghivja a napvihart.
	 * Visszaallitja hot-ra a napkozeli aszteroidakat.
	 * Veletlenszeruen igazra allitja a vihar ekorejelzot.
	 * Beallitja critical-ra a napkozeli aszteroidakat.
	 * Frissiti a napkozeli aszteroidakat.
	 */
	public void Step() {
		if(sunStormNextRound == true) {
			SunStorm();
			for(Asteroid a : asteroids) {
				SetHot(a);
			}
		}
		else {
			Random rand = new Random();
			int sz = rand.nextInt(100);
			if(sz > 0 && sz < 10) {
				sunStormNextRound = true;
				for(Asteroid a : asteroids) {
					SetCritical(a);
				}
			}
			else {
				GetNewAsteroids();
			}
		}
	}
}
