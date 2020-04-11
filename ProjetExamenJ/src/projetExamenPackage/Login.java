package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;



public class Login extends JPanel {
	private JLabel labelTitre, labelDemandeConnexion, labelLogin, labelPassword;
	private JButton boutonLogin;  
	private JTextField zoneTextelogin;
	private JPasswordField zoneTextePassword;
	private Accueil accueil;
	
	public Login(Accueil accueil) {
		this.setLayout(null);
		
		//Titre et texte
		labelTitre = new JLabel("Bienvenue"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		add(labelTitre); 
		labelTitre.setBounds(100,20,255,50); 
		labelDemandeConnexion = new JLabel("Merci de vous connecter pour accéder à l'application"); 
		add(labelDemandeConnexion); 
		labelDemandeConnexion.setBounds(100,50,400,50); 
		
		//Login
		labelLogin = new JLabel("Login :");
		add(labelLogin); 
		labelLogin.setBounds(100,100,150,50); 
		zoneTextelogin = new  JTextField();
		add(zoneTextelogin); 
		zoneTextelogin.setBounds(100,150,300,50); 
		
		//Password
		labelPassword = new JLabel("Mot de passe :");
		add(labelPassword); 
		labelPassword.setBounds(100,200,500,50); 
		zoneTextePassword = new JPasswordField();
		add(zoneTextePassword); 
		zoneTextePassword.setBounds(100,250,300,50); 
		
		//Bouton
		boutonLogin = new JButton(" Login "); 
		add(boutonLogin); 
		boutonLogin.setBounds(100,320,150,50); 
		ActionBoutonLogin login = new ActionBoutonLogin();
		boutonLogin.addActionListener(login);
		
		this.accueil=accueil;
		setVisible(true);
}
	
	public class ActionBoutonLogin implements ActionListener{
		public void actionPerformed( ActionEvent a){
			if(a.getSource()==boutonLogin) {
				try {
					Connection connection = AccessBDGen.connecter("DbInstallations", zoneTextelogin.getText(), zoneTextePassword.getText());
					Fenetre fenetrePrincipal = new Fenetre();
					accueil.dispose();
				}
				catch(SQLException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		}	
	}
}