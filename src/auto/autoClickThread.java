package auto;

import gameplay.Game;

public class autoClickThread extends Thread {
	
	
    public void run() {
        long startTime = System.currentTimeMillis();
        int i = 0;
        
   
        while (true) {
            if(Game.checkAutoClick>1) {
            Game.score = Game.score + Game.checkAutoClick;
            }
            try {
            	 Game.label[0].setText("<html>" + "SCORE: " + Game.score + "<br>Derzeitiger Boost: " + Game.boost + "</html>"); 
            	 Game.updateUpgradeButtons();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       		
    }

    }

}