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
	
	
	//constructors 	
	public Tile(String name, int X, int Y, Color color){
		this.tileName = name;
		this.positionX = X;
		this.positionY = Y;	
		this.tileColor = color;
	}
	
	public Tile(String name, int X, int Y){
		this.tileName = name;
		this.positionX = X;
		this.positionY = Y;	
		this.tileColor = DEFAULT_COLOR;
	}
	
	public Tile(String name) {
		this.tileName = name;
		this.positionX = DEFAULT_POSITION_X;
		this.positionY = DEFAULT_POSITION_Y;
		this.tileColor = DEFAULT_COLOR;
	}
	
	
	
	//getters
	public int getPositionX() {
		return this.positionX;
	}
	public int getPositionY() {
		return this.positionY;
	}
	public Color getColor() {
		return this.tileColor;
	}
	
	//setters
	public void setPositionX(int position) {
		this.positionX = position;
	}
	public void setPositionY(int position) {
		this.positionY = position;
	}

	public void setColor(Color color) {
		this.tileColor = color;
	}
}
