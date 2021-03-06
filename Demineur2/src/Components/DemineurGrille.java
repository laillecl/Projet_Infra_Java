package Components;

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

public class DemineurGrille extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DemineurCase[][] matrice;
	public int size;
	public int mouseX;
	public int mouseY;
	public int xMat;
	public int yMat;
	public boolean defaite = false;
	public boolean victoire = false;
	public boolean flag = false;
	public int pourcentageBombes = 5;
	public int compteurPointsVictoire = 0;
	
	public static final int GRID_SIZE = 15;
	public static final int X_ORIGIN = 20; // X coordinate of the top left
	public static final int Y_ORIGIN = 50; // Y coordinate of the top left
	public static final int TILE_SIZE = 29; // Size of the tile spaces
	public static final int BORDER_SIZE = 1; // size of the border between spaces
	
	public DemineurGrille(int size) {
		this.matrice = new DemineurCase[size][size];
		construireMatrice();
	}

	public DemineurGrille() {
		this.size = GRID_SIZE;
		this.matrice = new DemineurCase[size][size];
		construireMatrice();
	}
	
	public DemineurCase[][] getMatrice() {
		return this.matrice;
	}
	
	public DemineurCase getDemineurCase(int x, int y) {
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
	
	public void setPourcentageBombes(int pourcentage) {
		this.pourcentageBombes = pourcentage;
	}
	
	public int getPourcentageBombes() {
		return this.pourcentageBombes;
	}
	
	public void setCompteurPointsVictoire(int compteurPointsVictoire) {
		this.compteurPointsVictoire = compteurPointsVictoire;
	}
	
	public int getCompteurPointsVictoire() {
		return this.compteurPointsVictoire;
	}
	
	
	public void resetMatrice() {
		construireMatrice();
		this.setCompteurPointsVictoire(0);
		this.setVictoire(false);
		this.setDefaite(false);
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.getDemineurCase(i, j).setIsClicked(false);
			}
		}
	}
	
	public void construireMatrice(){
		// placement aleatoire des bombes
		Random rand = new Random();
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if(i == 0 || j == 0) {
					this.matrice[i][j] = new DemineurCase(X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1),1);
				}
				else if(i == this.size -1 || j == this.size -1) {
					this.matrice[i][j] = new DemineurCase(X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1),1);
				}
				else {
					this.matrice[i][j] = new DemineurCase(X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1));
					if (rand.nextInt(100) < pourcentageBombes) {
						this.matrice[i][j].setTileType(2);
					}
				}
			}
		}
	}
	
	public int DemineurCaseAdjacenteBombe(int i,int j) {
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
	
	public boolean DemineurCaseAdjacenteVide(int i, int j) {
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
	public void devoileDemineurCaseAdjacente(int i, int j) {
		if (this.DemineurCaseAdjacenteBombe(i, j) < 1){
				this.getDemineurCase(i-1, j-1).setIsClicked(true);
				this.getDemineurCase(i-1, j).setIsClicked(true);
				this.getDemineurCase(i-1, j+1).setIsClicked(true);
				this.getDemineurCase(i, j-1).setIsClicked(true);
				this.getDemineurCase(i, j+1).setIsClicked(true);
				this.getDemineurCase(i+1, j-1).setIsClicked(true);
				this.getDemineurCase(i+1, j).setIsClicked(true);
				this.getDemineurCase(i+1, j+1).setIsClicked(true);
				
				devoileDemineurCaseAdjGauche(i,j);
				devoileDemineurCaseAdjDroite(i,j);
//				devoileDemineurCaseAdjHaut(i,j);
//				devoileDemineurCaseAdjBas(i,j);
				
				// pour debug
		}
	}
	
	public void devoileDemineurCaseAdjGauche(int i, int j) {
		if (this.DemineurCaseAdjacenteBombe(i, j) < 1){
			this.getDemineurCase(i-1, j-1).setIsClicked(true);
			this.getDemineurCase(i-1, j).setIsClicked(true);
			this.getDemineurCase(i-1, j+1).setIsClicked(true);
			if(this.matrice[i-1][j-1].getTileType() != 1){
				devoileDemineurCaseAdjGauche(i-1,j-1);
			}
			if(this.matrice[i-1][j].getTileType() != 1){
				devoileDemineurCaseAdjGauche(i-1,j);
			}
			if(this.matrice[i-1][j+1].getTileType() != 1){
				devoileDemineurCaseAdjGauche(i-1,j+1);
			}
		}
	}
	
	public void devoileDemineurCaseAdjDroite(int i, int j) {
		if (this.DemineurCaseAdjacenteBombe(i, j) < 1){
			this.getDemineurCase(i+1, j-1).setIsClicked(true);
			this.getDemineurCase(i+1, j).setIsClicked(true);
			this.getDemineurCase(i+1, j+1).setIsClicked(true);
			if(this.matrice[i+1][j-1].getTileType() != 1){
				devoileDemineurCaseAdjacente(i+1,j-1);
			}
			if(this.matrice[i+1][j].getTileType() != 1){
				devoileDemineurCaseAdjacente(i+1,j);
			}
			if(this.matrice[i+1][j+1].getTileType() != 1){
				devoileDemineurCaseAdjacente(i+1,j+1);
			}
		}
	}
	
	public void devoileDemineurCaseAdjHaut(int i, int j) {
		if (this.DemineurCaseAdjacenteBombe(i, j) < 1){
			this.getDemineurCase(i, j-1).setIsClicked(true);
			if(this.matrice[i][j-1].getTileType() != 1){
				devoileDemineurCaseAdjacente(i,j-1);
			}
		}
	}
	
	public void devoileDemineurCaseAdjBas(int i, int j) {
		if (this.DemineurCaseAdjacenteBombe(i, j) < 1){
			this.getDemineurCase(i, j+1).setIsClicked(true);
			if(this.matrice[i][j+1].getTileType() != 1){
				devoileDemineurCaseAdjacente(i,j+1);
			}
		}
	}
	
	public int compterBombes() {
		int killian = 0;
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if(this.getDemineurCase(i, j).getTileType() == 2) {
					killian++;
				}
			}
		}
		return killian;
	}
	
	public int compterDemineurCasesRestantes() {
		int gabriel = 0;
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if(this.getDemineurCase(i, j).getTileType() == 0) {
					if(this.getDemineurCase(i, j).getIsClicked() == true) {
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
						this.getDemineurCase(i, j).setIsFlagged(true);
						this.getDemineurCase(i, j).setDrapeau(!this.getDemineurCase(i, j).getDrapeau());
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
					// Est-ce que la DemineurCase est cliqu�e ?
					if (i == xMat && j == yMat) {
						if(this.getDemineurCase(i, j).getIsFlagged() == false){
							this.matrice[i][j].setIsClicked(true);
							devoileDemineurCaseAdjacente(i,j);
						}
					}
					
					// Si oui on change sa couleur
					if(this.getDemineurCase(i, j).isClicked) {
						g2.setColor(Color.LIGHT_GRAY);
						// Si c'est un bombe, icone bombe
						if(this.getDemineurCase(i, j).getTileType() == 2) {
							if(this.getDemineurCase(i, j).getIsFlagged() == false){
								g2.setColor(Color.red);
							}
						}
					}
					
					// Sinon on laisse un rectangle gris
					if(this.getDemineurCase(i, j).getIsFlagged() == false){
						g2.fillRect(X_ORIGIN + i*(TILE_SIZE+1), Y_ORIGIN + j*(TILE_SIZE+1), TILE_SIZE, TILE_SIZE);
					}
					
					if(this.getDemineurCase(i, j).getTileType() == 2) {
						if(this.getDemineurCase(i, j).getIsFlagged() == false){
							if(this.getDemineurCase(i, j).getIsClicked()) {
								g2.setColor(Color.black);
								g2.fillOval(X_ORIGIN + i*(TILE_SIZE+1)+(TILE_SIZE)/8, Y_ORIGIN + j*(TILE_SIZE+1)+(TILE_SIZE)/8, (TILE_SIZE)*6/8, (TILE_SIZE)*6/8);
							}
						}
					}
					
					int cpt = DemineurCaseAdjacenteBombe(i,j);
					String str = String.valueOf(cpt);
					
					if(cpt != 0) {
						if(this.getDemineurCase(i, j).isClicked) {
							if(this.getDemineurCase(i,j).getTileType() != 2) {
								if(this.getDemineurCase(i, j).getIsFlagged() == false){
									g2.setColor(Color.black);
									g2.drawString(str, X_ORIGIN + i*(TILE_SIZE+1) + TILE_SIZE/2, Y_ORIGIN + j*(TILE_SIZE+1) + TILE_SIZE/2);
								}
							}
						}
					}
					
					if(this.getDemineurCase(i, j).getIsFlagged()) {
						if(this.getDemineurCase(i, j).getDrapeau() == false) {
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
					
					// SET DEFAITE
					if(this.getDefaite() == true) {
						this.getDemineurCase(i,	j).setIsClicked(true);
						Font font2 = new Font("Arial", Font.BOLD, 24);
						g2.setColor(Color.red);
						g2.setFont(font2);
						g2.drawString("DEFAITE", X_ORIGIN, Y_ORIGIN );
						g2.setFont(myFont);
					}
					
					// SET VICTOIRE
					if(this.getVictoire() == true) {
						int compteur = 1;
						this.getDemineurCase(i,	j).setIsClicked(true);
						Font font2 = new Font("Arial", Font.BOLD, 24);
						g2.setColor(Color.green);
						g2.setFont(font2);
						g2.drawString("VICTOIRE", X_ORIGIN, Y_ORIGIN );
						g2.setFont(myFont);
						//ANNEK
						//ICI ON AJOUTE LES POINTS DE LA VICTOIRE
//						if(this.getCompteurPointsVictoire() == 1) {
							try{  
								 System.out.println("testFin");
						    	 //Connexion bdd
								 /*
						    	 Class.forName("com.mysql.cj.jdbc.Driver");  
						    	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_infra","root","");  
						    	 */
								 Class.forName("org.postgresql.Driver");
						    	 Connection con=DriverManager.getConnection("jdbc:postgresql://192.168.4.213:5432/projet_infra","admin","adminadmin5");  
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
								 System.out.println("testError");
						    	 System.out.println(e);
						     }
//						}
						this.setCompteurPointsVictoire(this.getCompteurPointsVictoire() + 1);
						
							
					}
					
					// CONDITION DEFAITE
					if(this.getDemineurCase(i, j).getTileType() == 2) {
						if(this.getVictoire() == false) {
							if (this.getDemineurCase(i, j).getIsClicked()) {
								this.setDefaite(true);
							}
						}
					}
					
					// CONDITION VICTOIRE
					if(this.getDefaite() == false) {
						if(((this.size-2)*(this.size-2) - this.compterBombes()) == this.compterDemineurCasesRestantes()){
							this.setVictoire(true);
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
//			System.out.println("");
//			System.out.println("Drapeau Global : " + this.getFlag());
//			System.out.println("Drapeau Local : " + this.getDemineurCase(xMat,yMat).getDrapeau());
//			System.out.println("Drapeau Local Boolean : " + this.getDemineurCase(xMat,yMat).getIsFlagged());
	    }
		else if(buttonDown == MouseEvent.BUTTON3) {
//			this.setFlag(true);
//			mouseX = e.getX();
//			mouseY = e.getY();
//			xMat = (mouseX - X_ORIGIN)/(TILE_SIZE + BORDER_SIZE);
//			yMat = (mouseY - Y_ORIGIN)/(TILE_SIZE + BORDER_SIZE) -1;
//			System.out.println("");
//			System.out.println("Drapeau Global : " + this.getFlag());
//			System.out.println("Drapeau Local : " + this.getDemineurCase(xMat,yMat).getDrapeau());
//			System.out.println("Drapeau Local Boolean : " + this.getDemineurCase(xMat,yMat).getIsFlagged());
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