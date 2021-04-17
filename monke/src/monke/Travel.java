package monke;

public interface Travel {
	public void Accept(Creature c); //Creature elfogadasa
	public void SetIsMoving(); //isMoving boolean beallitasa
	public void RemoveNeighbor(Travel t); //Szomszed eltavolitasa
	public void AcceptTeleport(Teleport t); //Teleport elfogadasa
}
