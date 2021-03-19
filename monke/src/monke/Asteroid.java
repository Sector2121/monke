package monke;

public class Asteroid {
	private int layers;
	private boolean closeToSun;
	private String weather;
	private boolean isEmpty;
	private Creature[] creatures;
	private Resource[] resources;
	private Travel[] neighbors;
	
	
	public Asteroid() {
		
	}
	
	public Travel[] GetNeighbors(){
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
		
	}
	
	public void Remove(Creature c) {
		
	}
	
	public void Accept(Creature c) {
		
	}
	
	public void CheckEnoughResources() {
		
	}
	
	public boolean CheckNeighbor(Travel t) {
		return false;
		
	}
	
	public int GetLayers() {
		return layers;
		
	}
	
	public Creature[] GetCreatures() {
		return creatures;
		
	}
	
	public Resource GetResource() {
		return null;
		
	}
	
	public void SetResource(Resource r) {
		
	}
	
	public boolean GetCloseToSun() {
		return false;
		
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
