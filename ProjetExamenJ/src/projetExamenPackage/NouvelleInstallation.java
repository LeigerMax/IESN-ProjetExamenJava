package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.*;

import accessBD.*;




public class NouvelleInstallation extends JPanel {
	private JLabel labelTitre, labelIdInstallation,labelDateInstallation, labelTypeInstallation,labelCommentaires,labelDureeInstallation,labelRefProcedureInstallation,labelValidation,labelDateValidation, labelSoftware,labelMatricule, labelOS,labelAjoutReussi;
	private JTextField zoneTexteIdInstallation, zoneTexteCommentaires,zoneTextRefProcedureInstallation; 
	//private Fenetre parent;
	private JComboBox<String> comboBoxTypeInstallation,comboxSoftware,comboxMatricule,  comboxOS;
	private String[] listeTypeBool = {"Standard","Personnalisée"};
	private JSpinner spinnerDureeInstallation;
	private SpinnerNumberModel modelSpinner;
	private JRadioButton boutonAPrevoir, boutonTerminee,boutonEnCours; 
	private JPanel panneauTitre, panneauFormulaire, panneauValidation, panneauAjoutReussi; 
	private ButtonGroup boutonGroupe; 
	private String SqlInto;
	private String choixBouton;
	private ComboxDate panneauDateInstallation,panneauDateAPrevoir;

	
	
