package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;


public class SoftwareProfesseur extends JPanel{
	private JLabel labelTitre;
	private JButton boutonAfficher;
	private Fenetre fenetreParent;
	private String SqlSelectFrom;
	private JComboBox<String> comboChoix;
	
	public  SoftwareProfesseur(Connection connection, Fenetre fenetre) {
		
		setLayout(null);
		fenetreParent = fenetre;

		//Titre
		labelTitre = new JLabel("Softwares utilisés dans les sections"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		labelTitre.setBounds(220,10,450,30); 
		add(labelTitre); 
		
		//Combo Choix
		comboChoix = new JComboBox<String>();
		comboChoix.setBounds(250,50,150,30); 
		add(comboChoix);
		
		RécupérerNomsTableau(connection);
		
		//Bouton afficher
		boutonAfficher = new JButton("Afficher");
		boutonAfficher.setBounds(400,50,80,30); 
		add(boutonAfficher);
		
		ActionAfficherTable actionAfficherTable = new ActionAfficherTable();
		boutonAfficher.addActionListener(actionAfficherTable);
		
		setVisible(true);
	}
	
	private void RécupérerNomsTableau(Connection connect) {
		try {
			PreparedStatement prepStat = connect.prepareStatement("select NomPrenom from professeur;");
			TableModelGen table = AccessBDGen.creerTableModel(prepStat);
			for(int i=0; i <= table.getRowCount()-1; i++) {  
				comboChoix.addItem((String) table.getValueAt(i, 0));
				}
			}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private class ActionAfficherTable implements ActionListener{
		public void actionPerformed(ActionEvent a){
			SqlSelectFrom = "select distinct Nom from Software join utilisationsoftware on Software.CodeSoftware = utilisationsoftware.CodeSoftware join anneeetude on utilisationsoftware.IdAnneeEtude = anneeetude.IdAnneeEtude join section on anneeetude.CodeSection = section.CodeSection join professeur on section.CodeSection = professeur.CodeSection where professeur.NomPrenom like '"+(String)comboChoix.getSelectedItem()+"';";
			AfficherUneTable afficherLaTable  = new AfficherUneTable(fenetreParent.getConnect(), SqlSelectFrom);
			
			removeAll();	
			add(labelTitre);
			add(comboChoix);
			add(boutonAfficher);
			afficherLaTable.setBounds(5,100,775,400); 
			add(afficherLaTable);
			validate();
		}
	}
}
