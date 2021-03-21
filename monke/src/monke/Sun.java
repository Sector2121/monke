package monke;

import java.util.ArrayList;
import java.util.Scanner;

public class Sun {
	private ArrayList<Asteroid> asteroids;
	private boolean sunStormNextRound;
	
	
	public Sun(ArrayList<Asteroid> asteroids) { //Konstruktor
		this.asteroids = asteroids;
		this.sunStormNextRound = false;
	}
	
	public void GetNewAsteroids(Asteroid asteroid) { //Megszerzi az új napközeli aszteroidát
		System.out.println("Get new asteroid!");
		asteroids.add(asteroid); //Hozzáadja a megkapott aszteroidát a nap aszteroidáihoz (napközeliekhez)
	}
	
	public void SunStorm() {
		System.out.println("SunStorm was called!");
		asteroids.get(0).GetLayers();
		Scanner myObj = new Scanner(System.in);
		int ertek = Integer.parseInt(myObj.nextLine()); //Bekéri a köpeny méretét
		if (ertek==0) {
			System.out.println("\tEveryone save!"); //Nincs köpeny, így el tudnak bújni a telepesek és robotok
			return;
		}
		else if(ertek>0) { //Van köpenye így meghívja az aszteroidára a napvihart
			asteroids.get(0).SunStorm();
		}
	}
	
	public void SetCritical() { //Beállítja az időjárást kritikusra
		System.out.println("Weather critical!");
		
	}
	
	public void SetNormal() { //Beállítja az időjárást normálisra
		System.out.println("Weather normal!");
	}
	
	public void Step() { //Lép a Nap
		System.out.println("Sun stepped!");
	}
}
