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
			if (cmd.length == 0 || cmd[0].equals("")) {
			}	
			else if (cmd[0].equals("exit")) { //Ezzel a paranccsal lehet kilépni a programból
				break;
			} else if (cmd[0].equals("moveAsteroid")) { //Ezzel a paranccsal tud mozogni a settler egy átadott aszteroidára
				s.Move(a); //Meghívjuk a settler Move függvényét
			}else if (cmd[0].equals("moveTpk")) { //Ezzel a paranccsal tud mozogni a settler egy átadott aszteroidára teleportkapu segítségével
				Teleport tele = new Teleport();
				Teleport tele2 = new Teleport(); //A tesztesetek miatt létrehozott teleportkapuk
				tele2.SetAsteroid(a); //Beállítjuk, az aszteroidát a teleportkapunak
				tele.SetPair(tele2); //Párosítjuk a kapukat
				s.Move(tele); //Meghívjuk a settler Move függvényét
			} else if (cmd[0].equals("drilluranium")) {
				Uranium u = new Uranium();
				Asteroid a1 = new Asteroid(u);
				s.SetAsteroid(a1);
				a1.AddCreature(s);
				s.Drill();
			} else if (cmd[0].equals("drillwaterice")) {
				Waterice w = new Waterice();
				Asteroid a2 = new Asteroid(w);
				a2.AddCreature(s);
				s.SetAsteroid(a2);
				s.Drill();
			} else if (cmd[0].equals("drillother")) {
				Carbon c = new Carbon();
				Asteroid a3 = new Asteroid(c);
				a3.AddCreature(s);
				s.SetAsteroid(a3);
				s.Drill();
			} else if (cmd[0].equals("mine")) {
				Resource r2 = new Resource();
				Asteroid a4 = new Asteroid(r2);
				Settler s2 = new Settler();
				s2.SetAsteroid(a4);
				a4.AddCreature(s);
				a4.GetLayers();
				int layer = Integer.parseInt(myObj.nextLine());
				if(layer != 0) {
					System.out.println("\t\t\tAsteroid can't be mined!");
				} else {
					s2.Mine();
				}
			} else if (cmd[0].equals("build")) {
				System.out.println("Enter object to build (robot, teleport): ");
				String string = myObj.nextLine();
				if(string.equals("robot")) {
					s.BuildRobot();
				}
				if(string.equals("teleport")) {
					s.BuildTeleport();
				}
			} else if (cmd[0].equals("place_teleport")) {
				Settler s3 = new Settler();
				Asteroid a5 = new Asteroid(r);
				s3.SetAsteroid(a5);
				a5.AddCreature(s3);
				s.PlaceTeleport(a5);
				int teleportCount = Integer.parseInt(myObj.nextLine());
				if(teleportCount == 0) {
					System.out.println("\t\tYou don't have a teleport to place!");
				}
				else if(teleportCount > 0 && teleportCount < 3) {
					Teleport t = new Teleport();
					if(teleportCount == 2) {
						Teleport t2 = new Teleport();
						t.SetPair(t2);
						t2.SetPair(t);
					}
					t.SetAsteroid(a5);
					System.out.println("\t\t\tTeleport successfully placed!"); 
					teleportCount--;
					System.out.println("\t\t\tRemaining teleports: " + teleportCount);
				}
				else {
					System.out.println("\t\tThat's not a valid number of teleports!");
				}
			}
			else if (cmd[0].equals("replace_resource")) {
				s.PlaceResource(r);
			} else if (cmd[0].equals("skip")) {
				s.Skip();
			} else if (cmd[0].equals("give_up")) {
				System.out.println("Are you sure, you want to give up the game? Yes/No");
				String yn = myObj.nextLine();
				if(yn.equals("Yes")) {
					s.GiveUp();
				}
			} else if (cmd[0].equals("sunstorm")) {
				ArrayList<Asteroid> asteroids = new ArrayList<>();
				asteroids.add(a);
				Sun sun = new Sun(asteroids);
				sun.SunStorm();
			}
			else {
				System.out.println("'" + cmd[0] +"' is not recognized command");
			}
		}
	}
}
