package battleship.components;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class TestTile {

	@Test
	void testConstructeur1() {
		Tile tile = new Tile("test", 1, 1, 10, Color.black);
		assertEquals(1, tile.getPositionX());
		assertEquals(1, tile.getPositionY());
		assertEquals(Color.black, tile.getColor());
	}
	
	@Test
	void testConstructeur2() {
		Tile tile = new Tile("", 1, 1, 10, Color.black);
		assertEquals(1, tile.getPositionX());
		assertEquals(1, tile.getPositionY());
		assertEquals(Color.black, tile.getColor());
	}
	
	@Test
	void testConstructeur3() {
		Tile tile = new Tile("test", -1, 1, 10, Color.black);
		assertEquals(-1, tile.getPositionX());
		assertEquals(1, tile.getPositionY());
		assertEquals(Color.black, tile.getColor());
	}
	
	@Test
	void testConstructeur4() {
		Tile tile = new Tile("test", 1, -1, 10, Color.black);
		assertEquals(1, tile.getPositionX());
		assertEquals(-1, tile.getPositionY());
		assertEquals(Color.black, tile.getColor());
	}
	
	@Test
	void testConstructeur11() {
		Tile tile = new Tile("test", 1, 1, 10);
		assertEquals(1, tile.getPositionX());
		assertEquals(1, tile.getPositionY());
		assertEquals(tile.DEFAULT_COLOR, tile.getColor());
	}
	
	@Test
	void testConstructeur12() {
		Tile tile = new Tile("test", -1, 1, 10);
		assertEquals(-1, tile.getPositionX());
		assertEquals(1, tile.getPositionY());
		assertEquals(tile.DEFAULT_COLOR, tile.getColor());
	}

	@Test
	void testConstructeur13() {
		Tile tile = new Tile("test", 1, -1, 10);
		assertEquals(1, tile.getPositionX());
		assertEquals(-1, tile.getPositionY());
		assertEquals(tile.DEFAULT_COLOR, tile.getColor());
	}
	
	@Test
	void testConstructeur14() {
		Tile tile = new Tile("", -1, -1, 10);
		assertEquals(-1, tile.getPositionX());
		assertEquals(-1, tile.getPositionY());
		assertEquals(tile.DEFAULT_COLOR, tile.getColor());
	}
	
	@Test
	void testConstructeur21() {
		Tile tile = new Tile("test");
		assertEquals(tile.DEFAULT_POSITION_X, tile.getPositionX());
		assertEquals(tile.DEFAULT_POSITION_Y, tile.getPositionY());
		assertEquals(tile.DEFAULT_COLOR, tile.getColor());
	}
	
	@Test
	void testConstructeur22() {
		Tile tile = new Tile("");
		assertEquals(tile.DEFAULT_POSITION_X, tile.getPositionX());
		assertEquals(tile.DEFAULT_POSITION_Y, tile.getPositionY());
		assertEquals(tile.DEFAULT_COLOR, tile.getColor());
	}
	
	@Test
	void testSetPositionX1() {
		Tile tile = new Tile("");
		tile.setPositionX(5);
		assertEquals(5, tile.getPositionX());
	}
	
	@Test
	void testSetPositionX2() {
		Tile tile = new Tile("");
		tile.setPositionX(-5);
		assertEquals(-5, tile.getPositionX());
	}
	
	@Test
	void testSetPositionX3() {
		Tile tile = new Tile("");
		tile.setPositionX(0);
		assertEquals(0, tile.getPositionX());
	}
	
	@Test
	void testSetPositionY1() {
		Tile tile = new Tile("");
		tile.setPositionY(5);
		assertEquals(5, tile.getPositionY());
	}
	
	@Test
	void testSetPositionY2() {
		Tile tile = new Tile("");
		tile.setPositionY(-5);
		assertEquals(-5, tile.getPositionY());
	}
	
	@Test
	void testSetPositionY3() {
		Tile tile = new Tile("");
		tile.setPositionY(0);
		assertEquals(0, tile.getPositionY());
	}
	
	@Test
	void testSetColor1() {
		Tile tile = new Tile("");
		tile.setColor(Color.blue);
		assertEquals(Color.blue, tile.getColor());
	}
	
	
}
