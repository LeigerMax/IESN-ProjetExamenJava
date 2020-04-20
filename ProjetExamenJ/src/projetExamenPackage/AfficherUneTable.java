package projetExamenPackage;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;



public class AfficherUneTable extends JPanel {
	private static JTable table2;
	
	public AfficherUneTable(Connection connection, String SqlSelectFrom) {
		try {
			PreparedStatement prepStat = connection.prepareStatement(SqlSelectFrom);
			TableModelGen table = AccessBDGen.creerTableModel(prepStat);
		 	table2 = new JTable(table);

		 	JScrollPane defilant = new JScrollPane (table2) ;
		 	defilant.setPreferredSize(new Dimension(775, 400));
		 	this.add(defilant);
			}
		catch(SQLException e) {	}
		
		setVisible(true);
		}
	
}
