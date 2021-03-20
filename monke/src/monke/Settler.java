package monke;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Settler extends Creature{
	private int hasTpk;
	private Game game;
	private ArrayList<Resource> resources;
	private static BillOfResources billOfResources = new BillOfResources();
	private Teleport[] teleports;
	
	
	public Settler() {
		//System.out.println("Settler created!");
	}
	
	/*public Settler(Game game, BillOfResources bill, String name, Asteroid asteroid) {
		hasTpk = 0;
		this.game = game;
		resources = new ArrayList<Resource>();
		teleports = null;
		billOfResources = bill;
		this.SetName(name);
		this.asteroid = asteroid;
		System.out.println("Settler created!");
	}*/
	
	
	public void Move(Travel t) {
			boolean tf;
			tf = asteroid.CheckNeighbor(t);
			if(tf) {
				asteroid.Remove(this);
				t.Accept(this);
				//System.out.println("You are now on a new asteroid!");
			}else {
				System.out.println("You unfortunately cant move to neighboring asteroid!");
			}
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
		/*if(GetAsteroid().GetIsEmpty() && GetAsteroid().GetLayers() == 0) {
			GetAsteroid().SetResource(r);
			RemoveResource();
			System.out.println("Resource placed!");
		}
		else System.out.println("The asteroid is not empty!");*/
		System.out.println("\tStart replace resource to asteroida!");
		boolean igaz_e = CheckResource(r);
		asteroid.GetLayers();
		if(igaz_e == true) {
			asteroid.SetResource(r);
			RemoveResource(r);
		}
		else {
			System.out.println("\t\t\t\tSettler doesn't have resource!");
		}
		
	}
	
	public boolean CheckResource(Resource r) {
		System.out.println("\t\tSettler has this resource!");
		return true;
	}
	
	public void RemoveResource(Resource r) {
		/*
		for(Resource r : resources) {
			if(r == rem) {
				resources.remove(r);
				System.out.println("Resource removed!");
				return;
			}
		}
		System.out.println("Settler did not have this resource!");
		*/
		System.out.println("\t\t\t\t\tRemoveResource was called!");
	}
	
	public void GiveUp() {
		System.out.println("Settler gave up!");
	}
	
	public void Skip() {
		System.out.println("Settler skipped turn!");
	}
	
	@Override
	public void Die() {
		game = new Game();
		asteroid.Remove(null);
		game.RemoveSettler(null);
		System.out.println("\t\t\t\t\t\t\tSettler died!");
	}
	
	public void BuildTeleport() {//BELENYÚLTAM!!!!!!!!!!!!!!
		System.out.println("\tBuildTeleport was called");
		Resource re = new Resource();
		if(hasTpk == 0) {
			if(billOfResources.CheckResourceTpk()) {
				RemoveResource(re);
				hasTpk = 2;
				Teleport t = new Teleport();
			}
		}
		/*
		if(billOfResources.CheckResourceTpk(resources) && hasTpk == 0) {
			teleports[0] = new Teleport(1);
			teleports[1] = new Teleport(1, teleports[0]);
			teleports[0].SetPair(teleports[1]);
			System.out.println("Teleport built!");
			//remove resources + id meghatÃ¡rozÃ¡s
		}
		else if(hasTpk > 0){
			System.out.println("Settler has teleports already!");
		}
		else {
			System.out.println("Settler does't have the resources to build teleport!");
		}
		*/
	}
	
	public void BuildRobot() {//BELENYÚLTAM!!!!!!!!!!!!!!
		System.out.println("\tBuildRobot was called");
		Resource re = new Resource();
		if(billOfResources.CheckResourceRobot()) {
			Robot r = new Robot(asteroid);
			RemoveResource(re);
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
