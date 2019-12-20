package ihm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AfficheGrille extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame frame = new JFrame();
	public static final int LARGEUR_PAR_DEFAUT = 500;
	public static final int HAUTEUR_PAR_DEFAUT = 500;
	public static final java.awt.Color COULEUR_FOND_PAR_DEFAUT = Color.white;
	
	public AfficheGrille() {
		super.setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT));
		super.setBackground(COULEUR_FOND_PAR_DEFAUT);
//		this.outilCourant = null;
	}

}


