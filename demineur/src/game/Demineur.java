package game;

public class Demineur implements Runnable{
	
	IHM ihm = new IHM();
	
    public static void main(String args[]) {
    	new Thread(new Demineur()).start();
    }

	@Override
    public void run() {
    	while(true) {
    		ihm.repaint();
    		ihm.checkVictoryStatus();
    	}
    	
    }
    
}