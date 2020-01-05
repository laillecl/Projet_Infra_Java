package components;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase {

	@Test
	public void testContructeur1() {
		Case case1 = new Case(5, 2, 0);
		assertEquals(5, case1.getPositionX());
		assertEquals(0, case1.getTileType());
		assertEquals(2, case1.getPositionY());
	}
	
	@Test
	public void testContructeur2() {
		Case case2 = new Case(5, 2, 1);
		assertEquals(5, case2.getPositionX());
		assertEquals(1, case2.getTileType());
		assertEquals(2, case2.getPositionY());
	}
	
	@Test
	public void testContructeur3() {
		Case case3 = new Case(5, 2, 2);
		assertEquals(5, case3.getPositionX());
		assertEquals(2, case3.getTileType());
		assertEquals(2, case3.getPositionY());
	}
	
	@Test
	public void testContructeur4() {
		Case case1 = new Case(-5, 2, 0);
		assertEquals(-5, case1.getPositionX());
		assertEquals(0, case1.getTileType());
		assertEquals(2, case1.getPositionY());
	}
	
	@Test
	public void testContructeur5() {
		Case case2 = new Case(-5, 2, 1);
		assertEquals(-5, case2.getPositionX());
		assertEquals(1, case2.getTileType());
		assertEquals(2, case2.getPositionY());
	}
	
	@Test
	public void testContructeur6() {
		Case case3 = new Case(-5, 2, 2);
		assertEquals(-5, case3.getPositionX());
		assertEquals(2, case3.getTileType());
		assertEquals(2, case3.getPositionY());
	}
	
	@Test
	public void testContructeur7() {
		Case case1 = new Case(-5, -2, 0);
		assertEquals(-5, case1.getPositionX());
		assertEquals(0, case1.getTileType());
		assertEquals(-2, case1.getPositionY());
	}
	
	@Test
	public void testContructeur8() {
		Case case2 = new Case(-5, -2, 1);
		assertEquals(-5, case2.getPositionX());
		assertEquals(1, case2.getTileType());
		assertEquals(-2, case2.getPositionY());
	}
	
	@Test
	public void testContructeur9() {
		Case case3 = new Case(-5, -2, 2);
		assertEquals(-5, case3.getPositionX());
		assertEquals(2, case3.getTileType());
		assertEquals(-2, case3.getPositionY());
	}
	
	@Test
	public void testContructeur10() {
		Case case3 = new Case(0, 0, 0);
		assertEquals(0, case3.getPositionX());
		assertEquals(0, case3.getTileType());
		assertEquals(0, case3.getPositionY());
	}
	
	@Test
	public void testContructeur11() {
		Case case1 = new Case(0, 0);
		assertEquals(0, case1.getPositionX());
		assertEquals(0, case1.getPositionY());
	}
	
	@Test
	public void testContructeur12() {
		Case case1 = new Case(2, 3);
		assertEquals(2, case1.getPositionX());
		assertEquals(3, case1.getPositionY());
	}
	
	@Test
	public void testContructeur13() {
		Case case1 = new Case(-2, -3);
		assertEquals(-2, case1.getPositionX());
		assertEquals(-3, case1.getPositionY());
	}
	
	@Test
	public void testContructeur14() {
		Case case1 = new Case();
		assertEquals(0, case1.getPositionX());
		assertEquals (0, case1.getPositionY());
		assertEquals (0, case1.getTileType());
		assertEquals(false, case1.getIsClicked());
	}
	
	@Test
	public void testSetPositionX1() {
		Case case1 = new Case();
		case1.setPositionX(3);
		assertEquals(3, case1.getPositionX());
	}
	
	@Test
	public void testSetPositionX2() {
		Case case1 = new Case();
		case1.setPositionX(-3);
		assertEquals(-3, case1.getPositionX());
	}
	
	@Test
	public void testSetPositionX3() {
		Case case1 = new Case();
		case1.setPositionX(0);
		assertEquals(0, case1.getPositionX());
	}
	
	@Test
	public void testSetPositionY1() {
		Case case1 = new Case();
		case1.setPositionY(-3);
		assertEquals(-3, case1.getPositionY());
	}
	
	@Test
	public void testSetPositionY2() {
		Case case1 = new Case();
		case1.setPositionY(0);
		assertEquals(0, case1.getPositionY());
	}
	
	@Test
	public void testSetTitleType1() {
		Case case1 = new Case();
		case1.setTileType(0);
		assertEquals(0, case1.getTileType());
	}
	
	@Test
	public void testSetTitleType2() {
		Case case1 = new Case();
		case1.setTileType(1);
		assertEquals(1, case1.getTileType());
	}
	
	@Test
	public void testSetTitleType3() {
		Case case1 = new Case();
		case1.setTileType(3);
		assertEquals(3, case1.getTileType());
	}
	
	@Test
	public void testIsCliked1() {
		Case case1 = new Case();
		case1.setIsClicked(true);
		assertEquals(true, case1.isClicked);
	}
	
	@Test
	public void testIsCliked2() {
		Case case1 = new Case();
		case1.setIsClicked(false);
		assertEquals(false, case1.isClicked);
	}


}
