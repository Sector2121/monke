package monke;

public class Settler extends Creature{
	private int hasTpk;
	private Game game;
	private Resource[] resources;
	private static BillOfResources billOfResources;
	private Teleport[] teleports;
	
	public void Mine() {
		
	}
	
	public void AddResource(Resource r) {
		if(resources.length < 10) {
			
		}
	}
	
	public Resource[] GetResources() {
		return resources;
	}
	
	public void PlaceResource(Resource r) {
		
	}
	
	public boolean CheckResource(Resource r) {
		return false;
	}
	
	public void RemoveResource(Resource r) {
		
	}
	
	public void GiveUp() {
		this.Die();
	}
	
	public void Skip() {
		
	}
	
	@Override
	public void Die() {
		
	}
	
	public void BuildTeleport() {
		
	}
	
	public void BuildRobot() {
		
	}
	
	public void PlaceTeleport(Asteroid a) {
		
	}
}
