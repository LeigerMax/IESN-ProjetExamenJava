package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;




public class Accueil extends JFrame {
	private JLabel labelTitre, labelDemandeConnexion, labelLogin, labelPassword;
	private JButton boutonLogin;  
	private Container cont;
	private JTextField zoneTextelogin;
	private JPasswordField zoneTextePassword;
	
	public Accueil() {
		super("Bienvenue");
		this.setLayout(null);
	    setBounds(500,200,500,450);
	    setResizable(false);
	    cont = getContentPane();
	
		
		labelTitre = new JLabel("Bienvenue"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		cont.add(labelTitre); 
		labelTitre.setBounds(100,20,255,50); 
		
		labelDemandeConnexion = new JLabel("Merci de vous connecter pour accéder à l'application"); 
		cont.add(labelDemandeConnexion); 
		labelDemandeConnexion.setBounds(100,50,400,50); 
		
		
		
		labelLogin = new JLabel("Login :");
		cont.add(labelLogin); 
		labelLogin.setBounds(100,100,150,50); 
		
		zoneTextelogin = new  JTextField();
		cont.add(zoneTextelogin); 
		zoneTextelogin.setBounds(100,150,300,50); 
		
		
		labelPassword = new JLabel("Mot de passe :");
		cont.add(labelPassword); 
		labelPassword.setBounds(100,200,500,50); 
		
		zoneTextePassword = new JPasswordField();
		cont.add(zoneTextePassword); 
		zoneTextePassword.setBounds(100,250,300,50); 
		
		boutonLogin = new JButton(" Login "); 
		cont.add(boutonLogin); 
		boutonLogin.setBounds(100,320,150,50); 
		ActionBoutonLoginr login = new ActionBoutonLoginr();
		boutonLogin.addActionListener(login);

		setVisible(true);
	}
	
		public class ActionBoutonLoginr implements ActionListener{
			public void actionPerformed( ActionEvent a){
				if(a.getSource()==boutonLogin) {
					try {
						Connection connection = AccessBDGen.connecter("DbInstallations", zoneTextelogin.getText(), zoneTextePassword.getText());
						Fenetre fenetrePrincipal = new Fenetre();
						dispose();
					}
					catch(SQLException e) {
						JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
		}
	
	
	
	/*
	private class AccueilActionNouvelleInstallation implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {;
			System.out.println("Nouvelle Installation");
			}}
	
	
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
	boutonSuppression.setBounds(250,240,255,50); */

}
