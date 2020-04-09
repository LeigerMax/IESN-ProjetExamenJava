package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;



public class Accueil extends JPanel {
	private JLabel labelTitre;
	private JButton boutonNouvelleInstallation, boutonLecture, boutonSuppression;   

	
	public Accueil() {
		this.setLayout(null);
		
		labelTitre = new JLabel("Accueil  "); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(labelTitre); 
		labelTitre.setBounds(255,20,255,50); 
		
		boutonNouvelleInstallation = new JButton(" Nouvelle installation ");  
		boutonNouvelleInstallation.setPreferredSize(new Dimension(300,50)); 
		this.add(boutonNouvelleInstallation);
		boutonNouvelleInstallation.setBounds(250,100,255,50); 
		AccueilActionNouvelleInstallation NouvelleInstallation = new AccueilActionNouvelleInstallation();    
		boutonNouvelleInstallation.addActionListener(NouvelleInstallation);
		
		boutonLecture = new JButton(" Lecture ");  
		boutonLecture.setPreferredSize(new Dimension(300,50));
		this.add(boutonLecture);
		boutonLecture.setBounds(250,170,255,50); 
		
		
		boutonSuppression = new JButton(" Suppression "); 
		boutonSuppression.setPreferredSize(new Dimension(300,50));
		this.add(boutonSuppression);
		boutonSuppression.setBounds(250,240,255,50); 
		
		
		
	}
	
	
	private class AccueilActionNouvelleInstallation implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			
			System.out.println("Nouvelle Installation");
			}}

}
