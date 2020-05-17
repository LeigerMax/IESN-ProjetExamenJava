package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import accessBD.*;


public class NouvelleInstallation extends JPanel {
	private JLabel labelTitre,labelObliger, labelIdInstallation,labelDateInstallation, labelTypeInstallation,labelCommentaires,labelDureeInstallation,labelRefProcedureInstallation,labelValidation,labelDateValidation, labelSoftware,labelMatricule, labelOS,labelAjoutReussi, labelAnnuler;
	private JTextField zoneTexteIdInstallation, zoneTexteCommentaires,zoneTextRefProcedureInstallation; 
	private JComboBox<String> comboBoxTypeInstallation,comboxSoftware,comboxMatricule,comboxOS;
	private String[] listeTypeBool = {"Standard","Personnalis�e"};
	private JSpinner spinnerDureeInstallation;
	private SpinnerNumberModel modelSpinner;
	private JRadioButton boutonAPrevoir, boutonTerminee,boutonEnCours; 
	private JPanel panneauTitre, panneauFormulaire,panneauBoutons, panneauValidation; 
	private ButtonGroup boutonGroupe; 
	private String SqlInto, SqlDelete;
	private String choixBouton = "Termin�e";
	private ComboxDate panneauDateInstallation,panneauDateAPrevoir;
	private Integer anulation = 0;

	
	public NouvelleInstallation(Connection connection, Fenetre fenetre) {
		setLayout(new FlowLayout()); 
		
		//Titre
		labelTitre = new JLabel("Nouvelle installation : "); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
		labelObliger = new JLabel("Veillez remplir les champs obligatoire  : * "); 
		labelObliger.setFont(new java.awt.Font(Font.SERIF,Font.ITALIC,15));
		
		panneauTitre = new JPanel( );     
		panneauTitre.setLayout(new GridLayout( 2, 1, 0, 0 ));
		panneauTitre.add(labelTitre);
		panneauTitre.add(labelObliger);
		add(panneauTitre);
		

		// IdInstallation
		labelIdInstallation = new JLabel("Id Installation  : "); 
		labelIdInstallation.setHorizontalAlignment(SwingConstants.RIGHT);
		zoneTexteIdInstallation = new JTextField(5); 
		zoneTexteIdInstallation.setEnabled(false);
		
		R�cup�rerIdInstallation(connection);
		
		//Date
		labelDateInstallation = new JLabel("* Date d'installation  : "); 
		labelDateInstallation.setHorizontalAlignment(SwingConstants.RIGHT);
		panneauDateInstallation = new ComboxDate();
		
		//Type d'installation : bool�en pr�cisant si installation standard ou personnalis�e 
		labelTypeInstallation = new JLabel("* Type d'installation  : "); 
		labelTypeInstallation.setHorizontalAlignment(SwingConstants.RIGHT);
		comboBoxTypeInstallation = new JComboBox<String>(listeTypeBool);
	
		//Commentaires PAS OBLIGATOIRE
		labelCommentaires = new JLabel("Commentaire  : "); 
		labelCommentaires.setHorizontalAlignment(SwingConstants.RIGHT);
		zoneTexteCommentaires = new JTextField(25); 

		
		//Duree Installation PAS OBLIGATOIRE
		labelDureeInstallation = new JLabel("* Dur�e Installation  : "); 
		labelDureeInstallation.setHorizontalAlignment(SwingConstants.RIGHT);
		modelSpinner = new SpinnerNumberModel(0,0,86400,1);
		spinnerDureeInstallation = new JSpinner(modelSpinner);
		spinnerDureeInstallation.setEditor(new JSpinner.DefaultEditor(spinnerDureeInstallation));
		
		//RefProcedureInstallation 
		labelRefProcedureInstallation = new JLabel("Ref Procedure Installation  : "); 
		labelRefProcedureInstallation.setHorizontalAlignment(SwingConstants.RIGHT);
		zoneTextRefProcedureInstallation = new JTextField(25); 
		
		//Validation  
		labelValidation = new JLabel("* Validation : "); 
		labelValidation.setHorizontalAlignment(SwingConstants.RIGHT);
		boutonAPrevoir = new JRadioButton("A prevoir",false); 
		boutonTerminee = new JRadioButton("Termin�e",true); 
		boutonEnCours = new JRadioButton("En cours",false); 

		boutonGroupe = new ButtonGroup();
		boutonGroupe.add(boutonAPrevoir);
		boutonGroupe.add(boutonTerminee);
		boutonGroupe.add(boutonEnCours);
		
		ItemRadioValidation gNR = new ItemRadioValidation( ); 
		boutonAPrevoir.addItemListener(gNR); 
		boutonTerminee.addItemListener(gNR); 
		boutonEnCours.addItemListener(gNR); 

		panneauValidation= new JPanel( );
		panneauValidation.setLayout(new GridLayout( 1, 3, 0, 0 ));
		panneauValidation.add(boutonAPrevoir); 
		panneauValidation.add(boutonTerminee); 
		panneauValidation.add(boutonEnCours); 

		//DateValidation PAS OBLIGATOIRE UNIQUEMENT SI VALIDATION EST A PREVOIR
		labelDateValidation = new JLabel("Date Validation : "); 
		labelDateValidation.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDateValidation.setVisible(false);	
		panneauDateAPrevoir = new ComboxDate();
		panneauDateAPrevoir.setVisible(false);
		
		//Software  Matricule Os
		labelSoftware = new JLabel("* Software  : ");
		labelSoftware.setHorizontalAlignment(SwingConstants.RIGHT);
		comboxSoftware = new JComboBox<String>();
		labelMatricule = new JLabel("* Matricule  : "); 
		labelMatricule.setHorizontalAlignment(SwingConstants.RIGHT);
		comboxMatricule = new JComboBox<String>();
		labelOS = new JLabel("* OS : "); 
		labelOS.setHorizontalAlignment(SwingConstants.RIGHT);
		comboxOS = new JComboBox<String>();
		
		R�cup�rerSoftwareMatriculeOs(connection);		

		//Bouton
		BoutonInsertion boutonInsertion = new BoutonInsertion(this,connection);
		BoutonAnnulation boutonAnnulation = new BoutonAnnulation(this,connection);
		
		panneauBoutons = new JPanel( );     
		panneauBoutons.setLayout(new GridLayout( 1, 2, 0, 0 ));
		panneauBoutons.add(boutonInsertion);
		panneauBoutons.add(boutonAnnulation);
		
		//Ajout r�ussi
		labelAjoutReussi = new JLabel("Ajout r�ussi ! "); 
		labelAjoutReussi.setForeground(Color.red);
		labelAjoutReussi.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAjoutReussi.setVisible(false);
		
		//Annuler
		labelAnnuler = new JLabel("Annulation r�ussi ! "); 
		labelAnnuler.setForeground(Color.red);
		labelAnnuler.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAnnuler.setVisible(false);
		
		//panneauFormulaire
		panneauFormulaire = new JPanel( );     
		panneauFormulaire.setLayout(new GridLayout( 11, 2, 10, 1 ));
		panneauFormulaire.add(labelIdInstallation); 
		panneauFormulaire.add(zoneTexteIdInstallation); 
		panneauFormulaire.add(labelDateInstallation); 
		panneauFormulaire.add(panneauDateInstallation); 
		panneauFormulaire.add(labelTypeInstallation); 
		panneauFormulaire.add(comboBoxTypeInstallation); 
		panneauFormulaire.add(labelCommentaires); 
		panneauFormulaire.add(zoneTexteCommentaires); 
		panneauFormulaire.add(labelDureeInstallation); 
		panneauFormulaire.add(spinnerDureeInstallation); 
		panneauFormulaire.add(labelRefProcedureInstallation); 
		panneauFormulaire.add(zoneTextRefProcedureInstallation); 
		panneauFormulaire.add(labelValidation); 
		panneauFormulaire.add(panneauValidation); 
		panneauFormulaire.add(labelDateValidation); 
		panneauFormulaire.add(panneauDateAPrevoir);
		panneauFormulaire.add(labelSoftware); 
		panneauFormulaire.add(comboxSoftware); 
		panneauFormulaire.add(labelMatricule); 
		panneauFormulaire.add(comboxMatricule); 
		panneauFormulaire.add(labelOS); 
		panneauFormulaire.add(comboxOS); 
		add(panneauFormulaire);
		
		//Add panneauBoutons et les labels
		add(panneauBoutons);
		add(labelAjoutReussi); ; 
		add(labelAnnuler);

		setVisible(true);
	}
	

	
	private void R�cup�rerIdInstallation(Connection connection) {
		try {
			PreparedStatement prepStat = connection.prepareStatement("select MAX(IdInstallation) from installation ;");
			TableModelGen idInsallation = AccessBDGen.creerTableModel(prepStat);
			Integer idPlusHaut = (Integer) idInsallation.getValueAt(0, 0) + 1;
			zoneTexteIdInstallation.setText(""+idPlusHaut);
			}
		catch(SQLException e) {
			//JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private void R�cup�rerSoftwareMatriculeOs(Connection connection) {
		try {
			PreparedStatement prepStatSoftware = connection.prepareStatement("select Nom from Software;");
			PreparedStatement prepStatMatricule = connection.prepareStatement("select NomPrenom from ResponsableReseaux;");
			PreparedStatement prepStatOS = connection.prepareStatement("select Libelle from OS;");
			TableModelGen tableSoftware = AccessBDGen.creerTableModel(prepStatSoftware);
			TableModelGen tableMatricule = AccessBDGen.creerTableModel(prepStatMatricule);
			TableModelGen tableOS = AccessBDGen.creerTableModel(prepStatOS);
			for(int i=0; i <= tableSoftware.getRowCount()-1; i++) {
				comboxSoftware.addItem((String) tableSoftware.getValueAt(i, 0));
				}
			for(int i=0; i <= tableMatricule.getRowCount()-1; i++) {
				comboxMatricule.addItem((String) tableMatricule.getValueAt(i, 0));
				}
			for(int i=0; i <= tableOS.getRowCount()-1; i++) {
				comboxOS.addItem((String) tableOS.getValueAt(i, 0));
				}
			}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	private class ItemRadioValidation implements ItemListener { 
		 public void itemStateChanged(ItemEvent e) { 
			 if(e.getSource()==boutonAPrevoir && e.getStateChange()==ItemEvent.SELECTED) {
				 panneauDateAPrevoir.setVisible(true);
				 labelDateValidation.setVisible(true);
				 choixBouton ="A prevoir";
				}
			 else if(e.getSource()==boutonTerminee && e.getStateChange()==ItemEvent.SELECTED) {
				 panneauDateAPrevoir.setVisible(false);
				 labelDateValidation.setVisible(false);
				 choixBouton = "Termin�e";
				}
			 else if(e.getSource()==boutonEnCours && e.getStateChange()==ItemEvent.SELECTED) {
				 panneauDateAPrevoir.setVisible(false);
				 labelDateValidation.setVisible(false);
				 choixBouton = "En cours";
				}
		 }
	} 

		
	public void AjoutNouvelleInstallation(Connection connection) {
		try {
			SqlInto="INSERT INTO Installation VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement myPrepStat = connection.prepareStatement(SqlInto);
			
			//IdInstallation
			myPrepStat.setString(1,zoneTexteIdInstallation.getText());
			
			//Date
			myPrepStat.setDate(2, new java.sql.Date(panneauDateInstallation.getDate().getTime()));
				
			//TypeInstallation
			if(comboBoxTypeInstallation.getSelectedItem().equals("Standard")) {
					myPrepStat.setBoolean(3, true);
				}
				else{
					myPrepStat.setBoolean(3, false);
				}
			
			//Commentaire 
			if(!zoneTexteCommentaires.getText().equals("")) {
				myPrepStat.setString(4,zoneTexteCommentaires.getText());
			}
			else {
				myPrepStat.setNull(4,Types.VARCHAR);
			}
			
			//DureeInstallation
			if(!spinnerDureeInstallation.getValue().equals(0)) {
				myPrepStat.setInt(5, (int)spinnerDureeInstallation.getValue());
			}
			else {
				JOptionPane.showMessageDialog(null, "Aucune dur�e d'installation s�lectionn�e !","Erreur",JOptionPane.ERROR_MESSAGE);
			}
			
			//RefProcedureInstallation
			if (!zoneTextRefProcedureInstallation.getText().equals("")) {
				myPrepStat.setString(6, zoneTextRefProcedureInstallation.getText());
			}
			else {
				myPrepStat.setNull(6, Types.VARCHAR);
			}
			
			//Validation ann�ePr�voir, moisPr�voir,jourPr�voir;
			if (choixBouton =="A prevoir") {
				myPrepStat.setString(7, "A prevoir");
				myPrepStat.setDate(8, new java.sql.Date(panneauDateAPrevoir.getDate().getTime()));
			}
			else if (choixBouton =="Termin�e") {
				myPrepStat.setString(7,"Termin�e");
				myPrepStat.setNull(8, Types.DATE);
			}
			else if (choixBouton =="En cours") {
				myPrepStat.setString(7,"En cours");
				myPrepStat.setNull(8, Types.DATE);
			}

			
			//Software
			if(comboxSoftware.getSelectedItem().equals("Bob50")) {
				myPrepStat.setString(9, "Bob001");
			}
			else if(comboxSoftware.getSelectedItem().equals("NetBeans")) {
				myPrepStat.setString(9, "NB02");
			}
			else if(comboxSoftware.getSelectedItem().equals("Office 2013")) {
				myPrepStat.setString(9, "Of13");
			}
			else if(comboxSoftware.getSelectedItem().equals("Oracle 11g")) {
				myPrepStat.setString(9, "Or11");
			}
			else if(comboxSoftware.getSelectedItem().equals("Visual Studio")) {
				myPrepStat.setString(9, "Vs12");
			}
		
			
			//Matricule
			if(comboxMatricule.getSelectedItem().equals("Alexandre Baligant")){
				myPrepStat.setString(10, "AlBa");
			}
			else if(comboxMatricule.getSelectedItem().equals("Andr� Van Kerrebroeck")){
				myPrepStat.setString(10, "AVK");
			}
			else if(comboxMatricule.getSelectedItem().equals("Marvin Gobin")){
				myPrepStat.setString(10, "MarGob");
			}
			
			
			//OS
			if(comboxOS.getSelectedItem().equals("Fedora 2012")) {
				myPrepStat.setString(11, "Fedora");
			}
			else if(comboxOS.getSelectedItem().equals("Linux Mint")) {
				myPrepStat.setString(11, "Mint");
			}
			else if(comboxOS.getSelectedItem().equals("Red Hat 8 Linux EN")) {
				myPrepStat.setString(11, "RedHat8");
			}
			else if(comboxOS.getSelectedItem().equals("Ubuntu 2012")) {
				myPrepStat.setString(11, "Ubuntu");
			}
			else if(comboxOS.getSelectedItem().equals("Windows 7 Professional English")) {
				myPrepStat.setString(11, "W7ProfEn");
			}
			else if(comboxOS.getSelectedItem().equals("Windows 10 Professional English")) {
				myPrepStat.setString(11, "W8ProfEn");
			}
			else if(comboxOS.getSelectedItem().equals("Windows 8 Prof Fran�ais")) {
				myPrepStat.setString(11, "W8ProfFr");
			}
			
			myPrepStat.executeUpdate();
			
			anulation = 1;
			labelAjoutReussi.setVisible(true);
			labelAnnuler.setVisible(false);
			r�initialiser(connection);
			
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void r�initialiser(Connection connection) {
		zoneTexteCommentaires.setText("");
		zoneTextRefProcedureInstallation.setText("");
		spinnerDureeInstallation.setValue(0);
		R�cup�rerIdInstallation(connection);
	} 


	public void ActionAnnulation(Connection connection) {
		try {
			if (anulation == 1) {
				SqlDelete = "delete from installation order by IdInstallation desc limit 1;";
				PreparedStatement prepStat = connection.prepareStatement(SqlDelete);
				int annulation = prepStat.executeUpdate(); //Permet de mettre � jour l'id le plus haut
				anulation = 0;
				labelAjoutReussi.setVisible(false);
				labelAnnuler.setVisible(true);
				r�initialiser(connection);
			}
		}
		catch(SQLException e) {
			//JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}