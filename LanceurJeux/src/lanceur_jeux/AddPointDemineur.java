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
	int scoreAvant;
	

	public AddPointDemineur(String name){
		this.name = name;
	}
	
	public void ajouterPoints() {
		this.connexionBDD();
	}

	void connexionBDD() {
		try{  
	    	 //Connexion bdd
			/*
	    	 Class.forName("com.mysql.cj.jdbc.Driver");  
	    	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_infra","root",""); 
	    	 */
			Class.forName("org.postgresql.Driver");
	    	 Connection con=DriverManager.getConnection("jdbc:postgresql://192.168.4.213:5432/projet_infra","admin","adminadmin5");
	    	 this.ajoutPointsBDD(con);  
	     }
	     catch(Exception e){ 
	    	 System.out.println(e);
	    }  
	}
	
	void ajoutPointsBDD(Connection con) {
	   	 try {
			stmt=con.createStatement();
			//On récupère l'ancienne valeur du score
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from utilisateur");  
	    	 while(rs.next()) {
	    		 if(rs.getString(2).equals(this.name)) {
	    			 scoreAvant = rs.getInt(5);
	   	    	 }
	    	 }			
			rs.close();
			stmt.close();
			
			//On set le score
			PreparedStatement ps = con.prepareStatement("UPDATE utilisateur SET score = ? WHERE user_name = ?");
			//TODO - AJOUTER LES POINTS, ICI ON CHANGE JUSTE LA VALEUR
			int nouveauScore = this.scoreAvant + 5;
			ps.setInt(1, nouveauScore);
			ps.setString(2, this.name);
			ps.executeUpdate();
			ps.close();
		   	con.close();
		   	
		} catch (SQLException e) {
			e.printStackTrace();
		}  
	}
}
