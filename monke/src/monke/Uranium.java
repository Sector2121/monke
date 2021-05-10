package monke;

public class Uranium extends Resource{
	
	private int exposedCount = 0;
	
	/**
	 * Napkozelseg eseten az uran miatt felrobban az aszteroida.
	 * Meghivodik az aszteroidara a felrobban fuggveny.
	 */
	public Uranium(int c) {
		exposedCount = c;
	}
	
	public int GetExposedCount() {
		return exposedCount;
	}
	
	@Override
	public void CloseToSun(Asteroid a) {
		exposedCount++;
		if(exposedCount == 3) {
			a.Explode();
		}
	}
	
	String GetName() {
		return "uranium";
	}
}
