package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import accessBD.*;

public class ComboxDate extends JPanel {
	private JComboBox<Integer> année,jour;
	private JComboBox<String>  mois;
	private String[] listeMois = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
	private java.util.Date dateUtilJava;
	
	public ComboxDate() {
		setLayout(new GridLayout(1,3,1,1));
		
		année = new JComboBox<Integer>();
		mois = new JComboBox<String>(listeMois);
		jour = new JComboBox<Integer>();
		for(int annéeI=2025;annéeI>=2000;annéeI--) {
			année.addItem(annéeI);
		}
		for(int jourI=1;jourI<=31;jourI++) {
			jour.addItem(jourI);
		}
		
		add(année);
		add(mois);
		add(jour);
		
		setVisible(true);
		}
		
		public Date getDate() {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String dateString = année.getSelectedItem()+"-"+mois.getSelectedIndex()+"-"+jour.getSelectedItem();
			try {
				dateUtilJava = simpleDateFormat.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return dateUtilJava;
		}
		
		public String getDateAcquis() {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String dateString = année.getSelectedItem()+"-"+mois.getSelectedIndex()+"-"+jour.getSelectedItem();
			return dateString;
		}
	}

