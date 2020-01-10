package battleship.components;

public class Boat {
	
	public static final int CARRIER_LENGTH = 5;
	public static final int BATTLESHIP_LENGTH = 4;
	public static final int CRUISER_LENGTH = 3;
	public static final int SUBMARINE_LENGTH = 3;
	public static final int DESTROYER_LENGTH = 2;
	
	private int health;
	private Tile origin;
	private String orientation;
	private Tile[] shipParts;
	private boolean shipSunk;
	
	Boat(String name)
	{
		switch(name)
		{
		case "Carrier":
			this.setHealth(CARRIER_LENGTH);
			this.setShipSunk(false);
			break;
		case "Battleship":
			this.setHealth(BATTLESHIP_LENGTH);
			this.setShipSunk(false);
			break;
		case "Cruiser":
			this.setHealth(CRUISER_LENGTH);
			this.setShipSunk(false);
			break;
		case "Submarine":
			this.setHealth(SUBMARINE_LENGTH);
			this.setShipSunk(false);
			break;
		case "Destroyer":
			this.setHealth(DESTROYER_LENGTH);
			this.setShipSunk(false);
			break;
		default:
			break;
		}
	}
	
	// Getters and setters

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Tile getOrigin() {
		return this.origin;
	}

	public void setOrigin(Tile origin) {
		this.origin = origin;
	}

	public String getOrientation() {
		return this.orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	public Tile[] getShipParts() {
		return this.shipParts;
	}

	public void setShipParts(Tile[] shipParts) {
		this.shipParts = shipParts;
	}

	public boolean isShipSunk() {
		return this.shipSunk;
	}

	public void setShipSunk(boolean shipSunk) {
		this.shipSunk = shipSunk;
	}
	
	
	// Methods

	public void takeDamage()
	{
		this.setHealth(this.getHealth()-1);
	}
	
	public void shipSunk()
	{
		if(this.getHealth() <= 0)
		{
			this.setShipSunk(true);
		}
	}
	
	
}
