package monke;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BillOfResources {
	private ArrayList<Resource> billOfTpk;
	private ArrayList<Resource> billOfRobot;
	private ArrayList<Resource> billOfBase;
	
	Scanner myObj = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public BillOfResources() { 
		
	}
	
	public void AddResource(Resource r) {
		
	}
	
	public void RemoveResource(Resource r) {
		 
	}
	
	public boolean CheckResourceTpk(ArrayList<Resource> r) {
		
		System.out.println("Tpk resource checked");
		return true;
	}
	
	public boolean CheckResourceRobot() {
		System.out.println("\t\tDoes the settler have enough resources for robot? (yes/no)");
		String string = myObj.nextLine();
		if(string.equals("yes")) return true;
		else return false;
		
	}
	
	public boolean CheckResourceBase(ArrayList<Resource> r) {
		
		System.out.println("Base resource checked");
		return true;
	}
}
