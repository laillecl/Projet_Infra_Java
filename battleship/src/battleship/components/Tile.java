package battleship.components;

import java.awt.Color;

public class Tile {

	//constants
	public static final int DEFAULT_POSITION_X = 0;
	public static final int DEFAULT_POSITION_Y = 0;
	//Colors : blue for water (default), black for a boat's part.
	public static final Color DEFAULT_COLOR = new Color(0, 0, 255);

	// attributes 
	public String tileName;
	public int positionX;
	public int positionY;
	public Color tileColor;
	public boolean isClicked;
	public int seaOrBoat;
	
	//constructors 	
	public Tile(int X, int Y, Color color){
		this.setPositionX(X);
		this.setPositionY(Y);
		this.setTileColor(color);
		this.generateTileName(X, Y);
	}

	public Tile(int X, int Y){
		this(X, Y, DEFAULT_COLOR);
	}
	
	public Tile() {
		this(DEFAULT_POSITION_X, DEFAULT_POSITION_Y, DEFAULT_COLOR);
	}
	
	
	//getters && setters
	public int getPositionX() {
		return this.positionX;
	}
	public int getPositionY() {
		return this.positionY;
	}
	
	public void setPositionX(int position) {
		this.positionX = position;
	}
	public void setPositionY(int position) {
		this.positionY = position;
	}

	public String getTileName() {
		return this.tileName;
	}

	public void setTileName(String tileName) {
		this.tileName = tileName;
	}

	public Color getTileColor() {
		return this.tileColor;
	}

	public void setTileColor(Color tileColor) {
		this.tileColor = tileColor;
	}
	
	public boolean isClicked() {
		return isClicked;
	}


	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}


	public int isSeaOrBoat() {
		return this.seaOrBoat;
	}


	public void setSeaOrBoat(int seaOrBoat) {
		this.seaOrBoat = seaOrBoat;
	}
	
	
	// Methods
	
	private void generateTileName(int x, int y) {
		String name = "";
		name = String.valueOf((char)(x + 65));
		name += y+1;
		this.setTileName(name);
	}	
}
