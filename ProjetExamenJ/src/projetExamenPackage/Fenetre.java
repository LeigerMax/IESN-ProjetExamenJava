package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;

public class Fenetre extends JFrame {
	
	private Connection connection;
	private Login loginConect;
	private Container cont;
	private JLabel message;
	private JMenuBar menuBarre;
	private JMenu menuApplication, menuBaseDeDonnée, menuAide; 
	private JMenuItem menuItemAccueil,menuItemQuitter, menuItemNouvelleInstallation, menuItemLectureTable, menuItemSoftwaresAcquisDate, menuItemSoftwareProfesseur, menuItemSupprimerUneInstallation, menuItemGitHub, menuItemPropos; 
	private Desktop bureau = Desktop.getDesktop();
	
	public Fenetre(Login loginConect) {
		
		super("Examen Java ");
	    setBounds(500,200,800,600);
	    setResizable(false);
	    this.loginConect=loginConect;   
	    connection=loginConect.getConnect();
	
		//Message de bienvenue
		message = new JLabel("Bienvenue dans l'application réalisée pour le cour de Java 2");
		message.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		message.setHorizontalAlignment(SwingConstants.CENTER);
		add(message);
		
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

		
		//JMenuItem
		menuItemAccueil = new JMenuItem("Déconnexion");
		menuItemAccueil.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
		menuApplication.add(menuItemAccueil);
		menuActionDéconnexion actionDéconnexion = new menuActionDéconnexion();    
		menuItemAccueil.addActionListener(actionDéconnexion);
		
		menuItemQuitter = new JMenuItem("Sortie");
		menuItemQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		menuApplication.add(menuItemQuitter);
		MenuActionQuitter actionQuitter = new MenuActionQuitter();     
		menuItemQuitter.addActionListener(actionQuitter);
		
		menuItemNouvelleInstallation = new JMenuItem("Nouvelle Installation"); 
		menuBaseDeDonnée.add(menuItemNouvelleInstallation);
		MenuActionNouvelleInstallation actionNouvelleInstallation = new MenuActionNouvelleInstallation();    
		menuItemNouvelleInstallation.addActionListener(actionNouvelleInstallation);
		
		menuItemLectureTable = new JMenuItem("Lecture des tables"); 
		menuBaseDeDonnée.add(menuItemLectureTable);
		MenuActionLectureTable actionLectureTable = new MenuActionLectureTable();    
		menuItemLectureTable.addActionListener(actionLectureTable);
		
		menuItemSoftwaresAcquisDate = new JMenuItem("Softwares Acquis Date"); 
		menuBaseDeDonnée.add(menuItemSoftwaresAcquisDate);
		MenuActionSoftwaresAcquisDate actionSoftwaresAcquisDate = new MenuActionSoftwaresAcquisDate();    
		menuItemSoftwaresAcquisDate.addActionListener(actionSoftwaresAcquisDate);
		
		menuItemSoftwareProfesseur = new JMenuItem("Softwares Professeur"); 
		menuBaseDeDonnée.add(menuItemSoftwareProfesseur);
		MenuActionSoftwareProfesseur actionSoftwareProfesseur = new MenuActionSoftwareProfesseur();    
		menuItemSoftwareProfesseur.addActionListener(actionSoftwareProfesseur);
		
		menuItemSupprimerUneInstallation = new JMenuItem("Supprimer Installation"); 
		menuBaseDeDonnée.add(menuItemSupprimerUneInstallation);
		MenuActionSupprimerInstallation actionSupprimerInstallation = new MenuActionSupprimerInstallation();    
		menuItemSupprimerUneInstallation.addActionListener(actionSupprimerInstallation);
		
		menuItemGitHub = new JMenuItem("GitHub du logiciel"); 
		menuAide.add(menuItemGitHub);
		menuActionGitHub actionGitHub = new menuActionGitHub();    
		menuItemGitHub.addActionListener(actionGitHub); 
		
		menuAide.addSeparator(); 
		
		menuItemPropos = new JMenuItem("A propos"); 
		menuAide.add(menuItemPropos);
		menuActionPropos actionPropos = new menuActionPropos();    
		menuItemPropos.addActionListener(actionPropos); 
		
		//Quitter via la croix rouge
	    addWindowListener(new WindowAdapter() { 
	    	public void windowClosing(WindowEvent e) {
				try {
					connection.close();
					System.exit(0);
				}
				catch(SQLException exit1) { 
					System.out.println(exit1.getMessage());
				}	
	    	}
	    });
		
	    setVisible(true);	    
	}
	
	
	private class menuActionDéconnexion implements ActionListener {
		public void  actionPerformed(ActionEvent exit)  {
			dispose();
			try {
				connection.close();
				LoginFenetre loginFenetre = new LoginFenetre();
			}
			catch(SQLException exit1) { 
				System.out.println(exit1.getMessage());
			}
		}
	} 
	
	
	private class MenuActionQuitter implements ActionListener  { 
		public void actionPerformed(ActionEvent e)  {
			try {
				connection.close();
			}
			catch(SQLException exit1) { }
			System.exit(0);
		}
	}
	
	
	private class MenuActionNouvelleInstallation implements ActionListener {
		public void  actionPerformed(ActionEvent e)  { 
			getContentPane().removeAll();
			NouvelleInstallation nouvelleInstallation = new NouvelleInstallation(connection,Fenetre.this);
			add(nouvelleInstallation);
			nouvelleInstallation.repaint();
			Fenetre.this.setVisible(true);
		}
	}
	
	
	private class MenuActionSupprimerInstallation implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			getContentPane().removeAll();
			Suppression suppression = new Suppression(connection,Fenetre.this);
			add(suppression);
			suppression.repaint();
			Fenetre.this.setVisible(true);
		}
	}
	
	
	private class MenuActionLectureTable implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			getContentPane().removeAll();
			AfficherLesTables afficherLesTables = new AfficherLesTables (connection,Fenetre.this);
			add(afficherLesTables);
			afficherLesTables.repaint();
			Fenetre.this.setVisible(true);
		}
	}
	
	private class MenuActionSoftwaresAcquisDate implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			getContentPane().removeAll();
			SoftwaresAcquisDate softwaresAcquisDate = new SoftwaresAcquisDate(connection,Fenetre.this);
			add(softwaresAcquisDate);
			softwaresAcquisDate.repaint();
			Fenetre.this.setVisible(true);
		}
	}
	
	private class MenuActionSoftwareProfesseur implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			getContentPane().removeAll();
			SoftwareProfesseur softwareProfesseur = new SoftwareProfesseur(connection,Fenetre.this);
			add(softwareProfesseur);
			softwareProfesseur.repaint();
			Fenetre.this.setVisible(true);
		}
	}
	
	private class menuActionGitHub implements ActionListener {
        public void  actionPerformed(ActionEvent e)  {
            try {
                bureau.browse(new URI("https://github.com/LeigerMax/ProjetExamenJava"));
                } 
            catch (Exception o) {
                o.printStackTrace();
                }
        }
    }
	
	private class menuActionPropos implements ActionListener {
		public void  actionPerformed(ActionEvent e)  {
			APropos propos = new APropos();
		}
	} 

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