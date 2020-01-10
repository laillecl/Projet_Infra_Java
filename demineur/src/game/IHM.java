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
	
	boolean res = false;
	boolean gabriel = false;

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
		
		Button reset = new Button("reset");
		reset.setEnabled(true);
		reset.addActionListener(this);
		this.add(reset);
		this.setVisible(true);
		
		if (flag.isSelected()){
			System.out.println("AaaaAAAs");
			if(grille.getDrapo() == false) {
				grille.setDrapo(true);
			}
			else {
				grille.setDrapo(false);
			}
		    
		}   
		
		if (res = true) {
			grille.reset();
			res = false;
		}
		
	}
	
	public void itemStateChanged() {
		System.out.println("La");
	}

	public void actionPerformed(ActionEvent e) {
		res = true;
		System.out.println(res);
	}
}
