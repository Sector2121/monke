package monke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
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
				
			} else if (cmd[0].equals("Create_ufos")) {

			} else if (cmd[0].equals("Create_asteroids")) {

			} else if (cmd[0].equals("Start_settlers")) {

			} else if (cmd[0].equals("Start_ufos")) {

			} else if (cmd[0].equals("Move")) {

			} else if (cmd[0].equals("List_neighbors")) {

			} else if (cmd[0].equals("Drill")) {
				
			} else if (cmd[0].equals("Mine")) {
				
			} else if (cmd[0].equals("Build")) {
			
			} else if (cmd[0].equals("Place_teleport")) {

			} else if (cmd[0].equals("Replace_resource")) {

			} else if (cmd[0].equals("Skip")) {

			} else if (cmd[0].equals("Give_up")) {

			} else if (cmd[0].equals("Save_game")) {

			} else if (cmd[0].equals("Load_game")) {

			} else if (cmd[0].equals("Stat")) {

			} else if (cmd[0].equals("Set_weather")) {

			} else if (cmd[0].equals("Set_resource")) {

			} else if (cmd[0].equals("Set_layer")) {

			} else if (cmd[0].equals("Sunstorm")) {

			} else if (cmd[0].equals("Add_resource")) {

			} else if (cmd[0].equals("Set_resource_settler")) {

			} else if (cmd[0].equals("Create_robot")) {

			} else if (cmd[0].equals("Create_teleport")) {

			} else if (cmd[0].equals("Add_teleport")) {

			} else if (cmd[0].equals("Set_neighbor")) {

			} else if (cmd[0].equals("Reset")) {

			} else if (cmd[0].equals("Stat_asteroid")) {

			}
			else {
				System.out.println("'" + cmd[0] +"' is not recognized command");
			}
		}
	}
}
