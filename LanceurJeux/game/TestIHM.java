package game;

import static org.junit.Assert.*;

import org.junit.Test;

import components.DemineurGrille;

public class TestIHM {

	@Test
	public void testsetDef1() {
		IHMDemineur ihm = new IHMDemineur();
		ihm.setDef(true);
		assertEquals(true, IHMDemineur.getDef());
	}
	
	@Test
	public void testsetDef2() {
		IHMDemineur ihm = new IHMDemineur();
		ihm.setDef(false);
		assertEquals(false, IHMDemineur.getDef());
	}
	
	@Test
	public void testFin() {
		IHMDemineur ihm = new IHMDemineur();
		DemineurGrille grille = new DemineurGrille();
		grille.setDefaite(true);
		ihm.setDef(true);
	}

}
