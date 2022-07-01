package gameplay.settings;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class customPanel extends JPanel {

	public customPanel(BufferedImage read) {
		// TODO Auto-generated constructor stub
	}

	@Override
	  protected void paintComponent(Graphics g) {
		Image background = Toolkit.getDefaultToolkit().createImage("./resources/bloon.png");
	    super.paintComponent(g);
	        g.drawImage(background, 0, 0, null);
	       
	}
}
