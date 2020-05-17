package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;

public class Suppression extends JPanel {
	private JLabel labelTitre, labelFamilleSoft;
	private JButton boutonAfficherInstall, boutonSupprimerInstall;
	private JComboBox<String> comboFamilleSoft;
	private Fenetre parent;
	private String SqlSelectFrom;
	private AfficherUneTable afficherLaTable;
	
	public  Suppression(Connection connection, Fenetre fenetre) {
		setLayout(null);
		parent = fenetre;

		//Titre
		labelTitre = new JLabel("Supprimer une installation"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		labelTitre.setBounds(245,10,450,30); 
		add(labelTitre); 
		
		//Famillesoft
		labelFamilleSoft = new JLabel("Famille de Software : ");
		labelFamilleSoft.setHorizontalAlignment(SwingConstants.LEFT);
		labelFamilleSoft.setBounds(140, 60, 300, 30);
		add(labelFamilleSoft);
		
		//Combox Famillesoft
		comboFamilleSoft = new JComboBox();
		comboFamilleSoft.setBounds(270, 60, 170, 30);
		comboFamilleSoft.setSelectedItem("");
		comboFamilleSoft.setMaximumRowCount(3);
		add(comboFamilleSoft);
		
		//Bouton afficher
		boutonAfficherInstall = new JButton("AFFICHER"); 
		boutonAfficherInstall.setBounds(460,60,100,30); 
		ActionBoutonAfficher a = new ActionBoutonAfficher();
		boutonAfficherInstall.addActionListener(a);
		add(boutonAfficherInstall);
		
		//Bouton supprimer
		boutonSupprimerInstall = new JButton("SUPPRIMER");
		boutonSupprimerInstall.setBounds(580, 60, 110, 30);
		ActionBoutonSupprimer actionSupprimer = new ActionBoutonSupprimer();
		boutonSupprimerInstall.addActionListener(actionSupprimer);
		add(boutonSupprimerInstall);
		
		RécupérerNomsTableau(connection);


		setVisible(true);
	}
	
	private void RécupérerNomsTableau(Connection connection) {
		try {
			PreparedStatement prepStat = connection.prepareStatement("SELECT libelle FROM familleSoftware;");
			TableModelGen table2 = AccessBDGen.creerTableModel(prepStat);
			for(int i = 0; i <= table2.getRowCount()-1; i++) {
				comboFamilleSoft.addItem((String) table2.getValueAt(i, 0));
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public class ActionBoutonAfficher implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			SqlSelectFrom = "SELECT * FROM installation WHERE DureeInstallation < 120 AND CodeSoftware IN (SELECT CodeSoftware FROM software WHERE IdFamSoft = (SELECT IdFamSoft FROM famillesoftware WHERE libelle LIKE '"+(String)comboFamilleSoft.getSelectedItem()+"'));";
			afficherLaTable = new AfficherUneTable(parent.getConnect(), SqlSelectFrom);
			
			removeAll();
			add(labelTitre);
			add(comboFamilleSoft);
			add(boutonAfficherInstall);
			add(boutonSupprimerInstall);
			afficherLaTable.setBounds(5, 100, 775, 400);
			add(afficherLaTable);
			validate();
		}
	}
	
	public class ActionBoutonSupprimer implements ActionListener{
		public void actionPerformed(ActionEvent b){
			int choix=0;
			String SelectInstallation = "select * from installation where DureeInstallation < 120 and CodeSoftware in (select CodeSoftware from software where IdFamSoft = (select IdFamSoft from famillesoftware where libelle like '"+(String)comboFamilleSoft.getSelectedItem()+"'));";
  
			try {
				choix = JOptionPane.showConfirmDialog(null, "Confirmer ?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);

				if(choix == 0) {
					int[] SelectedRows=afficherLaTable.getTable().getSelectedRows();
					if(SelectedRows.length > 0 ) {
						for(int i=0;i<SelectedRows.length;i++) {
							int idInstallation = ((Integer)afficherLaTable.getTable().getModel().getValueAt(SelectedRows[i],0)).intValue();	
				            		String deleteInstallaion = "delete from installation where IdInstallation = "+idInstallation+";";

							Statement stmt=parent.getConnect().createStatement();
							stmt.executeUpdate(deleteInstallaion);
						}
						afficherLaTable = new AfficherUneTable(parent.getConnect(), SelectInstallation);
						removeAll();
						add(afficherLaTable);
						add(labelTitre);
						add(comboFamilleSoft);
						add(boutonAfficherInstall);
						add(boutonSupprimerInstall);
						afficherLaTable.setBounds(5, 100, 775, 400);
						add(afficherLaTable);
						validate();
					}else {
					JOptionPane.showMessageDialog(null,"Veillez sélectionner une installation",null, JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}