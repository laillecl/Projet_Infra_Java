package grille;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCoordonnee {
	
	@Test
	public void CoordonneeTest1() {
		Coordonnee c1 = new Coordonnee();
		System.out.print("oui");
		assertEquals(0, c1.getX());
	}

}
