package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AfficherLesTables extends JPanel{
	private JLabel labelTitre;
	
	AfficherLesTables(Connection connection) {
		System.out.println("Test lecture");
		labelTitre = new JLabel("Lecture tableau"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		add(labelTitre); 
		
		try {
			PreparedStatement prepStat = connection.prepareStatement("select * from installation;");
			TableModelGen tableInstallation = AccessBDGen.creerTableModel(prepStat);
		 	JTable JTabletableInstallation = new JTable(tableInstallation); 
		 	JTabletableInstallation.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		 	JScrollPane defilant = new JScrollPane (JTabletableInstallation) ;
		 	defilant.setPreferredSize(new Dimension(750, 400));
		 	add(defilant);
			}
		
		catch(SQLException e) {	
			System.out.println(e.getMessage());
		}
		
		setVisible(true);
	}

}
