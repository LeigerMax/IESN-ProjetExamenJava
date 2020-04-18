package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;

public class Suppression extends JPanel {
	private JLabel labelTitre, labelSelection;
	private JButton supInstall;
	private JComboBox<String> installExist;
	private Fenetre parent;
	private String SqlSelectFrom;
	
	public  Suppression(Connection connection, Fenetre fenetre) {
		setLayout(null);
		parent = fenetre;

		labelTitre = new JLabel("Supprimer une installation"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		labelTitre.setBounds(245,10,450,30); 
		add(labelTitre); 
		
		labelSelection = new JLabel("Sélectionnez la ligne à supprimer");
		labelSelection.setFont(new java.awt.Font(Font.SERIF,Font.ITALIC,15));
		labelSelection.setBounds(200, 60, 200, 30);
		add(labelSelection);
		
		supInstall = new JButton("Supprimer"); 
		supInstall.setBounds(100,320,120,40); 
		supInstall.setBackground(Color.LIGHT_GRAY);
		ActionBoutonSupprimer sup = new ActionBoutonSupprimer();
		sup.addActionListener();
		add(supInstall);

		setVisible(true);
	}
	
	public class ActionBoutonSupprimer implements ActionListener{

		public void actionPerformed(ActionEvent a) {
			
			if(a.getSource() == supInstall) {
				/*try {
					
				}
				catch() {
					
				}*/
			}
		}

		public void addActionListener() {
			
			
		}
		
	}
}
