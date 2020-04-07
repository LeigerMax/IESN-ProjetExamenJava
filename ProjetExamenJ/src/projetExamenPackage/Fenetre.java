package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Fenetre extends JFrame {
	
	private Container cont;
	private JMenuBar menuBarre;
	private JMenu menuApplication, menuApplication1, menuApplication2; 
	private JMenuItem menuQuitter, menuInscription, menuIESN, menuAide; 
	private JLabel labelTitre;
	
	public Fenetre() {
	super("Examen ");
    setBounds(500,200,400,450);
    
    cont = getContentPane();
    menuBarre = new JMenuBar(); 
	setJMenuBar(menuBarre);
	
	menuApplication = new JMenu("Application");
	menuApplication1 = new JMenu("Application1");
	menuApplication2 = new JMenu("Application2");
	menuBarre.add(menuApplication);
	menuBarre.add(menuApplication1);
	menuBarre.add(menuApplication2);
	
	menuQuitter = new JMenuItem("Sortie");
	menuQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
	menuApplication.add(menuQuitter);
	ActionQuitter exit = new ActionQuitter();     
	menuQuitter.addActionListener(exit);
	
	
	
    setVisible(true);
	}
	
	private class ActionQuitter implements ActionListener  { 
		public void actionPerformed(ActionEvent e)  {
		System.exit(0);} }
}
