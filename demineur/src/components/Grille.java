package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	public int xMat;
	public int yMat;
	public boolean defaite = false;
	public boolean victoire = false;
	private BufferedImage image;
	
	public static final int GRID_SIZE = 15;
	public static final int X_ORIGIN = 20; // X coordinate of the top left
	public static final int Y_ORIGIN = 20; // Y coordinate of the top left
	public static final int TILE_SIZE = 29; // Size of the tile spaces
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
	
	public boolean getDefaite() {
		return this.defaite;
	}
	
	public void setDefaite(boolean rejouer) {
		this.defaite = rejouer;
	}
	
	public void construireMatrice(){
		// placement aleatoire des bombes
		Random rand = new Random();
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if(i == 0 || j == 0) {
					this.matrice[i][j] = new Case(X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1),1);
				}
				else if(i == this.size -1 || j == this.size -1) {
					this.matrice[i][j] = new Case(X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1),1);
				}
				else {
					this.matrice[i][j] = new Case(X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1));
					if (rand.nextInt(100) <10) {
						this.matrice[i][j].setTileType(2);
					}
				}
			}
		}
	}
	
	public int caseAdjacenteBombe(int i,int j) {
		int compteurBombes = 0;
		if (this.matrice[i-1][j-1].getTileType() == 2){
			compteurBombes++;
		}
		if (this.matrice[i-1][j].getTileType() == 2){
			compteurBombes++;
		}
		if (this.matrice[i-1][j+1].getTileType() == 2){
			compteurBombes++;
		}
		if (this.matrice[i][j+1].getTileType() == 2){
			compteurBombes++;
		}
		if (this.matrice[i][j-1].getTileType() == 2){
			compteurBombes++;
		}
		if (this.matrice[i+1][j-1].getTileType() == 2){
			compteurBombes++;
		}
		if (this.matrice[i+1][j].getTileType() == 2){
			compteurBombes++;
		}
		if (this.matrice[i+1][j+1].getTileType() == 2){
			compteurBombes++;
		}
		return compteurBombes;		
	}
	
	public boolean caseAdjacenteVide(int i, int j) {
		boolean adjVide = false;
		if (this.matrice[i-1][j-1].getTileType() == 1){
			adjVide = true;
		}
		if (this.matrice[i-1][j].getTileType() == 1){
			adjVide = true;
		}
		if (this.matrice[i-1][j+1].getTileType() == 1){
			adjVide = true;
		}
		if (this.matrice[i][j+1].getTileType() == 1){
			adjVide = true;
		}
		if (this.matrice[i][j-1].getTileType() == 1){
			adjVide = true;
		}
		if (this.matrice[i+1][j-1].getTileType() == 1){
			adjVide = true;
		}
		if (this.matrice[i+1][j].getTileType() == 1){
			adjVide = true;
		}
		if (this.matrice[i+1][j+1].getTileType() == 1){
			adjVide = true;
		}
		return adjVide;
	}
	
	// Fonction recursive
	public void devoileCaseAdjacente(int i, int j) {
		if (this.caseAdjacenteBombe(i, j) < 1){
				this.getCase(i-1, j-1).setIsClicked(true);
				this.getCase(i-1, j).setIsClicked(true);
				this.getCase(i-1, j+1).setIsClicked(true);
				this.getCase(i, j-1).setIsClicked(true);
				this.getCase(i, j+1).setIsClicked(true);
				this.getCase(i+1, j-1).setIsClicked(true);
				this.getCase(i+1, j).setIsClicked(true);
				this.getCase(i+1, j+1).setIsClicked(true);
				
				devoileCaseAdjGauche(i,j);
				devoileCaseAdjDroite(i,j);
//				devoileCaseAdjHaut(i,j);
//				devoileCaseAdjBas(i,j);
				
				// pour debug
				
//				if(this.matrice[i-1][j-1].getTileType() != 1){
//					devoileCaseAdjacente(i-1,j-1);
//				}
//				if(this.matrice[i-1][j].getTileType() != 1){
//					devoileCaseAdjacente(i-1,j);
//				}
//				if(this.matrice[i-1][j+1].getTileType() != 1){
//					devoileCaseAdjacente(i-1,j+1);
//				}
//				if(this.matrice[i][j-1].getTileType() != 1){
//					devoileCaseAdjacente(i,j-1);
//				}
//				if(this.matrice[i][j+1].getTileType() != 1){
//					devoileCaseAdjacente(i,j+1);
//				}
//				if(this.matrice[i+1][j-1].getTileType() != 1){
//					devoileCaseAdjacente(i+1,j-1);
//				}
//				if(this.matrice[i+1][j].getTileType() != 1){
//					devoileCaseAdjacente(i+1,j);
//				}
//				if(this.matrice[i+1][j+1].getTileType() != 1){
//					devoileCaseAdjacente(i+1,j+1);
//				}
		}
	}
	
	public void devoileCaseAdjGauche(int i, int j) {
		if (this.caseAdjacenteBombe(i, j) < 1){
			this.getCase(i-1, j-1).setIsClicked(true);
			this.getCase(i-1, j).setIsClicked(true);
			this.getCase(i-1, j+1).setIsClicked(true);
			if(this.matrice[i-1][j-1].getTileType() != 1){
				devoileCaseAdjGauche(i-1,j-1);
			}
			if(this.matrice[i-1][j].getTileType() != 1){
				devoileCaseAdjGauche(i-1,j);
			}
			if(this.matrice[i-1][j+1].getTileType() != 1){
				devoileCaseAdjGauche(i-1,j+1);
			}
		}
	}
	
	public void devoileCaseAdjDroite(int i, int j) {
		if (this.caseAdjacenteBombe(i, j) < 1){
			this.getCase(i+1, j-1).setIsClicked(true);
			this.getCase(i+1, j).setIsClicked(true);
			this.getCase(i+1, j+1).setIsClicked(true);
			if(this.matrice[i+1][j-1].getTileType() != 1){
				devoileCaseAdjacente(i+1,j-1);
			}
			if(this.matrice[i+1][j].getTileType() != 1){
				devoileCaseAdjacente(i+1,j);
			}
			if(this.matrice[i+1][j+1].getTileType() != 1){
				devoileCaseAdjacente(i+1,j+1);
			}
		}
	}
	
	public void devoileCaseAdjHaut(int i, int j) {
		if (this.caseAdjacenteBombe(i, j) < 1){
			this.getCase(i, j-1).setIsClicked(true);
			if(this.matrice[i][j-1].getTileType() != 1){
				devoileCaseAdjacente(i,j-1);
			}
		}
	}
	
	public void devoileCaseAdjBas(int i, int j) {
		if (this.caseAdjacenteBombe(i, j) < 1){
			this.getCase(i, j+1).setIsClicked(true);
			if(this.matrice[i][j+1].getTileType() != 1){
				devoileCaseAdjacente(i,j+1);
			}
		}
	}
	
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
					
					// Est-ce que la case est cliquée ?
					if (i == xMat && j == yMat) {
						this.matrice[i][j].setIsClicked(true);
						devoileCaseAdjacente(i,j);
					}
					
					// Si oui on change sa couleur
					if(this.getCase(i, j).isClicked) {
						g2.setColor(Color.LIGHT_GRAY);
						
						// Si c'est un bombe, icone bombe
						if(this.getCase(i, j).getTileType() == 2) {
							g2.setColor(Color.red);
							// g2.drawImage(image, X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1), this);
						}
					}
					
					// Sinon on laisse un rectangle gris
					g2.fillRect(X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1), TILE_SIZE, TILE_SIZE);
					
					if(this.getCase(i, j).getTileType() == 2) {
						if(this.getCase(i, j).getIsClicked()) {
							g2.setColor(Color.black);
							g2.fillOval(X_ORIGIN + i*(TILE_SIZE+1)+(TILE_SIZE)/8, Y_ORIGIN + j*(TILE_SIZE+1)+(TILE_SIZE)/8, (TILE_SIZE)*6/8, (TILE_SIZE)*6/8);
						}
					}
					
					int cpt = caseAdjacenteBombe(i,j);
					String str = String.valueOf(cpt);
					
					if(cpt != 0) {
						if(this.getCase(i, j).isClicked) {
							if(this.getCase(i,j).getTileType() != 2) {
								g2.setColor(Color.black);
								g2.drawString(str, X_ORIGIN + i*(TILE_SIZE+1) + TILE_SIZE/2, Y_ORIGIN + j*(TILE_SIZE+1) + TILE_SIZE/2);
							}
						}
					}
					
					if(defaite == true) {
						this.getCase(i,	j).setIsClicked(true);
					}
					
					// Si une bombe est cliquée, fin de partie
					if(this.getCase(i, j).getTileType() == 2) {
						if (this.getCase(i, j).getIsClicked()) {
							defaite = true;
							
						}
					}
					
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
		System.out.println("Un clic en " + mouseX + " et " + mouseY + " Les coordonnees sont " + xMat + " et " + yMat);
		System.out.println("Les bombes adjactentes sont : " + caseAdjacenteBombe(xMat,yMat));
		System.out.println("Cette case est ajdacente au vide : " + caseAdjacenteVide(xMat,yMat));
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