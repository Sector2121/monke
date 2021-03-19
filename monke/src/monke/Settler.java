package monke;

public class Settler extends Creature{
	private int hasTpk;
	private Game game;
	private Resource[] resources;
	private static BillOfResources billOfResources;
	private Teleport[] teleports;
	
	public Settler(Game game, BillOfResources bill, String name) {
		hasTpk = 0;
		this.game = game;
		resources = null;
		teleports = null;
		billOfResources = bill;
		this.SetName(name);
	}
	
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
		game.RemoveSettler(this);
	}
	
	public void BuildTeleport() {
		if(billOfResources.CheckResourceTpk(resources)) {
			teleports[0] = new Teleport(1);
			teleports[1] = new Teleport(1, teleports[0]);
			teleports[0].SetPair(teleports[1]);
			//remove resources + id meghatározás
		}
	}
	
	public void BuildRobot(String name) {
		if(billOfResources.CheckResourceRobot(resources)) {
			Robot r = new Robot(name, this.GetAsteroid());
		}
	}
	
	public void PlaceTeleport(Asteroid a) {
		
	} 
}
