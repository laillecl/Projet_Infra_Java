package game;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.Grille;

public class IHM extends JFrame implements ActionListener{

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
		
		Button reset = new Button("reset");
		reset.setVisible(true);
		this.add(reset);
	}
	
	   public  void    actionPerformed(ActionEvent e){
	        System.out.println("Ici !");
	    }
	
}
