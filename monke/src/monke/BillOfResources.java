package monke;

public class BillOfResources {
	private Resource[] billOfTpk;
	private Resource[] billOfRobot;
	private Resource[] billOfBase;
	
	public BillOfResources(Resource[] billOfTpk, Resource[] billOfRobot, Resource[] billOfBase) {
		this.billOfTpk = billOfTpk;
		this.billOfRobot = billOfRobot;
		this.billOfBase = billOfBase;
	}
	
	public void AddResource(Resource r) {
		
	}
	
	public void RemoveResource(Resource r) {
		
	}
	
	public boolean CheckResourceTpk(Resource[] r) {
		
		return true;
	}
	
	public boolean CheckResourceRobot(Resource[] r) {
		
		return true;
	}
	
	public boolean CheckResourceBase(Resource[] r) {
		
		return true;
	}
}
