package lanceur_jeux;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




//TODO - Relier bouton Démineur à Demineur.java

public class Menu extends JFrame {  
	String path = "image.png";
	public String name;
	
	public Menu() {
		super();
		//Ajout d'un fond d'écran
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
		//Ajout des éléments sur le panel
		this.addButton(this);
	    this.addTitre(panel);
	    this.add(panel);
	    this.setSize(400,400); 
	    this.setVisible(true); 
	    this.setLayout(null);  
	    this.setVisible(true);  
	}
	
	public void addButton(JFrame frame) {
		JButton buttonDemineur=new JButton("Démineur");
	    JButton buttonBattleShip=new JButton("Bataille Navale");
	    buttonDemineur.setBounds(125,100,120,30); 
	    buttonBattleShip.setBounds(125,150,120,30);
	    this.linkButtonDemineur(buttonDemineur);
	    this.linkButtonBattleShip(buttonBattleShip);
	    frame.add(buttonDemineur, BorderLayout.CENTER);  
	    frame.add(buttonBattleShip, BorderLayout.CENTER); 
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void linkButtonDemineur(JButton bouton) {
		bouton.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		    	//TODO - Pour lancer d'autres application, modifier le chemin ci-dessous
		        File file = new File("D:\\Anne-Camille\\Documents\\I2\\Logiciels Et Donnes\\test_demineur.jar");		        
		        Desktop desktop = Desktop.getDesktop();
		        if(file.exists())
					try {
						desktop.open(file);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		    }
		});		
	}

	public void linkButtonBattleShip(JButton bouton) {
		bouton.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		    	System.out.print("ok clic");
		        File file = new File("D:\\Anne-Camille\\Documents\\I2\\Logiciels Et Donnes\\test_battleship.jar");		        
		        Desktop desktop = Desktop.getDesktop();
		        if(file.exists())
					try {
						desktop.open(file);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		    }
		});		
	}

	public void addTitre(JPanel panel) {
		JLabel label = new JLabel(); 
	    label.setText("Menu de jeux"); 
	    label.setForeground(Color.white);
	    label.setFont(new Font("Serif Bold", Font.BOLD, 30));
	    panel.add(label);
	}
	
	
	public static void main(String[] args) {  
	     try{  
	    	 //Connexion bdd
	    	 //Class.forName("com.mysql.cj.jdbc.Driver");  
	    	 Class.forName("org.postgresql.Driver");

	    	 //Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_infra","root","");  
	    	 Connection con=DriverManager.getConnection("jdbc:postgresql://192.168.4.213:5432/projet_infra","admin","adminadmin5");  
	    	    	 
	    	 //Requete SQL
	    	 Statement stmt=con.createStatement();  
	    	 
	    	 //Verification username
	    	 
	    	 //TEST Multiples inputs
	    	 JTextField xField = new JTextField(20);
	    	 JTextField yField = new JPasswordField(20);
	    	 JPanel myPanel = new JPanel();
	    	 myPanel.add(new JLabel("utilisateur:"));
	    	 myPanel.add(xField);
	    	 myPanel.add(Box.createHorizontalStrut(15));   
	    	 myPanel.add(new JLabel("mot de passe:"));
	    	 myPanel.add(yField);
	    	 
	    	 
	    	int result = JOptionPane.showConfirmDialog(null, myPanel,  "Connexion aux mini jeux", JOptionPane.OK_CANCEL_OPTION);
		    String first_name;	    			 
		    first_name = xField.getText();
		    String mdp = yField.getText();
	    	 //Connexion bdd
	    	 ResultSet rs=stmt.executeQuery("select * from utilisateur");  
	    	 while(rs.next()) {
	    		 if(rs.getString(2).equals(first_name) && rs.getString(3).equals(mdp)) {
	    			//Affichage des jeux
	    		     Menu menu = new Menu();
	    		     menu.setName(first_name);
	   	    	 }
	    	 }
	    	 con.close();  
	     }
	     catch(Exception e){ 
	    	 System.out.println(e);
	    }  
	}  

}  