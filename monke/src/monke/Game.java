package monke;

public class Game {
	private Sun sun;
	private Asteroid[] asteroids;
	private Settler[] settlers;
	
	public Game(int asteroidCount, int settlerCount){
		sun = new Sun();
		asteroids = new Asteroid[asteroidCount];
		settlers = new Settler[settlerCount];
	}
	
	public void RemoveAsteroid(Asteroid a) {}
	public void RemoveSettler(Settler c) {
		
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
