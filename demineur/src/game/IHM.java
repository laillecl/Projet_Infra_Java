package game;

import javax.swing.JFrame;

import components.Grille;

public class IHM extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IHM() {
		this.setTitle("Demineur");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		Grille grille = new Grille();
		this.setContentPane(grille);
		this.addMouseListener(grille);
	}

}
