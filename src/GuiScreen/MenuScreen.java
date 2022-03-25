package GuiScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import DisplayGame.GameObject.Button;

import java.util.Random;

public class MenuScreen extends JPanel {
	public static Button button = new Button(180, 200, 140, 40, 0, 0, true);
	public static Button button1 = new Button(180, 250, 140, 40, 0, 0, true);
	public static Button button2 = new Button(180, 300, 140, 40, 0, -1, true);
	public static Button button3 = new Button(180, 350, 140, 40, 0, 0, true);
	
	static Random random = new Random();
	public static int rainbow;
	public static int rainbow1 = 255;
	public static int rainbow2;
	
	public static int randomPositionX;
	public static int randomPositionY;
	
	public static int bestLevel;
	
	public static void draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("", Font.PLAIN, 25));
		
		g.setColor(Color.white);
		button.draw(g);
		g.drawString("Play", 222, 226);
		
		g.setColor(Color.white);
		button1.draw(g);
		g.drawString("Help", 222, 277);
		
		g.setColor(Color.white);
		button2.draw(g);
		g.drawString("Skin", 222, 328);
		
		if(GameScreen.level > bestLevel) {
			bestLevel = GameScreen.level;
		}
		
//		g.setColor(Color.white);
//		button3.draw(g);
//		g.drawString("Quit", 222, 377);
		
		g.setColor(Color.white);
		g.setFont(new Font("", Font.PLAIN, 20));
//		g.drawString("Press 'H' for instructions", 144, 280);
//		g.drawString("Press 'Escape' to quit", 155, 300);
//		g.drawString("Press 'C' to custommize your character", 75, 320);
		
		g.setFont(new Font("", Font.PLAIN, 15));
		g.drawString("Made by Dung �", 5, 452);
		
		
		g.setFont(new Font("", Font.PLAIN, 56));
		
		rainbow += 5;
		if(rainbow >= 240) {
			rainbow =+ 240;
			rainbow1 -= 10;
		}
		if(rainbow1 <= 0) {
			rainbow1 =+ 0;
			rainbow2 += 10;
		}
		if(rainbow2 >= 255) {
			rainbow2 =+ 255;
			rainbow -= 10;
		}
		if(rainbow <= 0) {
			rainbow1 += 10;
			rainbow =+ 0;
		}
		if(rainbow1 >= 255) {
			rainbow1 =+ 255;
			rainbow2 -= 10;
		}
		if(rainbow2 <= 0) {
			rainbow += 10;
			rainbow2 =+ 0;
		}

		g.setColor(new Color(rainbow, rainbow1, rainbow2));
		g.drawString("OBCOPUSTING", randomPositionX, randomPositionY);
		randomPositionX = random.nextInt(8) + 32;
		randomPositionY = random.nextInt(8) + 160;
	}

}
