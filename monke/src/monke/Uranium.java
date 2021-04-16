package monke;

public class Uranium extends Resource{
	private int exposedCount;
	public void CloseToSun(Asteroid a) { //Napkozelseg eseten az uran miatt felrobban az aszteroida
		System.out.println("\t\tUranium CloseToSun was called");
		if(exposedCount == 3) {
			a.Explode(); //Meghivodik az aszteroidara a felrobban fuggveny
		}
	}
}
