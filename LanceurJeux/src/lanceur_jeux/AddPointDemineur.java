package lanceur_jeux;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddPointDemineur {
	ResultSet rs;
	Statement stmt;
	Connection con;
	String name;
	

	public AddPointDemineur(String name){
		System.out.print("test");
		this.name = name;
	}
	
	public void ajouterPoints() {
		this.connexionBDD();
	}

	void connexionBDD() {
		try{  
	    	 //Connexion bdd
	    	 Class.forName("com.mysql.cj.jdbc.Driver");  
	    	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_infra","root","");  
	    	 this.ajoutPointsBDD(con);  
	     }
	     catch(Exception e){ 
	    	 System.out.println(e);
	    }  
	}
	
	void ajoutPointsBDD(Connection con) {
	   	 try {
			stmt=con.createStatement();
			//On r�cup�re l'ancienne valeur du score
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT score FROM utilisateur WHERE user_name = " + this.name);
			int scoreAvant = rs.getInt(5);
			System.out.println(scoreAvant);
			rs.close();
			stmt.close();
			
			/*
			//On set le score
			PreparedStatement ps = con.prepareStatement("UPDATE utilisateur SET score = ? WHERE user_name = ?");
			//TODO - AJOUTER LES POINTS, ICI ON CHANGE JUSTE LA VALEUR
			ps.setInt(1, 5);
			ps.setString(2, this.name);
			ps.executeUpdate();
			ps.close();
		   	con.close();
		   	*/
		} catch (SQLException e) {
			e.printStackTrace();
		}  
	}
}