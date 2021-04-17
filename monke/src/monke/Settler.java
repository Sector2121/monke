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
	private ArrayList<Teleport> teleports;
	private static int tpid= 0;
	
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
	
	public void Mine() {
		
		if(asteroid.GetLayers()>0) {return;}
		
		int length = resources.size();
		if(length<10) { 
			AddResource(GetAsteroid().GetResource());
			GetAsteroid().SetResource(null);
			asteroid.CheckEnoughResources();
		}
		else if(length==10) { 
			System.out.println("\tYou can't mine");
			return;
		}
	}
	public void Drill() {
		
		int layers = asteroid.GetLayers();
		boolean closetosun = asteroid.GetCloseToSun();
		if (layers<1) {
			return;
		}
		
		if(layers>0) {
			asteroid.ReduceLayers();
		}		
	}
	public void AddResource(Resource r) { 
		resources.add(r);
	}
	
	public ArrayList<Resource> GetResources() {
		return resources;
	}
	
	public void PlaceResource(Resource r) {
		
		if(asteroid.GetLayers() == 0 && asteroid.GetIsEmpty()) {
			boolean hasr = CheckResource(r);
			if(hasr == true) {
				asteroid.SetResource(r);
				RemoveResource(r);
			}
			else {
				System.out.println("\tSettler doesn't have resource!");
			}
		}
		else {
			System.out.println("\tCan't replace resource");
			return;
		}
		
	}
	
	public boolean CheckResource(Resource r) {
		for(Resource r2 : resources) {
			if(r == r2) {
				return true;
			}
		}
		return false;
	}
	
	public void RemoveResource(Resource rem) {
		
		for(Resource r : resources) {
			if(r == rem) {
				resources.remove(r);
				System.out.println("Resource removed!");
				return;
			}
		}
		
	}
	
	public void GiveUp() {
		System.out.println("Settler gave up!");
		Die(); 
	}
	
	
	
	
	public void Skip() {
		
	}
	
	
	
	
	
	@Override
	public void Die() {
		game = new Game();
		asteroid.Remove(this);
		game.RemoveSettler(this);
		System.out.println("Settler died!");
	}
	
	public void BuildTeleport() {
		if(teleports.size() > 2) {
			return;
		}
		
		//Resource re = new Resource();
			if(billOfResources.CheckResource(resources, "Teleport")) {
				RemoveResource(re);
				hasTpk = 2;
				Teleport t = new Teleport(tpid);
				tpid++;
				Teleport t2 = new Teleport(tpid);
				tpid++;
				t.SetPair(t2);
				t.SetPair(t);
				teleports.add(t);
				teleports.add(t2);
			}
	}
	
	public void BuildRobot() {
		//Resource re = new Resource();
		if(billOfResources.CheckResourceRobot(resources)) {
			Robot r = new Robot(asteroid);
			RemoveResource(re);
		}
	}
	
	public void PlaceTeleport(Asteroid a) {
		if(teleports.size() == 0) {
			return;
		}
		Teleport t = teleports.get(0);
		t.SetAsteroid(a);
		teleports.remove(0);
		
		System.out.println("\tHow many teleports does the settler have? (0-2)"); //Megkérdi mennyi teleportja van a settlernek
	} 
}
