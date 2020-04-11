package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;




public class Accueil extends JFrame {
	private Container cont;
	
	public Accueil() {

	    cont = getContentPane();
	    Login login = new Login(this);
	    add(login);
		
		
	    setTitle("Bienvenue");
	    setBounds(500,200,500,450);
	    setResizable(false);
		setVisible(true);
	}
	

}