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
	
	public void AddResource(Resource r) {
		
	}
	
	public void RemoveResource(Resource r) {
		 
	}
	
	/*public boolean CheckResourceTpk() {

	}*/
	
	public boolean CheckResourceRobot(ArrayList<Resource> resources) {
		int num=0;
		List<Resource> temporary = new ArrayList<Resource>();
		boolean talalt = false;
		for (Resource robot : this.billOfRobot) {
			System.out.println("ezeket keress�k " + robot);
			talalt=false;
			for (Resource name : resources) {
				System.out.println("ezekkkel " + name);
				talalt=false;
				if(robot.getClass().equals(name.getClass())==true) {
					System.out.println("Ugyanaz az oszt�lyuk " + robot + " " + name);
					for (Resource temp : temporary) {
						System.out.println("Volt-e m�r?");
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
		if(this.billOfRobot.size()==temporary.size())
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/*public boolean CheckResourceBase(ArrayList<Resource> r) {
		
		System.out.println("Base resource checked");
		return true;
	}*/
}
