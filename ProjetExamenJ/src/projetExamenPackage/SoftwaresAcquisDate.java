package projetExamenPackage;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;


public class SoftwaresAcquisDate extends JPanel {
	private JLabel labelTitre, labelDateDébut, labelDateFin;
	private JButton boutonChoix;
	private Fenetre parent;
	private String SqlSelectFrom, stringDateDébut,stringDateFin;
	private ComboxDate panneauDateDébut,panneauDateAFin;

	
	public  SoftwaresAcquisDate(Connection connection, Fenetre fenetre) {
		setLayout(null);
		parent = fenetre;

		labelTitre = new JLabel("Softwares acquis entre deux dates"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		labelTitre.setBounds(220,10,450,30); 
		add(labelTitre); 
		
		labelDateDébut = new JLabel("Date début : "); 
		labelDateDébut.setBounds(100,50,100,40); 
		add(labelDateDébut); 
		
		panneauDateDébut = new ComboxDate();
		panneauDateDébut.setBounds(180,50,175,40); 
		add(panneauDateDébut);
		
		labelDateFin = new JLabel("Date Fin : "); 
		labelDateFin.setBounds(360,50,100,40); 
		add(labelDateFin); 
		
		panneauDateAFin = new ComboxDate();
		panneauDateAFin.setBounds(420,50,175,40); 
		add(panneauDateAFin);
		
		
		boutonChoix = new JButton("Afficher");
		boutonChoix.setBounds(600,50,80,30); 
		add(boutonChoix);
		

		ActionAfficher a = new ActionAfficher();
		boutonChoix.addActionListener(a);

		setVisible(true);
	}
	

	
	
	private class ActionAfficher implements ActionListener{
		public void actionPerformed( ActionEvent a){
			SqlSelectFrom = "SELECT * FROM installation join software on installation.CodeSoftware = software.CodeSoftware WHERE software.DateAcquisition BETWEEN '"+panneauDateDébut.getDateAcquis()+"' AND '"+panneauDateAFin.getDateAcquis()+"';";
			AfficherUneTable afficherLaTable  = new AfficherUneTable(parent.getConnect(), SqlSelectFrom);

			removeAll();
			add(labelTitre);
			add(boutonChoix);
			add(panneauDateDébut);
			add(panneauDateAFin);
			afficherLaTable.setBounds(5,100,775, 400); 
			add(afficherLaTable,BorderLayout.CENTER);
			validate();
		}}
}