package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Accueil extends JPanel {
	private JLabel labelTitre;
	
	public Accueil() {
		this.setLayout(new FlowLayout());
		
		labelTitre = new JLabel("Accueil  "); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,16));
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(labelTitre); 
		
	}

}
