package projetExamenPackage;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import accessBD.*;


public class SoftwaresAcquisDate extends JPanel {
	private JLabel labelTitre, labelDateD�but, labelDateFin;
	private JButton boutonChoix;
	private Fenetre parent;
	private String SqlSelectFrom, stringDateD�but,stringDateFin;
	//private JComboBox<Integer> ann�e, mois ,jour;
	//private JComboBox<Integer> ann�eF, moisF ,jourF;
	private ComboxDate panneauDateD�but,panneauDateAFin;

	
	public  SoftwaresAcquisDate(Connection connection, Fenetre fenetre) {
		setLayout(null);
		parent = fenetre;

		labelTitre = new JLabel("Softwares acquis entre deux dates"); 
		labelTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,25));
		labelTitre.setBounds(220,10,450,30); 
		add(labelTitre); 
		
		labelDateD�but = new JLabel("Date d�but : "); 
		labelDateD�but.setBounds(100,50,100,40); 
		add(labelDateD�but); 
		
		panneauDateD�but = new ComboxDate();
		panneauDateD�but.setBounds(180,50,175,40); 
		add(panneauDateD�but);
		
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
		

		

		
		/*ann�e = new JComboBox<Integer>();
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
		
		ann�e.setBounds(175,50,65,30); 
		mois.setBounds(240,50,45,30); 
		jour.setBounds(285,50,45,30); 
		ann�eF.setBounds(425,50,65,30); 
		moisF.setBounds(490,50,45,30); 
		jourF.setBounds(535,50,45,30); 
		
		
		add(ann�e);
		add(mois);
		add(jour);
		add(ann�eF);
		add(moisF);
		add(jourF);*/
		
		

		setVisible(true);
	}
	

	
	
	private class ActionAfficher implements ActionListener{
		public void actionPerformed( ActionEvent a){
			SqlSelectFrom = "SELECT * FROM installation join software WHERE software.DateAcquisition BETWEEN '"+panneauDateD�but.getDateAcquis()+"' AND '"+panneauDateAFin.getDateAcquis()+"';";
			AfficherUneTable afficherLaTable  = new AfficherUneTable(parent.getConnect(), SqlSelectFrom);

			removeAll();
			add(labelTitre);
			add(boutonChoix);
			add(panneauDateD�but);
			add(panneauDateAFin);
			afficherLaTable.setBounds(100,100,600, 400); 
			add(afficherLaTable,BorderLayout.CENTER);
			validate();
		}}
}