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
