package auto;

import gameplay.Game;

public class updateObjects extends Thread {
	
	
    public void run() {
        long startTime = System.currentTimeMillis();
        int i = 0;
        
   
        while (true) {

            
        try {
       	 Game.label[0].setText("<html>" + "SCORE: " + Game.score + "<br>Derzeitiger Boost: " + Game.boost + "</html>"); 
       	 Game.updateUpgradeButtons();
           Thread.sleep(50);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       		
    }

    }  
   }

