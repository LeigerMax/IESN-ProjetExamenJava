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
	private String SqlSelectFrom, stringDateDébut,stringDateFin;
	private JComboBox<Integer> année, mois ,jour;
	private JComboBox<Integer> annéeF, moisF ,jourF;



	
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
		
		
		année = new JComboBox<Integer>();
		mois = new JComboBox<Integer>();
		jour = new JComboBox<Integer>();
		annéeF = new JComboBox<Integer>();
		moisF = new JComboBox<Integer>();
		jourF = new JComboBox<Integer>();

		for(int annéeI=2020;annéeI>=1900;annéeI--) {
			année.addItem(annéeI);
			annéeF.addItem(annéeI);
		}
		for(int moisI=1;moisI<=12;moisI++) {
			mois.addItem(moisI);
			moisF.addItem(moisI);
		}
		for(int jourI=1;jourI<=31;jourI++) {
			jour.addItem(jourI);
			jourF.addItem(jourI);
		}
		
		add(année);
		add(mois);
		add(jour);
		add(annéeF);
		add(moisF);
		add(jourF);
		
		

		setVisible(true);
	}
	

	
	
	private class ActionAfficher implements ActionListener{
		public void actionPerformed( ActionEvent a){
			stringDateDébut = année.getSelectedItem()+"-"+(mois.getSelectedItem())+"-"+jour.getSelectedItem();
			stringDateFin = annéeF.getSelectedItem()+"-"+(moisF.getSelectedItem())+"-"+jourF.getSelectedItem();
			SqlSelectFrom = "SELECT * FROM software WHERE software.DateAcquisition BETWEEN '"+stringDateDébut+"' AND '"+stringDateFin+"';";
			System.out.println(SqlSelectFrom);
			AfficherUneTable afficherLaTable  = new AfficherUneTable(parent.getConnect(), SqlSelectFrom);

			
			removeAll();
			add(labelTitre);
			add(boutonChoix);
			add(année);
			add(mois);
			add(jour);
			add(annéeF);
			add(moisF);
			add(jourF);
			add(afficherLaTable,BorderLayout.CENTER);
			validate();
		}}
}
