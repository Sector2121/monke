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
	
	public Asteroid(Game g, int id, Resource r) { //Konstruktor
		game = g;
		this.id = id; 						//Ez meg kell!!!!!!!!!!!!!!!!!!!!!!!
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
	 
	public boolean GetIsEmpty() {
		return isEmpty;
	}
	
	public void SetIsEmpty(boolean b) {
		isEmpty = b;
	}
	
	public int GetLayers() {
		return layers;
	}
	
	public void SetLayers(int l) {
		layers = l;
	}
	
	public Resource GetResource() {
		return resource;
	}
	
	public void SetResource(Resource r) { //Beallitja az aszteroida nyersanyagat a kapottra
		resource = r;
	}
	
	public boolean GetCloseToSun() {
		return closeToSun;
	}
	
	public void SetCloseToSun(boolean b) {
		closeToSun = b;
	}
	
	public String GetWeather() { //Visszaadja az idojarast
		return weather;
	}
	
	public void SetWeather(String w) { //Beallatja az idajarast a megkapottra
		weather = w;
	}
	
	public ArrayList<Travel> GetNeighbors(){
		return neighbors;
	}
	
	public void AddNewNeighbor(Travel t) { //A megkapott aszteroida vagy teleport hozzaadodik az aszteroida szomszedaihoz
		neighbors.add(t);
	}
	
	public void RemoveNeighbor(Travel t) { //A megkapott aszteroida vagy teleport torlodik az aszteroida szomszedai kozul
		neighbors.remove(t);
	}
	
	public ArrayList<Creature> GetCreatures() {
		return creatures;
	}
	
	public void AddCreature(Creature c){ //Hozzaadja az entitast az aszteroidahoz
		creatures.add(c);
	}	
	
	public void Remove(Creature c) { //Torli az aszteroidarol a megkapott entitast
		creatures.remove(c);
	}
	
	public void ReduceLayers() { //Csokkenti az aszteroida kopenyet
		if(layers == 1 && closeToSun) { //Ha epp napkozelben van, akkor meghivja a resource CloseToSun fuggvenyet
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
	
	public boolean CheckNeighbor(Travel t) { //Megnezi, hogy a kapott aszteroida szomszedja-e annak az aszteroidanak amire ez hivva van
		for(Travel tr : neighbors) {
			if(tr == t)
				return true;
		}
		return false;
	}
	
	public void SunStorm() { //Napviharnal ha el tudnak bujni az entitasok nem csinal semmit, egyebkent pedig megoli az osszes entitast ami rajta van
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
	
	public void Explode() { //Felrobban az aszteroida
		if(creatures != null)
			for(Creature c : creatures)
				c.Explode();
		if(neighbors != null)
			for(Travel t : neighbors)
				t.RemoveNeighbor(this);
		System.out.println("Asteroid exploded!");
	}
	
	public void CheckEnoughResources() { //Megnezi, hogy van-e osszesen minden nyersanyagbol harom az aszteroidan levo telepeseknel
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
	
	@Override
	public void AcceptTeleport(Teleport t) {
		t.SetAsteroid(this);
		AddNewNeighbor(t);
	}
	
	@Override
	public void Accept(Creature c) { //Elfogadja a ralepo entitast
		creatures.add(c);
		c.SetAsteroid(this);
	}
	
	@Override
	public void SetIsMoving() {}
	
}
