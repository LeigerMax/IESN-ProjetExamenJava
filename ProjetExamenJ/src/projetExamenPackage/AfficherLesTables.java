package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;



public class AfficherLesTables extends JPanel{
	private JLabel labelTitre;
	private JButton boutonChoix;
	private Fenetre parent;
	private String SqlSelectFrom;
	private JComboBox<String> comboxChoix;
	
	
	AfficherLesTables(Connection connection, Fenetre fenetre) {
		setLayout(null);
		parent = fenetre;
		
		labelTitre = new JLabel("Afficher tableau "); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		labelTitre.setBounds(300,10,450,30); 
		add(labelTitre); 

		
		comboxChoix = new JComboBox<String>();
		comboxChoix.setBounds(270,50,150,30); 
		add(comboxChoix);
		
		boutonChoix = new JButton("Afficher");
		boutonChoix.setBounds(420,50,80,30); 
		add(boutonChoix);
		
		RécupérerNomsTableau(connection);
		
		
		ActionAfficher a = new ActionAfficher();
		boutonChoix.addActionListener(a);
		

		
		setVisible(true);
	}
	
	private void RécupérerNomsTableau(Connection connect) {
		try {
			PreparedStatement prepStat = connect.prepareStatement("SHOW TABLES");
			TableModelGen table2 = AccessBDGen.creerTableModel(prepStat);
			for(int i=0; i <= table2.getRowCount()-1; i++) {
				comboxChoix.addItem((String) table2.getValueAt(i, 0));
				}
			}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
		private class ActionAfficher implements ActionListener{
			public void actionPerformed( ActionEvent a){
				SqlSelectFrom = "SELECT * FROM "+(String)comboxChoix.getSelectedItem()+";";
				AfficherUneTable afficherLaTable  = new AfficherUneTable(parent.getConnect(), SqlSelectFrom);

				
				removeAll();
				
				add(labelTitre);
				add(comboxChoix);
				add(boutonChoix);
				afficherLaTable.setBounds(100,100,600, 400); 
				add(afficherLaTable);
				validate();
			}}


}
