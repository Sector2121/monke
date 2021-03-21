package monke;

public class Waterice extends Resource{

	public void CloseToSun(Asteroid a) {
		System.out.println("\t\tWaterice CloseToSun was called");
		a.SetResource(null);
	}
}