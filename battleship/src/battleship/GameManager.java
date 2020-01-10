package battleship;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

import battleship.ihm.Grid;
import battleship.ihm.GridCreator;
import battleship.ihm.SmallGrid;
import battleship.Player;
import battleship.components.Boat;
import battleship.components.Tile;

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
	
	private boolean gameRunning;
	
	public Player currentPlayer;
	
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
		
		this.setGameRunning(true);
		// Create 2 players
		Player p1 = new Player(1);
		p1.setTurn(true);
		this.setCurrentPlayer(p1);
		Player p2 = new Player(2);
		
		// Instantiate ships
		Tile[][] p1Mat = this.placeBoats(this.initBoats());
		Tile[][] p2Mat = this.placeBoats(this.initBoats());
		// Instantiate grids
		Grid grid = new Grid(p1Mat);
		SmallGrid smallGrid = new SmallGrid(gridSize);
		smallGrid.setLocation(grid.getWidth()+10, grid.getY());
		
		int windowWidth = smallGrid.getX() + smallGrid.getWidth() + 10;
		frame.setPreferredSize(new Dimension(windowWidth, frame.getHeight())); 
		frame.setSize(frame.getPreferredSize());
		
		frame.getContentPane().add(grid); // adds the grids to the window
		frame.getContentPane().add(smallGrid);
		frame.addMouseListener(grid);
		frame.setVisible(true);
		frame.pack();
		
		this.gameLoop(p1, p2);
	}
	
	// loop method for game turns 
	public void gameLoop(Player p1, Player p2) {
		while(this.isGameRunning()) {
			System.out.println("Player " + p1.getPlayerNumber()+ "is playing...");
			this.setGameRunning(false);
		}
	}


	public boolean isGameRunning() {
		return this.gameRunning;
	}


	public void setGameRunning(boolean gameRunning) {
		this.gameRunning = gameRunning;
	}


	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}


	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	public Tile[][] placeBoats(Boat[] ships) 
	{
		GridCreator creator = new GridCreator(ships, 10, frame);
		creator.setup();
		frame.getContentPane().add(creator);
		frame.getContentPane().repaint();
		frame.setVisible(true);
		while (!creator.isSetupOver()) {}
		frame.getContentPane().removeAll();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		
		return creator.getTileMatrix();
	}
	
	public Boat[] initBoats()
	{
		Boat[] boats = new Boat[carrierAmount + battleshipAmount + cruiserAmount + submarineAmount + destroyerAmount];
		for (int i = 0; i < boats.length; i++)
		{
			boats[i] = new Boat("Carrier");
		}
		return boats;
	}
}
