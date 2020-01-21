package game;

public class Demineur implements Runnable{
	
	IHMDemineur ihm = new IHMDemineur();
	
    public static void main(String args[]) {
    	new Thread(new Demineur()).start();
    }

	@Override
    public void run() {
    	while(true) {
    		ihm.repaint();
    	}
    	
    }
    
}
