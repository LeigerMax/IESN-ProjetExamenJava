package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class APropos extends JFrame {

	private Container cont;
	private JLabel labelTexte1,labelTexte2,labelTexte3;
	private JButton boutonRetour;
	
	
	public APropos() {
        super("A propos");
        setBounds(500,200,350,450);
        cont = getContentPane();
        
        labelTexte1 = new JLabel("Programme créer en Java sur Eclipse"); 
        labelTexte1.setHorizontalAlignment(SwingConstants.RIGHT); 
        cont.add(labelTexte1);
        
        labelTexte2 = new JLabel("Fait par Maxime & Paul "); 
        labelTexte2.setHorizontalAlignment(SwingConstants.RIGHT); 
        cont.add(labelTexte2);
        
        labelTexte3 = new JLabel("Pour le cours Développement orienté objet avancé "); 
        labelTexte3.setHorizontalAlignment(SwingConstants.RIGHT); 
        cont.add(labelTexte3);

        
        boutonRetour = new JButton("Retour au menu principal");     
        boutonRetour.setBounds(200,400,100,30);    
        MonGestionnaireActionRetour BRetour = new MonGestionnaireActionRetour();     
        boutonRetour.addActionListener(BRetour); 
        cont.add(boutonRetour,BorderLayout.PAGE_END); 
 
        setVisible(true); }
	
	private class MonGestionnaireActionRetour implements ActionListener {  
		public void actionPerformed( ActionEvent e) { 
			dispose(); }}

}