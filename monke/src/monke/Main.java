package monke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Settler s = new Settler(); //A tesztesetek miatt létrehozott settler
		Resource r = new Resource(); //A tesztesetek miatt létrehozott resource
		Asteroid a = new Asteroid(r); //A tesztesetek miatt létrehozott asteroida
		s.SetAsteroid(a); //Az 's' settlernek beállítja, hogy 'a' aszteroidán áll
		a.AddCreature(s); //Az 'a' aszteroidának beállítja, hogy 's' settler rajta áll
		Resource re = new Resource(); //A tesztesetek miatt létrehozott resource
		Scanner myObj = new Scanner(System.in); //A tesztesetek miatt létrehozott szkenner
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //A tesztesetek miatt létrehozott buffered reader
		while (true) {
			System.out.print("Enter command: ");
			String[] cmd = null;
			try {
				cmd = br.readLine().split(" ");
			} catch (IOException e) {
				System.out.println(e);
			}
			if (cmd.length == 0 || cmd[0].equals("")) { //Ha semmit nem ír be csak enter-el, vagy ha csak space-t ír és enter-el nem történik semmi
			}	
			else if (cmd[0].equals("exit")) { //Ezzel a paranccsal lehet kilépni a programból
				break;
			} else if (cmd[0].equals("moveAsteroid")) { //Ezzel a paranccsal nézzük meg mi történik amikor lép a settler
				s.Move(a);
			}else if (cmd[0].equals("moveTpk")) { //Ezzel a paranccsal nézzük meg mi történik amikor lép a settler teleportkapu segítségével
				Teleport tele = new Teleport();
				Teleport tele2 = new Teleport(); //A tesztesetek miatt létrehozott változók
				tele2.SetAsteroid(a); //Beállítjuk, az aszteroidát a teleportkapunak
				tele.SetPair(tele2); //Párosítjuk a kapukat
				s.Move(tele);
			} else if (cmd[0].equals("drilluranium")) { //Ezzel a paranccsal nézzük meg mi történik uránium fúrásakor
				Uranium u = new Uranium();
				Asteroid a1 = new Asteroid(u); //A tesztesetek miatt létrehozott tesztalanyok
				s.SetAsteroid(a1);
				a1.AddCreature(s); //Beállítjuk a szükséges kapcsolatokat
				s.Drill();
			} else if (cmd[0].equals("drillwaterice")) { //Ezzel a paranccsal nézzük meg mi történik vízjég fúrásakor
				Waterice w = new Waterice();
				Asteroid a2 = new Asteroid(w); //A tesztesetek miatt létrehozott változók
				a2.AddCreature(s); 
				s.SetAsteroid(a2); //Beállítjuk a szükséges kapcsolatokat
				s.Drill();
			} else if (cmd[0].equals("drillother")) { //Ezzel a paranccsal nézzük meg mi történik a többi nyersanyag fúrásakor
				Carbon c = new Carbon();
				Asteroid a3 = new Asteroid(c); //A tesztesetek miatt létrehozott változók
				a3.AddCreature(s);
				s.SetAsteroid(a3); //Beállítjuk a szükséges kapcsolatokat
				s.Drill();
			} else if (cmd[0].equals("mine")) { //Ezzel a paranccsal nézzük meg mi történik bányászáskor
				Resource r2 = new Resource();
				Asteroid a4 = new Asteroid(r2);
				Settler s2 = new Settler(); //A tesztesetek miatt létrehozott változók
				s2.SetAsteroid(a4);
				a4.AddCreature(s); //Beállítjuk a szükséges kapcsolatokat
				a4.GetLayers(); //Lekéri az aszteroida köpenyét
				int layer = Integer.parseInt(myObj.nextLine()); //Beolvassuk a bekért adatot a konzolról
				if(layer != 0) {
					System.out.println("\t\t\tAsteroid can't be mined!"); // Ha van köpenye, akkor nem tud bányászni
				} else {
					s2.Mine();
				}
			} else if (cmd[0].equals("build")) { //Ezzel a paranccsal nézzük meg mi történik robot vagy teleportkapu építéskor
				System.out.println("Enter object to build (robot, teleport): ");
				String string = myObj.nextLine(); //Beolvassuk a bekért adatot, hogy robotot vagy teleportkaput akar építeni a tesztelő, a konzolról
				if(string.equals("robot")) { //A bekért adat alapján dől el melyik függvény hívódik meg
					s.BuildRobot();
				}
				if(string.equals("teleport")) {
					s.BuildTeleport();
				}
			} else if (cmd[0].equals("place_teleport")) { //Ezzel a paranccsal nézzük meg mi történik amikor teleportkaput akarunk lehelyezni
				Settler s3 = new Settler();
				Asteroid a5 = new Asteroid(r); //A tesztesetek miatt létrehozott változók
				s3.SetAsteroid(a5);
				a5.AddCreature(s3); //Beállítjuk a szükséges kapcsolatokat
				s.PlaceTeleport(a5);
				int teleportCount = Integer.parseInt(myObj.nextLine()); //Bekéri mennyi teleportkapu van a settlernél a tesztelőtől
				if(teleportCount == 0) {
					System.out.println("\t\tYou don't have a teleport to place!"); //Nem tud mit lerakni
				}
				else if(teleportCount > 0 && teleportCount < 3) { //Ha van nála 1 vagy 2 akkor lehelyezi az aszteroidára a kaput
					Teleport t = new Teleport();
					if(teleportCount == 2) { //2 teleportkapu esetén párosítja őket
						Teleport t2 = new Teleport();
						t.SetPair(t2);
						t2.SetPair(t);
					}
					t.SetAsteroid(a5);
					System.out.println("\t\t\tTeleport successfully placed!"); 
					teleportCount--;
					System.out.println("\t\t\tRemaining teleports: " + teleportCount); // Maradék kapu
				}
				else {
					System.out.println("\t\tThat's not a valid number of teleports!"); // Helytelen érték esetén
				}
			}
			else if (cmd[0].equals("replace_resource")) { //Ezzel a paranccsal nézzük meg mi történik amikor nyersanyagot szeretnénk visszahelyezni az aszteroidába
				s.PlaceResource(r);
			} else if (cmd[0].equals("skip")) {  //Ezzel a paranccsal nézzük meg mi történik amikor passzol egy játékos
				s.Skip();
			} else if (cmd[0].equals("give_up")) {  //Ezzel a paranccsal nézzük meg mi történik amikor feladja egy játékos
				System.out.println("Are you sure, you want to give up the game? Yes/No");
				String yn = myObj.nextLine(); //Azt olvassa be, hogy a játékos biztos-e abban, hogy feladja
				if(yn.equals("Yes")) {
					s.GiveUp();
				}
			} else if (cmd[0].equals("sunstorm")) { //Ezzel a paranccsal nézzük meg mi történik amikor napvihar van
				ArrayList<Asteroid> asteroids = new ArrayList<>();
				asteroids.add(a);
				Sun sun = new Sun(asteroids); //A tesztesetek miatt létrehozott változók és kapcsolatok beállítása
				sun.SunStorm();
			}
			else {
				System.out.println("'" + cmd[0] +"' is not recognized command"); //Nem létező parancs esetén íródik ki
			}
		}
	}
}
