package monke;

import java.util.ArrayList;

public class BillOfResources {
	private ArrayList<Resource> billOfTpk;
	private ArrayList<Resource> billOfRobot;
	private ArrayList<Resource> billOfBase;
	
	public BillOfResources(ArrayList<Resource> billOfTpk, ArrayList<Resource> billOfRobot, ArrayList<Resource> billOfBase) {
		this.billOfTpk = billOfTpk;
		this.billOfRobot = billOfRobot;
		this.billOfBase = billOfBase;
	}
	
	public void AddResource(Resource r) {
		
	}
	
	public void RemoveResource(Resource r) {
		 
	}
	
	public boolean CheckResourceTpk(Resource[] r) {
		
		System.out.println("Tpk resource checked");
		return true;
	}
	
	public boolean CheckResourceRobot(Resource[] r) {
		
		System.out.println("Robot resource checked");
		return true;
	}
	
	public boolean CheckResourceBase(Resource[] r) {
		
		System.out.println("Base resource checked");
		return true;
	}
}
