package components;

import java.awt.Graphics;

public class Case{
	
	public int type = 0;
	// type = 0 si case vide, type = 1 si case bord, type = 2 si bombe
	public boolean estDevoile = false;
	public Coordonnee coordonnee = new Coordonnee();
	public static int taille = 25;
	
	public Case(Coordonnee coordonnee, int type) {
		this.coordonnee = coordonnee;
		this.type = type;
		this.estDevoile = false;
	}
	
	public void setcoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}
	
	public void setType (int type) {
		this.type = type;
	}
	
	public void setDevoile(boolean estDevoile) {
		this.estDevoile = estDevoile;
	}
	
	public Coordonnee getCoordonne() {
		return this.coordonnee;
	}
	
	public int getType() {
		return this.type;
	}
	
	public boolean getEstDevoile() {
		return this.estDevoile;
	}

	public static void paintAll(Graphics g) {
		// TODO Auto-generated method stub
	}

}
