package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;



public class Fenetre extends JFrame {
	
	private Connection connection;
	private Login login;
	private Container cont;
	private JLabel message;
	private JMenuBar menuBarre;
	private JMenu menuApplication, menuBaseDeDonn�e, menuAide; 
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
		menuBaseDeDonn�e = new JMenu("Base de donn�e");
		menuBarre.add(menuBaseDeDonn�e);
		menuAide = new JMenu("Aide");
		menuBarre.add(menuAide);
		
		//Message de bienvenue
		message = new JLabel("Bienvenue dans l'application r�alis�e pour le cour de Java 2");
		message.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		message.setHorizontalAlignment(SwingConstants.CENTER);
		add(message);
		
		//JMenuItem
		menuAccueil = new JMenuItem("D�connexion");
		menuAccueil.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
		menuApplication.add(menuAccueil);
		menuActionD�connexion accueil = new menuActionD�connexion();    
		menuAccueil.addActionListener(accueil);
		
		menuQuitter = new JMenuItem("Sortie");
		menuQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		menuApplication.add(menuQuitter);
		MenuActionQuitter Exit = new MenuActionQuitter();     
		menuQuitter.addActionListener(Exit);
		
		menuNouvelleInstallation = new JMenuItem("Nouvelle Installation"); 
		menuBaseDeDonn�e.add(menuNouvelleInstallation);
		MenuActionNouvelleInstallation NouvelleInstallation = new MenuActionNouvelleInstallation();    
		menuNouvelleInstallation.addActionListener(NouvelleInstallation);
		
		menuLectureTable = new JMenuItem("Lecture d'une table"); 
		menuBaseDeDonn�e.add(menuLectureTable);
		MenuActionLectureInstallation LectureInstallation = new MenuActionLectureInstallation();    
		menuLectureTable.addActionListener(LectureInstallation);
		
		menuSupprimerUneInstallation = new JMenuItem("Supprimer Installation"); 
		menuBaseDeDonn�e.add(menuSupprimerUneInstallation);
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
	    
		try {
		ResultSet r�sultats = null;
		String requete = "SELECT * FROM installation";
		Connection connection = AccessBDGen.connecter("DbInstallations","root", "Tigrou007");
		System.out.println("Connexion r�ussi !"); // Etablir la connexion ("le c�ble qui relie le programme Java � la BD")  
		
		 
		Statement stmt = connection.createStatement();
		r�sultats = stmt.executeQuery(requete);
		System.out.println(r�sultats);
		
		
		String sqlInstruction = "insert into FamilleSoftware (IdFamSoft, Libelle)values (?,?)"; 
		PreparedStatement myPrepStat = connection.prepareStatement(sqlInstruction); // Cr�er le PreparedStatement � partir de cette instruction SQL ("chariotsur c�ble")
		myPrepStat.setInt(1,202); // remplacer les ? par valeurs introduites par user (pour �viter lesinjections SQL) 
		myPrepStat.setString(2,"Ma famille Software "); // remplacer les ? par valeurs introduites par user (pour �viter lesinjections SQL) 
		int nbUpdatedLines = myPrepStat.executeUpdate(); // Ex�cuter ("envoyer le chariot � la BD et demander d'ex�cuter l'instruction") 
		System.out.println("Nombre de lignes modifi�es: " + nbUpdatedLines); // R�cup�rer le nombre de lignes modifi�es et l'afficher		
		

            
	}
		catch (SQLException e) {
		System.out.println(e.getMessage()); }
	}
	
	
	private class menuActionD�connexion implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			dispose();
			Accueil fenetreD�connexion = new Accueil();
		}} 
	
	
	private class MenuActionQuitter implements ActionListener  { 
		public void actionPerformed(ActionEvent e)  {
			System.exit(0);
		}}
	
	
	private class menuActionCommentaire implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			
		}} 
	
	
	private class menuActionPropos implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			APropos propos = new APropos();
		}} 
	
	
	private class MenuActionNouvelleInstallation implements ActionListener {
		public void  actionPerformed(ActionEvent e)  { 
			remove(message);
			getContentPane().removeAll();
			NouvelleInstallation nouvelleInstallation = new NouvelleInstallation(connection);
			add(nouvelleInstallation);
			nouvelleInstallation.setVisible(true); 
			repaint();
			revalidate(); //Permet de rafficher la fen�tre
			System.out.println("Nouvelle Installation");
		}}
	
	
	private class MenuActionSupprimerInstallation implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {

		}}
	
	
	private class MenuActionLectureInstallation implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			remove(message);
			getContentPane().removeAll();
			Lecture lecture = new Lecture(connection);
			add(lecture);
			lecture.setVisible(true); 
			repaint();
			revalidate(); //Permet de rafficher la fen�tre
			System.out.println("Lecture de la table");
			/*cont.removeAll();
			cont.add(lecture);
			cont.repaint();
			Fenetre.this.setVisible(true);*/
		}}

	public Connection getConnect() {
		return connection;
	}
}