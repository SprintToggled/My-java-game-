package DisplayGame;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import DisplayGame.Game;
import DisplayGame.Secret.HackClass;
import DisplayGame.Secret.HackDisplay;

public class Display extends JFrame {
	public static boolean start;
	public static boolean Toggled = false;
	
	Image icon = new ImageIcon("WindowsIcon.png").getImage();
	public static JFrame window = new JFrame();
	
	public Display() {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		window.setResizable(false);
		window.setIconImage(icon);
		Display.window.setTitle("Obcopusting | " + Game.Fps + " Fps");
		
		Game game = new Game();
		window.add(game);
		window.setVisible(true);
	}
	
	public static void main(String args[]) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Display display = new Display();
		if(Toggled) {
			HackClass hackGui = new HackClass();
		}
	}

}
