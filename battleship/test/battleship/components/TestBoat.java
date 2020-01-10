package battleship.components;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBoat {

	@Test
	void testConstructeur1() {
		Boat boat = new Boat("Carrier");
		assertEquals(boat.CARRIER_LENGTH, boat.getHealth());
	}
	
	@Test
	void testConstructeur2() {
		Boat boat = new Boat("Battleship");
		assertEquals(boat.BATTLESHIP_LENGTH, boat.getHealth());
	}
	
	@Test
	void testConstructeur3() {
		Boat boat = new Boat("Cruiser");
		assertEquals(boat.CRUISER_LENGTH, boat.getHealth());
	}
	
	@Test
	void testConstructeur4() {
		Boat boat = new Boat("Submarine");
		assertEquals(boat.SUBMARINE_LENGTH, boat.getHealth());
	}
	
	@Test
	void testConstructeur5() {
		Boat boat = new Boat("Destroyer");
		assertEquals(boat.DESTROYER_LENGTH, boat.getHealth());
	}
	
	@Test
	void testConstructeur6() {
		Boat boat = new Boat("test");
		assertEquals(0, boat.getHealth());
	}
	
	@Test
	void testConstructeur7() {
		Boat boat = new Boat("");
		assertEquals(0, boat.getHealth());
	}
	
	//TODO - origin
	

}
