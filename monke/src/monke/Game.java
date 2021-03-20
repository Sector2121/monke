package monke;

import java.util.ArrayList;

public class Game {
	private Sun sun;
	private ArrayList<Asteroid> asteroids;
	private ArrayList<Settler> settlers;
	
	public Game(){
		asteroids = new ArrayList<>();
		sun = new Sun(asteroids);
		settlers = new ArrayList<>();
	}
	
	public void RemoveAsteroid(Asteroid a) {}
	public void RemoveSettler(Settler c) {
		System.out.println("\t\t\t\t\t\tSettler removed from the game!");
	}
	public boolean CheckSettlerLifeLines() {
		return true;
	}
	public void EndGame() {
		
	}
	public void StormActivate() {
		
	}
	public void Start() {
		
	}
	
}
