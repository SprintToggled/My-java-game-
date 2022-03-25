package GuiScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class HelpScreen extends JPanel {
	public static void draw(Graphics g) {
		Font defaultFont = new Font("", Font.PLAIN, 15);
		Font defaultFontBig = new Font("", Font.PLAIN, 20);
		
		g.setColor(Color.white);
		g.drawRect(50, 50, 390, 360);
		g.setFont(defaultFontBig);
		g.drawString("How to play?", 55, 70);
		g.setFont(defaultFont);
		g.drawString("Using WASD to move the player and dodge enemies", 55, 90);
		g.drawString("Press 'e' to open the Store", 55, 105);
		g.setFont(defaultFontBig);
		g.drawString("How to buy in Store?", 55, 125);
		g.setFont(defaultFont);
		g.drawString("You have to fight until you have enough score to buy", 55, 145);
		g.setFont(defaultFontBig);
		g.drawString("What all effect in Store can do?", 55, 165);
		g.setFont(defaultFont);
		g.drawString("Healing Potion: Heal you when you on low health", 55, 185);
		g.drawString("Speed Potion: Make you move faster in the game", 55, 200);
		g.drawString("Score Booster: Boost your score up!", 55, 215);
		g.setFont(defaultFontBig);
		g.drawString("What does green and red color mean in", 55, 235);
		g.drawString("Store when you buying?", 55, 255);
		g.setFont(defaultFont);
		g.drawString("The red color mean you don't have enough score to buy it", 55, 275);
		g.drawString("The green color mean you have enough score to buy it", 55, 290);
	}

}
