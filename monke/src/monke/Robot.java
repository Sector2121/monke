package monke;

public class Robot extends Creature{
	
	public Robot(String name, Asteroid a) {
		this.SetName(name);
		this.SetAsteroid(a);
		System.out.println("Robot created");
	}
	
	@Override
	public void Die() {
		System.out.println("Robot died");
	}
	
	public void Step() {
		System.out.println("Robot stepped");
	}
}
