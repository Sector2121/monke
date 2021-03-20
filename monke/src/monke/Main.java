package monke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Settler s = new Settler();
		Asteroid a = new Asteroid();
		Scanner myObj = new Scanner(System.in);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
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

			} else if (cmd[0].equals("drill")) {
				s.Drill();
				a.GetLayers();
				int ertek = Integer.parseInt(myObj.nextLine());
				if (ertek==1) {
					a.GetCloseToSun();
					String napközelség = myObj.nextLine();
					if(napközelség=="igen") {

					}
				}
				
				
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
					System.out.println("Robot built!");
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
				
			} else if (cmd[0].equals("give_up")) {
				System.out.println("Are you sure, you want to give up the game? Yes/No");
				String yn = myObj.nextLine();
				Settler s1 = new Settler();
				if(yn.equals("Yes")) {
					s1.GiveUp();
				}
			} else if (cmd[0].equals("sunstorm")) {
				System.out.println("Enter asteroid layer:");
				int l = Integer.parseInt(myObj.nextLine());
				System.out.println("\tEnter asteroid resource (uranium, waterice, carbon, iron, empty):");
				String ra = myObj.nextLine();
				if (l == 0 && ra.equals("empty")) {
					System.out.println("\tCreatures save, asteroid doesn't have layers and is empty!");
				}
				else {
					System.out.println("\tCreatures dies, asteroid has layers and/or is not empty!");
				}
			}
			else {
				System.out.println("'" + cmd[0] +"' is not recognized command");
			}
		}
	}
}
