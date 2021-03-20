package monke;

import java.util.ArrayList;

public class Asteroid {
	private int layers;
	private boolean closeToSun;
	private String weather;
	private boolean isEmpty;
	private ArrayList<Creature> creatures;
	private Resource resource;
	private ArrayList<Travel> neighbors;
	
	
	public Asteroid() {
		layers = 3;
		isEmpty = false;
		closeToSun = false;
		weather = "normal";
		creatures = new ArrayList<Creature>();
		resource = new Iron();
		neighbors = new ArrayList<Travel>();
	}
	
	public boolean GetIsEmpty() {
		if(isEmpty) System.out.println("The asteroid is empty!");
		else System.out.println("The asteroid is not empty!");
		return isEmpty;
	}
	
	public ArrayList<Travel> GetNeighbors(){
		return neighbors;
	}
	
	public void AddCreature(Creature c){
		System.out.println("Creature " + c.GetName() + " added!");
	}	
	
	public void SetWeather(String w) {
		weather = w;
		System.out.println("Weather set to " + w);
	}
	
	public String GetWeather() {
		System.out.println("The weather is " + weather + "!");
		return weather;
	}
	
	public void ReduceLayers() {
		layers--;
		System.out.println("Layers reduced!");
	}
	
	public void Remove(Creature c) {
		System.out.println("Creature removed from asteroid!");
	}
	
	public void Accept(Creature c) {
		creatures.add(c);
		System.out.println("Creature accepted to asteroid!");
	}
	
	public void CheckEnoughResources() {
		
	}
	
	public boolean CheckNeighbor(Travel t) {
		System.out.println("The asteroid/teleport is a neighbor!"); 
		return true;
	}
	
	public int GetLayers() {
		System.out.println("The layers on this asteroid: " + layers);
		return layers;
	}
	
	public ArrayList<Creature> GetCreatures() {
		System.out.println("Creatures on this asteroid: ");
		for(Creature c : creatures){
			System.out.println(c.GetName());
		}
		return creatures;
	}
	
	public Resource GetResource() {
		System.out.println("The resource on this asteroid: " + resource);
		return resource;
	}
	
	public void SetResource(Resource r) {
		resource = r;
		if(r == null) isEmpty = true;
		System.out.println("Resource set to " + r + "!");
	}
	
	public boolean GetCloseToSun() {
		if(closeToSun) System.out.println("The asteroid is close to the sun!");
		else System.out.println("The asteroid is not close to the sun!");
		return closeToSun;
	}
	
	public void SunStorm() {
		System.out.println("Sunstorm started!");
		if(layers == 0 && isEmpty);
		else {
			for(Creature c : creatures){
				c.Die();
			}
		}
	}
	
	public void Explode() {
		for(Creature c : creatures){
			c.Explode();
		}
	}
	
	public void AddNewNeighbor(Asteroid a) {
		System.out.println("New neighbor added!");
	}
	
	public void RemoveNeighbor(Asteroid a) {
		System.out.println("Neighbor removed!");
	}
	
}
