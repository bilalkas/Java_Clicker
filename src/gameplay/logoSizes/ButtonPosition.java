package gameplay.logoSizes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ButtonPosition {

	public Object homeScreen(int getWidth, int bwidth, int getHeight, int bheight, int middle, JButton play, JButton changelog, JButton exit, JButton load, JButton save, JButton settings, JButton credits, JLabel textHover, ImageIcon save2) {
		 
                  textHover.setBounds(middle+(bwidth+10), getWidth/7+(bheight), bwidth, bheight);
                  textHover.setFont(new Font("Sans", Font.BOLD,15));
                  textHover.setText("");
                  textHover.setVisible(false);
                  
          //Play Button
          
          play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				play.setForeground(Color.black);			
			}       	       	  
          });
          		  play.setBounds(middle, getHeight/6+30, bwidth, bheight);
                  play.setForeground(Color.darkGray);
                  play.addMouseListener(new MouseAdapter() {
                  Color oldcolor = play.getForeground();
                  public void mouseEntered(MouseEvent me) { 
                  oldcolor = play.getForeground();
                  play.setForeground(Color.red);
                  textHover.setVisible(true);
                  }
                  public void mouseExited(MouseEvent me) {
                  play.setForeground(oldcolor);
                  textHover.setVisible(false);
                    }
                     });  			  
		  //Changelog Button
		  changelog.setBounds(middle, getHeight/6+30+(bheight+5), bwidth, bheight);
                  changelog.setForeground(Color.darkGray);
		  changelog.addMouseListener(new MouseAdapter() {
                  Color oldcolor = changelog.getForeground();
                  public void mouseEntered(MouseEvent me) {
                  textHover.setText(
                		  "<html>"
                		  + "Changelogs:<br>"
                  		+ "</html>");
                  oldcolor = changelog.getForeground();
                  changelog.setForeground(Color.red);
                  textHover.setVisible(true);
                  }
                  public void mouseExited(MouseEvent me) {
                      textHover.setText("");
                  changelog.setForeground(oldcolor);
                  textHover.setText("");
                  textHover.setVisible(false);
                    }
                     });  
                  //Credits Button
		  credits.setBounds(middle, getHeight/6+30+((bheight*2)+10),bwidth,bheight);
                  credits.setForeground(Color.darkGray);
                  credits.addMouseListener(new MouseAdapter() {
                  Color oldcolor = credits.getForeground();
                  public void mouseEntered(MouseEvent me) {
                  oldcolor = credits.getForeground();
                  textHover.setText(
                		  "<html>"
                		  + "Credits:<br>"
                  		+ "</html>");
                  credits.setForeground(Color.red);
                  textHover.setVisible(true);
                  }
                  public void mouseExited(MouseEvent me) {
                  credits.setForeground(oldcolor);
                  textHover.setVisible(false);
                    }
                     });  
                  //Exit Button
		  exit.setBounds(middle, getHeight/3+90, bwidth, bheight);
                  exit.setForeground(Color.darkGray);
                  exit.addMouseListener(new MouseAdapter() {
                  Color oldcolor = exit.getForeground();
                  public void mouseEntered(MouseEvent me) {
                  oldcolor = exit.getForeground();
                  exit.setForeground(Color.red);
                  textHover.setVisible(true);
                  }
                  public void mouseExited(MouseEvent me) {
                  exit.setForeground(oldcolor);
                  textHover.setVisible(false);
                    }
                     });  		  
            exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
					
				}
            	
            });
                  //BOTTTOM LEFT SIZES
                  int box=45;
                  
          //Load a Save File
		  load. setBounds(getWidth-(box+(box/2+(box))), getHeight-(box*2), box, box);
		  
		  //Save File
		  save.setBounds(getWidth-(box+(box/2+(box*2))), getHeight-(box*2), box, box);  
		  save.setIcon(save2);
          //Settings
		  settings.setBounds(getWidth-(box+(box/2)), getHeight-(box*2), box, box);
                  
		return null;
	}

	public Object playScreen() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object game(JButton bloonPress, ImageIcon bloon, int bwidth, int bheight, int getHeight, int getWidth, int middle) {
		bloonPress = new JButton(bloon);
		bloonPress.setBorderPainted(false); 
		bloonPress.setContentAreaFilled(false); 
		bloonPress.setFocusPainted(false); 
		bloonPress.setRolloverEnabled(true);
		bloonPress.setBounds(middle, getHeight/4, bwidth, bheight*4);
		bloonPress.setFocusable(false);	   
		return null;
	}

}
