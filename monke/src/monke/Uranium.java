package monke;

public class Uranium extends Resource{
	
	private int exposedCount;
	/**
	 * Napkozelseg eseten az uran miatt felrobban az aszteroida.
	 * Meghivodik az aszteroidara a felrobban fuggveny.
	 */
	@Override
	public void CloseToSun(Asteroid a) {
		if(exposedCount == 3) {
			a.Explode();
		}
	}
	
	String GetName() {
		return "uranium ";
	}
}
