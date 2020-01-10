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
	
	boolean def = false;

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
		flag.addActionListener(this);
		
		Button reset = new Button("reset");
		reset.setEnabled(false);
		this.add(reset);
		
<<<<<<< HEAD
//		if (flag.isSelected()){
//			System.out.println("AaaaAAAs");
//			if(grille.getDrapo() == false) {
//				grille.setDrapo(true);
//			}
//			else {
//				grille.setDrapo(false);
//			}
//		    
//		}   
//		
//		if (res = true) {
//			grille.reset();
//			res = false;
//		}
=======
		this.setVisible(true);
		
		boolean fin = grille.getDefaite();
		if (fin) {
			this.setDef(true);
		}
>>>>>>> parent of 93960df... test Flag
		
		
		
	}
<<<<<<< HEAD

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == flag) {
			
			
		}
		res = true;
		System.out.println(res);
=======
	
	private void setDef(boolean b) {
		this.def = b;
		
	}

	public boolean getDef() {
		return this.def;
>>>>>>> parent of 93960df... test Flag
	}

	public void checkVictoryStatus() {
		// TODO Auto-generated method stub
		
	}
	
}
