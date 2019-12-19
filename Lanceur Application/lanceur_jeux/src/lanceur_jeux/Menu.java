package lanceur_jeux;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//TODO - Centrer les boutons
//TODO - Ajouter un fond d'écran
//TODO - Relier bouton Démineur à Demineur.java

public class Menu extends JFrame {  
	String path = "image.jpg";
	
	public Menu() {
		super();
		//JPanel panel = new JPanel();
		 
		 //TEST FOND D ECRAN
		
	    JPanel panel = new JPanel(){
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                ImageIcon m = new ImageIcon(path);
                Image monImage = m.getImage();
                g.drawImage(monImage, 0, 0,this);
            }
        };
		panel.repaint();
        
		this.addButton(this);
	    this.addTitre(panel);
	    this.add(panel);
	    this.setSize(400,400); 
	    this.show(); 
	    this.setLayout(null);  
	    this.setVisible(true);  
	}
	
	public void addButton(JFrame frame) {
		JButton buttonDemineur=new JButton("Démineur");
	    JButton buttonBattleShip=new JButton("Bataille Navale");
	    buttonDemineur.setBounds(125,100,120,30); 
	    buttonBattleShip.setBounds(125,150,120,30); 
	    this.linkButton(buttonDemineur);
	    frame.add(buttonDemineur, BorderLayout.CENTER);  
	    frame.add(buttonBattleShip, BorderLayout.CENTER); 
	}
	
	public void linkButton(JButton bouton) {
		bouton.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		        System.out.print("ok ");
		    } 
		});
	}
	
	public void addTitre(JPanel panel) {
		JLabel label = new JLabel(); 
	    label.setText("Menu de jeux"); 
	    label.setFont(new Font("Serif Bold", Font.BOLD, 30));
	    panel.add(label);
	}
	

	public static void main(String[] args) {  
	     new Menu();
	}  
}  