package monke;

import java.util.ArrayList;

public class Sun {
	private ArrayList<Asteroid> asteroids;
	private boolean sunStormNextRound;
	
	
	public Sun(ArrayList<Asteroid> asteroids) {
		this.asteroids = asteroids;
		this.sunStormNextRound = false;
	}
	
	public void GetNewAsteroids() {
		System.out.println("Get new asteroid!");
	}
	
	public void SunStorm() {
		System.out.println("\t\tStarted sun the sunstorm!");
		for(Asteroid a : asteroids) {
			a.GetLayers();
			a.SunStorm();
		}
	}
	
	public void SetCritical() {
		System.out.println("Weather critical!");
		
	}
	
	public void SetNormal() {
		System.out.println("Weather normal!");
	}
	
	public void Step() {
		System.out.println("Sun stepped!");
	}
}
