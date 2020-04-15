package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;

public class Fenetre extends JFrame {
	
	private Connection connection;
	private Login login;
	private Container cont;
	private JLabel message;
	private JMenuBar menuBarre;
	private JMenu menuApplication, menuBaseDeDonnée, menuAide; 
	private JMenuItem menuQuitter, menuNouvelleInstallation, menuSupprimerUneInstallation, menuLectureTable, menuCommentaire, menuPropos,menuAccueil; 

	
	public Fenetre(Login parent) {
		super("Examen Java ");
	    setBounds(500,200,800,600);
	    setResizable(false);
	    this.login=parent;   
	    connection=login.getConnect();
	
	    //Menu
	    menuBarre = new JMenuBar(); 
		setJMenuBar(menuBarre);
		
		//JMenu
		menuApplication = new JMenu("Application");
		menuBarre.add(menuApplication);
		menuBaseDeDonnée = new JMenu("Base de donnée");
		menuBarre.add(menuBaseDeDonnée);
		menuAide = new JMenu("Aide");
		menuBarre.add(menuAide);
		
		//Message de bienvenue
		message = new JLabel("Bienvenue dans l'application réalisée pour le cour de Java 2");
		message.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		message.setHorizontalAlignment(SwingConstants.CENTER);
		add(message);
		
		//JMenuItem
		menuAccueil = new JMenuItem("Déconnexion");
		menuAccueil.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
		menuApplication.add(menuAccueil);
		menuActionDéconnexion accueil = new menuActionDéconnexion();    
		menuAccueil.addActionListener(accueil);
		
		menuQuitter = new JMenuItem("Sortie");
		menuQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		menuApplication.add(menuQuitter);
		MenuActionQuitter Exit = new MenuActionQuitter();     
		menuQuitter.addActionListener(Exit);
		
		menuNouvelleInstallation = new JMenuItem("Nouvelle Installation"); 
		menuBaseDeDonnée.add(menuNouvelleInstallation);
		MenuActionNouvelleInstallation NouvelleInstallation = new MenuActionNouvelleInstallation();    
		menuNouvelleInstallation.addActionListener(NouvelleInstallation);
		
		menuLectureTable = new JMenuItem("Lecture d'une table"); 
		menuBaseDeDonnée.add(menuLectureTable);
		MenuActionLectureInstallation LectureInstallation = new MenuActionLectureInstallation();    
		menuLectureTable.addActionListener(LectureInstallation);
		
		menuSupprimerUneInstallation = new JMenuItem("Supprimer Installation"); 
		menuBaseDeDonnée.add(menuSupprimerUneInstallation);
		MenuActionSupprimerInstallation SupprimerInstallation = new MenuActionSupprimerInstallation();    
		menuSupprimerUneInstallation.addActionListener(SupprimerInstallation);
		
		menuCommentaire = new JMenuItem("Commentaire"); 
		menuAide.add(menuCommentaire);
		menuActionCommentaire Commentaire = new menuActionCommentaire();    
		menuCommentaire.addActionListener(Commentaire); 
		
		menuAide.addSeparator(); 
		
		menuPropos = new JMenuItem("A propos"); 
		menuAide.add(menuPropos);
		menuActionPropos Propos = new menuActionPropos();    
		menuPropos.addActionListener(Propos); 
		
	    setVisible(true);
	    
	}
	
	
	private class menuActionDéconnexion implements ActionListener {
		public void  actionPerformed(ActionEvent exit)  {
			dispose();
			try {
				connection.close();
				System.out.println("Déco");
				Accueil fenetreDéconnexion = new Accueil();
			}
			catch(SQLException exit1) { 
				System.out.println(exit1.getMessage());
			}
		}} 
	
	
	private class MenuActionQuitter implements ActionListener  { 
		public void actionPerformed(ActionEvent e)  {
			try {
				connection.close();
			}
			catch(SQLException exit1) { }
			System.exit(0);
		}}
	

	
	
	private class MenuActionNouvelleInstallation implements ActionListener {
		public void  actionPerformed(ActionEvent e)  { 
			remove(message);
			getContentPane().removeAll();
			NouvelleInstallation nouvelleInstallation = new NouvelleInstallation(connection);
			add(nouvelleInstallation);
			nouvelleInstallation.setVisible(true); 
			repaint();
			revalidate(); //Permet de rafficher la fenêtre
			System.out.println("Nouvelle Installation");
		}}
	
	
	private class MenuActionSupprimerInstallation implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {

		}}
	
	
	private class MenuActionLectureInstallation implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			getContentPane().removeAll();
			AfficherLesTables afficherLesTables = new AfficherLesTables (connection,Fenetre.this);
			add(afficherLesTables);
			afficherLesTables.repaint();
			Fenetre.this.setVisible(true);
			/*cont.remove(message);
			getContentPane().removeAll();
			AfficherLesTables afficherLesTables = new AfficherLesTables(connection);
			add(afficherLesTables);
			afficherLesTables.setVisible(true); 
			repaint();
			revalidate(); //Permet de rafficher la fenêtre*/
			System.out.println("Lecture de la table");

		}}
	
	private class menuActionCommentaire implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			
		}} 
	
	
	private class menuActionPropos implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			APropos propos = new APropos();
		}} 

	public Connection getConnect() {
		return connection;
	}
	
	public Fenetre getWin() {
		return this;
	}
	
	public Container getCont(){
		return cont;
	}
}