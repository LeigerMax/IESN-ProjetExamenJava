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
	//private JComboBox<Integer> année, mois ,jour;
	//private JComboBox<Integer> annéeF, moisF ,jourF;
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
		

		

		
		/*année = new JComboBox<Integer>();
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
		
		année.setBounds(175,50,65,30); 
		mois.setBounds(240,50,45,30); 
		jour.setBounds(285,50,45,30); 
		annéeF.setBounds(425,50,65,30); 
		moisF.setBounds(490,50,45,30); 
		jourF.setBounds(535,50,45,30); 
		
		
		add(année);
		add(mois);
		add(jour);
		add(annéeF);
		add(moisF);
		add(jourF);*/
		
		

		setVisible(true);
	}
	

	
	
	private class ActionAfficher implements ActionListener{
		public void actionPerformed( ActionEvent a){
			SqlSelectFrom = "SELECT * FROM installation join software WHERE software.DateAcquisition BETWEEN '"+panneauDateDébut.getDateAcquis()+"' AND '"+panneauDateAFin.getDateAcquis()+"';";
			AfficherUneTable afficherLaTable  = new AfficherUneTable(parent.getConnect(), SqlSelectFrom);

			removeAll();
			add(labelTitre);
			add(boutonChoix);
			add(panneauDateDébut);
			add(panneauDateAFin);
			afficherLaTable.setBounds(100,100,600, 400); 
			add(afficherLaTable,BorderLayout.CENTER);
			validate();
		}}
}