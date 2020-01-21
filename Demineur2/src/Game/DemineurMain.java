package Game;

public class DemineurMain implements Runnable{
	
	DemineurIHM ihm = new DemineurIHM();
	
    public static void main(String args[]) {
    	new Thread(new DemineurMain()).start();
    }

	@Override
    public void run() {
    	while(true) {
    		ihm.repaint();
    	}
    	
    }
    
}
