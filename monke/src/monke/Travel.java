package monke;

public interface Travel {
	public void Accept(Creature c);
	public void SetIsMoving();
	public void RemoveNeighbor(Travel t);
	public void AcceptTeleport(Teleport t);
}
