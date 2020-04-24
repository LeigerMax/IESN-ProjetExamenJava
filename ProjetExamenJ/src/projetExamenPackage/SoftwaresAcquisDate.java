package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;


public class SoftwaresAcquisDate extends JPanel {
	private JLabel labelTitre, labelDateDébut, labelDateFin;
	private JButton boutonAfficher;
	private Fenetre fenetreParent;
	private String SqlSelectFrom;
	private ComboxDate panneauDateDébut,panneauDateAFin;
	
	public  SoftwaresAcquisDate(Connection connection, Fenetre fenetre) {
		
		setLayout(null);
		fenetreParent = fenetre;

		//Titre
		labelTitre = new JLabel("Softwares acquis entre deux dates"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		labelTitre.setBounds(220,10,450,30); 
		add(labelTitre); 
		
		//Date début
		labelDateDébut = new JLabel("Date début : "); 
		labelDateDébut.setBounds(100,50,100,40); 
		add(labelDateDébut); 
		
		panneauDateDébut = new ComboxDate();
		panneauDateDébut.setBounds(180,50,175,40); 
		add(panneauDateDébut);
		
		//Date fin
		labelDateFin = new JLabel("Date Fin : "); 
		labelDateFin.setBounds(360,50,100,40); 
		add(labelDateFin); 
		
		panneauDateAFin = new ComboxDate();
		panneauDateAFin.setBounds(420,50,175,40); 
		add(panneauDateAFin);
		
		//Bouton afficher
		boutonAfficher = new JButton("Afficher");
		boutonAfficher.setBounds(600,50,80,30); 
		add(boutonAfficher);
		
		ActionAfficherTable actionAfficherTable = new ActionAfficherTable();
		boutonAfficher.addActionListener(actionAfficherTable);

		setVisible(true);
	}
	
	private class ActionAfficherTable implements ActionListener{
		public void actionPerformed(ActionEvent a){
			SqlSelectFrom = "SELECT * FROM installation join software on installation.CodeSoftware = software.CodeSoftware WHERE software.DateAcquisition BETWEEN '"+panneauDateDébut.getDateAcquis()+"' AND '"+panneauDateAFin.getDateAcquis()+"';";
			AfficherUneTable afficherLaTable  = new AfficherUneTable(fenetreParent.getConnect(), SqlSelectFrom);
			
			removeAll();
			add(labelTitre);
			add(boutonAfficher);
			add(panneauDateDébut);
			add(panneauDateAFin);
			afficherLaTable.setBounds(5,100,775, 400); 
			add(afficherLaTable,BorderLayout.CENTER);
			validate();
		}
	}
}