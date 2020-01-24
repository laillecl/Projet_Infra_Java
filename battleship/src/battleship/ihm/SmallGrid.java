package battleship.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import battleship.Player;
import battleship.components.Tile;

public class SmallGrid extends JPanel {
	private static final long serialVersionUID = 1L;
	private Tile[][] tileMatrix;
	private BufferedImage gridImage;
	private BufferedImage P1Boat;
	private BufferedImage P1BoatHit;
	private BufferedImage P2Boat;
	private BufferedImage P2BoatHit;
	
	public Player player;
	
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
			this.gridImage = ImageIO.read(SmallGrid.class.getResource("/battleship/image/gridSmallLabels.png"));
			this.P1Boat = ImageIO.read(SmallGrid.class.getResource("/battleship/image/BoatPartP1.png"));
			this.P1BoatHit = ImageIO.read(SmallGrid.class.getResource("/battleship/image/BoatPartHitP1.png"));
			this.P2Boat = ImageIO.read(SmallGrid.class.getResource("/battleship/image/BoatPartP2.png"));
			this.P2BoatHit = ImageIO.read(SmallGrid.class.getResource("/battleship/image/BoatPartHitP2.png"));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// draws the grid image
		g2.drawImage(this.gridImage, 0, 15, this);
		
		// loops through the array
		
		for (int i = 0; i < this.getTileMatrix().length; i++) {
			for (int j = 0; j < this.getTileMatrix()[i].length; j++) {
				// if there is a ship piece at the location
				if (this.getTileMatrix()[i][j].isSeaOrBoat() == 1) {
					// draw the image of the ship piece at the proper grid location
					// check if boat part has been hit or not
					if(this.getTileMatrix()[i][j].isClicked() == true)
					{
						BufferedImage image;
						if(this.getPlayer().getPlayerNumber() == 1)
						{
							image = this.P1BoatHit;
						} else 
						{
						    image = this.P2BoatHit;
						}
						g2.drawImage(image, 
								X_ORIGIN + 2 + ((TILE_SIZE + BORDER_SIZE) * i) + BORDER_SIZE/2,
								Y_ORIGIN + 2 + ((TILE_SIZE + BORDER_SIZE) * j) + BORDER_SIZE/2,
								PIECE_SIZE, PIECE_SIZE, this);
					} else
					{
						BufferedImage image;
						if(this.getPlayer().getPlayerNumber() == 1)
						{
							image = this.P1Boat;
						} else 
						{
						    image = this.P2Boat;
						}
						g2.drawImage(image, 
								X_ORIGIN + 2 + ((TILE_SIZE + BORDER_SIZE) * i) + BORDER_SIZE/2,
								Y_ORIGIN + 2 + ((TILE_SIZE + BORDER_SIZE) * j) + BORDER_SIZE/2,
								PIECE_SIZE, PIECE_SIZE, this);
					}
				}
			}
		}
	}


	public Tile[][] getTileMatrix() {
		return tileMatrix;
	}

	public void setTileMatrix(Tile[][] tileMatrix) {
		this.tileMatrix = tileMatrix;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
