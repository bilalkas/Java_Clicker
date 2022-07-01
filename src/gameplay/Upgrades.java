package gameplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Upgrades {
	
	static int autoClickCost=300;
	
	public Object autoClick(JButton upgradem) {
		
		upgradem.addActionListener(new ActionListener(){
			@Override
            public void actionPerformed(ActionEvent event) {
				String[] sizeselect = {"Ja", "Nein"};
                int returnsize = JOptionPane.showOptionDialog(null, "Wollen Sie den AutoClick *"+ Game.checkAutoClick*2 +" kaufen?",
                "Kaufbildschirm",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sizeselect, sizeselect[0]);
                
                if(Game.score>(autoClickCost*Game.checkAutoClick)-1 && returnsize == 0) {
                JOptionPane.showMessageDialog(null, "Kauf bestätigt!");
                Game.checkAutoClick = Game.checkAutoClick*2;
                Game.score = Game.score - autoClickCost;
                }else {
                JOptionPane.showMessageDialog(null, "Kauf fehlgeschlagen!");
                }
			
				System.out.print("Check Auto Click State="+Game.checkAutoClick);
               
            }
        });	
		return null;
	}

	public Object boost(JButton upgradeb) {
		upgradeb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(Game.score > Game.upgrade*Game.boost-1 && Game.boost<Game.maxupgrade) {
					
					
					System.out.println(Game.boost*Game.upgrade);
					Game.score = Game.score - Game.upgrade*Game.boost;
					Game.boost++;				 

				    JOptionPane.showMessageDialog(null, "Upgrade erfolgreich!");				   
				    if(Game.boost==Game.maxupgrade) {
				    upgradeb.setText("Keine Upgrades mehr");
				    }
				    
				}
				
			}
			
		});
		return null;
	}

}
