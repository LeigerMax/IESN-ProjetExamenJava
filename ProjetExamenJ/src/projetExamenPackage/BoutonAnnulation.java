package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;

public class BoutonAnnulation extends JPanel {
	private JButton boutonAnnulation;
	private NouvelleInstallation nouvelleInstallation;
	private Connection connection;
	
	public BoutonAnnulation(NouvelleInstallation nouvelleInstallation,Connection connection) {
		
		this.nouvelleInstallation=nouvelleInstallation;
		this.connection=connection;
		
		//Bouton insertion
		boutonAnnulation = new JButton("Annulation");
		add(boutonAnnulation);
		
		ActionInsertion actionInsertion= new ActionInsertion();
		boutonAnnulation.addActionListener(actionInsertion);
		
		setVisible(true);
	}
	
	private class ActionInsertion implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==boutonAnnulation) {
				nouvelleInstallation.ActionAnnulation(connection);
			}
		}
	}
}	
