package monke;

public class Waterice extends Resource{

	@Override
	public void CloseToSun(Asteroid a) { //Napkozelseg eseten a vizjeg elparolog az aszteroidabol
		a.SetResource(null); //null-ra allitjuk az aszteroida nyersanyagat
	}
}
