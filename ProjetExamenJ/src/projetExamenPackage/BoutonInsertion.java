package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;


public class BoutonInsertion extends JPanel{
	private JButton boutonInsertion;
	private NouvelleInstallation nouvelleInstallation;
	private Connection connection;
	
	public BoutonInsertion(NouvelleInstallation nouvelleInstallation,Connection connection) {
		
		this.nouvelleInstallation=nouvelleInstallation;
		this.connection=connection;
		
		//Bouton insertion
		boutonInsertion = new JButton("Insertion");
		add(boutonInsertion);
		
		ActionInsertion actionInsertion= new ActionInsertion();
		boutonInsertion.addActionListener(actionInsertion);
		
		setVisible(true);
	}
	
	private class ActionInsertion implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==boutonInsertion) {
				nouvelleInstallation.AjoutNouvelleInstallation(connection);
			}
		}
	}
}	
