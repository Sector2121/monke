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
	
	
	
	public Asteroid(Resource resource) {
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
	
	public void AddCreature(Creature c){
		creatures.add(c);
	}	
	
	public void SetWeather(String w) {
		weather = w;
		System.out.println("Weather set to " + w);
	}
	
	public String GetWeather() {
		System.out.println("Please set the weather of the asteroid (normal, hot, critical): ");
		return weather;
	}
	
	public void ReduceLayers(Asteroid asteroid, int ertek, String napkozelseg) { //Lol ezt csak �gy lehet?
		System.out.println("\tLayers reduced!");
		if(ertek==1 && napkozelseg.equals("yes")) {
			resource.CloseToSun(asteroid);
		}
	}
	
	public void Remove(Creature c) {
		System.out.println("\t\t\t\tCreature removed from asteroid!");
	}
	
	public void Accept(Creature c) {
		/*creatures.add(c);
		c.SetAsteroid(this);*/
		System.out.println("Creature accepted to asteroid!");
	}
	
	public void CheckEnoughResources() {
		
	}
	
	public boolean CheckNeighbor(Travel t) {
		System.out.println("The asteroid/teleport is a neighbor!"); 
		return true;
	}
	
	public int GetLayers() {
		System.out.println("\tPlease enter layers");
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
	
	public void SetResource(Resource r) {
		System.out.println("\t\t\t\tAsteroid set resource!");
		this.resource=r;
	}
	
	public boolean GetCloseToSun() {
		System.out.println("\tPlease decide if the asteroid is close to sun or not (yes/no): ");
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
		r1.SetAsteroid(a);
		s.Die();
		r1.Die();
	}
	
	public void Explode() {
		System.out.println("\t\t\tAsteroi explode was called");
		creatures.get(0).Die();
	}
	
	public void AddNewNeighbor(Asteroid a) {
		System.out.println("New neighbor added!");
	}
	
	public void RemoveNeighbor(Asteroid a) {
		System.out.println("Neighbor removed!");
	}
	
}
