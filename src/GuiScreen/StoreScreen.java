package GuiScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import DisplayGame.Game;
import DisplayGame.GameObject.Button;

public class StoreScreen extends JPanel {
	public static int timer = 150;
	public static boolean FScore = false;
	
	public static Button buttonHealing = new Button(60, 100, 150, 80, 0, 1, true);
	public static Button buttonSpeed = new Button(260, 100, 150, 80, 0, 2, true);
	public static Button buttonScoreBoost = new Button(260, 200, 150, 80, 0, 3, true);
	public static Button buttonFillHealth = new Button(60, 200, 150, 80, 0, 4, true);
	public static Button buttonSkill = new Button(60, 300, 150, 80, 0, 5, true);
	
	static Image healthImg = new ImageIcon("healthImg.png").getImage();
	static Image speedImg = new ImageIcon("speedImg.png").getImage();
	static Image explodeImg = new ImageIcon("explodeImg.png").getImage();
	static Image fireImg = new ImageIcon("fireImg.png").getImage();
	static Image teleportImg = new ImageIcon("teleportImg.png").getImage();
	
	public static void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 500, 500);
		
		//don't need
//		if(Game.Score >= 500) { g.setColor(Color.green); }
//		else if(Game.Score < 500) { g.setColor(Color.red); }
//		g.drawString("Healing Potion: 500 Scores (press h to buy)", 5, 15);
//		
//		if(Game.Score >= 300) { g.setColor(Color.green); }
//		else if(Game.Score < 300) { g.setColor(Color.red); }
//		g.drawString("Speed Potion: 300 Scores (press s to buy)", 5, 30);
//		
//		if(Game.Score >= 1000) { g.setColor(Color.green); }
//		else if(Game.Score < 1000) { g.setColor(Color.red); }
//		g.drawString("Score Booster: 1000 Scores (press c to buy)", 5, 45);
//		
//		if(Game.Score >= 800) { g.setColor(Color.green); }
//		else if(Game.Score < 800) { g.setColor(Color.red); }
//		g.drawString("Fill Health: 800 Scores (press f to buy)", 5, 60);

		
		
		g.setColor(Color.white);
		g.setFont(new Font("", Font.PLAIN, 20));
		g.drawString("Scores: " + Game.Score, 5, 20);
		
		
		if(Game.Score >= 500) { g.setColor(Color.green); }
		else if(Game.Score < 500) { g.setColor(Color.red); }
		buttonHealing.draw(g);
		g.drawString("Healing", 100, 155);
		g.drawString("500 Scores", 85, 173);
		g.drawImage(healthImg, 116, 103, 35, 35, null);
		
		if(Game.Score >= 300) { g.setColor(Color.green); }
		else if(Game.Score < 300) { g.setColor(Color.red); }
		buttonSpeed.draw(g);
		g.drawString("Speed", 300, 155);
		g.drawString("300 Scores", 300 - (100 - 85), 155 + 20 - 2);
		g.drawImage(speedImg, 316, 103, 35, 35, null);
		
		if(Game.Score >= 800) { g.setColor(Color.green); }
		else if(Game.Score < 800) { g.setColor(Color.red); }
		buttonFillHealth.draw(g);
		g.drawString("Fill Health", 93, 255);
		g.drawString("800 Scores", 93 - (100 - 93), 255 + 20 - 2);
		g.drawImage(healthImg, 80, 203, 35, 35, null);
		g.drawImage(healthImg, 118, 203, 35, 35, null);
		g.drawImage(healthImg, 154, 203, 35, 35, null);
		
		if(Game.Score >= 1000) { g.setColor(Color.green); }
		else if(Game.Score < 1000) { g.setColor(Color.red); }
		buttonScoreBoost.draw(g);
		g.drawString("Score Booster", 270, 255);
		g.drawString("1000 Scores", 275, 255 + 20 - 2);
		g.setColor(Color.green);
		g.setFont(new Font("", Font.PLAIN, 30));
		g.drawString("+5", 310, 230);
		
		if(CharacterCustomScreen.skin == "Creeper") {
			g.setFont(new Font("", Font.PLAIN, 20));
			if(Game.Score >= 900) { g.setColor(Color.green); }
			else if(Game.Score < 900) { g.setColor(Color.red); }
			buttonSkill.draw(g);
			g.drawString("Explode", 100, 355);
			g.drawString("900 Scores", 85, 355 + 20 - 2);
			g.drawImage(explodeImg, 115, 298, 45, 45, null);
		}
//		else if(CharacterCustomScreen.skin == "Blaze") {
//			g.setFont(new Font("", Font.PLAIN, 20));
//			if(Game.Score >= 900) { g.setColor(Color.green); }
//			else if(Game.Score < 900) { g.setColor(Color.red); }
//			buttonSkill.draw(g);
//			g.drawString("Shoot", 108, 355);
//			g.drawString("900 Scores", 85, 355 + 20 - 2);
//			g.drawImage(fireImg, 115, 298, 45, 45, null);
//		}
		else if(CharacterCustomScreen.skin == "Enderman") {
			g.setFont(new Font("", Font.PLAIN, 20));
			if(Game.Score >= 900) { g.setColor(Color.green); }
			else if(Game.Score < 900) { g.setColor(Color.red); }
			buttonSkill.draw(g);
			g.drawString("Teleport", 96, 355);
			g.drawString("900 Scores", 85, 355 + 20 - 2);
			g.drawImage(teleportImg, 110, 298, 45, 45, null);
		}
	}

}
