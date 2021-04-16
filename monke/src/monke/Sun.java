package monke;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sun {
	private ArrayList<Asteroid> asteroids;
	private boolean sunStormNextRound;
	
	
	public Sun(ArrayList<Asteroid> asteroids) { //Konstruktor
		this.asteroids = asteroids;
		this.sunStormNextRound = false;
	}
	
	public void GetNewAsteroids() { //Megszerzi az uj napkozeli aszteroidat
		int db = 0;
		for(Asteroid a : asteroids) {
			db++;
		}
		for(int i = 0; i < db; i++) {
			if(asteroids.get(i).GetNeighbors() == null) {}
			else {
				for(Travel t : asteroids.get(i).GetNeighbors()) {
					while(((Asteroid) t).GetWeather() != "hot") {
						SetHot((Asteroid) t); //Beallitja hot-ra
						asteroids.add((Asteroid) t); //Hozzaadja a megkapott aszteroidat a nap aszteroidaihoz (napkozeliekhez)
						break;
					}
				}
				SetNormal(asteroids.get(i));//Visszaallitja az eddigit normal-ra
				asteroids.remove(asteroids.get(i));//Torli az aszteroidat a listarol
			}
		}
	}
	
	public void SunStorm() {
		for(Asteroid a : asteroids) { //Minden napkozeli aszteroidara meghivja a napvihart 
			a.SunStorm();
		}
	}
	
	public void SetCritical(Asteroid a) { //Beallitja a homersekletet critical-ra
		a.SetWeather("critical");
		
	}
	
	public void SetNormal(Asteroid a) { //Beallitja a homersekletet normal-ra
		a.SetWeather("normal");
	}
	
	public void SetHot(Asteroid a) { //Beallitja a homersekletet hot-ra
		a.SetWeather("hot");
	}
	
	public void Step() { //Lep a Nap
		if(sunStormNextRound == true) { //Ha napvihar van, akkor mindegyik aszteroidajara meghivja a napvihart
			SunStorm();
			for(Asteroid a : asteroids) { //Visszaallitja hot-ra a napkozeli aszteroidakat
				SetHot(a);
			}
		}
		else {
			Random rand = new Random();
			int sz = rand.nextInt(100);
			if(sz > 0 && sz < 10) { //Veletlenszeruen igazra allitja a vihar ekorejelzot
				sunStormNextRound = true;
				for(Asteroid a : asteroids) { //Beallitja critical-ra a napkozeli aszteroidakat
					SetCritical(a);
				}
			}
			else {
				GetNewAsteroids(); //Frissiti a napkozeli aszteroidakat
			}
		}
	}
}
