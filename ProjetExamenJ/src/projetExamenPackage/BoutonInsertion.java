package projetExamenPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;



public class BoutonInsertion extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton boutonInserction;
	private NouvelleInstallation nouvelleInstallation;
	private Connection connection;
	
	public BoutonInsertion(NouvelleInstallation nouvelleInstallation,Connection connection) {
		this.nouvelleInstallation=nouvelleInstallation;
		this.connection=connection;
		
		boutonInserction = new JButton("Insertion");
		
		add(boutonInserction);
		
		ActionInserction actionInserction = new ActionInserction();
		boutonInserction.addActionListener(actionInserction);
		
		setVisible(true);
	}
	
	private class ActionInserction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==boutonInserction) {
				nouvelleInstallation.AjoutNouvelleInstallation(connection);

		}}}
}	
