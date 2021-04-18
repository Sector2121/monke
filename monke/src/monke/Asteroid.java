package monke;

import java.util.ArrayList;
import java.util.Random;

public class Asteroid implements Travel{
	private Game game;
	private int id;
	private int layers;
	private boolean closeToSun;
	private String weather;
	private boolean isEmpty;
	private ArrayList<Creature> creatures;
	private Resource resource;
	private ArrayList<Travel> neighbors;
	private static BillOfResources bill;
	/**
	 * Konstruktor.
	 * @param g
	 * @param id
	 * @param r
	 */
	public Asteroid(Game g, int id, Resource r) {
		game = g;
		this.id = id; 						/*Ez meg kell!!!!!!!!!!!!!!!!!!!!!!!*/
		Random rand = new Random();
		layers = rand.nextInt(3) + 3;
		closeToSun = false;
		weather = "normal";
		if(r == null)
			isEmpty = true;
		else
			isEmpty = false;
		creatures = new ArrayList<Creature>();
		resource = r;
		neighbors = new ArrayList<Travel>();
		bill = new BillOfResources();
	}
	/**
	 * Visszaadja az aszteroida id-jet.
	 * @return Visszater az id-vel.
	 */
	public int GetId() {
		return id;
	}
	/**
	 * Visszaadja, hogy ures-e az aszteroida.
	 * @return  Visszater az isEmpty-vel.
	 */
	public boolean GetIsEmpty() {
		return isEmpty;
	}
	/**
	 * Beallitja az isEmpty booleant.
	 * @param b
	 */
	public void SetIsEmpty(boolean b) {
		isEmpty = b;
	}
	/**
	 * Visszaadja, hogy mekkora az aszteroida kopenye.
	 * @return Visszaadja a layers valtozot.
	 */
	public int GetLayers() {
		return layers;
	}
	/**
	 * Beallitja a layers valtozot.
	 * @param l
	 */
	public void SetLayers(int l) {
		System.out.println("Asteroida layer set successfully!");
		layers = l;
	}
	/**
	 * Visszaadja, hogy milyen nyersanyag van az aszteroidaban.
	 * @return Visszaadja a resource-t.
	 */
	public Resource GetResource() {
		return resource;
	}
	/**
	 * Beallitja a a resource-t.
	 * @param r
	 */
	public void SetResource(Resource r) {
		System.out.println("Asteroid resource set successfully!");
		resource = r;
	}
	/**
	 * Visszaadja, hogy az aszteroida napkozelben van-e.
	 * @return Visszaadja a closeToSun booleant.
	 */
	public boolean GetCloseToSun() {
		return closeToSun;
	}
	/**
	 * Beallitja a closeToSun booleant.
	 * @param b
	 */
	public void SetCloseToSun(boolean b) {
		closeToSun = b;
	}
	/**
	 * Visszaadja az aszteroidan levo idojarast.
	 * @return Visszaadja a weather-t.
	 */
	public String GetWeather() {
		return weather;
	}
	/**
	 * Beallitja az idojarast.
	 * @param w
	 */
	public void SetWeather(String w) {
		System.out.println("Weather set successfully!");
		weather = w;
	}
	/**
	 * Visszaadja a szomszedos aszteroidak es teleportok listajat
	 * @return Visszaadja a neighbors-t.
	 */
	public ArrayList<Travel> GetNeighbors(){
		return neighbors;
	}
	/**
	 * A megkapott aszteroida vagy teleport hozzaadodik az aszteroida szomszedaihoz.
	 * @param t
	 */
	public void AddNewNeighbor(Travel t) {
		neighbors.add(t);
	}
	/**
	 * A megkapott aszteroida vagy teleport torlodik az aszteroida szomszedai kozul.
	 */
	public void RemoveNeighbor(Travel t) {
		neighbors.remove(t);
	}
	/**
	 * Visszaadja az aszteroidan tartozkodo entitasokat.
	 * @return Visszaadja a creature-ok listajat.
	 */
	public ArrayList<Creature> GetCreatures() {
		return creatures;
	}
	/**
	 * Hozzaadja az entitast az aszteroidahoz.
	 * @param c
	 */
	public void AddCreature(Creature c){
		creatures.add(c);
	}
	/**
	 * Torli az aszteroidarol a megkapott entitast.
	 * @param c
	 */
	public void Remove(Creature c) {
		creatures.remove(c);
	}
	/**
	 * Csokkenti az aszteroida kopenyet.
	 * Ha epp napkozelben van, akkor meghivja a resource CloseToSun fuggvenyet.
	 */
	public void ReduceLayers() {
		if(layers == 1 && closeToSun) {
			layers--;
			System.out.println("Successful drill!");
			resource.CloseToSun(this);
		}
		else if(layers > 0){
			layers--;
			System.out.println("Successful drill!");
		}
		else {
			System.out.println("The asteroid has no layers, drilling unsuccessful!");
		}
	}
	/**
	 * Megnezi, hogy a kapott travel szomszedja-e annak a travelnek amire ez hivva van.
	 * @param t
	 * @return Ha szomszedja, akkor true-val, ha nem, akkor false-al ter vissza.
	 */
	public boolean CheckNeighbor(Travel t) {
		for(Travel tr : neighbors) {
			if(tr == t)
				return true;
		}
		return false;
	}
	/**
	 * Napviharnal ha el tudnak bujni az entitasok nem csinal semmit, egyebkent pedig megoli az osszes entitast ami rajta van.
	 */
	public void SunStorm() {
		if(layers == 0 && isEmpty);
		else {
			if(creatures != null)
				for(Creature c : creatures)
					c.Die();
			if(neighbors != null)
				for(Travel t : neighbors)
					t.SetIsMoving();
		}
	}
	/**
	 * Felrobban az aszteroida.
	 */
	public void Explode() {
		if(creatures != null)
			for(Creature c : creatures)
				c.Explode();
		if(neighbors != null)
			for(Travel t : neighbors)
				t.RemoveNeighbor(this);
		System.out.println("Asteroid exploded!");
	}
	/**
	 * Megnezi, hogy van-e osszesen minden nyersanyagbol harom az aszteroidan levo telepeseknel.
	 * Ha a telepesek osszegyujtottek eleg nyersanyagot, meghivja az EndGame()-et.
	 */
	public void CheckEnoughResources() {
		ArrayList<Resource> all = new ArrayList<>();
		for(Creature c : creatures) {
			if(c.GetResources() != null) {
				for(Resource r : c.GetResources()) {
					all.add(r);
				}
			}
		}
		if(bill.CheckResource(all, "Base")) {
			game.EndGame();
		}
	}
	/**
	 * Teleport elfogadasa.
	 */
	@Override
	public void AcceptTeleport(Teleport t) {
		t.SetAsteroid(this);
		AddNewNeighbor(t);
	}
	/**
	 * Elfogadja a ralepo entitast.
	 */
	@Override
	public void Accept(Creature c) {
		creatures.add(c);
		c.SetAsteroid(this);
	}
	/**
	 * Az isMoving boolean beallitasa.
	 */
	@Override
	public void SetIsMoving() {}
	
	//Innentõl minden új
	public void GetOtherCreaturesName(Creature ask) {
		for (Creature c : creatures) {
			if(!c.GetName().equals(ask.GetName())) {
				System.out.print(c.GetName()+" ");
			}
		}
		System.out.println();
	}
	
	public void GetCreaturesName() {
		for (Creature c : creatures) {
			System.out.print(c.GetName()+" ");
		}
		System.out.println();
	}
	
	public void GetResourceName() {
		if(layers == 0) {
			if(resource != null) {
				resource.GetName();
				System.out.println();
			}
			else {
				System.out.println("empty");
			}
		}
		else {
			System.out.println("unknown");
		}
	}
	
	public void GetResourceNameForSure() {
		if(resource != null) {
			resource.GetName();
			System.out.println();
		}
		else {
			System.out.println("empty");
		}
	}
}
