package monke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Settler s = new Settler();
		Resource r = new Resource();
		Asteroid a = new Asteroid(r);
		s.SetAsteroid(a);
		a.AddCreature(s);
		Resource re = new Resource();
		Scanner myObj = new Scanner(System.in);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
			else if (cmd[0].equals("exit")) {
				break;
			} else if (cmd[0].equals("moveAsteroid")) {
				s.Move(a);
			}else if (cmd[0].equals("moveTpk")) {
				Teleport tele = new Teleport();
				Teleport tele2 = new Teleport();
				tele2.SetAsteroid(a);
				tele.SetPair(tele2);
				s.Move(tele);
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
