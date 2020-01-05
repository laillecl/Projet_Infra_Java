package components;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGrille {

	//TODO
	@Test
	public void testContructeur1() {
		Grille grille = new Grille(5);
	}

	//TODO
	@Test
	public void testContructeur2() {
		Grille grille = new Grille();
	}
	
	@Test
	public void getMatrice1() {
		Grille grille = new Grille(5);
		Case[][] matrice = new Case[5][5];
		assertEquals(matrice, grille.getMatrice());
		
	}
	
	//TODO
	@Test
	public void getMatrice2() {
		Grille grille = new Grille();
		Case[][] matrice = new Case[15][15];
		assertEquals(matrice, grille.getMatrice());
		
	}
	
	@Test
	public void getCase1() {
		Grille grille = new Grille(3);
		assertEquals(grille.getCase(2,2), grille.getCase(2,2));
	}
	
	@Test
	public void defaite1() {
		Grille grille = new Grille(3);
		assertEquals(false, grille.getDefaite());
	}
	
	@Test
	public void defaite2() {
		Grille grille = new Grille(3);
		grille.setDefaite(true);
		assertEquals(true, grille.getDefaite());
	}
	
	@Test
	public void defaite3() {
		Grille grille = new Grille(3);
		grille.setDefaite(false);
		assertEquals(false, grille.getDefaite());
	}
	

}
