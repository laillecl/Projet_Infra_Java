package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import lanceur_jeux.AddPointDemineur;

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
	public boolean flag = false;
	
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
	
	public boolean getVictoire() {
		return this.victoire;
	}
	
	public void setVictoire(boolean vic) {
		this.victoire = vic;
	}
	
	public boolean getFlag() {
		return this.flag;
	}
	
	public void setFlag(boolean annek) {
		this.flag = annek;
	}
	
	public void resetMatrice() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.matrice[i][j] = null;
			}
		}
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
	
	public int compterBombes() {
		int killian = 0;
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if(this.getCase(i, j).getTileType() == 2) {
					killian++;
				}
			}
		}
		return killian;
	}
	
	public int compterCasesRestantes() {
		int gabriel = 0;
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if(this.getCase(i, j).getTileType() == 0) {
					if(this.getCase(i, j).getIsClicked() == true) {
						gabriel++;
					}
				}
			}
		}
		return gabriel;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Font myFont = new Font("Arial", Font.BOLD, 12);
		
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				
				if(this.getFlag() == true) {
					if (i == xMat && j == yMat) {
						this.getCase(i, j).setIsFlagged(true);
						this.getCase(i, j).setDrapeau(!this.getCase(i, j).getDrapeau());
					}
				}
				
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
						if(this.getCase(i, j).getIsFlagged() == false){
							this.matrice[i][j].setIsClicked(true);
							devoileCaseAdjacente(i,j);
						}
					}
					
					// Si oui on change sa couleur
					if(this.getCase(i, j).isClicked) {
						g2.setColor(Color.LIGHT_GRAY);
						// Si c'est un bombe, icone bombe
						if(this.getCase(i, j).getTileType() == 2) {
							if(this.getCase(i, j).getIsFlagged() == false){
								g2.setColor(Color.red);
							}
						}
					}
					
					// Sinon on laisse un rectangle gris
					if(this.getCase(i, j).getIsFlagged() == false){
						g2.fillRect(X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1), TILE_SIZE, TILE_SIZE);
					}
					
					if(this.getCase(i, j).getTileType() == 2) {
						if(this.getCase(i, j).getIsFlagged() == false){
							if(this.getCase(i, j).getIsClicked()) {
								g2.setColor(Color.black);
								g2.fillOval(X_ORIGIN + i*(TILE_SIZE+1)+(TILE_SIZE)/8, Y_ORIGIN + j*(TILE_SIZE+1)+(TILE_SIZE)/8, (TILE_SIZE)*6/8, (TILE_SIZE)*6/8);
							}
						}
					}
					
					int cpt = caseAdjacenteBombe(i,j);
					String str = String.valueOf(cpt);
					
					if(cpt != 0) {
						if(this.getCase(i, j).isClicked) {
							if(this.getCase(i,j).getTileType() != 2) {
								if(this.getCase(i, j).getIsFlagged() == false){
									g2.setColor(Color.black);
									g2.drawString(str, X_ORIGIN + i*(TILE_SIZE+1) + TILE_SIZE/2, Y_ORIGIN + j*(TILE_SIZE+1) + TILE_SIZE/2);
								}
							}
						}
					}
					
					// condition defaite
					if(this.getDefaite() == true) {
						this.getCase(i,	j).setIsClicked(true);
						Font font2 = new Font("Arial", Font.BOLD, 24);
						g2.setColor(Color.red);
						g2.setFont(font2);
						g2.drawString("DEFAITE", X_ORIGIN, Y_ORIGIN );
						g2.setFont(myFont);
					}
					
					// condition victoire
					if(this.getVictoire() == true) {
							this.getCase(i,	j).setIsClicked(true);
							Font font2 = new Font("Arial", Font.BOLD, 24);
							g2.setColor(Color.green);
							g2.setFont(font2);
							g2.drawString("VICTOIRE", X_ORIGIN, Y_ORIGIN );
							g2.setFont(myFont);
							
							//ICI ON AJOUTE LES POINTS DE LA VICTOIRE
							try{  
						    	 //Connexion bdd
						    	 Class.forName("com.mysql.cj.jdbc.Driver");  
						    	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_infra","root","");  
						    	 //Requete SQL
						    	 Statement stmt=con.createStatement();  
						    	 //Verification username
						    	 String first_name;
						    	 first_name = JOptionPane.showInputDialog("Entrez votre nom d'utilisateur");
						    	 //Connexion bdd
						    	 ResultSet rs=stmt.executeQuery("select * from utilisateur");  
						    	 while(rs.next()) {
						    		 if(rs.getString(2).equals(first_name)) {
						    			AddPointDemineur ajoutPoints = new AddPointDemineur(first_name);
						    			ajoutPoints.ajouterPoints();
						    		 }
						    	 }
						    	 con.close();  
						     }
						     catch(Exception e){ 
						    	 System.out.println(e);
						    }
							
					}
					
					// Si une bombe est cliquée, fin de partie
					if(this.getCase(i, j).getTileType() == 2) {
						if (victoire = false) {
							if (this.getCase(i, j).getIsClicked()) {
								this.setDefaite(true);
							}
						}
					}
					
					if(((this.size-2)*(this.size-2) - this.compterBombes()) == this.compterCasesRestantes()){
						this.setVictoire(true);
					}
					
					if(this.getCase(i, j).getIsFlagged()) {
						if(this.getCase(i, j).getDrapeau() == false) {
							g2.setColor(Color.black);
							g2.drawLine(X_ORIGIN + i*(TILE_SIZE+1) + (TILE_SIZE)/2, Y_ORIGIN + j*(TILE_SIZE+1) + (TILE_SIZE)/8, X_ORIGIN + i*(TILE_SIZE+1) + (TILE_SIZE)/2, Y_ORIGIN + j*(TILE_SIZE+1) + (TILE_SIZE)*7/8);
							int xCoords[] = {X_ORIGIN + i*(TILE_SIZE+1) + (TILE_SIZE)/2,X_ORIGIN + i*(TILE_SIZE+1) + (TILE_SIZE)/2,X_ORIGIN + i*(TILE_SIZE+1) + (TILE_SIZE)*7/8};
							int yCoords[] = {Y_ORIGIN + j*(TILE_SIZE+1) + (TILE_SIZE)*4/8,Y_ORIGIN + j*(TILE_SIZE+1) + (TILE_SIZE)*1/8, Y_ORIGIN + j*(TILE_SIZE+1) + (TILE_SIZE)*2/8};
							g2.setColor(Color.red);
							g2.fillPolygon(xCoords, yCoords, 3);
						}
						else {
							g2.setColor(Color.DARK_GRAY);
							g2.fillRect(X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1), TILE_SIZE, TILE_SIZE);
						}
					}
				}
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int buttonDown = e.getButton();
		if (buttonDown == MouseEvent.BUTTON1) {
			this.setFlag(false);
			mouseX = e.getX();
			mouseY = e.getY();
			xMat = (mouseX - X_ORIGIN)/(TILE_SIZE + BORDER_SIZE);
			yMat = (mouseY - Y_ORIGIN)/(TILE_SIZE + BORDER_SIZE) -1;
			System.out.println("Un clic en " + mouseX + " et " + mouseY + " Les coordonnees sont " + xMat + " et " + yMat);
			System.out.println("Les cases devoilees : " + ((this.size-2)*(this.size-2) - this.compterBombes()));
			System.out.println("Les cases restantes : " + this.compterCasesRestantes());
			System.out.println("Flag : " + this.getFlag());
	    }
		else if(buttonDown == MouseEvent.BUTTON3) {
			this.setFlag(true);
			mouseX = e.getX();
			mouseY = e.getY();
			xMat = (mouseX - X_ORIGIN)/(TILE_SIZE + BORDER_SIZE);
			yMat = (mouseY - Y_ORIGIN)/(TILE_SIZE + BORDER_SIZE) -1;
			System.out.println("Flag : " + this.getFlag());
			System.out.println("La case a un drapeau : " + this.getCase(2, 2).getIsFlagged());
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

}