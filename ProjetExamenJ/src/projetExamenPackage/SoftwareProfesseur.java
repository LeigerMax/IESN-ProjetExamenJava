package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;


public class SoftwareProfesseur extends JPanel{
	private JLabel labelTitre;
	private JButton boutonChoix;
	private Fenetre parent;
	private String SqlSelectFrom;
	private JComboBox<String> comboxChoix;
	
	public  SoftwareProfesseur(Connection connection, Fenetre fenetre) {
		setLayout(null);
		parent = fenetre;

		
		labelTitre = new JLabel("Softwares utilisés dans les sections"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		labelTitre.setBounds(220,10,450,30); 
		add(labelTitre); 
		
		comboxChoix = new JComboBox<String>();
		comboxChoix.setBounds(250,50,150,30); 
		add(comboxChoix);
		
		boutonChoix = new JButton("Afficher");
		boutonChoix.setBounds(400,50,80,30); 
		add(boutonChoix);
		
		RécupérerNomsTableau(connection);
		
		ActionAfficher a = new ActionAfficher();
		boutonChoix.addActionListener(a);
		
		setVisible(true);
	}
	
	private void RécupérerNomsTableau(Connection connect) {
		try {
			PreparedStatement prepStat = connect.prepareStatement("select NomPrenom from professeur;");
			TableModelGen table2 = AccessBDGen.creerTableModel(prepStat);
			for(int i=0; i <= table2.getRowCount()-1; i++) {
				comboxChoix.addItem((String) table2.getValueAt(i, 0));
				}
			}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}}
	
	private class ActionAfficher implements ActionListener{
		public void actionPerformed( ActionEvent a){
			SqlSelectFrom = "SELECT DISTINCT Nom FROM Software JOIN utilisationsoftware on Software.CodeSoftware = utilisationsoftware.CodeSoftware JOIN anneeetude ON utilisationsoftware.IdAnneeEtude = anneeetude.IdAnneeEtude JOIN section ON anneeetude.CodeSection = section.CodeSection JOIN professeur ON section.CodeSection = professeur.CodeSection WHERE professeur.NomPrenom LIKE '"+(String)comboxChoix.getSelectedItem()+"';";
			AfficherUneTable afficherLaTable  = new AfficherUneTable(parent.getConnect(), SqlSelectFrom);

			
			removeAll();
			
			add(labelTitre);
			add(comboxChoix);
			add(boutonChoix);
			afficherLaTable.setBounds(5,100,775, 400); 
			add(afficherLaTable);
			validate();
		}}
	

}
