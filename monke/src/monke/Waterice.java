package monke;

public class Waterice extends Resource{
/**
 * Napkozelseg eseten a vizjeg elparolog az aszteroidabol, 
 * null-ra allitjuk az aszteroida nyersanyagat
 */
	@Override
	public void CloseToSun(Asteroid a) {
		System.out.println("Meg lettem h�vva");
		a.SetResource(null);
	}
	
	void GetName() {
		System.out.println("Waterice");
	}
}
