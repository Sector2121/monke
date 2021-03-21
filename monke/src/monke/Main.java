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
		a.AddCreature(s);
		ArrayList<Asteroid> asteroids = new ArrayList<>();
		asteroids.add(a);
		Sun sun = new Sun(asteroids);
		//Teleport tele = new Teleport();
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
			} else if (cmd[0].equals("move")) {
				//System.out.print("Do you want to go through a teleport(T) or do you want to use your spaceship (S) ?");
				//String answer = myObj.nextLine();
				//if(answer.equals("S")) {
					s.Move(a);
				//}else if(answer.equals("T")) {
				//	s.Move(tele);
				//}
				
			} else if (cmd[0].equals("drilluranium")) {
				System.out.println("Megbaszlak te kutya");
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
				System.out.print("Enter asteroid layer: ");
				int layer = Integer.parseInt(myObj.nextLine());
				if(layer != 0) {
					System.out.println("\tYou can't mine here!");
				} else {
					System.out.print("\tEnter asteroid resource: ");
					String resource = myObj.nextLine();
					System.out.print("\t\tEnter settler's inventory count: ");
					int invCount = Integer.parseInt(myObj.nextLine());
					if(invCount >= 10) {
						System.out.println("\t\t\tYou don't have space to carry!");
					} else {
						switch(resource) {
						case "iron": System.out.println("\t\t\tYou succesfully mined iron!"); break;
						case "carbon": System.out.println("\t\t\tYou succesfully mined carbon!"); break;
						case "uranium": System.out.println("\t\t\tYou succesfully mined uranium!"); break;
						case "waterice": System.out.println("\t\t\tYou succesfully mined waterice!"); break;
						default: System.out.println("\t\t\tThere is no such resource!"); break;
						}
					}
					
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
				System.out.print("Enter amount of settler's teleports: ");
				int teleportCount = Integer.parseInt(myObj.nextLine());
				if(teleportCount == 0) {
					System.out.println("\tYou don't have a teleport to place!");
				}
				else if(teleportCount > 0 && teleportCount < 3) {
					System.out.println("\tTeleport successfully placed!"); 
					teleportCount--;
					System.out.println("\tRemaining teleports: " + teleportCount);
				}
				else {
					System.out.println("\tThat's not a valid number of teleports!");
				}
			}
			else if (cmd[0].equals("replace_resource")) {
				System.out.println("Enter asteroid layer:");
				int l = Integer.parseInt(myObj.nextLine());
				if(l != 0) {
					System.out.println("\tOperation failed, asteroid has layers!");
				}
				else { 
					System.out.println("\tEnter asteroid resource (uranium, waterice, carbon, iron, empty):");
					String ra = myObj.nextLine();
					if (ra.equals("empty")) {
						System.out.println("\t\tEnter settler resource (uranium, waterice, carbon, iron, empty):");
						String rs = myObj.nextLine();
						if (rs.equals("empty")) {
							System.out.println("\t\t\tOperation failed, settler doesn't have resource!");
						}
						else {
							switch(rs) {
								case "iron": System.out.println("\t\t\tYou succesfully replaced iron!"); break;
								case "carbon": System.out.println("\t\t\tYou succesfully replaced carbon!"); break;
								case "uranium": System.out.println("\t\t\tYou succesfully replaced uranium!"); break;
								case "waterice": System.out.println("\t\t\tYou succesfully replaced waterice!"); break;
								default: System.out.println("\t\t\tThere is no such resource!"); break;
							}
						}
					}
					else {
						System.out.println("\t\tOperation failed, asteroid has resource!");
					}
				}
			} else if (cmd[0].equals("skip")) {
				s.Skip();
			} else if (cmd[0].equals("give_up")) {
				System.out.println("Are you sure, you want to give up the game? Yes/No");
				String yn = myObj.nextLine();
				if(yn.equals("Yes")) {
					s.GiveUp();
				}
			} else if (cmd[0].equals("sunstorm")) {
				System.out.println("Please set the layers of the asteroid: ");
				int l = Integer.parseInt(myObj.nextLine());
				if (l == 0) {
					System.out.println("\tAll creature survived!");
				}
				else {
					sun.SunStorm();
				}
			}
			else {
				System.out.println("'" + cmd[0] +"' is not recognized command");
			}
		}
	}
}
