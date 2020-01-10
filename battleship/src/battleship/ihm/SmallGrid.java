package battleship.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import battleship.components.Tile;

public class SmallGrid extends JPanel {
	private static final long serialVersionUID = 1L;
	private Tile[][] tileMatrix;
	private BufferedImage gridImage;
	public static final int X_ORIGIN = 23; // X coordinate of the top left
	public static final int Y_ORIGIN = 39; // y coordinate of the top left
	public static final int TILE_SIZE = 20; // size of the tile spaces
	public static final int BORDER_SIZE = 3; // size of the border between tiles
	public static final int PIECE_SIZE = 18; // size of the pieces that appear

	
	public SmallGrid(int size)
	{
		this(new Tile[size][size]);
	}
	
	public SmallGrid(Tile[][] tileMatrix) {
		this.setTileMatrix(tileMatrix);
		
		// sets the background to white
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((X_ORIGIN + 2 + (TILE_SIZE+BORDER_SIZE)*this.getTileMatrix().length), 
				Y_ORIGIN+ 2 + ((TILE_SIZE+BORDER_SIZE)*this.getTileMatrix().length)));
		setSize(getPreferredSize());
		
		// loads the grid file
		try {
			gridImage = ImageIO.read(new File("gridSmallLabels.png"));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// draws the grid image
		g2.drawImage(gridImage, 0, 15, this);
		
		// loops through the array
		/*
		for (int i = 0; i < this.getTileMatrix().length; i++) {
			for (int j = 0; j < this.getTileMatrix()[i].length; j++) {
				// if there is a ship piece at the location
				if (this.getTileMatrix()[i][j].isSeaOrBoat() == 1) {
					// draw the image of the ship piece at the proper grid location
					// TODO check if boat part has been hit or not
				}
			}
		}*/
	}


	public Tile[][] getTileMatrix() {
		return tileMatrix;
	}

	public void setTileMatrix(Tile[][] tileMatrix) {
		this.tileMatrix = tileMatrix;
	}

}
