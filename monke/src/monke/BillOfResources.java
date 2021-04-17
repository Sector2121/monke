package monke;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillOfResources {
	private ArrayList<Resource> billOfTpk;
	private ArrayList<Resource> billOfRobot;
	private ArrayList<Resource> billOfBase;
	
	public BillOfResources() {
		Iron i = new Iron();
		Carbon c = new Carbon();
		Waterice w = new Waterice();
		Uranium u = new Uranium();
		this.billOfTpk.add(i);
		this.billOfTpk.add(i);
		this.billOfTpk.add(w);
		this.billOfTpk.add(u);
		this.billOfRobot.add(i);
		this.billOfRobot.add(c);
		this.billOfRobot.add(u);
		for (int j=0; j<3; j++) {
			this.billOfBase.add(i);
			this.billOfBase.add(c);
			this.billOfBase.add(w);
			this.billOfBase.add(u);
		}
	}
	
	public ArrayList<Resource> GetBillOfTpk() {
		return this.billOfTpk;
	}
	
	public ArrayList<Resource> GetBillOfRobot() {
		return this.billOfRobot;
	}
	
	public ArrayList<Resource> GetBillOfBase() {
		return this.billOfBase;
	}
	
	public boolean CheckResource(ArrayList<Resource> resources, String valami) {
		List<Resource> check = new ArrayList<Resource>();
		if(valami == "Robot") {
			check = this.billOfRobot;
		}
		else if(valami == "Teleport") {
			check = this.billOfTpk;
		}
		else if(valami == "Base") {
			check = this.billOfBase;
		}
		List<Resource> temporary = new ArrayList<Resource>();
		boolean talalt = false;
		for (Resource robot : check) {
			System.out.println("ezeket keressuk " + robot);
			talalt=false;
			for (Resource name : resources) {
				System.out.println("ezekkkel " + name);
				talalt=false;
				if(robot.getClass().equals(name.getClass())==true) {
					System.out.println("Ugyanaz az osztalyuk " + robot + " " + name);
					for (Resource temp : temporary) {
						System.out.println("Volt-e mar?");
						if(temp.equals(name)==true) {
							System.out.println("Igen " + temp + " " + name);
							talalt = true;
							break;
						}
					}
					if (talalt==false) {
						System.out.println("Nem");
						temporary.add(name);
						break;
					}
				}
			}
		}
		System.out.println(temporary);
		if(check.size()==temporary.size()) {
			return true;
		}
		else {
			return false;
		}
	}
}
