package grille;

public class Coordonnee {

	int x = 0;
	int y = 0;
	boolean affiche = false;
	
	public Coordonnee(int x, int y, boolean affiche) {
		this.x = x;
		this.y = y;
		this.affiche = affiche;
	}
	
	public Coordonnee() {
		this.x = 0;
		this.y = 0;
		this.affiche = false;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int x) {
		this.y = y;
	}
	
	public void setAffcihe(boolean affiche) {
		this.affiche = affiche;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean getAffiche() {
		return this.affiche;
	}
	
	
}
