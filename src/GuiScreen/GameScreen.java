package GuiScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import DisplayGame.Display;
import DisplayGame.Game;
import DisplayGame.GameObject.Button;
import GuiScreen.SkillEffects.Explode;
import GuiScreen.SkillEffects.FireBall;
import gameMod.drawScreen;

public class GameScreen extends JPanel {
	public static int level = 1;
	public static int realLevel = 1;
	public static int levelTime = 300;
	
	public static int PositionTime = 5;
	
	public static Explode explode = new Explode(0, 0, 1, 1);
	public static FireBall fireball = new FireBall(1000, 1000, 40, 40);
	
	public static void draw(Graphics g) {
//		level = 19;
//		realLevel = 19;
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 500, 500);
		g.setColor(Color.red);
		g.fillRect(5, 5, 200, 30);
		g.setColor(Color.green);
		Game.healthBar.draw(g);
		Game.rect.draw(g);
		
		if(!Game.gameOver && Game.GuiScreen == 1) {
			levelTime -= 1;
		}
		g.setColor(Color.white);
		g.drawString("Level: " + level, 5, 50);
		if(CharacterCustomScreen.skin == "Creeper") { if(Game.explode >= 1) { g.drawString("Explode: " + Game.explode, 5, 70); }}
		if(CharacterCustomScreen.skin == "Blaze") { if(Game.fireball >= 1) { g.drawString("Fireballs: " + Game.fireball, 5, 70); }}
		if(CharacterCustomScreen.skin == "Enderman") { if(Game.teleport >= 1) { g.drawString("Teleport: " + Game.teleport, 5, 70); }}
		if(Explode.cooldown >= 1 && Game.explode >= 1 || Explode.cooldown >= 1 && Game.fireball >= 1 || Explode.cooldown >= 1 && Game.teleport >= 1) {
			g.drawString("Cool down time: " + Explode.cooldown, 5, 90);
		}
		else {
			g.drawString("", 0, 0);
		}
		
//		g.setFont(new Font("Casper Comics", Font.PLAIN, 45));
//		g.setColor(Color.white);
//		Game.button.draw(g);
//		g.setColor(Color.black);
//		g.drawString("Store", 350, 443);
		
//		if(gameOver) {
//			g.setColor(Color.red);
//			g.setFont(new Font("Casper Comics", Font.PLAIN, 45));
//			g.drawString("Game Over", 145, 100);
//	    }
		
		g.setFont(new Font("", Font.PLAIN, 15));
		if(Game.healthBar.width <= 0) {
			Game.gameOver = true;
		}
		
		if(Game.gameOver == false) {
			g.setColor(Color.white);
			g.drawString("Score: " + Game.Score, 20, 450);
			if(!StoreScreen.FScore) { Game.Score += 1; }
			if(StoreScreen.FScore) { Game.Score += 5; }
		}
		if(Game.gameOver) {
			g.setFont(new Font("", Font.PLAIN, 35));
			g.setColor(Color.green);
			g.drawString("Score: " + Game.Score, 15, 450);
		}
		
		if(levelTime <= 0) {
			level += 1;
			levelTime = 300;
			realLevel += 1;
		}
		
		drawScreen.draw(g);
		
		if(Game.speed) {
			g.setColor(Color.gray);
			g.fill3DRect(301, 0, 185, 50, true);
			g.setColor(Color.cyan);
			g.setFont(new Font("", Font.PLAIN, 30));
			g.drawString("Speed Effect", 305, 32);
		}
		else if(StoreScreen.FScore) {
			g.setColor(Color.gray);
			g.fill3DRect(301, 0, 185, 50, true);
			g.setColor(Color.green);
			g.setFont(new Font("", Font.PLAIN, 28));
			g.drawString("Score Booster", 305, 32);
		}
		
		if(Game.shoot) {
			PositionTime -= 1;
			if(PositionTime >= 1) {
				fireball.x = Game.rect.x;
				fireball.y = Game.rect.y;
			}
		}
		fireball.draw(g);
		
		if(!explode.start) {
			explode.x = Game.rect.x + 20;
			explode.y = Game.rect.y + 20;
		}
		else if(explode.start) {
			explode.draw(g);
		}
		
//		if(CharacterCustomScreen.skin == "Blaze") {
//			Game.croshair.draw(g);
//		}
		
		Game.collision();
	}

}
