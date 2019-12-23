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
	
	
	//constructors 	
	public Case(int X, int Y, int type){
		this.positionX = X;
		this.positionY = Y;	
		this.tileType = type ;
		this.isClicked = false;
	}
	
	public Case(int X, int Y){
		this.positionX = X;
		this.positionY = Y;	
		this.tileType = DEFAULT_TILE_TYPE;
		this.isClicked = false;
	}
	
	public Case() {
		this.positionX = DEFAULT_POSITION_X;
		this.positionY = DEFAULT_POSITION_Y;
		this.tileType = DEFAULT_TILE_TYPE;
		this.isClicked = false;
	}
	
	
	
	//getters
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
	
	//setters
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
}
