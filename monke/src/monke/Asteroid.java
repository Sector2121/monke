package monke;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Asteroid implements Travel{
	private int layers;
	private boolean closeToSun;
	private String weather;
	private boolean isEmpty;
	private ArrayList<Creature> creatures;
	private Resource resource;
	private ArrayList<Travel> neighbors;
	
	/*private Scanner myObj = new Scanner(System.in);
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));*/
	//
	
	
	public Asteroid(Resource resource) { //Konstruktor
		creatures = new ArrayList<Creature>();
		this.resource = resource;
		neighbors = new ArrayList<Travel>();
	}
	
	public boolean GetIsEmpty() {
		return isEmpty;
	}
	
	public ArrayList<Travel> GetNeighbors(){
		return neighbors;
	}
	
	public void AddCreature(Creature c){ //Hozzáadja az entitást az aszteroidához
		creatures.add(c);
	}	
	
	public void SetWeather(String w) { //Beállítja az időjárást a megkapottra
		weather = w;
		System.out.println("Weather set to " + w);
	}
	
	public String GetWeather() { //Visszaadja az időjárást
		System.out.println("Please set the weather of the asteroid (normal, hot, critical): "); //Lekéri milyen épp az időjárás
		return weather;
	}
	
	public void ReduceLayers(Asteroid asteroid, int ertek, String napkozelseg) { //Csökkenti az aszteroida köpenyét
		System.out.println("\tLayers reduced!");
		if(ertek==1 && napkozelseg.equals("yes")) { //Ha épp napközelben van, akkor ahhoz mérten meghívja a resourcetól függően a CloseToSun fv-t
			resource.CloseToSun(asteroid);
		}
	}
	
	public void Remove(Creature c) { //Törli az aszteroidáról a megkapott entitást
		System.out.println("\t\t\t\tCreature removed from asteroid!");
	}
	
	public void Remove1(Creature c) { //A tabulálás miatt van még egy ilyen fv.
		System.out.println("\tCreature removed from asteroid!");
	}
	
	public void Accept(Creature c) { //Elfogadja a rálépő entitást
		/*creatures.add(c);
		c.SetAsteroid(this);*/
		System.out.println("\tCreature accepted to asteroid!");
	}
	
	public void Accept1(Creature c) { //Tabulálás miatt van még egy ilyen fv.
		/*creatures.add(c);
		c.SetAsteroid(this);*/
		System.out.println("\t\tCreature accepted to asteroid!");
	}
	
	public void CheckEnoughResources() { //Megnézi, hogy van-e összesen minden nyersanyagból három az aszteroidán lévő telepeseknél
		System.out.println("\tCheckEnoughResources was called!");
	}
	
	public boolean CheckNeighbor(Travel t) { //Megnézi, hogy a kapott aszteroida szomszédja-e annak az aszteroidának amire ez hívva van
		System.out.println("\tThe asteroid/teleport is a neighbor!"); 
		return true;
	}
	
	public int GetLayers() {
		System.out.println("\tPlease enter layers"); //Megkérdi mekkora az aszteroida köpenye
		return layers;
	}
	
	public ArrayList<Creature> GetCreatures() {
		/*System.out.println("Creatures on this asteroid: ");
		for(Creature c : creatures){
			System.out.println(c.GetName());
		}*/
		return creatures;
	}
	
	public Resource GetResource() {
		return resource;
	}
	
	public void SetResource(Resource r) { //Beállítja az aszteroida nyersanyagát a kapottra
		System.out.println("\t\t\tAsteroid set resource!");
		this.resource=r;
	}
	
	public void SetResource1(Resource r) { //Tabulálás miatt van még egy ilyen fv.
		System.out.println("\tAsteroid set resource!");
		this.resource=r;
	}
	
	public boolean GetCloseToSun() { 
		System.out.println("\tPlease decide if the asteroid is close to sun or not (yes/no): "); //Megkérdezi a tesztelőtől, hogy napközelben van-e az aszteroida
		return closeToSun;
	}
	
	public void SunStorm() {
		System.out.println("\tSunstorm in asteroid started!");
		Resource r = new Resource();
		Asteroid a = new Asteroid(r);
		Settler s = new Settler();
	    Robot r1 = new Robot();
		a.AddCreature(s);
		a.AddCreature(r1);
		s.SetAsteroid(a);
		r1.SetAsteroid(a); //A teszthez szükséges tagok létrehozása és a köztük levő kapcsolat felállítása
		s.Die();
		r1.Die(); //Az aszteroidán tartózkodó példa robotra és settlerre meghívjuk a Die() fv-t
	}
	
	public void Explode() { //Felrobban asz aszteroida
		System.out.println("\t\t\tAsteroi explode was called");
		creatures.get(0).Die(); //A rajta lévő entitások meghalnak
	}
	
	public void AddNewNeighbor(Asteroid a) { //A megkapott aszteroida hozzáadódik az aszteroida szomszédai közé
		System.out.println("New neighbor added!");
	}
	
	public void RemoveNeighbor(Asteroid a) { //A megkapott aszteroida törlődik az aszteroida szomszédai közül
		System.out.println("Neighbor removed!");
	}
	
}
