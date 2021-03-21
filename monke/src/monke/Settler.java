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
		System.out.println("Move was callled");
			boolean tf;
			tf = asteroid.CheckNeighbor(t);
			if(tf) {
				asteroid.Remove1(this);
				t.Accept(this);
				//System.out.println("You are now on a new asteroid!");
			}else {
				System.out.println("You unfortunately cant move to neighboring asteroid!");
			}
		}
	
	
	public void Mine() {
		System.out.println("Mine was called");
		System.out.println("\tAdd resource size");
		Scanner myObj = new Scanner(System.in);
		int ertek = Integer.parseInt(myObj.nextLine());
		if(ertek<10) {
			AddResource(GetAsteroid().GetResource());
			GetAsteroid().SetResource(null);
			asteroid.CheckEnoughResources();
		}
		else if(ertek==10) {
			System.out.println("\tYou can't mine");
			return;
		}
	}
	
	public void AddResource(Resource r) { 
		System.out.println("\tResource added to settler!");
	}
	
	public ArrayList<Resource> GetResources() {
		return resources;
	}
	
	public void PlaceResource(Resource r) {
		System.out.println("PlaceResorce was called!");
		asteroid.GetLayers();
		Scanner myObj = new Scanner(System.in);
		int ertek = Integer.parseInt(myObj.nextLine());
		if(ertek==0) {
			boolean igaz_e = CheckResource(r);
			if(igaz_e == true) {
				asteroid.SetResource1(r);
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
		/*if(GetAsteroid().GetIsEmpty() && GetAsteroid().GetLayers() == 0) {
			System.out.println("\\tStart replace resource to asteroida!");
			boolean igaz_e = CheckResource(r);
			asteroid.GetLayers();
			if(igaz_e == true) {
				asteroid.SetResource(r);
				RemoveResource(r);
			}
			else {
				System.out.println("\t\t\t\tSettler doesn't have resource!");
			}
		//}
		//else System.out.println("The asteroid is not empty!");*/
	}
	
	public boolean CheckResource(Resource r) {
		System.out.println("\tSettler has this resource!");
		return true;
	}
	
	public void RemoveResource(Resource rem) {
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
		System.out.println("\tSettler RemoveResource was called!");
	}
	
	public void GiveUp() {
		System.out.println("Settler gave up!");
		Die();
	}
	
	public void Skip() {
		System.out.println("Settler skipped turn!");
	}
	
	@Override
	public void Die() {
		game = new Game();
		asteroid.Remove(null);
		game.RemoveSettler(null);
		System.out.println("\t\t\t\t\t\tSettler died!");
	}
	
	public void BuildTeleport() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("BuildTeleport was called");
		System.out.println("\tHow many teleports he has?");
		int ertek = Integer.parseInt(myObj.nextLine());
		Resource re = new Resource();
		if(ertek==0) {
			if(billOfResources.CheckResourceTpk()) {
				RemoveResource(re);
				hasTpk = 2;
				Teleport t = new Teleport();
			}
		}
	}
	
	public void BuildRobot() {
		System.out.println("BuildRobot was called");
		Resource re = new Resource();
		if(billOfResources.CheckResourceRobot()) {
			Robot r = new Robot(asteroid);
			RemoveResource(re);
		}
	}
	
	public void PlaceTeleport(Asteroid a) {
		/*if(teleports[0].GetAsteroid() == null && hasTpk == 2) {
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
		}*/
		System.out.println("\tHow many teleports does the settler have? (0-2)");
	} 
}
