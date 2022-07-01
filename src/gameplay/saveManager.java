package gameplay;

import javax.swing.JOptionPane;

public class saveManager {
	
	String name;
	
	saveManager(){
		
	}

	public int manager(int saveManager) {
		if(saveManager==1) {
			name = "laden?";
		}else {
			name = "speichern";
		}
		String[] sizeselect = {"Ja","Nein"};
        int returnsize = JOptionPane.showOptionDialog(null, "Wollen Sie das Spiel " + name,
        		"Wollen Sie das Spiel " + name,
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sizeselect, sizeselect[0]);
        System.out.println(returnsize);
        
        if(returnsize==-1 || returnsize==1) {
        	returnsize = 20;
        }
        
		return returnsize;
	}

}
