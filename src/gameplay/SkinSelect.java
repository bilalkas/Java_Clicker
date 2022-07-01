package gameplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SkinSelect  {

	JButton[] button = new JButton[10];
	ImageIcon bloonIcon = new ImageIcon("./resources/bloon.png");
	
	public SkinSelect(JPanel playpanel, JPanel skinPanel,  JButton bloon, int bluebloonstate) {

		playpanel.setVisible(false);
		
		button[0] = new JButton(bloonIcon);
		button[0].setVisible(true);
		button[0].setBounds(1,1,120,100);
		
		button[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					playpanel.setVisible(true);
					skinPanel.setVisible(false);
					bloon.setIcon(bloonIcon);
				
				
			}
			
		});
		skinPanel.add(button[0]);
		
		skinPanel.setVisible(true);	
	}


}
