package projetExamenPackage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Image extends JPanel{
	private JLabel image;
	public Image() {
		image = new JLabel(new ImageIcon("images/menu.png"));

		add(image);
		setVisible(true);
}}
