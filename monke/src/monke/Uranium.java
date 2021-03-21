package monke;

public class Uranium extends Resource{
	
	public void CloseToSun(Asteroid a) {
		System.out.println("\t\tUranium CloseToSun was called");
		a.Explode();
	}
}
