package battleship;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

import battleship.ihm.Grid;
import battleship.ihm.SmallGrid;
import battleship.Player;

public class GameManager {
	
	// Constants
	public static  int gridSize = 10;
	
	public static int carrierAmount = 1;
	public static int battleshipAmount = 1;
	public static int cruiserAmount = 1;
	public static int submarineAmount = 1;
	public static int destroyerAmount = 1;
	
	
	// Frame instance
	private JFrame frame;
	
	// TODO Players
	public void setUpWindow() {
		frame = new JFrame();
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(910, 640));
		frame.setMinimumSize(new Dimension(910, 640));
		frame.setResizable(false);
		frame.setTitle("Battleship");
		frame.pack();
	}
	
	
	public void startGame()
	{
		this.setUpWindow();
		
		// Create 2 players
		Player p1 = new Player(1);
		p1.setTurn(true);
		Player p2 = new Player(2);
		
		// Instantiate ships
		//p1.placeBoats();
		//p2.placeBoats();
		// Instantiate grids
		Grid grid = new Grid(gridSize);
		SmallGrid smallGrid = new SmallGrid(gridSize);
		smallGrid.setLocation(grid.getWidth()+10, grid.getY());
		
		int windowWidth = smallGrid.getX() + smallGrid.getWidth() + 10;
		frame.setPreferredSize(new Dimension(windowWidth, frame.getHeight())); 
		frame.setSize(frame.getPreferredSize());
		frame.pack();
		
		frame.getContentPane().add(grid); // adds the grids to the window
		frame.getContentPane().add(smallGrid);
		frame.addMouseListener(grid);
		frame.setVisible(true);
		
		//instanciate turn 
	}
	
	// loop method for game turns 
	public void gameLoop(Player p1, Player p2){
		while(p1.isTurn == true) {
			System.out.println("Player" + p1.getPlayerNumber()+ "is playing...");
			
		}
	}
	
}
