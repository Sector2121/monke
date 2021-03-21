package monke;

import java.util.ArrayList;
import java.util.Scanner;

public class Sun {
	private ArrayList<Asteroid> asteroids;
	private boolean sunStormNextRound;
	
	
	public Sun(ArrayList<Asteroid> asteroids) {
		this.asteroids = asteroids;
		this.sunStormNextRound = false;
	}
	
	public void GetNewAsteroids(Asteroid asteroid) {
		System.out.println("Get new asteroid!");
		asteroids.add(asteroid);
	}
	
	public void SunStorm() {
		System.out.println("SunStorm was called!");
		asteroids.get(0).GetLayers();
		Scanner myObj = new Scanner(System.in);
		int ertek = Integer.parseInt(myObj.nextLine());
		if (ertek==0) {
			System.out.println("\tEveryone save!");
			return;
		}
		else if(ertek>0) {
			asteroids.get(0).SunStorm();
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
