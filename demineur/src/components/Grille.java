package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Grille extends JPanel implements MouseListener{
	
	public int nbBombes;
	public int tailleGrille;
	
	public Grille(int nbBombes, int tailleGrille) {
		this.nbBombes = nbBombes;
		this.tailleGrille = tailleGrille;
	}
		
	public Grille() {
		this.nbBombes = 10;
		this.tailleGrille = 10;
	}
		
	@Override	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// draw grid background image
		
		// loops through all spots in the grid
		g2.setColor(Color.gray);
		g2.fillRect(13,50,100,125);
		
	}
	
	
	
	
	
	
	public void setnbBombes(int nbBombes) {
		this.nbBombes = nbBombes;
	}
	
	public int nbBombes() {
		return this.nbBombes;
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
	
}
