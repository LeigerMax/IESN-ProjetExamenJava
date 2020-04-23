package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;

public class Suppression extends JPanel {
	private JLabel labelTitre, labelFamilleSoft;
	private JButton affInstall, supInstall;
	private JComboBox<String> familleSoft;
	private Fenetre parent;
	private String SqlSelectFrom;
	
	public  Suppression(Connection connection, Fenetre fenetre) {
		setLayout(null);
		parent = fenetre;

		labelTitre = new JLabel("Supprimer une installation"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		labelTitre.setBounds(245,10,450,30); 
		add(labelTitre); 
		
		labelFamilleSoft = new JLabel("Famille de Software : ");
		labelFamilleSoft.setHorizontalAlignment(SwingConstants.LEFT);
		labelFamilleSoft.setBounds(140, 60, 300, 30);
		add(labelFamilleSoft);
		
		familleSoft = new JComboBox();
		familleSoft.setBounds(270, 60, 170, 30);
		familleSoft.setSelectedItem("");
		familleSoft.setMaximumRowCount(3);
		add(familleSoft);
		
		affInstall = new JButton("AFFICHER"); 
		affInstall.setBounds(460,60,100,30); 
		ActionBoutonAfficher a = new ActionBoutonAfficher();
		affInstall.addActionListener(a);
		add(affInstall);
		
		supInstall = new JButton("SUPPRIMER");
		supInstall.setBounds(580, 60, 110, 30);
		//ActionSupprimer b = new ActionSupprimer();
		//supInstall.addActionListener(b);
		add(supInstall);
		
		RécupérerNomsTableau(connection);


		setVisible(true);
	}
	
	private void RécupérerNomsTableau(Connection connection) {
		try {
			PreparedStatement prepStat = connection.prepareStatement("SELECT libelle FROM familleSoftware;");
			TableModelGen table2 = AccessBDGen.creerTableModel(prepStat);
			for(int i = 0; i <= table2.getRowCount()-1; i++) {
				familleSoft.addItem((String) table2.getValueAt(i, 0));
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public class ActionBoutonAfficher implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			SqlSelectFrom = "SELECT *  FROM installation JOIN software ON installation.CodeSoftware = software.CodeSoftware JOIN famillesoftware ON software.IdFamSoft = famillesoftware.IdFamSoft WHERE famillesoftware.libelle LIKE '"+(String)familleSoft.getSelectedItem()+"' AND DureeInstallation < 120;";
			AfficherUneTable afficherLaTable = new AfficherUneTable(parent.getConnect(), SqlSelectFrom);
			
			removeAll();
			
			add(labelTitre);
			add(familleSoft);
			add(affInstall);
			add(supInstall);
			afficherLaTable.setBounds(5, 100, 775, 400);
			add(afficherLaTable);
			validate();
		}
	}
	
	public class ActionBoutonSupprimer implements ActionListener{
		public void actionPerformed(ActionEvent b) {
			//Pas correct
			SqlSelectFrom = "DELETE * FROM" + (String)familleSoft.getSelectedItem()+";";
			AfficherUneTable afficherLaTable = new AfficherUneTable(parent.getConnect(), SqlSelectFrom);
			
			removeAll();
			
			add(labelTitre);
			add(familleSoft);
			add(affInstall);
			add(supInstall);
			afficherLaTable.setBounds(5, 100, 775, 400);
			add(afficherLaTable);
			validate();
		}
	}

}
