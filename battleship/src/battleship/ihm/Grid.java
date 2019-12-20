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

import battleship.components.Tile;

public class Grid extends JPanel implements MouseListener {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tile[][] tileMatrix;
	private BufferedImage gridImage;
	
	public static final int GRID_SIZE = 10;
	public static final int X_ORIGIN = 54; // X coordinate of the top left
	public static final int Y_ORIGIN = 56; // Y coordinate of the top left
	public static final int TILE_SIZE = 47; // Size of the tile spaces
	public static final int BORDER_SIZE = 5; // size of the border between spaces
	
	
	public Grid()
	{
		this(new Tile[GRID_SIZE][GRID_SIZE], "gridLabels.png");
	}

	public Grid(int size)
	{
		this(new Tile[size][size], "gridLabels.png");
	}
	
	public Grid(Tile[][] tileMatrix, String path)
	{
		this.setTileMatrix(tileMatrix);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension((X_ORIGIN+ this.getTileMatrix().length + 1 + ((TILE_SIZE+BORDER_SIZE)*this.getTileMatrix().length)), 
				Y_ORIGIN+ this.getTileMatrix().length + 1 + ((TILE_SIZE+BORDER_SIZE)*this.getTileMatrix().length)));
		this.setSize(getPreferredSize());
		this.setLocation(0,0);
		
		try {
			gridImage = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
				
				g2.setColor(Color.gray);
				g2.fillRect(X_ORIGIN + i + 1 + ((TILE_SIZE + BORDER_SIZE) * i), Y_ORIGIN + j + 1 + ((TILE_SIZE + BORDER_SIZE) * j),
						TILE_SIZE+(BORDER_SIZE/2)-1, TILE_SIZE+(BORDER_SIZE/2)-1);
				
			}
		}
	}

	public Tile[][] getTileMatrix() {
		return this.tileMatrix;
	}

	public void setTileMatrix(Tile[][] tileMatrix) {
		this.tileMatrix = tileMatrix;
	}
	
	
}
