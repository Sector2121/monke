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
	
	
	public void Move(Travel t) { //Settler két aszteroida közötti mozgását valósítja meg
		System.out.println("Move was called");
			boolean tf;
			tf = asteroid.CheckNeighbor(t); //Lekérdezi, hogy a megkapott aszteroida/teleport szomszédos-e azzal amin áll
			if(tf) { 
				asteroid.Remove1(this); //Mivel az, így eltávolítja az aszteroidáról magát
				t.Accept(this); //Átáll az új aszteroidára
				//System.out.println("You are now on a new asteroid!");
			}else {
				System.out.println("You unfortunately cant move to neighboring asteroid!"); //Nem szomszédosak
			}
		}
	
	
	public void Mine() { //Settler bányászik
		System.out.println("Mine was called");
		System.out.println("\tAdd resource size");
		Scanner myObj = new Scanner(System.in);
		int ertek = Integer.parseInt(myObj.nextLine()); //Bekéri a tesztelőtől, hogy mennyi nyersanyag van a settlernél
		if(ertek<10) { //Még tud bányászni, mert van nála még hely
			AddResource(GetAsteroid().GetResource()); // Hozzáadódik az aszteroidában levő nyersanyag a Settler tárához
			GetAsteroid().SetResource(null); //Az aszteroidában null-ra állítódik a nyersanyag, mivel kivette a settler
			asteroid.CheckEnoughResources(); //Meghívja az aszteroidán levő nyersanyagok ellenőrző függvényét
		}
		else if(ertek==10) { 
			System.out.println("\tYou can't mine"); // Van 10 nyersanyaga, ezért nem bányászhat
			return;
		}
	}
	
	public void AddResource(Resource r) { //Hozzáadja a megkapott nyersanyagot a settlernél levőkhöz
		System.out.println("\tResource added to settler!");
	}
	
	public ArrayList<Resource> GetResources() {
		return resources;
	}
	
	public void PlaceResource(Resource r) { //Lehelyez nyersanyagot
		System.out.println("PlaceResorce was called!");
		asteroid.GetLayers();
		Scanner myObj = new Scanner(System.in);
		int ertek = Integer.parseInt(myObj.nextLine()); //Bekéri a tesztelőtől, hogy mekkora az aszteroida köpenye amire a nyersanyagot tenni akarja
		if(ertek==0) { // Nincs köpenye
			boolean igaz_e = CheckResource(r); //Lekérdezi, hogy van-e a settlernek nyersanyaga
			if(igaz_e == true) {
				asteroid.SetResource1(r); //Beállítja az aszteroida új nyersanyagát
				RemoveResource(r); //Törli a settler listájáról a letett nyersanyagot
			}
			else {
				System.out.println("\tSettler doesn't have resource!"); //Nincs a settlernél nyersanyag, így nincs mit letenni
			}
		}
		else {
			System.out.println("\tCan't replace resource"); //Van köpenye, így nem tudja letenni a nyersanyagot
			return;
		}
		/*if(GetAsteroid().GetIsEmpty() && GetAsteroid().GetLayers() == 0) {
		//}
		//else System.out.println("The asteroid is not empty!");*/
	}
	
	public boolean CheckResource(Resource r) { //Visszaadja van-e a settlernél a megadott nyersanyag
		System.out.println("\tSettler has this resource!");
		return true;
	}
	
	public void RemoveResource(Resource rem) { //Törli a settler listájából a megadott nyersanyagot
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
	
	public void GiveUp() { //A játékos feladja
		System.out.println("Settler gave up!");
		Die(); //Meghal a telepese a játékosnak
	}
	
	public void Skip() { //Játékos elpasszolja a kört
		System.out.println("Settler skipped turn!");
	}
	
	@Override
	public void Die() { //Meghal a settler
		game = new Game();
		asteroid.Remove(null); //Törli az aszteroidáról
		game.RemoveSettler(null); //Törli a játékból
		System.out.println("\t\t\t\t\t\tSettler died!");
	}
	
	public void BuildTeleport() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("BuildTeleport was called");
		System.out.println("\tHow many teleports he has?");
		int ertek = Integer.parseInt(myObj.nextLine()); //Bekéri mennyi teleportja van a settlernek
		Resource re = new Resource();
		if(ertek==0) { //Ha nincsen teleportja
			if(billOfResources.CheckResourceTpk()) { //És ha van-e elég nyersanyaga, akkor építhet újat
				RemoveResource(re); //Törli a settlertől a nyersanyagokat
				hasTpk = 2;
				Teleport t = new Teleport(); //Elkészíti a teleportot
			}
		}
	}
	
	public void BuildRobot() {
		System.out.println("BuildRobot was called");
		Resource re = new Resource();
		if(billOfResources.CheckResourceRobot()) { //Ha van-e elég nyersanyaga, akkor építhet újat
			Robot r = new Robot(asteroid); //Elkészíti a robotot
			RemoveResource(re); //Törli a settlertől a nyersanyagokat
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
		System.out.println("\tHow many teleports does the settler have? (0-2)"); //Megkérdi mennyi teleportja van a settlernek
	} 
}
