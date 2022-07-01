package gameplay.logoSizes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

public class TextSettings {

	public Object logoSize(JButton button, int x, int xbutton, int y, int ybutton, ImageIcon logo) {
		button.setIcon(logo);
        button.setBounds(x/2-(xbutton+(xbutton/2)), y/35, xbutton*3,ybutton*3);
		button.setFont(new Font("Sans", Font.BOLD,40));
		button.setBorderPainted(false); 
		button.setContentAreaFilled(false); 
		button.setFocusPainted(false); 
		button.setRolloverEnabled(true);
		button.addMouseListener(new java.awt.event.MouseAdapter() {
			  
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	button.setBackground(Color.GREEN);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	button.setBackground(UIManager.getColor("control"));
			    }
			});
		return null;
	}

}
