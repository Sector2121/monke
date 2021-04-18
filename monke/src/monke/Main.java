package monke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
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
			} else if (cmd[0].equals("Create_settlers")) {
				for (int i=1;i<cmd.length;i++) {
					try {
						Settler s = new Settler(game, cmd[i]);
					}
					catch (Exception e) {}
				}
			} else if (cmd[0].equals("Create_ufos")) {
				for (int i=1;i<cmd.length;i++) {
					Ufo u = new Ufo(game, cmd[i]);
				}
			} else if (cmd[0].equals("Create_asteroids")) {
				for (int i=1;i<=Integer.parseInt(cmd[1]);i++) {
					Random rand = new Random();
					int random = rand.nextInt(4) + 1;
					Resource r;
					if(random == 1) {
						r = new Iron();
					}
					else if (random == 2) {
						r = new Carbon();
					}
					else if (random == 3) {
						r = new Waterice();
					}
					else {
						r = new Uranium();
					}
					Asteroid a = new Asteroid(game, i, r);
					game.GetAsteroid().add(a);
				}
			} else if (cmd[0].equals("Start_settlers")) {
				for (Settler s : game.GetSettlers()) {
					s.asteroid=game.GetAsteroid().get(Integer.parseInt(cmd[1])-1);
					game.GetAsteroid().get(Integer.parseInt(cmd[1])-1).AddCreature(s);
				}
			} else if (cmd[0].equals("Start_ufos")) {
				for (Ufo u : game.GetUfos()) {
					u.asteroid=game.GetAsteroid().get(Integer.parseInt(cmd[1])-1);
					game.GetAsteroid().get(Integer.parseInt(cmd[1])-1).AddCreature(u);
				}
			} else if (cmd[0].equals("Move")) {
				for (Settler s : game.GetSettlers()) {
					if(s.GetName()==cmd[1]) {
						s.asteroid=game.GetAsteroid().get(Integer.parseInt(cmd[2])-1);
						break;
					}
				}
			} else if (cmd[0].equals("List_neighbors")) {
				int id = Integer.parseInt(cmd[1]);
				ArrayList<Asteroid> list = new ArrayList<Asteroid>();
				ArrayList<Travel> neighbors = new ArrayList<Travel>();
				
				list = game.GetAsteroid();
				neighbors = list.get(id-1).GetNeighbors();
				for(int i= 0; i<neighbors.size();i++) {
					Asteroid a = new Asteroid(game, i, null);
					a = (Asteroid)neighbors.get(i);
					System.out.println(a.GetId());
				}
			} else if (cmd[0].equals("Drill")) {
				for (Settler s : game.GetSettlers()) {
					if(s.GetName().equals(cmd[1])) {
						s.Drill();
						break;
					}
				}
			} else if (cmd[0].equals("Mine")) {
				boolean found = false;
				for (Settler s : game.GetSettlers()) {
					if(s.GetName().equals(cmd[1])) {
						try {
							s.Mine();
						}
						catch (Exception e) {}
						found = true;
						break;
					}
				}
				if(found == false) {
					for (Ufo u : game.GetUfos()) { 
						if(u.GetName().equals(cmd[1])) {
							u.Mine();
							break;
						}
					}
				}
			} else if (cmd[0].equals("Build")) {
				for (Settler s : game.GetSettlers()) {
					if(s.GetName().equals(cmd[1])) {
						if(cmd[2].equals("robot")) {
							System.out.println("buzi");
							s.BuildRobot(cmd[3]);
						}
						else if (cmd[2].equals("teleport")) {
							s.BuildTeleport();
						}
						break;
					}
				}
			} else if (cmd[0].equals("Place_teleport")) {
				for (Settler s : game.GetSettlers()) {
					if(s.GetName().equals(cmd[1])) {
						s.PlaceTeleport(s.GetAsteroid());
						break;
					}
				}
			} else if (cmd[0].equals("Replace_resource")) {
				boolean cont = true;
				Resource r;
				if(cmd[2].equals("uranium")) {
					r = new Uranium();
				}
				else if(cmd[2].equals("waterice")) {
					r = new Waterice();
				}
				else if(cmd[2].equals("iron")) {
					r = new Iron();
				}
				else if(cmd[2].equals("carbon")) {
					r = new Carbon();
				}
				else {
					r = null;
					cont = false;
					System.out.println("The command is invalid");
				}
				if(cont == true) {
					for (Settler s : game.GetSettlers()) {
						if(s.GetName().equals(cmd[1])) {
							for (Resource name : s.GetResources()) {
								if(r.getClass().equals(name.getClass())) {
									System.out.println(name);
									s.PlaceResource(name);
									break;
								}
							}
							break;
						}
					}
				}
			} else if (cmd[0].equals("Skip")) {
				for (Settler s : game.GetSettlers()) {
					if(s.GetName().equals(cmd[1])) {
						s.Skip();
						break;
					}
				}
			} else if (cmd[0].equals("Give_up")) {
				for (Settler s : game.GetSettlers()) {
					if(s.GetName().equals(cmd[1])) {
						s.GiveUp();
						break;
					}
				}
			} else if (cmd[0].equals("Step")) {
				game.Step();
			} else if (cmd[0].equals("Save_game")) {

			} else if (cmd[0].equals("Load_game")) {

			} else if (cmd[0].equals("Stat")) {
				for (Settler s : game.GetSettlers()) {
					if(s.GetName().equals(cmd[1])) {
						System.out.println("-------------------------------------------------------------------------------------");
						System.out.println("Your settlers statistics are the following:");
						System.out.println("Name: "+s.GetName());
						System.out.print("Resources: ");
						s.ListAllResourceName();
						System.out.println("Asteroid ID: "+s.asteroid.GetId());
						System.out.print("Core: ");
						s.asteroid.GetResourceName();
						System.out.println("Weather: "+s.asteroid.GetWeather());
						//System.out.prtinln("Teleport: "+s.asteroid.get) <---- Ezt most hirtelen nem tudom
						System.out.print("Other creatures on your asteroid: ");
						s.asteroid.GetOtherCreaturesName(s);
						System.out.println("-------------------------------------------------------------------------------------");
						break;
					}
				}
			} else if (cmd[0].equals("Set_weather")) {
				for(Asteroid a : game.GetAsteroid()) {
					if(a.GetId() == Integer.parseInt(cmd[1])) {
						a.SetWeather(cmd[2]);
						if(cmd[2].equals("hot")) {
							a.SetCloseToSun(true);
						}
						else {
							a.SetCloseToSun(false);
						}
						break;
					}
				}
			} else if (cmd[0].equals("Set_resource")) {
				boolean cont = true;
				Resource r;
				if(cmd[2].equals("uranium")) {
					r = new Uranium();
				}
				else if(cmd[2].equals("waterice")) {
					r = new Waterice();
				}
				else if(cmd[2].equals("iron")) {
					r = new Iron();
				}
				else if(cmd[2].equals("carbon")) {
					r = new Carbon();
				}
				else {
					r = null;
					cont = false;
					System.out.println("The command is invalid");
				}
				if(cont == true) {
					for(Asteroid a : game.GetAsteroid()) {
						if(a.GetId() == Integer.parseInt(cmd[1])) {
							a.SetResource(r);
							break;
						}
					}
				}
			} else if (cmd[0].equals("Set_layer")) {
				for(Asteroid a : game.GetAsteroid()) {
					if(a.GetId() == Integer.parseInt(cmd[1])) {
						a.SetLayers(Integer.parseInt(cmd[2]));
						break;
					}
				}
			} else if (cmd[0].equals("Sunstorm")) {

			} else if (cmd[0].equals("Add_resource")) {
				boolean cont = true;
				Resource r;
				if(cmd[2].equals("uranium")) {
					r = new Uranium();
				}
				else if(cmd[2].equals("waterice")) {
					r = new Waterice();
				}
				else if(cmd[2].equals("iron")) {
					r = new Iron();
				}
				else if(cmd[2].equals("carbon")) {
					r = new Carbon();
				}
				else {
					r = null;
					cont = false;
					System.out.println("The command is invalid");
				}
				if(cont == true) {
					for (Settler s : game.GetSettlers()) {
						if(s.GetName().equals(cmd[1])) {
							try {
								s.AddResource(r);
							}
							catch (Exception e) {}
							break;
						}
					}
				}
			} else if (cmd[0].equals("Set_resource_settler")) {
				String nev = cmd[1];
				int n = Integer.parseInt(cmd[2]);
				for(Settler s : game.GetSettlers()) {
					if(s.GetName().equals(cmd[1]) ) {
						s.SetResources(n);
						break;
					}
				}
			} else if (cmd[0].equals("Create_robot")) {
				String nev = cmd[2];
				int id = Integer.parseInt(cmd[1]);
				Robot robi = new Robot(game, game.GetAsteroid().get(id-1), nev);
			} else if (cmd[0].equals("Create_teleport")) {
				Teleport t1 = new Teleport(game, 1);
				Teleport t2 = new Teleport(game, 2);
				t1.SetPair(t2);
				t2.SetPair(t1);
				for(Asteroid a : game.GetAsteroid()) {
					if(a.GetId() == Integer.parseInt(cmd[1])) {
						t1.SetAsteroid(a);
					}
					if(a.GetId() == Integer.parseInt(cmd[2])) {
						t2.SetAsteroid(a);
					}
				}
				System.out.println("Teleport successfully created!");
			} else if (cmd[0].equals("Add_teleport")) {
				for (Settler s : game.GetSettlers()) {
					if(s.GetName().equals(cmd[1])) {
						if(s.GetHasTpk() >= 2) {
							break;
						}
						else {
							s.AddTeleport();
							break;
						}
					}
				}
				System.out.println("Teleport added!");
			} else if (cmd[0].equals("Set_neighbor")) {
				int id1 = Integer.parseInt(cmd[1]);
				int id2 = Integer.parseInt(cmd[2]);
				ArrayList<Asteroid> list = new ArrayList<Asteroid>();
				list = game.GetAsteroid();
				list.get(id1-1).AddNewNeighbor(list.get(id2-1));
				list.get(id2-1).AddNewNeighbor(list.get(id1-1));
			} else if (cmd[0].equals("Reset")) {
				game.Reset();
			} else if (cmd[0].equals("Stat_asteroid")) {
				for(Asteroid a : game.GetAsteroid()) {
					if(a.GetId() == Integer.parseInt(cmd[1])) {
						System.out.println("-------------------------------------------------------------------------------------");
						System.out.println("Asteroid "+a.GetId()+" stat:");
						System.out.println("Layers: "+a.GetLayers());
						System.out.print("Resource: ");
						a.GetResourceName();
						System.out.println("Weather: "+a.GetWeather());
						System.out.print("Creatures: ");
						a.GetCreaturesName();
						System.out.println("-------------------------------------------------------------------------------------");
					}
				}
			}
			else {
				System.out.println("'" + cmd[0] +"' is not recognized command");
			}
		}
	}
}
