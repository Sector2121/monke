package monke;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Settler extends Creature{
	private int hasTpk;
	private Game game;
	private ArrayList<Resource> resources;
	private static BillOfResources billOfResources;
	private ArrayList<Teleport> teleports;
	private static int tpid= 0;
	
	public Settler() {
	}
	
	public Settler(Game game, String name) {
		hasTpk = 0;
		this.game = game;
		resources = new ArrayList<Resource>();
		teleports = new ArrayList<Teleport>();
		billOfResources = new BillOfResources();
		this.SetName(name);
		this.asteroid = null;
		System.out.println("Settler created!");
	}
	
	public void Mine() {
		if(asteroid.GetLayers() > 0) {
			return;
		}
		
		int length = resources.size();
		if(length < 10) { 
			AddResource(asteroid.GetResource());
			asteroid.SetResource(null);
			asteroid.CheckEnoughResources();
		}
		else if(length == 10) {
			return;
		}
	}
	
	public void Drill() {
		asteroid.ReduceLayers();
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
				ArrayList<Resource> re = new ArrayList<>();
				re.add(r);
				RemoveResource(re);
				System.out.println("Successfully replaced resource!");
			}
			else {
				System.out.println("Replace unsuccessful!");
			}
		}
		else {
			System.out.println("Replace unsuccessful!");
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
	
	public void RemoveResource(ArrayList<Resource> rem) {
		for(Resource re : rem) {
			for(Resource r : resources) {
				if(r == re) {
					resources.remove(r);
					continue;
				}
			}
		}
		
	}
	
	public void GiveUp() {
		System.out.println("You gave up, your settler has commited suicide! Press F to continue. Thank you for playing our game!");
		Die(); 
	}
	
	
	
	
	public void Skip() {
		System.out.println("Successfully skipped!");
	}
	
	
	@Override
	public void Die() {//Leveszi az aszteroidarol es kiveszi a jatekbol a telepest, ezzel megolve azt.
		asteroid.Remove(this);
		game.RemoveSettler(this);
	}
	
	public void BuildTeleport() {//Megepit egy teleportkapu part, amiket behelyez a listajaba
		if(hasTpk >= 2) {//Amennyiben tobb mint ketto teleportja van, visszater.
			return;
		}
			if(billOfResources.CheckResource(resources, "Teleport")) {//Van-e eleg nyersanyaga egy tpk parhoz a nyersanyaglista alapjan
				
				RemoveResource(billOfResources.GetBillOfTpk());// Ha van, kiveszi az elhasznalt nyersanyagokat, megnoveli a teleportszamlalojat
				hasTpk += 2;
				Teleport t = new Teleport(tpid);//Letrehoz ket teleportot, melyeket egymas parjanak allit, majd beleteszi a listajaba oket.
				tpid++;
				Teleport t2 = new Teleport(tpid);
				tpid++;
				t.SetPair(t2);
				t2.SetPair(t);
				teleports.add(t);
				teleports.add(t2);
				System.out.println("The selected object got built!");
			}else {
				System.out.println("You don’t have enough resources to complete this action!");
			}
	}
	
	public void BuildRobot() {// Megepit egy robotot, amit lehelyez az aszteroidajara.
		if(billOfResources.CheckResource(resources, "Robot")) {//Van-e eleg nyersanyaga egy robothoz a nyersanyaglista alapjan
			Robot r = new Robot(asteroid);//Ha van, letrehoz egy uj robotot, majd meghivja a RemoveResource-ot, amivel a felhasznalt nyersanyagokat kiveszi.
			RemoveResource(billOfResources.GetBillOfRobot());
			System.out.println("The selected object got built!");
		}else {
			System.out.println("You don’t have enough resources to complete this action!");
		}
	}
	
	public void PlaceTeleport(Asteroid a) {// Lerakja a parameter aszteroidara a listaja elso teleportjat.
		if(hasTpk == 0) {// Amennyiben nincs nala tpk, visszater
			System.out.println("You don’t have any teleports!");
			return;
		}
		Teleport t = teleports.get(0);//Kulonben a teleports lista elso elemenek beallitja az aszteroidajat a parameterre, kiveszi a listabol
		// es csokkenti a teleportszamlalo erteket.
		t.SetAsteroid(a);
		teleports.remove(0);
		hasTpk--;
		System.out.println("You've succesfully placed the teleport!");
	} 
}
