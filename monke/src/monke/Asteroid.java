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
		System.out.println("Creature (" + c.GetName() + ") added!");
	}	
	
	public void SetWeather(String w) {
		weather = w;
		System.out.println("Weather set to " + w);
	}
	
	public String GetWeather() {
		System.out.println("Please set the weather of the asteroid (normal, hot, critical): ");
		return weather;
	}
	
	public void ReduceLayers(Asteroid asteroid, int ertek, String napközelség) { //Lol ezt csak �gy lehet?
		System.out.println("\tLayers reduced!");
		if(ertek==1 && napközelség.equals("yes")) {
			resource.CloseToSun(asteroid);
		}
	}
	
	public void Remove(Creature c) {
		System.out.println("\t\t\t\t\tCreature removed from asteroid!");
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
	
	public int GetLayers() { ///AJAJAJAJA //:=( (Hitler XD)
		System.out.println("\t\t\tPlease enter layers");
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
		System.out.println("\t\t\tSetResource was called");
		this.resource=r;
	}
	
	public boolean GetCloseToSun() {
		System.out.println("\tPlease decide if the asteroid is close to sun or not (yes/no): ");
		return closeToSun;
	}
	
	public void SunStorm() {
		System.out.println("\t\t\t\tSunstorm in asteroid started!");
		Settler s = new Settler();
	    Robot r = new Robot();
		s.Die();
		r.Die();
		/*if(layers == 0 && isEmpty);
		else {
			for(Creature c : creatures){
				c.Die();
			}
		}*/
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
