package game;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Button;

import components.Grille;

public class IHM extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static boolean def = false;

	public IHM() {
		this.setTitle("Demineur");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		Grille grille = new Grille();
		this.setContentPane(grille);
		this.addMouseListener(grille);
		
		JRadioButton flag = new JRadioButton("flag");
		this.add(flag);
//		flag.addActionListener(this);
		
		Button reset = new Button("reset");
		reset.setEnabled(false);
		this.add(reset);
	}

	public void checkVictoryStatus() {
		// TODO Auto-generated method stub
		
	}
	
}
