package monke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Szisza");
	    
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
			} else if (cmd[0].equals("mine")) {
				System.out.println("szex");

			} else if (cmd[0].equals("drill")) {
				System.out.println("Enter asteroid layer:");
				int layer=myObj.nextInt();
			} 
			else {
				System.out.println("'" + cmd[0] +"' is not recognized command");
			}
		}
	}
}