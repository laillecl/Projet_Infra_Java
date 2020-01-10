package game;

import static org.junit.Assert.*;

import org.junit.Test;

import components.Grille;

public class TestIHM {

	@Test
	public void testsetDef1() {
		IHM ihm = new IHM();
		ihm.setDef(true);
		assertEquals(true, IHM.getDef());
	}
	
	@Test
	public void testsetDef2() {
		IHM ihm = new IHM();
		ihm.setDef(false);
		assertEquals(false, IHM.getDef());
	}
	
	@Test
	public void testFin() {
		IHM ihm = new IHM();
		Grille grille = new Grille();
		grille.setDefaite(true);
		ihm.setDef(true);
	}

}
