package battleship.components;

import java.awt.event.MouseEvent;
import java.awt.Point;

public class Boat {
	
	public static final int CARRIER_LENGTH = 5;
	public static final int BATTLESHIP_LENGTH = 4;
	public static final int CRUISER_LENGTH = 3;
	public static final int SUBMARINE_LENGTH = 3;
	public static final int DESTROYER_LENGTH = 2;
	
	private int health;
	private Tile origin;
	private Point startingPosition = new Point(0,0);
	private String orientation;
	private Tile[] shipParts;
	private boolean shipSunk;
	
	public Boat(String name)
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
	
	// Check if a boat part is on the Tile
	public boolean tileBelongsToBoat(Tile tile)
	{
		for(int i = 0; i < this.getShipParts().length; i++) {
			if(tile.getPositionX() == this.getShipParts()[i].getPositionX() 
					&& tile.getPositionY() == this.getShipParts()[i].getPositionY())
			{
				if(this.getHealth()>1) {
					this.takeDamage();
				}else {
					this.setShipSunk(true);
				}
				return true;
			}
		}
		return false;
	}

	
	public Point getStartingOffGridPosition() {
		return this.startingPosition;
	}
	
	public void setStartingOffGridPosition(Point sp)
	{
		this.startingPosition = sp;
	}
	
}
