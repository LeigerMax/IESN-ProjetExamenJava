package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import com.mysql.cj.xdevapi.Statement;



public class NouvelleInstallation extends JPanel {
	private JLabel labelTitre, labelIdInstallation,labelDateInstallation, labelTypeInstallation,labelCommentaires,labelDureeInstallation,labelRefProcedureInstallation,labelDateValidation, labelSoftware, labelOS;
	private JTextField zoneTexteIdInstallation,zoneTexteDateInstallation,zoneTexteTypeInstallation, zoneTexteCommentaires, zoneTexteDureeInstallation,zoneTextRefProcedureInstallation, zoneTexteDateValidation; 
	private JComboBox comboxSoftware, comboxOS; 
	private JRadioButton boutonAPrevoir, boutonTerminee,boutonEnCours; 
	private ButtonGroup groupeBoutonValidation; 
	private JPanel  panneauTitre, panneauFormulaire ,panneauBoutonValider,  panneauBoutons ; 
	private JButton boutonRetour, boutonValidation, boutonR�initialiser;   
	
	
	public NouvelleInstallation() {
		this.setLayout(new FlowLayout()); 
		
		 
		labelTitre = new JLabel("Nouvelle installation  "); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,16));
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(labelTitre); 
		
		labelIdInstallation = new JLabel("Id Installation  : "); 
		labelIdInstallation.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(labelIdInstallation); 
		zoneTexteIdInstallation = new JTextField(30); 
		zoneTexteIdInstallation.setEnabled(false);
		this.add(zoneTexteIdInstallation); 
		
		
		
		labelDateInstallation = new JLabel("Date d'Installation  : "); 
		labelDateInstallation.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(labelDateInstallation); 
		zoneTexteDateInstallation = new JTextField(30); 
		this.add(zoneTexteDateInstallation);
		
		
		labelTypeInstallation = new JLabel("Type Installation  : "); 
		labelTypeInstallation.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(labelTypeInstallation); 
		zoneTexteTypeInstallation = new JTextField(30); 
		this.add(zoneTexteTypeInstallation); 
		
		
		
		labelCommentaires = new JLabel("Commentaire  : "); 
		labelCommentaires.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(labelCommentaires); 
		zoneTexteCommentaires = new JTextField(30); 
		this.add(zoneTexteCommentaires); 
		
		
		labelDureeInstallation = new JLabel("Dur�e Installation  : "); 
		labelDureeInstallation.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(labelDureeInstallation); 
		zoneTexteDureeInstallation = new JTextField(30); 
		this.add(zoneTexteDureeInstallation); 
		
		
		labelRefProcedureInstallation = new JLabel("Ref Procedure Installation  : "); 
		labelRefProcedureInstallation.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(labelRefProcedureInstallation); 
		zoneTextRefProcedureInstallation = new JTextField(30); 
		this.add(zoneTextRefProcedureInstallation); 

		
		
		labelDateValidation = new JLabel("Date Validation  : "); 
		labelDateValidation.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(labelDateValidation); 
		zoneTexteDateValidation = new JTextField(30); 
		this.add(zoneTexteDateValidation);
		
		
		String[ ] contenuSoftware = {" "}; //mettre les softwares
		comboxSoftware = new JComboBox(contenuSoftware);
		comboxSoftware.setSelectedItem("");
		comboxSoftware.setMaximumRowCount(3); 
		labelSoftware = new JLabel("SoftWare : "); 
		labelSoftware.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(labelSoftware); 
		this.add(comboxSoftware); 	
		
		String[ ] contenuOS = {" "}; //mettre les OS
		comboxOS = new JComboBox(contenuOS);
		comboxOS.setSelectedItem("");
		comboxOS.setMaximumRowCount(3); 
		labelOS = new JLabel("OS : "); 
		labelOS.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(labelOS); 
		this.add(comboxOS); 	
		
		
		boutonAPrevoir = new JRadioButton("A prevoir",true); 
		this.add(boutonAPrevoir); 
		boutonTerminee = new JRadioButton("Termin�e ",false); 
		this.add(boutonTerminee); 
		boutonEnCours = new JRadioButton("En cours",false); 
		this.add(boutonEnCours);
		groupeBoutonValidation = new ButtonGroup( ); 
		groupeBoutonValidation.add(boutonAPrevoir); 
		groupeBoutonValidation.add(boutonTerminee); 
		groupeBoutonValidation.add(boutonEnCours); 
		
		MonGestionnaireItemRadioValidation gNR = new MonGestionnaireItemRadioValidation( ); 
		boutonAPrevoir.addItemListener(gNR); 
		boutonTerminee.addItemListener(gNR);
		boutonEnCours.addItemListener(gNR);
		
		panneauTitre = new JPanel( );
		panneauTitre.setLayout(new GridLayout( 1, 1, 0, 0 ));
		panneauTitre.add(labelTitre); 
		this.add(panneauTitre,BorderLayout.NORTH);
		
		
		panneauFormulaire = new JPanel( );     
		panneauFormulaire.setLayout(new GridLayout( 10, 2, 0, 0 ));
		panneauFormulaire.add(labelIdInstallation); 
		panneauFormulaire.add(zoneTexteIdInstallation); 
		panneauFormulaire.add(labelDateInstallation); 
		panneauFormulaire.add(zoneTexteDateInstallation); 
		panneauFormulaire.add(labelTypeInstallation); 
		panneauFormulaire.add(zoneTexteTypeInstallation); 
		panneauFormulaire.add(labelCommentaires); 
		panneauFormulaire.add(zoneTexteCommentaires); 
		panneauFormulaire.add(labelDureeInstallation); 
		panneauFormulaire.add(zoneTexteDureeInstallation); 
		panneauFormulaire.add(labelRefProcedureInstallation); 
		panneauFormulaire.add(zoneTextRefProcedureInstallation); 
		panneauFormulaire.add(labelDateValidation); 
		panneauFormulaire.add(zoneTexteDateValidation); 
		panneauFormulaire.add(comboxSoftware); 
		panneauFormulaire.add(labelSoftware); 
		panneauFormulaire.add(comboxOS); 
		panneauFormulaire.add(labelOS); 
		this.add(panneauFormulaire,BorderLayout.CENTER);
		
		panneauBoutonValider = new JPanel( );     
		panneauBoutonValider.setLayout(new GridLayout( 1, 3, 0, 0 ));
		panneauBoutonValider.add(boutonAPrevoir); 
		panneauBoutonValider.add(boutonTerminee); 
		panneauBoutonValider.add(boutonEnCours); 
		this.add(panneauBoutonValider,BorderLayout.CENTER);
		
		
		
		boutonRetour = new JButton(" Retour ");     
		boutonValidation = new JButton(" Validation ");     
		boutonR�initialiser = new JButton(" R�initialiser "); 
		panneauBoutons = new JPanel( );     
		panneauBoutons.add(boutonRetour); 
		panneauBoutons.add(boutonValidation);    
		panneauBoutons.add(boutonR�initialiser);	
		this.add(panneauBoutons,BorderLayout.SOUTH);
	}
	
	
	private class ActionValider implements ActionListener { 
		public void actionPerformed (ActionEvent e) {
			/*
			try {
				Connection connection = AccessBDGen.connecter("DbInstallations","root", "Tigrou007");
				System.out.println("Connexion r�ussi !");
				
				
				String sqlInstruction = "insert into FamilleSoftware (IdFamSoft, Libelle)values (?,?)"; 
				PreparedStatement myPrepStat = connection.prepareStatement(sqlInstruction); 
				myPrepStat.setInt(1,id); 
				myPrepStat.setString(2,nomFamille);  
				int nbUpdatedLines = myPrepStat.executeUpdate();
				System.out.println("Nombre de lignes modifi�es: " + nbUpdatedLines); 
				

			
			}
				catch (SQLException eValider) {
				System.out.println(eValider.getMessage()); }
			*/
		
		}} 
	
	private class MonGestionnaireItemRadioValidation implements ItemListener { 
		 public void itemStateChanged( ItemEvent e) { 
			 
		 }} 
}
