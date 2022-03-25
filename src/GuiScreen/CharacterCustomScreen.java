package GuiScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import DisplayGame.Game;
import DisplayGame.GameObject.Button;

public class CharacterCustomScreen extends JPanel {
	public static int bestScore;
	public static int bestLevel;
	
	public static Image player = new ImageIcon("playerImage.png").getImage();
	public static Image player1 = new ImageIcon("playerImg.png").getImage();
	public static Image playerBlaze = new ImageIcon("playerBlaze.png").getImage();
	public static Image playerEnderman = new ImageIcon("playerEnderman.png").getImage();
	public static Image playerGalaxy = new ImageIcon("playerGalaxy.png").getImage();
	public static Image playerHerobrine = new ImageIcon("playerHerobrine.png").getImage();
	public static Image playerKaiser = new ImageIcon("kaiserImg.png").getImage();
	
	public static Button buttonCreeper = new Button(220, 100, 50, 50, 1, 0, false);
	public static Button buttonWhite = new Button(310, 100, 50, 50, 2, 0, false);
	public static Button buttonYellow = new Button(405, 100, 50, 50, 0, 0, false);
	public static Button buttonBlaze = new Button(220, 165, 50, 50, 3, 10, false);
	public static Button buttonEnderman = new Button(310, 165, 50, 50, 4, 11, false);
	public static Button buttonGalaxy = new Button(405, 165, 50, 50, 5, 12, false);
	public static Button buttonHerobrine = new Button(220, 230, 50, 50, 6, 14, false);
	public static Button buttonKaiser = new Button(310, 230, 50, 50, 7, 15, false);
	
	public static String skin = "White";
	
	public static void draw(Graphics g) {
		if(Game.Score > bestScore) {
			bestScore = Game.Score;
		}
		if(GameScreen.level > bestLevel) {
			bestLevel = GameScreen.level;
		}
		
		g.setColor(Color.white);
		g.drawRect(200, 10, 275, 300);
		g.setFont(new Font("", Font.PLAIN, 20));
		g.drawString("Your Character:", 15, 150);
		
		if(skin == "Creeper") { g.drawImage(player, 30, 180, 100, 100, null); }
		if(skin == "White") { g.drawImage(player1, 30, 180, 100, 100, null); }
		if(skin == "Yellow") { 
			g.setColor(Color.yellow);
			g.fillRect(30, 180, 100, 100); 
		}
		if(skin == "Enderman") { g.drawImage(playerEnderman, 30, 180, 100, 100, null); }
		if(skin == "Galaxy") { g.drawImage(playerGalaxy, 30, 180, 100, 100, null); }
		if(skin == "Blaze") { g.drawImage(playerBlaze, 30, 180, 100, 100, null); }
		if(skin == "Herobrine") { g.drawImage(playerHerobrine, 30, 180, 100, 100, null); }
		if(skin == "Kaizereich") { g.drawImage(playerKaiser, 30, 180, 100, 100, null); }
		
		g.setColor(Color.white);
		g.setFont(new Font("", Font.PLAIN, 15));
		g.drawString("Skin: " + skin, 205, 30);
		g.drawString("Highest Score: " + bestScore, 205, 50);
		g.drawString("Best Level: " + bestLevel, 205, 70);
		
		g.drawRect(200, 80, 275, 0);
		

		if(skin == "Creeper") {
			g.setColor(Color.white);
			g.fillRect(210, 90, 70, 70);
		}
		if(skin == "White") {
			g.fillRect(300, 90, 70, 70);
		}
		if(skin == "Yellow") {
			g.fillRect(405 - 10, 90, 70, 70);
		}
		if(skin == "Blaze") {
			g.fillRect(210, 155, 70, 70);
		}
		if(skin == "Enderman") {
			g.fillRect(300, 155, 70, 70);
		}
		if(skin == "Galaxy") {
			g.fillRect(395, 155, 70, 70);
		}
		if(skin == "Herobrine") {
			g.fillRect(210, 220, 70, 70);
		}
		if(skin == "Kaizereich") {
			g.fillRect(300, 220, 70, 70);
		}
		
		buttonCreeper.draw(g);
		
		buttonWhite.draw(g);
//		g.setColor(new Color(0, 0, 0, 70));
//		g.fillRect(310, 100, 50, 50);
		
		g.setColor(Color.yellow);
		buttonYellow.draw(g);
//		g.setColor(new Color(0, 0, 0, 70));
//		g.fillRect(405, 100, 50, 50);
		g.setColor(Color.white);
		
		buttonBlaze.draw(g);
		buttonEnderman.draw(g);
		buttonGalaxy.draw(g);
		buttonHerobrine.draw(g);
		buttonKaiser.draw(g);
		
	}

}
