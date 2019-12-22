package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import components.Grille;

public class GameManager {
	
	// Frame instance
	private static JFrame frame;
	
	public void setUpWindow() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(900, 640));
		frame.setMinimumSize(new Dimension(900, 640));
		frame.setResizable(false);
		frame.setTitle("Demineur");
		frame.pack();
	}
	
	public static void InitJeu() {		
		Grille grille = new Grille();
//		frame.setVisible(true);
		
	}

}
