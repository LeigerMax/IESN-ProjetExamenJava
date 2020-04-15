package projetExamenPackage;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;


public class SoftwaresAcquisDate extends JPanel {
	private JLabel labelTitre;
	private JButton boutonChoix;
	private Fenetre parent;
	private String SqlSelectFrom;
	private JComboBox<String> comboxChoix;
	
	public  SoftwaresAcquisDate(Connection connection, Fenetre fenetre) {
		parent = fenetre;
		System.out.println("Softwares acquis entre deux dates ");
		labelTitre = new JLabel("Softwares acquis entre deux dates"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		add(labelTitre); 
		
		comboxChoix = new JComboBox<String>();
		add(comboxChoix);
		
		boutonChoix = new JButton("Afficher");
		add(boutonChoix);
		
		RécupérerNomsTableau(connection);
		

		setVisible(true);
	}
	
	private void RécupérerNomsTableau(Connection connect) {
		try {
			PreparedStatement prepStat = connect.prepareStatement("select * from software; ");
			TableModelGen table2 = AccessBDGen.creerTableModel(prepStat);
			for(int i=0; i <= table2.getRowCount()-1; i++) {
				comboxChoix.addItem((String) table2.getValueAt(i, 0));
				}
			}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	

}
