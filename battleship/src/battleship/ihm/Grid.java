package battleship.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import battleship.Player;
import battleship.components.*;


public class Grid extends JPanel implements MouseListener {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tile[][] tileMatrix;
	private BufferedImage gridImage;
	
	public static final int GRID_SIZE = 10;
	public static final int X_ORIGIN = 50; // X coordinate of the top left
	public static final int Y_ORIGIN = 52; // Y coordinate of the top left
	public static final int TILE_SIZE = 48; // Size of the tile spaces
	public static final int BORDER_SIZE = 5; // size of the border between spaces
	
	public int mouseX;
	public int mouseY;
	public int xMat;
	public int yMat;
	
	public Player player;
	
	public Grid()
	{
		this(new Tile[GRID_SIZE][GRID_SIZE], "gridLabels.png");
	}
	
	public Grid(Tile[][] tileMatrix)
	{
		this(tileMatrix, "gridLabels.png");
	}
 
	public Grid(int size)
	{
		this(new Tile[size][size], "gridLabels.png");
	}
	
	public Grid(Tile[][] tileMatrix, String path)
	{
		this.setTileMatrix(tileMatrix);
		this.setBackground(Color.red);
		this.setPreferredSize(new Dimension((X_ORIGIN + BORDER_SIZE + ((TILE_SIZE+BORDER_SIZE)*this.getTileMatrix().length)), 
				Y_ORIGIN + BORDER_SIZE + ((TILE_SIZE+BORDER_SIZE)*this.getTileMatrix().length)));
		this.setSize(getPreferredSize());
		this.setLocation(0,0);
		
		try {
			this.gridImage = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// left click
		if (e.getButton() == MouseEvent.BUTTON1) {
			this.setMouseX(e.getX());
			this.setMouseY(e.getY() - (TILE_SIZE/2));
			int X = 0;
			while (X_ORIGIN + BORDER_SIZE + ((TILE_SIZE + BORDER_SIZE) * X) + BORDER_SIZE < this.getMouseX()) {
				X++;
			}
			X--;

			int Y = 0;
			while (Y_ORIGIN + BORDER_SIZE + ((TILE_SIZE + BORDER_SIZE) * Y) + BORDER_SIZE < this.getMouseY()) {
				Y++;
			}
			Y--;
			if (X > GRID_SIZE-1 || Y > GRID_SIZE-1 || X < 0 || Y < 0) {
				System.out.println("Clicked outside the window");
			} else {
				this.setxMat(X);
				this.setyMat(Y);
				System.out.println("Un clic en " + this.getMouseX() + " et " + this.getMouseY() + " Les coordonnees sont " + this.getxMat() + " et " + this.getyMat());
				
				System.out.println(this.getTileMatrix()[X][Y].getTileName() + " : " + this.getTileMatrix()[X][Y].isSeaOrBoat());
				this.getTileMatrix()[X][Y].setClicked(true);
			
				repaint();
				// TODO damage boats
				if (this.getTileMatrix()[X][Y].isSeaOrBoat() == 0)
				{
					this.getPlayer().setTurn(false);
					repaint();
				}
			
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// draw grid background image
		g2.drawImage(gridImage, 0, 0, this);
		
		// loops through all spots in the grid
		for (int i = 0; i < this.getTileMatrix().length; i++) {
			for (int j = 0; j < this.getTileMatrix()[i].length; j++) {
				// check if the Tile has not been clicked yet
				if (! this.getTileMatrix()[i][j].isClicked)
				{
					g2.setColor(Color.gray);
					g2.fillRect(X_ORIGIN + BORDER_SIZE + ((TILE_SIZE + BORDER_SIZE) * i), Y_ORIGIN + BORDER_SIZE + ((TILE_SIZE + BORDER_SIZE) * j),
							TILE_SIZE, TILE_SIZE);
				} else
				{
					// else check if there is a boat part or sea
					if (this.getTileMatrix()[i][j].isSeaOrBoat() == 0)
					{
						g2.setColor(Color.blue);
						g2.fillRect(X_ORIGIN + BORDER_SIZE + ((TILE_SIZE + BORDER_SIZE) * i), Y_ORIGIN + BORDER_SIZE + ((TILE_SIZE + BORDER_SIZE) * j),
								TILE_SIZE, TILE_SIZE);
					} else {
						//dessiner bateau touché ou coulé
						g2.setColor(Color.red);
						g2.fillRect(X_ORIGIN + BORDER_SIZE + ((TILE_SIZE + BORDER_SIZE) * i), Y_ORIGIN + BORDER_SIZE + ((TILE_SIZE + BORDER_SIZE) * j),
								TILE_SIZE, TILE_SIZE);
					}
				}
			}
		}
	}

	public Tile[][] getTileMatrix() {
		return this.tileMatrix;
	}

	public void setTileMatrix(Tile[][] tileMatrix) {
		this.tileMatrix = tileMatrix;
	}

	public int getxMat() {
		return this.xMat;
	}

	public void setxMat(int xMat) {
		this.xMat = xMat;
	}

	public int getyMat() {
		return this.yMat;
	}

	public void setyMat(int yMat) {
		this.yMat = yMat;
	}

	public int getMouseX() {
		return this.mouseX;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public int getMouseY() {
		return this.mouseY;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
