package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;

public class Suppression extends JPanel {
	private JLabel labelTitre, labelFamilleSoft;
	private JButton affInstall;
	private JComboBox<String> installExist, familleSoft;
	private Fenetre parent;
	private String SqlSelectFrom;
	
	public  Suppression(Connection connection, Fenetre fenetre) {
		setLayout(null);
		parent = fenetre;

		labelTitre = new JLabel("Supprimer une installation"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		labelTitre.setBounds(245,10,450,30); 
		add(labelTitre); 
		
		labelFamilleSoft = new JLabel("Famille de Software : ");
		labelFamilleSoft.setHorizontalAlignment(SwingConstants.LEFT);
		labelFamilleSoft.setBounds(150, 60, 300, 30);
		add(labelFamilleSoft);
		String[ ] contSoft = {"Windows", "Linux", "Mac IOS"};
		familleSoft = new JComboBox(contSoft);
		familleSoft.setBounds(280, 60, 100, 30);
		familleSoft.setSelectedItem("");
		familleSoft.setMaximumRowCount(3);
		add(familleSoft);
		
		affInstall = new JButton("AFFICHER"); 
		affInstall.setBounds(400,60,100,30); 
		ActionBoutonAfficher a = new ActionBoutonAfficher();
		a.addActionListener();
		add(supInstall);

		setVisible(true);
	}
	
	public class ActionBoutonSupprimer implements ActionListener{

		public void actionPerformed(ActionEvent a) {
			
		}

		public void addActionListener() {
			
			
		}
		
	}
}
