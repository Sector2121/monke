package monke;

public class Creature {
	private Asteroid asteroid;
	private String name;
	
	public void Move(Travel t) {
		t.Accept(this);
		
	}
	
	public Asteroid GetAsteroid() {
		return null;
	}
	
	public void SetAsteroid() {
		
	}
	
	public void Drill() {
		
	}
	
	public void Die() {
		
	}
}
