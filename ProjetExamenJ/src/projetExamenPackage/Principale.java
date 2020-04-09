package projetExamenPackage;

import java.sql.*;
import java.util.*;



import projetExamenPackage.AccessBDGen; 


public class Principale {

	public static void main(String[] args) {
		Fenetre f = new Fenetre();
		
		  
		try {
			ResultSet résultats = null;
			String requete = "SELECT * FROM installation";
			Connection connection = AccessBDGen.connecter("DbInstallations","root", "Tigrou007");
			System.out.println("Connexion réussi !"); // Etablir la connexion ("le câble qui relie le programme Java à la BD")  
			
			 
			Statement stmt = connection.createStatement();
			résultats = stmt.executeQuery(requete);
			System.out.println(résultats);
			
			
			String sqlInstruction = "insert into FamilleSoftware (IdFamSoft, Libelle)values (?,?)"; 
			PreparedStatement myPrepStat = connection.prepareStatement(sqlInstruction); // Créer le PreparedStatement à partir de cette instruction SQL ("chariotsur câble")
			myPrepStat.setInt(1,202); // remplacer les ? par valeurs introduites par user (pour éviter lesinjections SQL) 
			myPrepStat.setString(2,"Ma famille Software "); // remplacer les ? par valeurs introduites par user (pour éviter lesinjections SQL) 
			int nbUpdatedLines = myPrepStat.executeUpdate(); // Exécuter ("envoyer le chariot à la BD et demander d'exécuter l'instruction") 
			System.out.println("Nombre de lignes modifiées: " + nbUpdatedLines); // Récupérer le nombre de lignes modifiées et l'afficher		
			

	            
		}
			catch (SQLException e) {
			System.out.println(e.getMessage()); }
	
	}
}