package projetExamenPackage;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;



public class AfficherUneTable extends JPanel {
	private static JTable table2;
	JTable getTable() {return table2;}
	
	public AfficherUneTable(Connection connection, String SqlSelectFrom) {
		try {
			PreparedStatement prepStat = connection.prepareStatement(SqlSelectFrom);
			TableModelGen table = AccessBDGen.creerTableModel(prepStat);
			table2 = new JTable(table);
			table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Obtenir un meilleur affiche des tableaux
			table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Permettre à l'user de ne sélectionner qu'une seule ligne
			JScrollPane defilant = new JScrollPane (table2) ;
		 	defilant.setPreferredSize(new Dimension(775, 400));
		 	this.add(defilant);
			}
		catch(SQLException e) {	}
		
		setVisible(true);
		}
	
}
