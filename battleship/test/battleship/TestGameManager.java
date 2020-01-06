package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGameManager {

	@Test
	void testWindow() {
		GameManager gm = new GameManager();
		gm.setUpWindow();
	}
	
	@Test
	void teststartGame() {
		GameManager gm = new GameManager();
		gm.startGame();
	}

}