	public NouvelleInstallation(Connection connection, Fenetre fenetre) {
		setLayout(new FlowLayout()); 
		//parent = fenetre;

		
		//Titre
		
		labelTitre = new JLabel("Nouvelle installation : "); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,16));
		//add(labelTitre,BorderLayout.NORTH); 
		
		
		panneauTitre = new JPanel( );     
		panneauTitre.setLayout(new GridLayout( 1, 1, 0, 0 ));
		panneauTitre.add(labelTitre);
		add(panneauTitre, BorderLayout.NORTH);
		
		// IdInstallation
		
		labelIdInstallation = new JLabel("Id Installation  : "); 
		zoneTexteIdInstallation = new JTextField(5); 
		zoneTexteIdInstallation.setEnabled(false);
		
		RécupérerIdInstallation(connection);
		
		//Date
		
		labelDateInstallation = new JLabel("Date d'installation  : "); 
		panneauDateInstallation = new ComboxDate();

		
		//Type d'installation : booléen précisant si installation standard ou personnalisée 
		
		
		labelTypeInstallation = new JLabel("Type d'installation  : "); 

		comboBoxTypeInstallation = new JComboBox<String>(listeTypeBool);
	
		//Commentaires PAS OBLIGATOIRE
		
		labelCommentaires = new JLabel("Commentaire  : "); 
		zoneTexteCommentaires = new JTextField(25); 

		
		//Duree Installation PAS OBLIGATOIRE
		
		labelDureeInstallation = new JLabel("Durée Installation  : "); 
		modelSpinner = new SpinnerNumberModel(0,0,999,1);
		spinnerDureeInstallation = new JSpinner(modelSpinner);
		spinnerDureeInstallation.setEditor(new JSpinner.DefaultEditor(spinnerDureeInstallation));
		
		//RefProcedureInstallation 
		labelRefProcedureInstallation = new JLabel("Ref Procedure Installation  : "); 
		zoneTextRefProcedureInstallation = new JTextField(25); 
		
		//Validation  
		labelValidation = new JLabel("Validation  : "); 
		
		boutonAPrevoir = new JRadioButton("A prevoir",false); 
		boutonTerminee = new JRadioButton("Terminée",true); 
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
		labelDateValidation.setVisible(false);	
		panneauDateAPrevoir = new ComboxDate();
		panneauDateAPrevoir.setVisible(false);
		
		//Software  Matricule Os
		labelSoftware = new JLabel("Software  : "); 
		comboxSoftware = new JComboBox<String>();
		labelMatricule = new JLabel("Matricule  : "); 
		comboxMatricule = new JComboBox<String>();
		labelOS = new JLabel("OS : "); 
		comboxOS = new JComboBox<String>();
		
		RécupérerSoftwareMatriculeOs(connection);		

		
		//panneauFormulaire
	
		
		panneauFormulaire = new JPanel( );     
		panneauFormulaire.setLayout(new GridLayout( 11, 2, 0, 0 ));
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
		add(panneauFormulaire,BorderLayout.CENTER);
		
		//Bouton
		
		BoutonInsertion boutonInsertion = new BoutonInsertion(this,connection);
		add(boutonInsertion);
		
		//Ajout réussi
		labelAjoutReussi = new JLabel("Ajout réussi ! "); 
		panneauAjoutReussi = new JPanel( );   
		labelAjoutReussi.setForeground(Color.red);
		panneauAjoutReussi.setLayout(new GridLayout( 1, 1, 0, 0 ));
		panneauAjoutReussi.add(labelAjoutReussi);
		add(panneauAjoutReussi, BorderLayout.SOUTH);
		panneauAjoutReussi.setVisible(false);
		
		setVisible(true);
	}
	
	
	private void RécupérerIdInstallation(Connection connect) {
		try {
			PreparedStatement prepStat = connect.prepareStatement("SELECT MAX(IdInstallation) FROM installation ORDER BY IdInstallation DESC;");
			TableModelGen idInsallation = AccessBDGen.creerTableModel(prepStat);
			Integer idPlusHaut = (Integer) idInsallation.getValueAt(0, 0) + 1;
			zoneTexteIdInstallation.setText(""+idPlusHaut);
			}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}}
	
	
	private void RécupérerSoftwareMatriculeOs(Connection connect) {
		try {
			PreparedStatement prepStatSoftware = connect.prepareStatement("SELECT Nom FROM Software;");
			PreparedStatement prepStatMatricule = connect.prepareStatement("SELECT NomPrenom FROM ResponsableReseaux;");
			PreparedStatement prepStatOS = connect.prepareStatement("SELECT Libelle FROM OS;");
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
		}}
	

	
	private class ItemRadioValidation implements ItemListener { 
		 public void itemStateChanged( ItemEvent e) { 
			 if(e.getSource()==boutonAPrevoir && e.getStateChange()==ItemEvent.SELECTED) {
				 panneauDateAPrevoir.setVisible(true);
				 labelDateValidation.setVisible(true);
				 choixBouton ="A prevoir";
				}
			  if(e.getSource()==boutonTerminee && e.getStateChange()==ItemEvent.SELECTED) {
				 panneauDateAPrevoir.setVisible(false);
				 labelDateValidation.setVisible(false);
				 choixBouton = "Terminée";
				}
			  if(e.getSource()==boutonEnCours && e.getStateChange()==ItemEvent.SELECTED) {
				 panneauDateAPrevoir.setVisible(false);
				 labelDateValidation.setVisible(false);
				 choixBouton = "En cours";
				}
		 }} 
	

		
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
				JOptionPane.showMessageDialog(null, "Aucune durée d'installation sélectionnée !","Erreur",JOptionPane.ERROR_MESSAGE);
			}
			
			//RefProcedureInstallation
			if (!zoneTextRefProcedureInstallation.getText().equals("")) {
				myPrepStat.setString(6, zoneTextRefProcedureInstallation.getText());
			}
			else {
				myPrepStat.setNull(6, Types.VARCHAR);
			}
			
			//Validation annéePrévoir, moisPrévoir,jourPrévoir;
			
			if (choixBouton =="A prevoir") {
				myPrepStat.setString(7, "A prevoir");
				myPrepStat.setDate(8, new java.sql.Date(panneauDateAPrevoir.getDate().getTime()));
			}
			else if (choixBouton =="Terminée") {
				myPrepStat.setString(7,"Terminée");
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
			else if(comboxMatricule.getSelectedItem().equals("André Van Kerrebroeck")){
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
			else if(comboxOS.getSelectedItem().equals("Windows 8 Prof Français")) {
				myPrepStat.setString(11, "W8ProfFr");
			}
			
			myPrepStat.executeUpdate();
			
			panneauAjoutReussi.setVisible(true);
			
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}}
}