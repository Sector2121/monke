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
	private Game game;
	private ArrayList<Resource> resources;
	private static BillOfResources billOfResources;
	private ArrayList<Teleport> teleports;
	private static int tpid= 0;
	/**
	 * A telepes parameter nelkuli konstruktora.
	 */
	public Settler() {
	}
	/**
	 * A telepes konstruktora.
	 * @param game
	 * @param name
	 * @throws Exception 
	 * @throws IOException 
	 */
	public Settler(Game game, String name) throws IOException, Exception {
		hasTpk = 0;
		this.game = game;
		resources = new ArrayList<Resource>();
		teleports = new ArrayList<Teleport>();
		billOfResources = new BillOfResources();
		this.SetName(name);
		this.asteroid = null;
		System.out.println("Settler created!");
		TesztString("Settler created!");
	}
	/**
	 * Banyaszik egy aszteroidabol.
	 * Ha az aszteroida kerge nagyobb nullanal, visszater.
	 * Ha a nyersanyaglistajaban van meg hely, hozzaadja az aszteroidaban levo nyersanyagot, es az aszteroidat uresre allitja.
	 * Megnezi tudnak-e nyerni a telepesek.
	 * Ha nincs, visszater.
	 */
	public void Mine() {
		if(asteroid.GetLayers() > 0) {
			return;
		}
		
		int length = resources.size();
		if(length < 10) {
			AddResource(asteroid.GetResource());
			asteroid.SetResource(null);
			asteroid.SetIsEmpty(true);
			asteroid.CheckEnoughResources();
		}
		else if(length == 10) {
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
	 */
	public void AddResource(Resource r) {
		resources.add(r);
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
		System.out.println(r);
		System.out.println(asteroid.GetLayers());
		System.out.println(asteroid.GetIsEmpty());
		if(asteroid.GetLayers() == 0 && asteroid.GetIsEmpty()) {
			boolean hasr = CheckResource(r);
			if(hasr == true) {
				System.out.println("ittvagyok");
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
	/**
	 * Megnezi, hogy a parameter benne van-e a nyersanyagai kozott.
	 * @param r
	 * @return True-val ter vissza ha benne van, false-al ha nem.
	 */
	public boolean CheckResource(Resource r) {
		System.out.println("mennyi nyersanyagod van?"+resources.size());
		for(Resource r2 : resources) {
			if(r == r2) {
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
		System.out.println(rem.size());
		System.out.println(resources.size());
		System.out.println(rem.get(0) + " " + resources.get(0));
		for(Resource re : rem) {
			System.out.println("ittvagyok");
			for(Resource r : resources) {
				System.out.println("ittvagyok");
				if(r == re) {
					System.out.println("ittvagyok");
					resources.remove(r);
					System.out.println("ittvagyok");
					break;
				}
			}
		}
		System.out.println("befejezed?");
		
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
			return;
		}
			if(billOfResources.CheckResource(resources, "Teleport")) {
				
				RemoveResource(billOfResources.GetBillOfTpk());
				hasTpk += 2;
				Teleport t = new Teleport(tpid);
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
	/**
	 * Megepit egy robotot, amit lehelyez az aszteroidajara.
	 * Megnezi van-e eleg nyersanyaga egy robothoz a nyersanyaglista alapjan.
	 * Ha van, letrehoz egy uj robotot, majd meghivja a RemoveResource-ot, amivel a felhasznalt nyersanyagokat kiveszi.
	 * @param name
	 */
	public void BuildRobot(String name) {
		if(billOfResources.CheckResource(resources, "Robot")) {
			Robot r = new Robot(asteroid, name);
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
		teleports.remove(0);
		hasTpk--;
		System.out.println("You've succesfully placed the teleport!");
	}
	/**
	 * Kilistazza a nyersanyagok neveit.
	 */
	//Ez uj
	public void ListAllResourceName() {
		for(Resource r : resources) {
			r.GetName();
		}
	}
	public void TesztString(String sz) throws IOException, Exception {
		FileInputStream fajlbe = new FileInputStream("konzol");
		ObjectInputStream be = new ObjectInputStream(fajlbe);
		ArrayList<String> parancsok = (ArrayList<String>)be.readObject();
		be.close();
		parancsok.add(sz);
		FileOutputStream fajlki = new FileOutputStream("konzol");
		ObjectOutputStream ki = new ObjectOutputStream(fajlki);
		ki.writeObject(parancsok);
		ki.close();
	}
}
