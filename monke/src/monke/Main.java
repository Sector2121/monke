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
		ArrayList<Ufo> ufos = new ArrayList<Ufo>();
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
					Settler s = new Settler(game, cmd[i]);
					game.GetSettlers().add(s);
				}
			} else if (cmd[0].equals("Create_ufos")) {
				for (int i=1;i<cmd.length;i++) {
					Ufo u = new Ufo(cmd[i]);
					ufos.add(u);
				}
			} else if (cmd[0].equals("Create_asteroids")) {
				for (int i=0;i<Integer.parseInt(cmd[1]);i++) {
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
					s.asteroid=game.GetAsteroid().get(Integer.parseInt(cmd[1]));
				}
			} else if (cmd[0].equals("Start_ufos")) {
				for (Ufo u : ufos) {
					u.asteroid=game.GetAsteroid().get(Integer.parseInt(cmd[1]));
				}
			} else if (cmd[0].equals("Move")) {
				for (Settler s : game.GetSettlers()) {
					if(s.GetName()==cmd[1]) {
						s.asteroid=game.GetAsteroid().get(Integer.parseInt(cmd[2]));
						break;
					}
				}
			} else if (cmd[0].equals("List_neighbors")) {

			} else if (cmd[0].equals("Drill")) {
				for (Settler s : game.GetSettlers()) {
					if(s.GetName()==cmd[1]) {
						s.Drill();
						break;
					}
				}
			} else if (cmd[0].equals("Mine")) {
				boolean found = false;
				for (Settler s : game.GetSettlers()) {
					if(s.GetName()==cmd[1]) {
						s.Mine();
						found = true;
						break;
					}
				}
				if(found == false) {
					for (Ufo u : ufos) {
						if(u.GetName()==cmd[1]) {
							u.Mine();
							break;
						}
					}
				}
			} else if (cmd[0].equals("Build")) {
				for (Settler s : game.GetSettlers()) {
					if(s.GetName()==cmd[1]) {
						if(cmd[1]=="robot") {
							
						}
						else if (cmd[1]=="teleport") {
							
						}
						break;
					}
				}
			} else if (cmd[0].equals("Place_teleport")) {

			} else if (cmd[0].equals("Replace_resource")) {

			} else if (cmd[0].equals("Skip")) {
				for (Settler s : game.GetSettlers()) {
					if(s.GetName()==cmd[1]) {
						s.Skip();
						break;
					}
				}
			} else if (cmd[0].equals("Give_up")) {
				for (Settler s : game.GetSettlers()) {
					if(s.GetName()==cmd[1]) {
						s.GiveUp();
						break;
					}
				}
			} else if (cmd[0].equals("Step")) {

			} else if (cmd[0].equals("Save_game")) {

			} else if (cmd[0].equals("Load_game")) {

			} else if (cmd[0].equals("Stat")) {

			} else if (cmd[0].equals("Set_weather")) {
				for(Asteroid a : game.GetAsteroid()) {
					if(a.GetId() == Integer.parseInt(cmd[1])) {
						a.SetWeather(cmd[2]);
					}
				}
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
