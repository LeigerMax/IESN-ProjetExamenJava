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
	private String[] listeMois = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	private java.util.Date dateJava;
	
	public ComboxDate() {
		setLayout(new GridLayout(1,3,1,1));
		
		jour = new JComboBox<Integer>();
		mois = new JComboBox<String>(listeMois);
		ann�e = new JComboBox<Integer>();
		
		for(int ann�eI=2021;ann�eI>=1995;ann�eI--) {
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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String dateText = ann�e.getSelectedItem()+"0"+(mois.getSelectedIndex()+1)+jour.getSelectedItem();
			try {
				dateJava = sdf.parse(dateText);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return dateJava;
		}
		
		public String getDateAcquis() {
			String dateString = ann�e.getSelectedItem()+"-0"+(mois.getSelectedIndex()+1)+"-"+jour.getSelectedItem();
			return dateString;
		}
	}

