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
		
	}
	
	public boolean GetIsEmpty() {
		return isEmpty;
	}
	
	public ArrayList<Travel> GetNeighbors(){
		return neighbors;
	}
	
	public void AddCreature(Creature c){
		
	}	
	
	public void SetWeather(String w) {
		weather = w;
	}
	
	public String GetWeather() {
		return weather;
	}
	
	public void ReduceLayers() {
		layers--;
	}
	
	public void Remove(Creature c) {
		
	}
	
	public void Accept(Creature c) {
		creatures.add(c);
	}
	
	public void CheckEnoughResources() {
		
	}
	
	public boolean CheckNeighbor(Travel t) {
		return false;
		
	}
	
	public int GetLayers() {
		return layers;
		
	}
	
	public ArrayList<Creature> GetCreatures() {
		return creatures;
		
	}
	
	public Resource GetResource() {
		return resource;
	}
	
	public void SetResource(Resource r) {
		resource = r;
	}
	
	public boolean GetCloseToSun() {
		return closeToSun;
	}
	
	public void SunStorm() {
		
	}
	
	public void Explode() {
		
	}
	
	public void AddNewNeighbor(Asteroid a) {
		
	}
	
	public void RemoveNeighbor(Asteroid a) {
		
	}
	
}
