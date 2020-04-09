package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Fenetre extends JFrame {
	
	private Container cont;
	private JMenuBar menuBarre;
	private JMenu menuApplication, menuBaseDeDonn�e, menuAide; 
	private JMenuItem menuQuitter, menuNouvelleInstallation, menuSupprimerUneInstallation, menuLectureTable, menuCommentaire, menuPropos,menuAccueil; 
	private JLabel labelTitre;
	private NouvelleInstallation nouvelleInstallation = new NouvelleInstallation();
	private Accueil accueil = new Accueil();
	
	public Fenetre() {
	super("Examen ");
    setBounds(500,200,800,600);
    setResizable(false);

    labelTitre = new JLabel("Bienvenue sur le programme d'installation  "); 
	labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,16));
	labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
	this.add(labelTitre); 
    
    cont = getContentPane();
    menuBarre = new JMenuBar(); 
	setJMenuBar(menuBarre);
	
	
	menuApplication = new JMenu("Application");
	menuBarre.add(menuApplication);
	menuBaseDeDonn�e = new JMenu("Base de donn�e");
	menuBarre.add(menuBaseDeDonn�e);
	menuAide = new JMenu("Aide");
	menuBarre.add(menuAide);
	
	menuAccueil = new JMenuItem("Accueil");
	menuApplication.add(menuAccueil);
	menuActionAccueil accueil = new menuActionAccueil();    
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
	}
	
	private class menuActionAccueil implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			nouvelleInstallation.setVisible(false);  
			labelTitre.setVisible(false);
			cont.add(accueil);
			accueil.setVisible(true); 
			cont.repaint();
			cont.revalidate(); //Permet de rafficher la fen�tre
			System.out.println("Nouvelle Installation");
			}} 
	
	private class menuActionCommentaire implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			
			}} 
	
	private class menuActionPropos implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			APropos propos = new APropos();
			}} 
	
	
	private class MenuActionQuitter implements ActionListener  { 
		public void actionPerformed(ActionEvent e)  {
			System.exit(0);} 
		}
	
	private class MenuActionNouvelleInstallation implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			accueil.setVisible(false);  
			labelTitre.setVisible(false);
			cont.add(nouvelleInstallation);
			nouvelleInstallation.setVisible(true); 
			cont.repaint();
			cont.revalidate(); //Permet de rafficher la fen�tre
			System.out.println("Nouvelle Installation");
			}}
	
	private class MenuActionSupprimerInstallation implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			/*panneauInfos.setVisible(false);  
			cont.add(panneauInscription);
			cont.repaint();
			panneauInscription.setVisible(true); 
			*/}}
	
	private class MenuActionLectureInstallation implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			/*panneauInfos.setVisible(false);  
			cont.add(panneauInscription);
			cont.repaint();
			panneauInscription.setVisible(true); 
			*/}}
}