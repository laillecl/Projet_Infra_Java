package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Grille extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Case[][] matrice;
	public int size;
	public int mouseX;
	public int mouseY;
	int xMat;
	int yMat;
	
	public static final int GRID_SIZE = 10;
	public static final int X_ORIGIN = 40; // X coordinate of the top left
	public static final int Y_ORIGIN = 40; // Y coordinate of the top left
	public static final int TILE_SIZE = 39; // Size of the tile spaces
	public static final int BORDER_SIZE = 1; // size of the border between spaces
	
	public Grille(int size) {
		this.matrice = new Case[size][size];
		construireMatrice();
	}
	
	public Grille() {
		this.size = GRID_SIZE;
		this.matrice = new Case[size][size];
		construireMatrice();
	}
	
	public Case[][] getMatrice() {
		return this.matrice;
	}
	
	public Case getCase(int x, int y) {
		return this.matrice[x][y];
	}
	
	public void construireMatrice(){
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if(i == 0 || j == 0) {
					this.matrice[i][j] = new Case(X_ORIGIN + i*TILE_SIZE, Y_ORIGIN + j*TILE_SIZE,1);
				}
				else if(i == this.size -1 || j == this.size -1) {
					this.matrice[i][j] = new Case(X_ORIGIN + i*TILE_SIZE, Y_ORIGIN + j*TILE_SIZE,1);
				}
				else {
					this.matrice[i][j] = new Case(X_ORIGIN + i*TILE_SIZE, Y_ORIGIN + j*TILE_SIZE);
				}
			}
		}
	}
	
//	public int[] convertirCoordonneesMatrice() {
//		int xMat = mouseX - X_ORIGIN / TILE_SIZE;
//		int yMat = mouseY - Y_ORIGIN / TILE_SIZE;
//		return [xMat,YMat];
//	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if(i == 0 || j == 0) {
					g2.setColor(this.getBackground());
					g2.fillRect(X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1), TILE_SIZE, TILE_SIZE);
				}
				else if(i == this.size -1 || j == this.size -1) {
					g2.setColor(this.getBackground());
					g2.fillRect(X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1), TILE_SIZE, TILE_SIZE);
				}
				else {
					g2.setColor(Color.DARK_GRAY);
					if (i == xMat && j == yMat) {
						this.matrice[i][j].setIsClicked(true);
					}
					if(this.getCase(i, j).isClicked) {
						g2.setColor(Color.LIGHT_GRAY);
					}
					g2.fillRect(X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1), TILE_SIZE, TILE_SIZE);
					
				}
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		xMat = (mouseX - X_ORIGIN)/(TILE_SIZE + BORDER_SIZE);
		yMat = (mouseY - Y_ORIGIN)/(TILE_SIZE + BORDER_SIZE) -1;
		System.out.println("Un clic en " + mouseX + " et " + mouseY + "Les coordonnees sont " + xMat + " et " + yMat);
		System.out.println("");
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

}