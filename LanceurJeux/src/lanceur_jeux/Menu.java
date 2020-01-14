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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




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
	    this.linkButton(buttonDemineur);
	    frame.add(buttonDemineur, BorderLayout.CENTER);  
	    frame.add(buttonBattleShip, BorderLayout.CENTER); 
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void linkButton(JButton bouton) {
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
	    	 Class.forName("com.mysql.cj.jdbc.Driver");  
	    	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_infra","root","");  
	    	 
	    	 //Requete SQL
	    	 Statement stmt=con.createStatement();  
	    	 
	    	 //Verification username
	    	 String first_name;	    			 
	    	 first_name = JOptionPane.showInputDialog("Entrez votre nom d'utilisateur");
	    	 
	    	 //Connexion bdd
	    	 ResultSet rs=stmt.executeQuery("select * from utilisateur");  
	    	 while(rs.next()) {
	    		 if(rs.getString(2).equals(first_name)) {
	    			//Affichage des jeux
	    		     Menu menu = new Menu();
	    		     menu.setName(first_name);
	   	    	 }
	    	 }
	    	 con.close();  

	    	 //TODO - Regarder lien HTTP/JAVA (postman), HTML lien PHP, PHP, lien BDD
	     }
	     catch(Exception e){ 
	    	 System.out.println(e);
	    }  
	}  

}  