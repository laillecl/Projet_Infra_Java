package Game;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Button;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Components.DemineurGrille;

public class DemineurIHM extends JFrame implements ActionListener{
	
	DemineurGrille demineurGrille = new DemineurGrille();
	Button reset = new Button("Recommencer");
	JRadioButton facile = new JRadioButton("facile");
	JRadioButton moyen = new JRadioButton("moyen");
	JRadioButton difficile = new JRadioButton("difficile");
	JLabel dif = new JLabel("Choisissez la difficulté : ");

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DemineurIHM() {
		this.setTitle("Demineur");
		this.setSize(500,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		demineurGrille.add(reset);
		reset.setVisible(true);
		reset.addActionListener(this);
		
		demineurGrille.add(dif);
		
		ButtonGroup difficulte = new ButtonGroup();
		difficulte.add(facile);
		difficulte.add(moyen);
		difficulte.add(difficile);
		moyen.setSelected(true);
		
		demineurGrille.add(facile);
		demineurGrille.add(moyen);
		demineurGrille.add(difficile);

		this.setContentPane(demineurGrille);
		this.addMouseListener(demineurGrille);

	}
	
	public  void    actionPerformed(ActionEvent e){
		demineurGrille.resetMatrice();
		if(facile.isSelected()) {
			demineurGrille.setPourcentageBombes(5);
		}
		else if(moyen.isSelected()) {
			demineurGrille.setPourcentageBombes(11);
		}
		else {
			demineurGrille.setPourcentageBombes(17);
		}
	}
	
}
