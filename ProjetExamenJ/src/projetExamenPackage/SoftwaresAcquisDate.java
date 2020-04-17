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
	private String SqlSelectFrom, stringDateD�but,stringDateFin;
	private JComboBox<Integer> ann�e, mois ,jour;
	private JComboBox<Integer> ann�eF, moisF ,jourF;



	
	public  SoftwaresAcquisDate(Connection connection, Fenetre fenetre) {
		parent = fenetre;
		System.out.println("Softwares acquis entre deux dates ");
		labelTitre = new JLabel("Softwares acquis entre deux dates"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		add(labelTitre); 
		
		boutonChoix = new JButton("Afficher");
		add(boutonChoix);
		

		ActionAfficher a = new ActionAfficher();
		boutonChoix.addActionListener(a);
		
		
		ann�e = new JComboBox<Integer>();
		mois = new JComboBox<Integer>();
		jour = new JComboBox<Integer>();
		ann�eF = new JComboBox<Integer>();
		moisF = new JComboBox<Integer>();
		jourF = new JComboBox<Integer>();

		for(int ann�eI=2020;ann�eI>=1900;ann�eI--) {
			ann�e.addItem(ann�eI);
			ann�eF.addItem(ann�eI);
		}
		for(int moisI=1;moisI<=12;moisI++) {
			mois.addItem(moisI);
			moisF.addItem(moisI);
		}
		for(int jourI=1;jourI<=31;jourI++) {
			jour.addItem(jourI);
			jourF.addItem(jourI);
		}
		
		add(ann�e);
		add(mois);
		add(jour);
		add(ann�eF);
		add(moisF);
		add(jourF);
		
		

		setVisible(true);
	}
	

	
	
	private class ActionAfficher implements ActionListener{
		public void actionPerformed( ActionEvent a){
			stringDateD�but = ann�e.getSelectedItem()+"-"+(mois.getSelectedItem())+"-"+jour.getSelectedItem();
			stringDateFin = ann�eF.getSelectedItem()+"-"+(moisF.getSelectedItem())+"-"+jourF.getSelectedItem();
			SqlSelectFrom = "SELECT * FROM software WHERE software.DateAcquisition BETWEEN '"+stringDateD�but+"' AND '"+stringDateFin+"';";
			System.out.println(SqlSelectFrom);
			AfficherUneTable afficherLaTable  = new AfficherUneTable(parent.getConnect(), SqlSelectFrom);

			
			removeAll();
			add(labelTitre);
			add(boutonChoix);
			add(ann�e);
			add(mois);
			add(jour);
			add(ann�eF);
			add(moisF);
			add(jourF);
			add(afficherLaTable,BorderLayout.CENTER);
			validate();
		}}
}
