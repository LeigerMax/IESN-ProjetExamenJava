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
	private JComboBox<Integer> ann�e,jour;
	private JComboBox<String>  mois;
	private String[] listeMois = {"Janvier","F�vrier","Mars","Avril","Mai","Juin","Juillet","Ao�t","Septembre","Octobre","Novembre","D�cembre"};
	private java.util.Date dateUtilJava;
	
	public ComboxDate() {
		setLayout(new GridLayout(1,3,1,1));
		
		ann�e = new JComboBox<Integer>();
		mois = new JComboBox<String>(listeMois);
		jour = new JComboBox<Integer>();
		for(int ann�eI=2025;ann�eI>=2000;ann�eI--) {
			ann�e.addItem(ann�eI);
		}
		for(int jourI=1;jourI<=31;jourI++) {
			jour.addItem(jourI);
		}
		
		add(ann�e);
		add(mois);
		add(jour);
		
		setVisible(true);
		}
		
		public Date getDate() {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String dateString = ann�e.getSelectedItem()+"-"+mois.getSelectedIndex()+"-"+jour.getSelectedItem();
			try {
				dateUtilJava = simpleDateFormat.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return dateUtilJava;
		}
		
		public String getDateAcquis() {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String dateString = ann�e.getSelectedItem()+"-"+mois.getSelectedIndex()+"-"+jour.getSelectedItem();
			return dateString;
		}
	}

