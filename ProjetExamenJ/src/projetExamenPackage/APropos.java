package projetExamenPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class APropos extends JFrame {

	private JLabel labelTexte1,labelTexte2,labelTexte3,labelTexte4;
	private JButton boutonRetour;
	
	
	public APropos() {
        super("A propos");
        setBounds(500,200,400,200);
        
		labelTexte1 = new JLabel("Programme créer en Java sur Eclipse");
		labelTexte1.setBounds(80, 20, 255, 45);
		this.add(labelTexte1);
        
        
        labelTexte2 = new JLabel("Fait par Maxime & Paul "); 
        labelTexte2.setBounds(80, 40, 255, 45);
        add(labelTexte2);
        
        labelTexte3 = new JLabel("Pour le cours Développement orienté objet avancé "); 
        labelTexte3.setBounds(80, 60, 300, 45);
        add(labelTexte3);
        
        labelTexte4 = new JLabel("  "); 
        labelTexte4.setBounds(80, 60, 255, 45);
        add(labelTexte4);

        
        boutonRetour = new JButton("Retour au menu principal");     
        boutonRetour.setBounds(200,400,100,30);    
        MonGestionnaireActionRetour BRetour = new MonGestionnaireActionRetour();     
        boutonRetour.addActionListener(BRetour); 
        add(boutonRetour,BorderLayout.PAGE_END); 
 
        setVisible(true); }
	
	private class MonGestionnaireActionRetour implements ActionListener {  
		public void actionPerformed( ActionEvent e) { 
			dispose(); }}

}