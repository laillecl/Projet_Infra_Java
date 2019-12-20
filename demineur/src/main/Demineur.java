package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import grille.Coordonnee;

public class Demineur {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setSize(500,500);
		
		Coordonnee c1 = new Coordonnee();
		c1.setX(30);
		System.out.print(c1.getY());
		
		
	}
}
