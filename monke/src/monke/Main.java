package monke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
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
				System.out.println("Enter asteroid layer:");
				int layer = myObj.nextInt();
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
				
			} else if (cmd[0].equals("place teleport")) {
				//viktor
			} else if (cmd[0].equals("replace resource")) {
				
			} else if (cmd[0].equals("skip")) {
				
			} else if (cmd[0].equals("give up")) {
				
			} else if (cmd[0].equals("sunstorm")) {
				
			}
			else {
				System.out.println("'" + cmd[0] +"' is not recognized command");
			}
		}
	}
}