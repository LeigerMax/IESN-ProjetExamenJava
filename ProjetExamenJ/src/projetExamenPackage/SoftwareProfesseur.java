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
		parent = fenetre;
		System.out.println("Softwares utilisés dans les sections ");
		labelTitre = new JLabel("Softwares utilisés dans les sections"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		add(labelTitre); 
		
		comboxChoix = new JComboBox<String>();
		add(comboxChoix);
		
		boutonChoix = new JButton("Afficher");
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
			SqlSelectFrom = "SELECT Nom FROM Software JOIN utilisationsoftware on Software.CodeSoftware = utilisationsoftware.CodeSoftware JOIN anneeetude ON utilisationsoftware.IdAnneeEtude = anneeetude.IdAnneeEtude JOIN section ON anneeetude.CodeSection = section.CodeSection JOIN professeur ON section.CodeSection = professeur.CodeSection WHERE professeur.NomPrenom LIKE '"+(String)comboxChoix.getSelectedItem()+"';";
			System.out.println(SqlSelectFrom);
			AfficherUneTable afficherLaTable  = new AfficherUneTable(parent.getConnect(), SqlSelectFrom);

			
			removeAll();
			
			add(labelTitre,BorderLayout.NORTH);
			add(comboxChoix,BorderLayout.NORTH);
			add(boutonChoix,BorderLayout.NORTH);
			add(afficherLaTable,BorderLayout.CENTER);
			validate();
		}}
	

}
