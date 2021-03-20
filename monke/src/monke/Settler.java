package monke;

import java.util.ArrayList;

public class Settler extends Creature{
	private int hasTpk;
	private Game game;
	private ArrayList<Resource> resources;
	private static BillOfResources billOfResources;
	private Teleport[] teleports;
	
	public Settler() {}
	
	public Settler(Game game, BillOfResources bill, String name, Asteroid asteroid) {
		hasTpk = 0;
		this.game = game;
		resources = new ArrayList<Resource>();
		teleports = null;
		billOfResources = bill;
		this.SetName(name);
		this.asteroid = asteroid;
		System.out.println("Settler created!");
	}
	
	public void Mine() {
		if(GetAsteroid().GetResource() != null && GetAsteroid().GetLayers() == 0) {
			if(resources.size() < 10) {
				AddResource(GetAsteroid().GetResource());
				GetAsteroid().SetResource(null);
				System.out.println("Asteroid mined!");
			}
		}
		else System.out.println("Asteroid can't be mined!");
	}
	
	public void AddResource(Resource r) {
		resources.add(r);
		System.out.println("Resource added!");
	}
	
	public ArrayList<Resource> GetResources() {
		return resources;
	}
	
	public void PlaceResource(Resource r) {
		if(GetAsteroid().GetIsEmpty() && GetAsteroid().GetLayers() == 0) {
			GetAsteroid().SetResource(r);
			RemoveResource(r);
			System.out.println("Resource placed!");
		}
		else System.out.println("The asteroid is not empty!");
	}
	
	public boolean CheckResource(Resource r) {
		System.out.println("Settler has this resource!");
		return true;
	}
	
	public void RemoveResource(Resource rem) {
		for(Resource r : resources) {
			if(r == rem) {
				resources.remove(r);
				System.out.println("Resource removed!");
				return;
			}
		}
		System.out.println("Settler did not have this resource!");
	}
	
	public void GiveUp() {
		System.out.println("Settler gave up!");
		this.Die();
	}
	
	public void Skip() {
		System.out.println("Settler skipped turn!");
	}
	
	@Override
	public void Die() {
		System.out.println("Settler died!");
		game.RemoveSettler(this);
	}
	
	public void BuildTeleport() {
		if(billOfResources.CheckResourceTpk(resources) && hasTpk == 0) {
			teleports[0] = new Teleport(1);
			teleports[1] = new Teleport(1, teleports[0]);
			teleports[0].SetPair(teleports[1]);
			System.out.println("Teleport built!");
			//remove resources + id meghatározás
		}
		else if(hasTpk > 0){
			System.out.println("Settler has teleports already!");
		}
		else {
			System.out.println("Settler does't have the resources to build teleport!");
		}
	}
	
	public void BuildRobot(String name) {
		if(billOfResources.CheckResourceRobot(resources)) {
			Robot r = new Robot(name, this.GetAsteroid());
			System.out.println("Robot built!");
		}
		else {
			System.out.println("Settler doesn't have the resources to build robot!");
		}
	}
	
	public void PlaceTeleport(Asteroid a) {
		if(teleports[0].GetAsteroid() == null && hasTpk == 2) {
			teleports[0].SetAsteroid(a);
			hasTpk--;
			System.out.println("Teleport placed!");
		}
		else if(teleports[1].GetAsteroid() == null && hasTpk == 1) {
			teleports[0].SetAsteroid(a);
			hasTpk--;
			teleports = null;
			System.out.println("Teleport placed!");
		}
		else {
			System.out.println("Settler doesn't have teleports!");
		}
	} 
}
