package monke;

public class Uranium extends Resource{
	
	private int exposedCount;
	/**
	 * Napkozelseg eseten az uran miatt felrobban az aszteroida.
	 * Meghivodik az aszteroidara a felrobban fuggveny.
	 */
	@Override
	public void CloseToSun(Asteroid a) {
		System.out.println("\t\tUranium CloseToSun was called");
		if(exposedCount == 3) {
			a.Explode();
		}
	}
	
	void GetName() {
		System.out.print("uranium ");
	}
}
