package monke;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Settler extends Creature{
	private int hasTpk;
	private ArrayList<Resource> resources;
	private static BillOfResources billOfResources;
	private ArrayList<Teleport> teleports;
	private static int tpid = 1;
	Ellenorzo el = new Ellenorzo();
	
	/**
	 * A telepes konstruktora.
	 * @param game
	 * @param name
	 * @throws Exception 
	 * @throws IOException 
	 */
	public Settler(Game game, String name) {
		hasTpk = 0;
		this.game = game;
		resources = new ArrayList<Resource>();
		teleports = new ArrayList<Teleport>();
		billOfResources = new BillOfResources();
		this.SetName(name);
		this.asteroid = null;
		game.AddSettler(this);
	}
	/**
	 * Banyaszik egy aszteroidabol.
	 * Ha az aszteroida kerge nagyobb nullanal, visszater.
	 * Ha a nyersanyaglistajaban van meg hely, hozzaadja az aszteroidaban levo nyersanyagot, es az aszteroidat uresre allitja.
	 * Megnezi tudnak-e nyerni a telepesek.
	 * Ha nincs, visszater.
	 * @throws Exception 
	 */
	public void Mine() {
		if(asteroid.GetLayers() > 0 || asteroid.GetResource() == null) {
			System.out.println("You are unable to mine!");
			return;
		}
		
		int length = resources.size();
		if(length < 10) {
			System.out.println("Resource mined!");
			AddResource(asteroid.GetResource());
			asteroid.SetResource(null);
			asteroid.SetIsEmpty(true);
			asteroid.CheckEnoughResources();
		}
		else if(length == 10) {
			System.out.println("You are unable to mine!");
			return;
		}
	}
	/**
	 * Meghivja a reducelayerst az aszteroidara.
	 */
	public void Drill() {
		asteroid.ReduceLayers();
	}
	/**
	 * Hozzaadja a parametert a nyersanyaglistajahoz.
	 * @param r
	 * @throws Exception 
	 */
	public void AddResource(Resource r) {
		resources.add(r);
		System.out.println("Settler resource added succesfully!");
		el.SetOsszString("Settler resource added succesfully!");
	}
	/**
	 * Visszaadja a nyersanyaglistat.
	 */
	public ArrayList<Resource> GetResources() {
		return resources;
	}
	/**
	 * Visszarak egy parameterul kapott nyersanyagot az aszteroidajaba.
	 * Amennyiben ures es teljesen atfurt az aszteroida,
	 * es a telepesnek van az adott nyersanyagbol, beallitja az aszteroida magjat ra, 
	 * illetve a RemoveResource-al elveszi magatol.
	 * @param r
	 */
	public void PlaceResource(Resource r) {
		if(asteroid.GetLayers() == 0 && asteroid.GetIsEmpty()) {
			boolean hasr = CheckResource(r);
			if(hasr == true) {
				asteroid.SetResource(r);
				ArrayList<Resource> re = new ArrayList<>();
				re.add(r);
				RemoveResource(re);
				System.out.println("Successfully replaced resource!");
				if(asteroid.GetCloseToSun())
					r.CloseToSun(asteroid);
					
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
	/**
	 * Megnezi, hogy a parameter benne van-e a nyersanyagai kozott.
	 * @param r
	 * @return True-val ter vissza ha benne van, false-al ha nem.
	 */
	public boolean CheckResource(Resource r) {
		for(Resource r2 : resources) {
			if(r.GetName().equals(r2.GetName())) {
				return true;
			}
		}
		return false;
	}
	/**
	 * A kapott nyersanyagokat kiveszi a telepes nyersanyagai kozul.
	 * @param rem
	 */
	public void RemoveResource(ArrayList<Resource> rem) {
		for(Resource re : rem) {
			for(Resource r : resources) {
				if(r.getClass().equals(re.getClass())) {
					resources.remove(r);
					break;
				}
			}
		}
	}
	/**
	 * Meghivja a Die-t magara, ezzel feladva a jatekot.
	 */
	public void GiveUp() {
		System.out.println("You gave up, your settler has commited suicide! Press F to continue. Thank you for playing our game!");
		Die(); 
	}
	/**
	 * A jatekos a koret tovabb passzolja.
	 */
	public void Skip() {
		System.out.println("Successfully skipped!");
	}
	/**
	 * Leveszi az aszteroidarol es kiveszi a jatekbol a telepest, ezzel megolve azt.
	 */
	@Override
	public void Die() {
		asteroid.Remove(this);
		game.RemoveSettler(this);
		System.out.println("R.I.P. " + GetName());
	}
	/**
	 * Megepit egy teleportkapu part, amiket behelyez a listajaba.
	 * Amennyiben tobb mint ketto teleportja van, visszater.
	 * Megnezi van-e eleg nyersanyaga egy tpk parhoz a nyersanyaglista alapjan.
	 * Ha van, kiveszi az elhasznalt nyersanyagokat, megnoveli a teleportszamlalojat.
	 * Letrehoz ket teleportot, melyeket egymas parjanak allit, majd beleteszi a listajaba oket.
	 */
	public void BuildTeleport() {
		if(hasTpk >= 2) {
			System.out.println("You don’t have enough space!");
		}
		else {
			if(billOfResources.CheckResource(resources, "Teleport")) {
				RemoveResource(billOfResources.GetBillOfTpk());
				/*AddTeleport();*/
				hasTpk += 2;
				Teleport t = new Teleport(game, tpid);
				tpid++;
				Teleport t2 = new Teleport(game, tpid);
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
	}
	/**
    * Megnoveli a teleport szamlalojat.
    * Letrehoz ket teleportot, melyeket egymas parjanak allit, majd beleteszi a listajaba oket.
    */
   public void AddTeleport(){
       hasTpk += 2;
       Teleport t = new Teleport(game, tpid);
       tpid++;
       Teleport t2 = new Teleport(game, tpid);
       tpid++;
       t.SetPair(t2);
       t2.SetPair(t);
       teleports.add(t);
       teleports.add(t2);
       System.out.println("Teleport added!");
       el.SetOsszString("Teleport added!");
   }
	/**
	 * Megepit egy robotot, amit lehelyez az aszteroidajara.
	 * Megnezi van-e eleg nyersanyaga egy robothoz a nyersanyaglista alapjan.
	 * Ha van, letrehoz egy uj robotot, majd meghivja a RemoveResource-ot, amivel a felhasznalt nyersanyagokat kiveszi.
	 * @param name
	 */
	public void BuildRobot(String name) {
		if(billOfResources.CheckResource(resources, "Robot")) {
			Robot r = new Robot(game, asteroid, name);
			RemoveResource(billOfResources.GetBillOfRobot());
			System.out.println("The selected object got built!");
		}else {
			System.out.println("You don’t have enough resources to complete this action!");
		}
	}
	/**
	 * Lerakja a parameter aszteroidara a listaja elso teleportjat.
	 * Amennyiben nincs nala tpk, visszater.
	 * Kulonben a teleports lista elso elemenek beallitja az aszteroidajat a parameterre, kiveszi a listabol es csokkenti a teleportszamlalo erteket.
	 * @param a
	 */
	public void PlaceTeleport(Asteroid a) {
		if(hasTpk == 0) {
			System.out.println("You don’t have any teleports!");
			return;
		}
		Teleport t = teleports.get(0);
		t.SetAsteroid(a);
		game.AddTeleport(t);
		asteroid.AddNewNeighbor(t);
		teleports.remove(0);
		hasTpk--;
		System.out.println("You've succesfully placed the teleport!");
	}
	/**
	 * Kilistazza a nyersanyagok neveit.
	 */
	public void ListAllResourceName() {
		int ir = 0;
		int car = 0;
		int ur = 0;
		int wa = 0;
		for(Resource r : resources) {
			if(r.GetName() == "iron")
				ir++;
			else if(r.GetName() == "carbon")
				car++;
			else if(r.GetName() == "uranium")
				ur++;
			else if(r.GetName() == "waterice")
				wa++;
		}
		System.out.println("[Iron: " + ir + ", Carbon: " + car + ", Uranium: " + ur + ", Waterice: " + wa + "]");
	}
	
	public void SetResources(int sz) {
		for(int i = 0; i < sz; i++) {
			Iron iron = new Iron();
			resources.add(iron);
		}
		System.out.println("Settler resources set!");
		el.SetOsszString("Settler resources set!");
	}
	
	public int GetHasTpk() {
		return hasTpk;
	}
	
	public void Explode() {
		Die();
	}
}
