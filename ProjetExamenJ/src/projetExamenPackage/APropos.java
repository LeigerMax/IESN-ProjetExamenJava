package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class APropos extends JFrame {

	private Container cont;
	private JLabel labelTexte1;
	private JButton boutonRetour;
	
	public APropos() {
        super("A propos");
        setBounds(500,200,350,450);
        cont = getContentPane();
        
        labelTexte1 = new JLabel("  "); 
        cont.add(labelTexte1);
        
        boutonRetour = new JButton("Retour au menu principal");     
        boutonRetour.setBounds(200,400,100,30);    
        MonGestionnaireActionRetour BRetour = new MonGestionnaireActionRetour();     
        boutonRetour.addActionListener(BRetour); 
        cont.add(boutonRetour,BorderLayout.SOUTH); 
 
        setVisible(true); }
	
	private class MonGestionnaireActionRetour implements ActionListener {  
		public void actionPerformed( ActionEvent e) { 
			dispose(); }}

}