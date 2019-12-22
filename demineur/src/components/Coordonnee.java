package components;

public class Coordonnee {

	public int x = 0;
	public int y = 0;
	
	public Coordonnee(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordonnee() {
		this.x = 0;
		this.y = 0;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
		
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}	
	
}
