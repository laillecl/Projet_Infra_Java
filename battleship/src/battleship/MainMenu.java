package battleship;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu {
	
	private JFrame window;
	private ImageIcon backgroundImageIcon;
	private JLabel bkgImageContainer;
	private JButton startGame;
	private volatile boolean isImageVisible;
	
	public MainMenu(JFrame theWindow){
		window = theWindow;
		backgroundImageIcon = new ImageIcon(MainMenu.class.getResource("/battleship/image/Title.png"));
		bkgImageContainer = new JLabel(backgroundImageIcon);
		isImageVisible = true;
	}
	
	public void loadTitleScreen() {
		bkgImageContainer.setSize(window.getContentPane().getWidth(),
				window.getContentPane().getHeight()/2);
		bkgImageContainer.setLocation(0, 0); 
		bkgImageContainer.setVisible(true);
		
		startGame = new JButton("Start Game");
		startGame.setSize(200, 100);
		startGame.setLocation(350, bkgImageContainer.getHeight() + 50);
		startGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.getContentPane().remove(startGame);
				window.getContentPane().remove(bkgImageContainer);
				window.getContentPane().revalidate();
				window.getContentPane().repaint();
				window.getContentPane().setBackground(Color.WHITE);
				isImageVisible = false;
			}	
		});
		
		startGame.setVisible(true);
		
		window.getContentPane().add(startGame);
		window.getContentPane().add(bkgImageContainer);
		window.getContentPane().setBackground(Color.BLACK);
		window.setVisible(true);
		window.getContentPane().revalidate();
		window.getContentPane().repaint();
	}

	public boolean isImageVisible(){
		return isImageVisible;
	}
	
}
