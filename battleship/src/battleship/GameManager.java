package battleship;

import java.awt.Color;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

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
		Tile[][] p1Mat = this.placeBoats(this.initBoats(), p1);
		
		Tile[][] p2Mat = this.placeBoats(this.initBoats(), p2);
		// Instantiate grids for P1
		Grid gridP1 = new Grid(p2Mat);
		gridP1.setPlayer(p1);
		gridP1.setOpponent(p2);
		SmallGrid smallGridP1 = new SmallGrid(p1Mat);
		smallGridP1.setPlayer(p1);
		
		// Instantiate grids for P2
		Grid gridP2 = new Grid(p1Mat);
		gridP2.setPlayer(p2);
		gridP2.setOpponent(p1);
		SmallGrid smallGridP2 = new SmallGrid(p2Mat);
		smallGridP2.setPlayer(p2);
		
		smallGridP1.setLocation(gridP1.getWidth()+10, gridP1.getY());
		
		int windowWidth = smallGridP1.getX() + smallGridP1.getWidth() + 10;
		frame.setPreferredSize(new Dimension(windowWidth, frame.getHeight())); 
		frame.setSize(frame.getPreferredSize());
		frame.pack();
		
		frame.getContentPane().add(gridP1); // adds the grids to the window
		frame.getContentPane().add(smallGridP1);
		frame.getContentPane().repaint();
		
		frame.addMouseListener(gridP1);
		frame.setVisible(true);
		
		this.gameLoop(gridP1, smallGridP1, gridP2, smallGridP2);
	}
	
	// loop method for game turns 
	public void gameLoop(Grid gridP1, SmallGrid smallGridP1, Grid gridP2, SmallGrid smallGridP2)
	{
		while (this.isGameRunning())
		{
			// Verify if Player 2 has won and all Player 1 boats are sunk
			if (gridP1.getPlayer().arePlayerBoatsSunk()) 
			{
				this.setGameRunning(false);
				gridP2.getPlayer().setPlayerWon(true);
			}
			// While p1 turn
			while(gridP1.getPlayer().isTurn()) {/* TODO solution boucle vide */ System.out.println("1");};
			frame.removeMouseListener(gridP1);
			
			// Change screen
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			changeTurn(gridP1, gridP2, smallGridP2);
			gridP2.getPlayer().setTurn(true);
			
			// Verify if Player 1 has won and all Player 2 boats are sunk
			if (gridP2.getPlayer().arePlayerBoatsSunk()) 
			{
				this.setGameRunning(false);
				gridP1.getPlayer().setPlayerWon(true);
			}
			// While p2 turn
			while(gridP2.getPlayer().isTurn()) {/* TODO solution boucle vide */ System.out.println("2");};
			frame.removeMouseListener(gridP2);
			
			// change screen
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.changeTurn(gridP2, gridP1, smallGridP1);
			gridP1.getPlayer().setTurn(true);
			
		}
	}
	
	public void changeTurn(Grid currentGrid, Grid nextGrid, SmallGrid nextSmallGrid) 
	{
		frame.getContentPane().removeAll();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		frame.removeMouseListener(currentGrid);
		System.out.println(frame.getContentPane().getComponentCount());
		
		nextSmallGrid.setLocation(nextGrid.getWidth()+10, nextGrid.getY());
		
		int windowWidth = nextSmallGrid.getX() + nextSmallGrid.getWidth() + 10;
		frame.setPreferredSize(new Dimension(windowWidth, frame.getHeight())); 
		frame.setSize(frame.getPreferredSize());
		frame.pack();
		
		frame.getContentPane().add(nextGrid); // adds the grids to the window
		frame.getContentPane().add(nextSmallGrid);
		frame.getContentPane().repaint();
		
		frame.addMouseListener(nextGrid);
		frame.setVisible(true);
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
	
	public Tile[][] placeBoats(Boat[] boats, Player player) 
	{
		GridCreator creator = new GridCreator(boats, 10, frame, player);
		creator.setup();
		frame.getContentPane().add(creator);
		frame.getContentPane().repaint();
		frame.setVisible(true);
		while (!creator.isSetupOver()) {}
		player.setPlayerBoats(creator.getBoats());
		frame.getContentPane().removeAll();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		
		return creator.getTileMatrix();
	}
	
	public Boat[] initBoats()
	{
		String[] boatNames = {"Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
		Boat[] boats = new Boat[carrierAmount + battleshipAmount + cruiserAmount + submarineAmount + destroyerAmount];
		for (int i = 0; i < boats.length; i++)
		{
			boats[i] = new Boat(boatNames[i]);
		}
		return boats;
	}
}
