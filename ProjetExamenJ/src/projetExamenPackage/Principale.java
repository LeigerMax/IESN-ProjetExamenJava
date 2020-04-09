package projetExamenPackage;

import java.sql.*;
import java.util.*;



import projetExamenPackage.AccessBDGen; 


public class Principale {

	public static void main(String[] args) {
		Fenetre f = new Fenetre();
		
		  
		try {
			ResultSet r�sultats = null;
			String requete = "SELECT * FROM installation";
			Connection connection = AccessBDGen.connecter("DbInstallations","root", "Tigrou007");
			System.out.println("Connexion r�ussi !"); // Etablir la connexion ("le c�ble qui relie le programme Java � la BD")  
			
			 
			Statement stmt = connection.createStatement();
			r�sultats = stmt.executeQuery(requete);
			System.out.println(r�sultats);
			
			
			String sqlInstruction = "insert into FamilleSoftware (IdFamSoft, Libelle)values (?,?)"; 
			PreparedStatement myPrepStat = connection.prepareStatement(sqlInstruction); // Cr�er le PreparedStatement � partir de cette instruction SQL ("chariotsur c�ble")
			myPrepStat.setInt(1,202); // remplacer les ? par valeurs introduites par user (pour �viter lesinjections SQL) 
			myPrepStat.setString(2,"Ma famille Software "); // remplacer les ? par valeurs introduites par user (pour �viter lesinjections SQL) 
			int nbUpdatedLines = myPrepStat.executeUpdate(); // Ex�cuter ("envoyer le chariot � la BD et demander d'ex�cuter l'instruction") 
			System.out.println("Nombre de lignes modifi�es: " + nbUpdatedLines); // R�cup�rer le nombre de lignes modifi�es et l'afficher		
			

	            
		}
			catch (SQLException e) {
			System.out.println(e.getMessage()); }
	
	}
}