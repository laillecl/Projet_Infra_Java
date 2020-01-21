package game;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.Grille;

public class IHMDemineur extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IHMDemineur() {
		this.setTitle("Demineur");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		Grille grille = new Grille();
		this.setContentPane(grille);
		this.addMouseListener(grille);
		
		Button reset = new Button("Recommencer");
		reset.setVisible(true);
		this.add(reset);
	}
	
	   public  void    actionPerformed(ActionEvent e){
	        System.out.println("Ici !");
	    }
	
}
