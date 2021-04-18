package monke;

public class Waterice extends Resource{
	
	Ellenorzo el = new Ellenorzo();
	/**
	 * Napkozelseg eseten a vizjeg elparolog az aszteroidabol, 
	 * null-ra allitjuk az aszteroida nyersanyagat
	 */
	@Override
	public void CloseToSun(Asteroid a) {
		a.SetResource(null);
		System.out.println("Waterice sublimated!");
		el.SetOsszString("Waterice sublimated!");
	}
	
	String GetName() {
		return "waterice";
	}
}
