package DisplayGame.Secret;

import javax.swing.JFrame;

public class HackClass extends JFrame {
	public HackClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 400);
		setResizable(false);
		
		HackDisplay hackDisplay = new HackDisplay();
		add(hackDisplay);
		setVisible(true);
	}
	
}
