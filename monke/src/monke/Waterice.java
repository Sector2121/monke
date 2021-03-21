package monke;

public class Waterice extends Resource{

	public void CloseToSun(Asteroid a) { //Napközelség esetén a vízjég elpárolog az aszteroidából
		System.out.println("\t\tWaterice CloseToSun was called");
		a.SetResource(null); //null-ra állítjuk az aszteroida nyersanyagát
	}
}
