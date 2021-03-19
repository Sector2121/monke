package monke;

public class Creature {
	private Asteroid asteroid;
	private String name;
	
	public void Move(Travel t) {
		asteroid.Remove(this);
		t.Accept(this);
		//...
	}
	
	public String GetName() {
		return name;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public Asteroid GetAsteroid() {
		return asteroid;
	}
	
	public void SetAsteroid(Asteroid a) {
		asteroid = a;
	}
	
	public void Drill() {
		if(asteroid.GetLayers() > 0) {
			asteroid.ReduceLayers();
		}
	}
	
	public void Die() {}
}
