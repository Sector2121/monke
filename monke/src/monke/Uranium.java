package monke;

public class Uranium extends Resource{
	
	public void CloseToSun(Asteroid a) { //Napközelség esetén az urán miatt felrobban az aszteroida
		System.out.println("\t\tUranium CloseToSun was called");
		a.Explode(); //Meghívódik az aszteroidára a felrobban függvény
	}
}
