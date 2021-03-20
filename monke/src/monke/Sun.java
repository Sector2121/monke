package monke;

public class Sun {
	private Asteroid[] asteroids;
	private boolean sunStormNextRound;
	
	public Sun() {
		
	}
	
	
	public Sun(Asteroid[] asteroids, boolean sunStormNextRound) {
		this.asteroids = asteroids;
		this.sunStormNextRound = sunStormNextRound;
	}
	
	public void GetNewAsteroids() {
		System.out.println("Get new asteroid!");
	}
	
	public void SunStorm() {
		System.out.println("Start sun sunstorm!");

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
