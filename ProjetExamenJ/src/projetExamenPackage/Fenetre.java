package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Fenetre extends JFrame {
	
	private Container cont;
	private JMenuBar menuBarre;
	private JMenu menuApplication, menuBaseDeDonnée, menuAide, menuAccueil; 
	private JMenuItem menuQuitter, menuNouvelleInstallation, menuSupprimerUneInstallation, menuLectureTable, menuCommentaire, menuPropos; 
	//private JLabel labelTitre;
	
	public Fenetre() {
	super("Examen ");
    setBounds(500,200,400,450);
    
    cont = getContentPane();
    menuBarre = new JMenuBar(); 
	setJMenuBar(menuBarre);
	
	
	menuApplication = new JMenu("Application");
	menuBarre.add(menuApplication);
	menuAccueil = new JMenu("Accueil");
	menuBarre.add(menuAccueil);
	menuBaseDeDonnée = new JMenu("Base de donnée");
	menuBarre.add(menuBaseDeDonnée);
	menuAide = new JMenu("Aide");
	menuBarre.add(menuAide);
	
	
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
			/*panneauInfos.setVisible(false);  
			cont.add(panneauInscription);
			cont.repaint();
			panneauInscription.setVisible(true); 
			*/}}
	
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