package grille;

public class Case{
	
	boolean estBombe = false;
	Coordonnee coordonnee = new Coordonnee();
	
	public Case(Coordonnee coordonnee, boolean estBombe) {
		this.coordonnee = coordonnee;
		this.estBombe = estBombe;
	}
	
	public void setcoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}
	
	public void setCoordonne(boolean estBombe) {
		this.estBombe = estBombe;
	}
	
	public Coordonnee getCoordonne() {
		return this.coordonnee;
	}
	
	public boolean getEstBombe() {
		return this.estBombe;
	}

}
