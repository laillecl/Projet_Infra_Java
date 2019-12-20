package grille;

public class Case{
	
	boolean estBombe = false;
	boolean estDevoile = false;
	Coordonnee coordonnee = new Coordonnee();
	int taille = 25;
	
	public Case(Coordonnee coordonnee, boolean estBombe) {
		this.coordonnee = coordonnee;
		this.estBombe = estBombe;
		this.estDevoile = false;
	}
	
	public void setcoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}
	
	public void setCoordonne(boolean estBombe) {
		this.estBombe = estBombe;
	}
	
	public void setDevoile(boolean estDevoile) {
		this.estDevoile = estDevoile;
	}
	
	public Coordonnee getCoordonne() {
		return this.coordonnee;
	}
	
	public boolean getEstBombe() {
		return this.estBombe;
	}
	
	public boolean getEstDevoile() {
		return this.estDevoile;
	}

}
