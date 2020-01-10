package components;

public class Case {

	//constants
	public static final int DEFAULT_POSITION_X = 0;
	public static final int DEFAULT_POSITION_Y = 0;
	public static final int DEFAULT_TILE_TYPE = 0;

	// attributes
	public int positionX;
	public int positionY;
	public boolean isClicked;
	public int tileType;	// 0 si case normale, 1 si case vide, 2 si bombe
	public boolean isFlagged;
	public boolean drapeau = false;
	
	//constructors 	
	public Case(int X, int Y, int type){
		this.positionX = X;
		this.positionY = Y;	
		this.tileType = type ;
		this.isClicked = false;
		this.isFlagged = false;
	}
	
	public Case(int X, int Y){
		this.positionX = X;
		this.positionY = Y;	
		this.tileType = DEFAULT_TILE_TYPE;
		this.isClicked = false;
		this.isFlagged = false;
	}
	
	public Case() {
		this.positionX = DEFAULT_POSITION_X;
		this.positionY = DEFAULT_POSITION_Y;
		this.tileType = DEFAULT_TILE_TYPE;
		this.isClicked = false;
	}
	
	public int getPositionX() {
		return this.positionX;
	}
	public int getPositionY() {
		return this.positionY;
	}
	public int getTileType() {
		return this.tileType;
	}
	
	public boolean getIsClicked() {
		return this.isClicked;
	}
	
	public boolean getIsFlagged() {
		return this.isFlagged;
	}
	
	public boolean getDrapeau() {
		return this.drapeau;
	}
	
	public void setPositionX(int position) {
		this.positionX = position;
	}
	public void setPositionY(int position) {
		this.positionY = position;
	}

	public void setTileType(int tileType) {
		this.tileType = tileType;;
	}
	
	public void setIsClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}
	
	public void setIsFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}
	
	public void setDrapeau(boolean drapeau) {
		this.drapeau = drapeau;
	}
	
}
